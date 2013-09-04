package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.Breakpoint;
import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.ContextData;
import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.ScriptSource;
import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.StackFrame;
import org.eclipse.wst.jsdt.debug.internal.rhino.transport.EventPacket;
import org.eclipse.wst.jsdt.debug.internal.rhino.transport.JSONConstants;

public class LocalContextData extends ContextData {

    private static final int CONTEXT_RUNNING = 0;
    private static final int CONTEXT_SUSPENDED = 1;

    private static final int STEP_CONTINUE = 0;
    private static final int STEP_IN = 1;
    private static final int STEP_NEXT = 2;
    private static final int STEP_OUT = 4;

    private final LinkedList frames = new LinkedList();

    private int contextState = CONTEXT_RUNNING;
    private int stepState = STEP_CONTINUE;
    private StackFrame stepFrame;
    private int mOldStepState;
    private StackFrame mOldStepFrame;
    private boolean mInclude;
    private final LocalDebuggerImpl mDebugger;
    private final boolean mStartAtLaunch = true;

    public LocalContextData(final Long threadId, final Long contextId, final LocalDebuggerImpl debugger) {
        super(threadId, contextId, debugger);
        mDebugger = debugger;
    }

    private StackFrame getTopFrame() {
        if ((this.frames != null) && !this.frames.isEmpty()) {
            return (StackFrame) this.frames.getFirst();
        }
        return null;
    }

    @Override
    public synchronized void pushFrame(final StackFrame frame, final ScriptSource script, final Integer lineNumber, final String functionName) {
        super.pushFrame(frame, script, lineNumber, functionName);
        frames.addFirst(frame);
        Breakpoint breakpoint = script.getBreakpoint(lineNumber, functionName);
        boolean isStepBreak = stepBreak(STEP_IN);
        if (isStepBreak || (breakpoint != null)) {
            if (sendBreakEvent(script, frame.getLineNumber(), functionName, breakpoint, isStepBreak, false)) {
                suspendState();
            }
        }
    }

    @Override
    public synchronized void resume(final String stepType) {

        try {// change the stepType if there is a false continue request
            if ((stepType == null) && ((mOldStepState == 2) || mInclude)) {
                stepState = mOldStepState;
                stepFrame = mOldStepFrame;
                mInclude = true;
            } else if ((stepType == null) && ((mOldStepState != 0) || mInclude)) {
                stepState = mOldStepState;
                mInclude = true;
            } else if (stepType == null) {
                stepState = STEP_CONTINUE;
                stepFrame = null;
                mInclude = false;
            } else if (stepType.equals(JSONConstants.STEP_IN)) {
                stepState = STEP_IN;
                stepFrame = null;
                mInclude = false;
            } else if (stepType.equals(JSONConstants.STEP_NEXT)) {
                stepState = STEP_NEXT;
                stepFrame = getTopFrame();
                mOldStepFrame = stepFrame;
                mInclude = false;
            } else if (stepType.equals(JSONConstants.STEP_OUT)) {
                if (frames.size() > 1) {
                    stepState = STEP_OUT;
                    stepFrame = (StackFrame) frames.get(1);
                } else {
                    stepState = STEP_CONTINUE;
                    stepFrame = null;
                }
                mInclude = false;
            } else if (stepType.equals(JSONConstants.STEP_ANY)) {
                stepState = STEP_IN | STEP_OUT | STEP_NEXT;
                stepFrame = null;
                mInclude = false;
            } else {
                throw new IllegalStateException("bad stepType: " + stepType); //$NON-NLS-1$
            }

        } finally {
            contextState = CONTEXT_RUNNING;
            notifyAll();
        }
        mOldStepState = stepState;
    }

    @Override
    public synchronized void lineChange(final ScriptSource script, final Integer lineNumber) {
        Breakpoint breakpoint = script.getBreakpoint(lineNumber, null);
        boolean isStepBreak = stepBreak(STEP_IN | STEP_NEXT);
        if (isStepBreak || (breakpoint != null)) {
            if (sendBreakEvent(script, lineNumber, null, breakpoint, isStepBreak, false)) {
                suspendState();
            }
        }
    }

    @Override
    public synchronized void debuggerStatement(final ScriptSource script, final Integer lineNumber) {
        Breakpoint breakpoint = script.getBreakpoint(lineNumber, null);
        boolean isStepBreak = stepBreak(STEP_IN | STEP_NEXT);
        if (sendBreakEvent(script, lineNumber, null, breakpoint, isStepBreak, true)) {
            suspendState();
        }
    }

