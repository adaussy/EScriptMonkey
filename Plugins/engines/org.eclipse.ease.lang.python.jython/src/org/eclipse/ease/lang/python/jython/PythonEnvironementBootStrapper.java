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
package org.eclipse.ease.lang.python.jython;

import org.eclipse.ease.IScriptEngine;
import org.eclipse.ease.IScriptEngineLaunchExtension;
import org.eclipse.ease.lang.python.debug.ITracingConstant;
import org.eclipse.ease.log.Tracer;
import org.eclipse.ease.modules.EnvironmentModule;
import org.eclipse.ease.modules.IModuleWrapper;
import org.eclipse.ease.service.ScriptService;

/**
 * The load Environment method into script
 */
public class PythonEnvironementBootStrapper implements IScriptEngineLaunchExtension {

	@Override
	public void createEngine(final IScriptEngine engine) {
		IModuleWrapper wrapper = getWrapper(engine.getID());
		if(wrapper != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("import ").append(EnvironmentModule.class.getCanonicalName()).append("\n");
			stringBuilder.append("ENV").append(" = ").append(wrapper.classInstantiation(EnvironmentModule.class, new String[0])).append("\n");
			stringBuilder.append("ENV.loadModule(\"");
			stringBuilder.append(EnvironmentModule.ENVIRONMENT_MODULE_NAME);
			stringBuilder.append("\")");
			if(ITracingConstant.PYTHON_BOOT_STRAPPER_TRACING) {
				Tracer.logInfo("[Python bootstapper]Injecting code:\n" + stringBuilder.toString());
			}
			engine.executeAsync(stringBuilder.toString());
		}

		// register java top level package
		engine.executeAsync("import java");
	}

	public static IModuleWrapper getWrapper(final String engineID) {
		return ScriptService.getInstance().getModuleWrapper(engineID);
	}
}
