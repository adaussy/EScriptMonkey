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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Base abstract action for action base on {@link IStoredScript}
 * @author adaussy
 *
 */
public abstract class AbstractStoredScriptAction extends Action {

	protected IStoredScript script;

	public AbstractStoredScriptAction() {
		super();
	}

	public AbstractStoredScriptAction(String text) {
		super(text);
	}

	public AbstractStoredScriptAction(String text, ImageDescriptor image) {
		super(text, image);
	}

	public AbstractStoredScriptAction(String text, int style) {
		super(text, style);
	}

	/**
	 * @return the script
	 */
	public IStoredScript getScript() {
		return script;
	}

	/**
	 * @param script
	 *        the script to set
	 */
	public void setScript(IStoredScript script) {
		this.script = script;
	}

}
