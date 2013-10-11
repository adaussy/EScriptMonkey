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

	/**
	 * Metadata used to specify a Core Expression for unable a script in the contextual menu
	 */
	public static final String ENABLE_WHEN = "EnableWhen";

	/**
	 * Metadata used to specified from where the script should be available
	 */
	public static final String AVAILABLE_FROM = "AvailableFrom";

	/**
	 * Metadata use to generate the effective script during execution
	 */
	public static final String GENERATE_CODE_INJECTION_FILE_METADA = "GenerateInjectedCodeFile";


}
