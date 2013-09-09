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



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;

/**
 * Abstract class for parser used for header which can be match with a single pattern
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractEndStartDelimiterHeaderParser extends AbstractFileHeaderParser {

	public AbstractEndStartDelimiterHeaderParser() {
		super();
	}

	@Override
	public String getHeader(IStoredScript storeScript) throws CoreException {
		String contents = getStoredScriptContent(storeScript);
		if(contents != null) {
			Matcher matcher = getPattern().matcher(contents);
			if(matcher.find()) {
				return matcher.group();
			}
		}
		return null;
	}

	protected abstract Pattern getPattern();

}
