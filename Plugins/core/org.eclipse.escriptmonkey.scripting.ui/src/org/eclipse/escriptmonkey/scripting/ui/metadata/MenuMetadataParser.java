package org.eclipse.escriptmonkey.scripting.ui.metadata;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;


public class MenuMetadataParser {


	private static final String SEPARATOR = ">";

	public MenuMetadataParser() {
		super();
	}


	public static List<String> getMenus(String toParse) {
		String[] separators = toParse.split(SEPARATOR);
		UnmodifiableIterator<String> ite = Iterators.forArray(separators);
		ArrayList<String> menu = new ArrayList<String>();
		while(ite.hasNext()) {
			String m = (String)ite.next();
			menu.add(m.trim());
		}
		return menu;
	}

}
