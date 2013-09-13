package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.Activator;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.EventDispatchJob;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.IEventProcessor;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebugEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.EngineStartedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.ResumedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.ScriptReadyEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.model.ResumeEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.model.TerminateEvent;

public class RhinoDebugTarget extends RhinoDebugElement implements IDebugTarget, IEventProcessor {

	private EventDispatchJob mDispatcher;

	private RhinoDebugProcess mProcess = null;

	private final List<RhinoDebugThread> mThreads = new ArrayList<RhinoDebugThread>();

	private final ILaunch mLaunch;

	public RhinoDebugTarget(final ILaunch launch) {
		super(null);
		mLaunch = launch;

		fireCreationEvent();
	}

	@Override
	public String getName() throws DebugException {
		return "eScriptMonkey Rhino Debugger";
	}

	@Override
	public RhinoDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public ILaunch getLaunch() {
		return mLaunch;
	}

	@Override
	public IProcess getProcess() {
		return mProcess;
	}

	@Override
	public RhinoDebugThread[] getThreads() throws DebugException {
		return mThreads.toArray(new RhinoDebugThread[mThreads.size()]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !mThreads.isEmpty();
	}

	@Override
	public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDispatcher(final EventDispatchJob dispatcher) {
		mDispatcher = dispatcher;
	}

	private void fireDispatchEvent(final IDebugEvent event) {
		System.out.println("Target:   ----> " + event);
		mDispatcher.addEvent(event);
	}

	// ************************************************************
	// IEventProcessor
	// ************************************************************

	@Override
	public void handleEvent(final IDebugEvent event) {
		System.out.println("     Target:    " + event);

		if(event instanceof EngineStartedEvent) {
			mProcess = new RhinoDebugProcess(this);
			mProcess.fireCreationEvent();

		} else if(event instanceof ScriptReadyEvent) {
			RhinoDebugThread debugThread = null;

			// find existing DebugThread
			final Thread eventThread = ((ScriptReadyEvent)event).getThread();
			try {
				for(final RhinoDebugThread thread : getThreads()) {
					if(eventThread.equals(thread.getThread())) {
						debugThread = thread;
						break;
					}
				}
			} catch (final DebugException e) {
			}

			if(debugThread == null) {
				// thread does not exist, create new ne
				debugThread = new RhinoDebugThread(getDebugTarget(), eventThread);
				debugThread.fireCreationEvent();
			}

			debugThread.addStackFrame(new RhinoDebugStackFrame(getDebugTarget(), ((ScriptReadyEvent)event).getScript()));

			// tell framework we are suspended
			fireSuspendEvent(DebugEvent.CLIENT_REQUEST);

			// set deferred breakpoints
			setDeferredBreakpoints(((ScriptReadyEvent)event).getScript());

			if(!suspendOnLoad())
				// resume thread
				fireDispatchEvent(new ResumeEvent());

		} else if(event instanceof ResumedEvent) {

		}

	}

	private void setDeferredBreakpoints(final Script script) {
		final Object file = script.getFile();
		if(file instanceof IResource)
			try {
				((IResource)file).findMarkers(getName(), isDisconnected(), IResource.DEPTH_ZERO);

			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub

	}

	private boolean suspendOnLoad() {
		return true;
	}

	// ************************************************************
	// IBreakpointListener
	// ************************************************************

	@Override
	public void breakpointAdded(final IBreakpoint breakpoint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	// ************************************************************
	// IMemoryBlockRetrieval
	// ************************************************************

	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "getMemoryBlock() not supported by " + getName()));
	}

	// ************************************************************
	// ITerminate
	// ************************************************************

	@Override
	public void terminate() throws DebugException {
		fireDispatchEvent(new TerminateEvent());
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public void resume() throws DebugException {
		fireDispatchEvent(new ResumeEvent());
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public void disconnect() throws DebugException {
		// TODO remove all breakpoints

		fireDispatchEvent(new ResumeEvent());
		setState(State.TERMINATED);
		fireTerminateEvent();
	}

	// ************************************************************
	// IStep
	// ************************************************************

	@Override
	public void stepInto() throws DebugException {
		getDebugTarget().stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		getDebugTarget().stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		getDebugTarget().stepReturn();
	}
}
