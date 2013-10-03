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
import java.util.Map;

import org.eclipse.escriptmonkey.scripting.modules.IModuleWrapper;
import org.eclipse.escriptmonkey.scripting.modules.ModuleDefinition;

public interface IScriptService {

	IScriptEngine createEngine(String scriptType);

	IScriptEngine createEngineByID(String engineID);

	Collection<EngineDescription> getEngines();

	IModuleWrapper getModuleWrapper(String engineID);

	Map<String, ModuleDefinition> getAvailableModules();
}
