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
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.NamedParameter;
import org.eclipse.escriptmonkey.scripting.modules.OptionalParameter;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.dialogs.ShowViewDialog;
import org.eclipse.ui.views.IViewDescriptor;


public class WorkbenchModule extends AbstractScriptModule {


	public WorkbenchModule() {
	}


	@WrapToScript
	public static IWorkbench getActiveWorkbench() {
		return PlatformUI.getWorkbench();
	}

	@WrapToScript
	public static IWorkbenchWindow getActiveWindow() {
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
	public static Shell getActiveShell() {
		return getActiveWindow().getShell();
	}

	@WrapToScript
	public static IWorkbenchPage getActivePage() {
		return getActiveWindow().getActivePage();
	}

	@WrapToScript
	public static IEditorPart getActiveEditor() {
		return getActiveWindow().getActivePage().getActiveEditor();
	}

	/**
	 * Display the view with the specific in the workbench
	 * 
	 * @param viewID
	 * @return
	 */
	@WrapToScript
	public IViewPart showView(@NamedParameter(name = "viewID") @OptionalParameter String viewID) {
		if(viewID == null) {
			ShowViewDialog dialog = new ShowViewDialog(getActiveWindow(), WorkbenchPlugin.getDefault().getViewRegistry());
			if(dialog.open() != ShowViewDialog.OK) {
				return null;
			}
			IViewDescriptor[] result = dialog.getSelection();
			if(result == null || result.length == 0) {
				return null;
			}
			viewID = result[0].getId();
		}
		RunnableWithResult<IViewPart> showViewRunnable = new ShowViewRunnable(viewID);
		Display.getDefault().asyncExec(showViewRunnable);
		return showViewRunnable.getResult();
	}

	private class ShowViewRunnable implements RunnableWithResult<IViewPart> {

		private String id;

		private IViewPart result;



		public ShowViewRunnable(String id) {
			super();
			this.id = id;
		}

		@Override
		public void run() {
			try {
				this.result = getActivePage().showView(id);
			} catch (PartInitException e) {
				e.printStackTrace();
				Logger.logError("Unable to show view " + id + " cause of :\n" + e.getMessage());
			}

		}

		@Override
		public IViewPart getResult() {
			return result;
		}

	}


}
