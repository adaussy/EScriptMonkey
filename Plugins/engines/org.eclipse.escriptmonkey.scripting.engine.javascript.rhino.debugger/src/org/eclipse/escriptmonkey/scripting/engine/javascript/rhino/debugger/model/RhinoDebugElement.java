package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDisconnect;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.Activator;

public abstract class RhinoDebugElement extends DebugElement implements ITerminate, ISuspendResume, IDisconnect, IStep {

	protected enum State {
		NOT_STARTED, SUSPENDED, RESUMED, STEPPING, TERMINATED
	}

	private State mState = State.NOT_STARTED;

	public RhinoDebugElement(final RhinoDebugTarget target) {
		super(target);
	}

	@Override
	public RhinoDebugTarget getDebugTarget() {
		return (RhinoDebugTarget)super.getDebugTarget();
	}

	@Override
	public String getModelIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void setState(final State state) {
		((RhinoDebugElement)getDebugTarget()).mState = state;
	}

	protected State getState() {
		return ((RhinoDebugElement)getDebugTarget()).mState;
	}

	// ************************************************************
	// ITerminate
	// ************************************************************

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public boolean isTerminated() {
		return State.TERMINATED == getState();
	}

	@Override
	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return false;
	}

	@Override
	public boolean isSuspended() {
		return State.SUSPENDED == getState();
	}

	@Override
	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	@Override
	public void suspend() throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "getMemoryBlock() not supported by " + getDebugTarget().getName()));
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public boolean canDisconnect() {
		return isDisconnected();
	}

	@Override
	public void disconnect() throws DebugException {
		getDebugTarget().disconnect();
	}

	@Override
	public boolean isDisconnected() {
		return isTerminated();
	}

	// ************************************************************
	// IStep
	// ************************************************************

	@Override
	public boolean canStepInto() {
		return isSuspended();
	}

	@Override
	public boolean canStepOver() {
		return isSuspended();
	}

	@Override
	public boolean canStepReturn() {
		return isSuspended();
	}

	@Override
	public boolean isStepping() {
		return State.STEPPING == getState();
	}

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
