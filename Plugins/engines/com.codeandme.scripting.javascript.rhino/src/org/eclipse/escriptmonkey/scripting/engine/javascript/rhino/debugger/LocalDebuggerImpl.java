package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.wst.jsdt.debug.core.breakpoints.IJavaScriptLoadBreakpoint;
import org.eclipse.wst.jsdt.debug.core.model.JavaScriptDebugModel;
import org.eclipse.wst.jsdt.debug.internal.core.JavaScriptDebugPlugin;
import org.eclipse.wst.jsdt.debug.internal.core.breakpoints.JavaScriptLoadBreakpoint;
import org.eclipse.wst.jsdt.debug.internal.core.model.JavaScriptDebugTarget;
import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.Breakpoint;
import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.RhinoDebuggerImpl;
import org.eclipse.wst.jsdt.debug.internal.rhino.transport.RhinoTransportService;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.debug.DebuggableScript;

public class LocalDebuggerImpl extends RhinoDebuggerImpl {

    private final boolean mStopAtLaunch;
    private final boolean mShowGeneratedFiles;
    private static IJavaScriptLoadBreakpoint allLoadsBreakpoint = null;
    private final ArrayList disabledThreads = new ArrayList();
    private boolean mFirstFile = true;

    private long currentBreakpointId = 0L;

    public LocalDebuggerImpl(final boolean stopAtLaunch, final boolean showGeneratedFiles, final String address) {
        super(new RhinoTransportService(), address, false, false);

        mStopAtLaunch = stopAtLaunch;
        mShowGeneratedFiles = showGeneratedFiles;

    }

    @Override
    public void handleCompilationDone(final Context context, final DebuggableScript script, final String source) {

        // Ignore unnamed script files for the debug process
        if ((mShowGeneratedFiles == true) || ((mShowGeneratedFiles == false) && !script.getSourceName().equals("unnamed script"))) {

            if (mFirstFile && (mStopAtLaunch == true)) {

                IJavaScriptLoadBreakpoint breakpoint = null;
                try {

                    HashMap map = new HashMap();
                    map.put(JavaScriptLoadBreakpoint.GLOBAL_SUSPEND, Boolean.TRUE);
                    breakpoint = JavaScriptDebugModel.createScriptLoadBreakpoint(ResourcesPlugin.getWorkspace().getRoot(), 0, 0, map, true);
                    breakpoint.setPersisted(false); // do not persist - https://bugs.eclipse.org/bugs/show_bug.cgi?id=323152

                } catch (DebugException e) {
                    JavaScriptDebugPlugin.log(e);
                } catch (CoreException e) {
                    e.printStackTrace();
                }

                if (breakpoint != null) {
                    // notify all the targets
                    IDebugTarget[] targets = DebugPlugin.getDefault().getLaunchManager().getDebugTargets();
                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] instanceof JavaScriptDebugTarget) {
                            ((JavaScriptDebugTarget) targets[i]).breakpointAdded(breakpoint);
                            allLoadsBreakpoint = breakpoint;
                        }
                    }
                }

            } else if ((mFirstFile == false) && (mStopAtLaunch == true)) {

                if (allLoadsBreakpoint != null) {
                    // notify all the targets
                    IDebugTarget[] targets = DebugPlugin.getDefault().getLaunchManager().getDebugTargets();
                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] instanceof JavaScriptDebugTarget) {
                            ((JavaScriptDebugTarget) targets[i]).breakpointRemoved(allLoadsBreakpoint, null);
                        }
                    }
                    try {
                        allLoadsBreakpoint.delete();
                    } catch (CoreException e) {
                        JavaScriptDebugPlugin.log(e);
                    } finally {
                        allLoadsBreakpoint = null;
                    }
                }
            }
            mFirstFile = false;
            super.handleCompilationDone(context, script, source);

        }

    }

    @Override
    // Set the id of the current breakpoint
    public synchronized Breakpoint setBreakpoint(final Long scriptId, final Integer lineNumber, final String functionName, final String condition,
            final Long threadId) {
        currentBreakpointId = new Long(currentBreakpointId++);
        return super.setBreakpoint(scriptId, lineNumber, functionName, condition, threadId);
    }

    @Override
    public synchronized void contextCreated(final Context context) {
        super.contextCreated(context);
        LocalThreadData infineonThreadData = new LocalThreadData((long) 0, this);
        infineonThreadData.contextCreated(context);
    }

    // Make the id of the current breakpoint for the class InfineonContextData visible
    public Long getBreakpointId() {
        return currentBreakpointId;
    }
}
