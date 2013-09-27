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

import org.eclipse.core.expressions.IIterable;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Lists;


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

	@WrapToScript
	public Iterable<Object> getIterableSelection() {
		ISelection selection = getSelection();
		IIterable result = getAdapter(IIterable.class, selection);
		if(result != null) {
			return Lists.newArrayList(result.iterator());
		}
		ErrorDialog.openError(Display.getDefault().getActiveShell(), "Error getting iterable selection", "The current selection is not an iterable", null);
		return null;
	}

	protected <T extends Object> T getAdapter(Class<T> cla, Object o) {
		if(cla.isInstance(o)) {
			return (T)o;
		} else if(o instanceof IAdaptable) {
			return (T)((IAdaptable)o).getAdapter(cla);
		} else {
			IAdapterManager manager = Platform.getAdapterManager();
			return (T)manager.getAdapter(o, cla);
		}
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
