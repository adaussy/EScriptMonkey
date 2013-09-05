/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.storedscript.metada;

import java.util.List;


/**
 * Metadata used to load statically some modules
 * 
 * @author adaussy
 * 
 */
public interface IModuleMetadata {

	public static String MODULE_KEY = "MODULE_KEY";

	public List<String> getModules();

	public void addModule(String module);

}
