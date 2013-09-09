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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.IHeaderParser;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.Utilities;


/**
 * This implementation of metadata parser for JavaScript files
 * @author adaussy
 *
 */
public class JavascriptHeaderParser implements IHeaderParser {

	private static final Pattern headerPattern = Pattern.compile("^\\s*\\/\\*.*?\\*\\/", Pattern.DOTALL);


	@Override
	public String getHeader(IStoredScript storeScript) throws CoreException {
		try {
			String contents = Utilities.getFileContents(storeScript.getPath());
			Matcher matcher = headerPattern.matcher(contents);
			if(matcher.find()) {
				return matcher.group();
			}

		} catch (IOException e) {
			e.printStackTrace();
			Logger.logError("Unable to get the header from " + storeScript.getPath());
		}
		return null;
	}

}