    @Override
    public synchronized void popFrame(final boolean byThrow, final Object resultOrException) {
        super.popFrame(byThrow, resultOrException);
        if (!frames.isEmpty()) {
            StackFrame frame = (StackFrame) frames.removeFirst();
            if (stepFrame == frame) {
                stepFrame = null;
                stepState = STEP_OUT;
            }
            boolean isStepBreak = stepBreak(STEP_IN | STEP_OUT);
            if (isStepBreak) {
                frame = getTopFrame();
                if ((frame != null) && sendBreakEvent(frame.getScript(), frame.getLineNumber(), null, null, isStepBreak, false)) {
                    suspendState();
                }
            }
        }

    }

    private void suspendState() {
        contextState = CONTEXT_SUSPENDED;
        while (contextState == CONTEXT_SUSPENDED) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean stepBreak(final int step) {
        return ((0 != (step & stepState)) && ((stepFrame == null) || (stepFrame == frames.getFirst())));
    }

    public boolean sendBreakEvent(final ScriptSource script, final Integer lineNumber, final String functionName, final Breakpoint breakpoint,
            final boolean isStepBreak, final boolean isDebuggerStatement) {

        EventPacket breakEvent = new EventPacket(JSONConstants.BREAK);
        Map body = breakEvent.getBody();
        body.put(JSONConstants.THREAD_ID, getThreadId());
        body.put(JSONConstants.CONTEXT_ID, getId());
        body.put(JSONConstants.SCRIPT_ID, script.getId());
        if (functionName != null) {
            body.put(JSONConstants.FUNCTION_NAME, functionName);
        }
        body.put(JSONConstants.LINE, lineNumber);
        if (breakpoint != null) {
            // Get the id of the current breakpoint
            body.put(JSONConstants.BREAKPOINT, mDebugger.getBreakpointId());
        }

        if (isStepBreak) {
            String stepType;
            if (stepState == STEP_IN) {
                stepType = JSONConstants.STEP_IN;
            } else if (stepState == STEP_NEXT) {
                stepType = JSONConstants.STEP_NEXT;
            } else if (stepState == STEP_OUT) {
                stepType = JSONConstants.STEP_OUT;
            } else {
                stepType = JSONConstants.SUSPEND;
            }
            body.put(JSONConstants.STEP, stepType);
            stepState = 0;
        }

        body.put(JSONConstants.DEBUGGER_STATEMENT, Boolean.valueOf(isDebuggerStatement));
        return mDebugger.sendEvent(breakEvent);
    }

    @Override
    public synchronized void exceptionThrown(final Throwable ex) {
        StackFrame frame = getTopFrame();
        if (sendExceptionEvent(frame.getScript(), frame.getLineNumber(), ex)) {
            suspendState();
        }
    }

    private boolean sendExceptionEvent(final ScriptSource script, final Integer lineNumber, final Throwable ex) {
        EventPacket exceptionEvent = new EventPacket(JSONConstants.EXCEPTION);
        Map body = exceptionEvent.getBody();
        body.put(JSONConstants.CONTEXT_ID, getId());
        body.put(JSONConstants.THREAD_ID, getThreadId());
        body.put(JSONConstants.SCRIPT_ID, script.getId());
        body.put(JSONConstants.LINE, lineNumber);
        body.put(JSONConstants.MESSAGE, ex.getMessage());
        return mDebugger.sendEvent(exceptionEvent);
    }

    @Override
    public synchronized void scriptLoaded(final ScriptSource script) {
        if (sendScriptEvent(script)) {
            suspendState();
        }
    }

    private boolean sendScriptEvent(final ScriptSource script) {
        EventPacket scriptEvent = new EventPacket(JSONConstants.SCRIPT);
        Map body = scriptEvent.getBody();
        body.put(JSONConstants.THREAD_ID, getThreadId());
        body.put(JSONConstants.CONTEXT_ID, getId());
        body.put(JSONConstants.SCRIPT_ID, script.getId());
        return mDebugger.sendEvent(scriptEvent);
    }

    @Override
    public synchronized String getState() {
        return contextState == CONTEXT_RUNNING ? JSONConstants.RUNNING : JSONConstants.SUSPENDED;
    }

}
