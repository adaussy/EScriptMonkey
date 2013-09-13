package org.eclipse.escriptmonkey.scripting.ui.metadata;


public interface IUIMetadata {

	/**
	 * Metadata used to define description of script (is used in UI)
	 */
	public static final String DESCRIPTION_METADATA = "Description";

	/**
	 * Unsused metadata for now (Inherited from Eclipse Monkey)
	 * Use to link a script to a keyboard shortcut
	 */
	public static final String KEY_METADATA = "Key";

	/**
	 * Metadata used to classify stored script in UI
	 */
	public static final String MENU_METADATA = "Menu";

	/**
	 * Use to define a name for the script (use the name of the file without the extension if not define)
	 * 
	 */
	public static final String NAME_METADATA = "Name";


}