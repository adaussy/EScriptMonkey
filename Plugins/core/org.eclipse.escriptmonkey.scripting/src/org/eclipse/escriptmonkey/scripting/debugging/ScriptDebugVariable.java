package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class ScriptDebugVariable extends ScriptDebugElement implements IVariable {

	private final ScriptDebugStackFrame mStackFrame;

	private final String mName;

	private final Object mValue;

	public ScriptDebugVariable(final ScriptDebugStackFrame stackFrame, final String name, final Object value) {
		super(stackFrame.getDebugTarget());

		mStackFrame = stackFrame;
		mName = name;
		mValue = value;
	}

	@Override
	public void setValue(final String expression) throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(final IValue value) throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsValueModification() {
		return false;
	}

	@Override
	public boolean verifyValue(final String expression) throws DebugException {
		return false;
	}

	@Override
	public boolean verifyValue(final IValue value) throws DebugException {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return mStackFrame.isTerminated();
	}

	@Override
	public boolean isSuspended() {
		return mStackFrame.isSuspended();
	}

	@Override
	public boolean isStepping() {
		return mStackFrame.isStepping();
	}

	@Override
	public IValue getValue() throws DebugException {
		return new ScriptDebugValue(this);
	}

	@Override
	public String getName() throws DebugException {
		return mName;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		// TODO Auto-generated method stub
		return "your reference type";
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		return false;
	}

	public Object getRawValue() {
		return mValue;
	}

	public ScriptDebugStackFrame getStackFrame() {
		return mStackFrame;
	}
}
