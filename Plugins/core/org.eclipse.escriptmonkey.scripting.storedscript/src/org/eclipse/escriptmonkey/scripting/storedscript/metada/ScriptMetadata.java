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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of metadataScriptMetadata
 */
public class ScriptMetadata implements IMenuMedata, IModuleMetadata, IDescriptionMetada {

	private Map<String, Object> metadataStore = new HashMap<String, Object>();

	@Override
	public String getDescription() {
		return (String)metadataStore.get(DESCRIPTION_KEY);
	}

	@Override
	public List<String> getModules() {
		return (List<String>)metadataStore.get(MODULE_KEY);
	}

	@Override
	public String getMenu() {
		return (String)metadataStore.get(MENU_KEY);
	}

	@Override
	public Map<String, Object> getMetadataMap() {
		return metadataStore;
	}

	@Override
	public void setDescription(String description) {
		metadataStore.put(DESCRIPTION_KEY, description);
	}

	@Override
	public void addModule(String module) {
		metadataStore.put(MODULE_KEY, module);

	}

	@Override
	public void setMenu(String menu) {
		metadataStore.put(MENU_KEY, menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("ScriptMetadata metadataStore= \n");
		for(java.util.Map.Entry<String, Object> entry : metadataStore.entrySet()) {
			builder.append("[").append(entry.getKey()).append(" ; ").append(entry.getValue().toString()).append("]\n");
		}
		builder.append("}\n");
		return builder.toString();
	}


}
