package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.escriptmonkey.scripting.Script;

public class ScriptDebugStackFrame extends ScriptDebugElement implements IStackFrame {

	private final ScriptDebugThread mThread;

	private final IScriptDebugFrame mDebugFrame;

	public ScriptDebugStackFrame(final ScriptDebugThread thread, final IScriptDebugFrame debugFrame) {
		super(thread.getDebugTarget());
		mThread = thread;

		mDebugFrame = debugFrame;
	}

	@Override
	public IThread getThread() {
		return mThread;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// TODO Auto-generated method stub
		return new IVariable[0];
	}

	@Override
	public boolean hasVariables() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLineNumber() throws DebugException {
		return getDebugFrame().getLineNumber();
	}

	@Override
	public int getCharStart() throws DebugException {
		return -1;
	}

	@Override
	public int getCharEnd() throws DebugException {
		return -1;
	}

	@Override
	public String getName() throws DebugException {
		return getScript().toString();
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return new IRegisterGroup[0];
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	// TODO eventually move next three methods to base class
	@Override
	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	@Override
	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	@Override
	public boolean isStepping() {
		return getThread().isStepping();
	}

	public Script getScript() {
		return getDebugFrame().getScript();
	}

	public IScriptDebugFrame getDebugFrame() {
		return mDebugFrame;
	}
}
