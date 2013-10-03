/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.debugging;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.escriptmonkey.scripting.debugging.events.ResumeRequest;

public class ScriptDebugThread extends ScriptDebugElement implements IThread {

	private final Thread mThread;

	private State mState = State.NOT_STARTED;

	private List<ScriptDebugStackFrame> mStackFrames = new ArrayList<ScriptDebugStackFrame>();

	public ScriptDebugThread(final ScriptDebugTarget target, final Thread thread) {
		super(target);

		mThread = thread;
	}

	@Override
	public String getName() throws DebugException {
		return "Thread: " + mThread.getName();
	}

	@Override
	public synchronized IStackFrame[] getStackFrames() {
		return mStackFrames.toArray(new IStackFrame[mStackFrames.size()]);
	}

	@Override
	public synchronized boolean hasStackFrames() {
		return getStackFrames().length > 0;
	}

	@Override
	public synchronized ScriptDebugStackFrame getTopStackFrame() {
		if(hasStackFrames())
			return mStackFrames.get(0);

		return null;
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		return new IBreakpoint[0];
	}

	public Thread getThread() {
		return mThread;
	}

	@Override
	public boolean isTerminated() {
		return State.TERMINATED == mState;
	}

	@Override
	public boolean isSuspended() {
		return State.SUSPENDED == mState;
	}

	@Override
	public boolean isStepping() {
		return State.STEPPING == mState;
	}

	protected void setTerminated() {
		mState = State.TERMINATED;
		fireTerminateEvent();
	}

	protected void setSuspended(final int type) {
		mState = State.SUSPENDED;
		fireSuspendEvent(type);
	}

	protected void setResumed(final int type) {
		mState = State.RESUMED;
		fireResumeEvent(type);
	}

	public synchronized void setStackFrames(final List<IScriptDebugFrame> debugFrames) {
		// update stack frames
		final List<ScriptDebugStackFrame> newStackFrames = new ArrayList<ScriptDebugStackFrame>(debugFrames.size());
		for(final IScriptDebugFrame debugFrame : debugFrames) {
			// find existing StackFrame
			ScriptDebugStackFrame stackFrame = null;
			for(final ScriptDebugStackFrame oldStackFrame : mStackFrames) {
				if(debugFrame.equals(oldStackFrame.getDebugFrame())) {
					stackFrame = oldStackFrame;
					stackFrame.setDirty();
					break;
				}
			}

			if(stackFrame == null)
				stackFrame = new ScriptDebugStackFrame(this, debugFrame);

			newStackFrames.add(stackFrame);
		}

		mStackFrames = newStackFrames;
		fireChangeEvent(DebugEvent.CHANGE);
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
	public void stepInto() throws DebugException {
		getDebugTarget().fireDispatchEvent(new ResumeRequest(DebugEvent.STEP_INTO, getThread()));
	}

	@Override
	public void stepOver() throws DebugException {
		getDebugTarget().fireDispatchEvent(new ResumeRequest(DebugEvent.STEP_OVER, getThread()));
	}

	@Override
	public void stepReturn() throws DebugException {
		getDebugTarget().fireDispatchEvent(new ResumeRequest(DebugEvent.STEP_RETURN, getThread()));
	}

}
