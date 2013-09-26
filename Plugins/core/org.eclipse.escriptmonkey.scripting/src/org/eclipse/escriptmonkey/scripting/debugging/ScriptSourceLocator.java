package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

public class ScriptSourceLocator implements IPersistableSourceLocator {

	@Override
	public Object getSourceElement(final IStackFrame stackFrame) {
		if(stackFrame instanceof ScriptDebugStackFrame)
			return ((ScriptDebugStackFrame)stackFrame).getScript();

		return null;
	}

	@Override
	public String getMemento() throws CoreException {
		return null;
	}

	@Override
	public void initializeFromMemento(final String memento) throws CoreException {
		// nothing to do
	}

	@Override
	public void initializeDefaults(final ILaunchConfiguration configuration) throws CoreException {
		// nothing to do
	}
}
