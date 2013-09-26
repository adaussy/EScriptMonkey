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
