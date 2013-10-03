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

public interface IModifiableScriptEngine extends IScriptEngine {

	/**
	 * Set a variable in the script engine. This variable will be stored in the global script scope
	 * 
	 * @param name
	 *        variable name
	 * @param content
	 *        variable content
	 */
	void setVariable(final String name, final Object content);

	/**
	 * Get a script variable. Retrieve a variable from the global script scope.
	 * 
	 * @param name
	 *        variable name
	 * 
	 * @return variable content or <code>null</code>
	 */
	Object getVariable(final String name);
}
