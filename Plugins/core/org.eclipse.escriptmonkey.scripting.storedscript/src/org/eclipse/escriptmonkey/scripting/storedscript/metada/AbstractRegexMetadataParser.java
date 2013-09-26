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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class AbstractRegexMetadataParser implements IMetadataParser {

	protected Pattern regex;


	public AbstractRegexMetadataParser() {
		this.regex = createPattern();
	}

	protected abstract Pattern createPattern();


	/**
	 * @return the regex
	 */
	protected Pattern getRegex() {
		return regex;
	}


	/**
	 * @param regex
	 *        the regex to set
	 */
	protected void setRegex(Pattern regex) {
		this.regex = regex;
	}

	@Override
	public List<String> parserMetadata(String header) {
		ArrayList<String> result = new ArrayList<String>();
		Matcher matcher = getRegex().matcher(header);
		while(matcher.find()) {
			String data = matcher.group(1);
			if(data != null && !data.isEmpty()) {
				result.add(data);
			}

		}
		return result;
	}

}
