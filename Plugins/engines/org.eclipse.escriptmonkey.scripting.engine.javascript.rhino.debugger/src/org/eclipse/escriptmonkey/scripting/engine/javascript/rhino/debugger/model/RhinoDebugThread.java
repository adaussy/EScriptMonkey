package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

public class RhinoDebugThread extends RhinoDebugElement implements IThread {

	private final Thread mThread;

	public RhinoDebugThread(final RhinoDebugTarget target, final Thread thread) {
		super(target);

		mThread = thread;
	}

	@Override
	public String getName() throws DebugException {
		return "Thread:";
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public Thread getThread() {
		return mThread;
	}

	public void addStackFrame(final RhinoDebugStackFrame stackFrame) {
		stackFrame.setThread(this);
	}
}
