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
