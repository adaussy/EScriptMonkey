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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScript;


/**
 * A Header parser is a class which is able to extract the header from a {@link StoredScript}
 * 
 * @author adaussy
 * 
 */
public interface IHeaderParser {

	public String getHeader(IStoredScript storeScript) throws CoreException;

}
