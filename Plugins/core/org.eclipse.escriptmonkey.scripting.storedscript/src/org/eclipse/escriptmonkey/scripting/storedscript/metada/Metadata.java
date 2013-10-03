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



public class Metadata {

	private String name;

	private IMetadataParser parser;

	public Metadata(String name, IMetadataParser parser) {
		super();
		this.name = name;
		this.parser = parser;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	public List<String> parse(String header) {
		return parser.parserMetadata(header);
	}





}
