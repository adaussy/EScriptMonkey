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

import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class WorkbenchModule extends AbstractScriptModule {


	public WorkbenchModule() {
		WINDOW = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}

	@WrapToScript
	public static IWorkbenchWindow WINDOW = null;

	@WrapToScript
	public IWorkbench getActiveWorkbench() {
		return PlatformUI.getWorkbench();
	}

	@WrapToScript
	public IWorkbenchWindow getActiveWindow() {
		return getActiveWorkbench().getActiveWorkbenchWindow();
	}

	@WrapToScript
	public Shell getActiveShell() {
		return getActiveWindow().getShell();
	}

	@WrapToScript
	public IWorkbenchPage getActivePage() {
		return getActiveWindow().getActivePage();
	}

	@WrapToScript
	public IEditorPart getActiveEditor() {
		return getActiveWindow().getActivePage().getActiveEditor();
	}


}
