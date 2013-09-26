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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;


/**
 * Module to interact with selection
 * 
 * @author adaussy
 * 
 */
public class SelectionModule extends AbstractScriptModule {

	public SelectionModule() {
		super();
	}

	@WrapToScript
	public ISelection getSelection() {
		GetSelectionRunnable runnable = new GetSelectionRunnable();
		Display.getDefault().syncExec(runnable);
		return runnable.getSelection();
	}

	private static class GetSelectionRunnable implements Runnable {

		private ISelection selection;

		@Override
		public void run() {
			ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
			if(selectionService != null) {
				this.selection = selectionService.getSelection();
			}
		}


		/**
		 * @return the selection
		 */
		public ISelection getSelection() {
			return selection;
		}



	}



}
