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
package org.eclipse.escriptmonkey.scripting.ui.actions;

import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.ui.utils.ScriptLauncherUtils;


/**
 * Action that run a {@link IStoredScript}
 * 
 * @author adaussy
 * 
 */
public class RunScriptAction extends AbstractStoredScriptAction {

	public RunScriptAction(String text) {
		super(text);
	}

	@Override
	public void run() {
		super.run();
		ScriptLauncherUtils.launchStoredScript(script);
	}



}
