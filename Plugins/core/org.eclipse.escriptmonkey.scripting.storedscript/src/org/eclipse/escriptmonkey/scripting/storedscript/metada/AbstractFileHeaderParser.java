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

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.Utilities;



/**
 * Abstract parser for stored file which matche file
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractFileHeaderParser implements IHeaderParser {

	public AbstractFileHeaderParser() {
		super();
	}

	protected String getStoredScriptContent(IStoredScript storeScript) {
		String content = null;
		try {
			content = Utilities.getFileContents(storeScript.getPath());
		} catch (CoreException e) {
			e.printStackTrace();
			Logger.logError("Unable to get the header from " + storeScript.getPath());
		} catch (IOException e) {
			e.printStackTrace();
			Logger.logError("Unable to get the header from " + storeScript.getPath());
		}
		return content;
	}

}
