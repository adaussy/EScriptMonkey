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
package org.eclipse.escriptmonkey.lang.python;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.AbstractFileHeaderParser;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;


/**
 * Header parser for python language
 * 
 * @author adaussy
 * 
 */
public class PythonHeaderParser extends AbstractFileHeaderParser {

	private Pattern commentPattern = Pattern.compile("^\\s*#(.*)", Pattern.MULTILINE);

	protected Pattern getPattern() {
		return commentPattern;
	}

	@Override
	public String getHeader(IStoredScript storeScript) throws CoreException {
		String content;
		try {
			content = storeScript.getContent();
			if(content != null) {
				StringBuilder headerBuilder = new StringBuilder();
				Matcher matcher = getPattern().matcher(content);
				while(matcher.find()) {
					headerBuilder.append(matcher.group(1)).append("\n");
				}
				return headerBuilder.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new CoreException(Logger.createErrorStatus(e.getMessage(), "org.eclipse.escriptmonkey.lang.python"));
		}
		return null;
	}




}
