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

import org.eclipse.escriptmonkey.scripting.common.RunnableWithResult;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class WorkbenchModule extends AbstractScriptModule {


	public WorkbenchModule() {
	}


	@WrapToScript
	public IWorkbench getActiveWorkbench() {
		return PlatformUI.getWorkbench();
	}

	@WrapToScript
	public IWorkbenchWindow getActiveWindow() {
		RunnableWithResult<IWorkbenchWindow> runnable = new RunnableWithResult<IWorkbenchWindow>() {

			private IWorkbenchWindow result;

			@Override
			public void run() {
				this.result = getActiveWorkbench().getActiveWorkbenchWindow();
			}

			@Override
			public IWorkbenchWindow getResult() {
				return result;
			}
		};
		Display.getDefault().syncExec(runnable);
		return runnable.getResult();
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
