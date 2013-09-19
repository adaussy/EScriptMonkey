/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.module.platform.modules;

import org.eclipse.escriptmonkey.scripting.module.platform.modules.editors.Editor;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.ui.PlatformUI;


public class TextEditorModule extends AbstractScriptModule {


	public TextEditorModule() {
	}

	@WrapToScript
	public Editor getActiveEditor() {
		return new Editor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
	}

}
