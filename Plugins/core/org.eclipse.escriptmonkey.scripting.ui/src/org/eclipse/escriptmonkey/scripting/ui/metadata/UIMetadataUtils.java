/**
 *   Copyright (c) 2013 Atos
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *       Arthur Daussy - initial implementation
 */
package org.eclipse.escriptmonkey.scripting.ui.metadata;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.AbstractMetadataUtils;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.IBasicMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;


public class UIMetadataUtils extends AbstractMetadataUtils {

	public static String getDescription(IStoredScript script) {
		return getUniqueMeta(script, IUIMetadata.DESCRIPTION_METADATA);
	}

	public static String getFileName(IStoredScript script) {
		URI uri = script.createURI();
		return uri.lastSegment().replace(uri.fileExtension(), "");

	}

	public static List<String> getMenu(IStoredScript script) {
		String menuList = getUniqueMeta(script, IUIMetadata.MENU_METADATA);
		if(menuList == null) {
			return Collections.singletonList(getFileName(script));
		} else {
			return MenuMetadataParser.getMenus(menuList);
		}
	}

	public static boolean hasToBeLaunchInUI(IStoredScript script) {
		ScriptMetadata meta = script.getMetadata(IBasicMetadata.THREAD_METADATA);
		if(meta != null) {
			for(String value : meta.getValue()) {
				if(value != null) {
					String v = value.trim();
					if(IBasicMetadata.UI_THREAD_METADATA_VALUE.equals(v)) {
						return true;
					}
				}
			}
		}
		return false;

	}



}
