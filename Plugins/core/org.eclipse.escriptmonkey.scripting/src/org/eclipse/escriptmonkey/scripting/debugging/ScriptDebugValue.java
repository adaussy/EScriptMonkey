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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class ScriptDebugValue extends ScriptDebugElement implements IValue {

	private final ScriptDebugStackFrame mStackFrame;

	private final Object mValue;

	public ScriptDebugValue(final ScriptDebugStackFrame stackFrame, final Object value) {
		super(stackFrame.getDebugTarget());

		mStackFrame = stackFrame;
		mValue = value;
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
	public String getReferenceTypeName() throws DebugException {
		return (mValue != null) ? mValue.getClass().getSimpleName() : "";
	}

	@Override
	public String getValueString() throws DebugException {
		if(isSimpleType(mValue))
			return mValue + " (" + mValue.getClass().getSimpleName().toLowerCase() + ")";

		return (mValue != null) ? mValue.getClass().getSimpleName() : "null";
	}

	@Override
	public boolean isAllocated() throws DebugException {
		return mValue != null;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		List<IVariable> variables = new ArrayList<IVariable>();

		if((mValue != null) && (!isSimpleType(mValue))) {
			if(mValue.getClass().isArray()) {
				// handle arrays

				if(mValue instanceof Object[]) {
					for(int index = 0; index < ((Object[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((Object[])mValue)[index]));

				} else if(mValue instanceof char[]) {
					for(int index = 0; index < ((char[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((char[])mValue)[index]));

				} else if(mValue instanceof byte[]) {
					for(int index = 0; index < ((byte[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((byte[])mValue)[index]));

				} else if(mValue instanceof boolean[]) {
					for(int index = 0; index < ((boolean[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((boolean[])mValue)[index]));

				} else if(mValue instanceof short[]) {
					for(int index = 0; index < ((short[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((short[])mValue)[index]));

				} else if(mValue instanceof int[]) {
					for(int index = 0; index < ((int[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((int[])mValue)[index]));

				} else if(mValue instanceof long[]) {
					for(int index = 0; index < ((long[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((long[])mValue)[index]));

				} else if(mValue instanceof double[]) {
					for(int index = 0; index < ((double[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((double[])mValue)[index]));

				} else if(mValue instanceof float[]) {
					for(int index = 0; index < ((float[])mValue).length; index++)
						variables.add(new ScriptDebugVariable(mStackFrame, "[" + index + "]", ((float[])mValue)[index]));
				}

			} else {
				// handle java objects
				for(Field field : mValue.getClass().getDeclaredFields()) {
					try {
						if(!Modifier.isStatic(field.getModifiers())) {
							if(!field.isAccessible())
								field.setAccessible(true);

							variables.add(new ScriptDebugVariable(mStackFrame, field.getName(), field.get(mValue)));
						}
					} catch (Exception e) {
					}
				}
			}
		}

		return variables.toArray(new IVariable[variables.size()]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}

	@Override
	public Object getAdapter(final Class adapter) {
		if(String.class.equals(adapter))
			return (mValue != null) ? mValue.toString() : "";

		return super.getAdapter(adapter);
	}

	public Object getValue() {
		return mValue;
	}

	private static boolean isSimpleType(final Object value) {
		return (value instanceof Integer) || (value instanceof Byte) || (value instanceof Short) || (value instanceof Boolean) || (value instanceof Character) || (value instanceof Long) || (value instanceof Double) || (value instanceof Float);
	}
}
