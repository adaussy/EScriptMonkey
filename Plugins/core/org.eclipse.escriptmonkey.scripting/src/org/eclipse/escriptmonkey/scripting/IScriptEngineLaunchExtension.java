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

/**
 * Interface for script engine launch extensions. An extension gets the chance to modify a script engine before scripts are fed to the engine.
 */
public interface IScriptEngineLaunchExtension {

	/**
	 * Called upon a script engine creation. As there might be multiple launch extensions, this might not be the only contribution to the script
	 * engine.
	 * 
	 * @param engine
	 *        engine just created
	 */
	void createEngine(IScriptEngine engine);
}
