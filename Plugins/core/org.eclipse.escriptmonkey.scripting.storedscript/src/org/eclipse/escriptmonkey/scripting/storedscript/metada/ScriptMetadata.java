/*******************************************************************************
 * Copyright (c) 2005, 2006 Eclipse Foundation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bjorn Freeman-Benson - initial implementation
 *     Ward Cunningham - initial implementation
 *     Channing Walton - bug 143456
 *     Jeff Mesnil - bug 132601
 *******************************************************************************/

package org.eclipse.escriptmonkey.scripting.storedscript.metada;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Implementation of metadata
 */
public class ScriptMetadata implements IScriptMetadata {

	private Multimap<String, String> metadataStore = ArrayListMultimap.create();


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("ScriptMetadata {\n");
		for(Entry<String, Collection<String>> entry : metadataStore.asMap().entrySet()) {
			builder.append("  ").append(entry.getKey()).append(" : \n");
			Iterator<String> ite = entry.getValue().iterator();
			while(ite.hasNext()) {
				String text = (String)ite.next();
				builder.append("    ").append(text).append("\n");

			}
		}
		return builder.toString();
	}

	@Override
	public Multimap<String, String> getMetadataMap() {
		return metadataStore;
	}


}
