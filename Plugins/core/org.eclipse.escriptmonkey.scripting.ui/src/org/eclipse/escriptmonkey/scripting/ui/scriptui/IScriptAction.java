/**
 * Copyright (c) 2005-2006 Aptana, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 */
package org.eclipse.escriptmonkey.scripting.ui.scriptui;

import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;



/**
 * @author Paul Colton
 */
public interface IScriptAction extends IScriptUI {

	/**
	 * getStoredScript
	 * 
	 * @return StoredScript
	 */
	IStoredScript getStoredScript();

	/**
	 * setStoredScript
	 * 
	 * @param s
	 */
	void setStoredScript(IStoredScript s);
}
