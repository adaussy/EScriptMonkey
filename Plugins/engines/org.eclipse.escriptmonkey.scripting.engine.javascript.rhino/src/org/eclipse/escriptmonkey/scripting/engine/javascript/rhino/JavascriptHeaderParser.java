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


import java.util.regex.Pattern;

import org.eclipse.escriptmonkey.scripting.storedscript.metada.AbstractEndStartDelimiterHeaderParser;


/**
 * This implementation of metadata parser for JavaScript files
 * 
 * @author adaussy
 * 
 */
public class JavascriptHeaderParser extends AbstractEndStartDelimiterHeaderParser {

	private static final Pattern headerPattern = Pattern.compile("^\\s*\\/\\*.*?\\*\\/", Pattern.DOTALL);


	@Override
	protected Pattern getPattern() {
		return headerPattern;
	}

}
