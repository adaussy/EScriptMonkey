package org.eclipse.escriptmonkey.scripting.debugging;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class ScriptDebugValue extends ScriptDebugElement implements IValue {

	private final ScriptDebugVariable mDebugVariable;

	public ScriptDebugValue(final ScriptDebugVariable debugVariable) {
		super(debugVariable.getDebugTarget());
		mDebugVariable = debugVariable;
	}

	@Override
	public boolean isTerminated() {
		return mDebugVariable.isTerminated();
	}

	@Override
	public boolean isSuspended() {
		return mDebugVariable.isSuspended();
	}

	@Override
	public boolean isStepping() {
		return mDebugVariable.isStepping();
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueString() throws DebugException {
		Object value = mDebugVariable.getRawValue();
		return (value != null) ? value.getClass().getSimpleName() : "null";
	}

	@Override
	public boolean isAllocated() throws DebugException {
		return mDebugVariable.getRawValue() != null;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		List<IVariable> variables = new ArrayList<IVariable>();
		Object value = mDebugVariable.getRawValue();
		if(value != null) {
			for(Field field : value.getClass().getDeclaredFields()) {
				try {
					if(!Modifier.isStatic(field.getModifiers())) {
						if(!field.isAccessible())
							field.setAccessible(true);

						variables.add(new ScriptDebugVariable(mDebugVariable.getStackFrame(), field.getName(), field.get(value)));
					}
				} catch (Exception e) {
				}
			}
		}

		return variables.toArray(new IVariable[variables.size()]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}
}
