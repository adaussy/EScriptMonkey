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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;

import com.google.common.collect.Collections2;

public class EngineDescription {

	private static final String CLASS = "class";

	private static final String PRIORITY = "priority";

	private static final String SUPPORTED_SCRIPT_TYPE = "supportedScriptType";

	private static final String TYPE = "type";

	private static final String ID = "id";

	private static final String NAME = "name";

	private IConfigurationElement mConfigurationElement;

	private List<ScriptType> types = null;

	public EngineDescription(IConfigurationElement configurationElement) {
		mConfigurationElement = configurationElement;
	}

	public Collection<String> getSupportedScriptTypesNames() {
		return Collections2.transform(getSupportedScriptTypes(), new ScriptType.ToScriptType());
	}

	public List<ScriptType> getSupportedScriptTypes() {
		if(types == null) {
			types = new ArrayList<ScriptType>();
			for(final IConfigurationElement child : mConfigurationElement.getChildren(SUPPORTED_SCRIPT_TYPE)) {
				String scriptTypeID = child.getAttribute(TYPE);
				if(scriptTypeID != null) {
					ScriptType scriptType = ScriptService.getInstance().getKownSwriptType().get(scriptTypeID);
					if(scriptType == null) {
						//TODO should log an error. Maybe need an activator
						System.err.println("Unknow scriptType " + scriptTypeID);
					}
					types.add(scriptType);
				}
			}
		}

		return types;
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
