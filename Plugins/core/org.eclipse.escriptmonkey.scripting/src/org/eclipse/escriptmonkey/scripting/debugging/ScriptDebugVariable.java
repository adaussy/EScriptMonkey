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
	}

	@Override
	public void setValue(final IValue value) throws DebugException {
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
	public ScriptDebugValue getValue() throws DebugException {
		return new ScriptDebugValue(mStackFrame, mValue);
	}

	@Override
	public String getName() throws DebugException {
		return mName;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return (mValue != null) ? mValue.getClass().getSimpleName() : "";
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		return false;
	}
}
