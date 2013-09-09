package org.eclipse.escriptmonkey.scripting.storedscript.metada;

import java.util.regex.Pattern;


public class Metadata {

	private String name;

	private Pattern regex;

	public Metadata(String name, String regex) {
		super();
		this.name = name;
		this.regex = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the regex
	 */
	public Pattern getRegex() {
		return regex;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regex == null) ? 0 : regex.hashCode());
		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Metadata other = (Metadata)obj;
		if(name == null) {
			if(other.name != null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		if(regex == null) {
			if(other.regex != null)
				return false;
		} else if(!regex.equals(other.regex))
			return false;
		return true;
	}




}
