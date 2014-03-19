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

/**
 * Python loader. Loads initial environment module.
 */
public class PythonEnvironementBootStrapper implements IScriptEngineLaunchExtension {

	@Override
	public void createEngine(final IScriptEngine engine) {

		// load environment module
		engine.executeAsync("from org.eclipse.ease.modules import EnvironmentModule");
		engine.executeAsync("EnvironmentModule().loadModule(\"/System/Environment\")");

		// register top level packages
		engine.executeAsync("import java");
		engine.executeAsync("import org");
		engine.executeAsync("import com");
	}
}
