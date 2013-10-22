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
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;

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
		ISelection selection = runnable.getSelection();
		return selection;
	}

	@WrapToScript
	public Object getCustomSelection() {
		ISelection selection = getSelection();
		IEvaluationService esrvc = (IEvaluationService)PlatformUI.getWorkbench().getService(IEvaluationService.class);

		Object customSelection = SelectorService.getInstance().getSelectionFromContext(selection, esrvc.getCurrentState());
		if(customSelection != null) {
			return customSelection;
		}
		return selection;
	}

	@WrapToScript
	public Object getCustomSelectionFromSelector(String selectorID) {
		ISelection selection = getSelection();
		return SelectorService.getInstance().getSelectionFromSelector(selection, selectorID);
	}

	@WrapToScript
	public Iterable<Object> getIterableSelection() {
		ISelection selection = getSelection();
		IIterable result = getAdapter(IIterable.class, selection);
		if(result != null) {
			return Lists.newArrayList(result.iterator());
		}
		DialogModule.error("The current selection is not an iterable");
		return null;
	}

	protected <T extends Object> T getAdapter(Class<T> cla, Object o) {
		if(o != null && cla != null) {
			if(cla.isInstance(o)) {
				return (T)o;
			} else if(o instanceof IAdaptable) {
				return (T)((IAdaptable)o).getAdapter(cla);
			} else {
				IAdapterManager manager = Platform.getAdapterManager();
				if(manager != null) {
					return (T)manager.getAdapter(o, cla);
				} else {
					Logger.logError("Unable to get thr AdapterManger");
					return null;
				}
			}
		}
		return null;
	}

	private static class GetSelectionRunnable implements Runnable {

		private ISelection selection;

		@Override
		public void run() {
			ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
			if(selectionService != null) {
				this.selection = selectionService.getSelection();
				if(selection == null) {
					Logger.logError("Unable to find a selection from the workbench");
				}
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
