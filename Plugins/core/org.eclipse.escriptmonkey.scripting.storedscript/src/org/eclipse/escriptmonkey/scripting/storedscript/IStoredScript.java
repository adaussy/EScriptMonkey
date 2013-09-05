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
package org.eclipse.escriptmonkey.scripting.storedscript;

import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.ScriptMetadata;


/**
 * A stored script is script stored a file
 * It identify with its path.
 * Note maybe {@link URL} should be use instead to be able to run online scrip
 * 
 * @author adaussy
 * 
 */
public interface IStoredScript {

	public IPath getPath();

	public ScriptMetadata getMetadata();

	public abstract void setMetadata(ScriptMetadata metadata);

	public abstract void setScriptPath(IPath scriptPath);



}
