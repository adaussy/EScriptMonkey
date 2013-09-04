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
package org.eclipse.escriptmonkey.scripting;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

public class EngineDescription {

	private static final String CLASS = "class";
	private static final String PRIORITY = "priority";
	private static final String SUPPORTED_SCRIPT_TYPE = "supportedScriptType";
	private static final String TYPE = "type";
	private static final String ID = "id";
	private static final String NAME = "name";

	private IConfigurationElement mConfigurationElement;

	public EngineDescription(IConfigurationElement configurationElement) {
		mConfigurationElement = configurationElement;
	}

	public Collection<String> getSupportedScriptTypes() {
		HashSet<String> scriptTypes = new HashSet<String>();
		for (final IConfigurationElement child : mConfigurationElement.getChildren(SUPPORTED_SCRIPT_TYPE))
			scriptTypes.add(child.getAttribute(TYPE));

		return scriptTypes;
	}

	public int getPriority() {
		try {
			return Integer.parseInt(mConfigurationElement.getAttribute(PRIORITY));
		} catch (Throwable e) {
			// ignore
		}

		return 0;
	}

	public Object createEngine() throws CoreException {
		return mConfigurationElement.createExecutableExtension(CLASS);
	}

	public String getID() {
		return mConfigurationElement.getAttribute(ID);
	}

	public String getName() {
		String name = mConfigurationElement.getAttribute(NAME);
		return (name != null) ? name : getID();
	}
}
