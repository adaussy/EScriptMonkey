package org.eclipse.escriptmonkey.scripting.ui.metadata;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.AbstractMetadataUtils;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;


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



}
