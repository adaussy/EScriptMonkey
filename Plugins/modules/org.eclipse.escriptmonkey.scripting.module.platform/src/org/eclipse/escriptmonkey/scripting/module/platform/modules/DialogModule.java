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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * Module to display dialog
 * 
 * @author adaussy
 * 
 */
public class DialogModule extends AbstractScriptModule {

	public DialogModule() {
		super();
	}

	@WrapToScript
	public Shell getActiveShel() {
		return Display.getDefault().getActiveShell();
	}

	@WrapToScript
	public void openDialog(final Window window) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				window.open();

			}
		});
	}

	@WrapToScript
	public void openInformationDialog(final String message) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", message);
			}
		});

	}

	public void openWindow(final Window window) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("tete");
				window.open();
			}
		};
		Display.getDefault().asyncExec(runnable);
	}




}
