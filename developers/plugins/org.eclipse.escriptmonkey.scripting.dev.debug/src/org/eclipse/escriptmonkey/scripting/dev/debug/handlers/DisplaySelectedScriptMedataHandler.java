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
package org.eclipse.escriptmonkey.scripting.dev.debug.handlers;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.IScriptMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.service.StoredScriptService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class DisplaySelectedScriptMedataHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public DisplaySelectedScriptMedataHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelect = (IStructuredSelection)selection;
			Object first = strucSelect.getFirstElement();
			if(first instanceof IFile) {
				IFile file = (IFile)first;
				IPath location = file.getLocation();
				IStoredScript script = StoredScriptService.getInstance().getStoreScript(location);
				if(script != null) {
					IScriptMetadata metadata = script.getMetadata();
					if(metadata != null) {
						MessageDialog.openInformation(window.getShell(), "Metadata", metadata.toString());
					} else {
						Logger.logError("The file " + location + " can not be parse to get metadata");
					}
				} else {
					Logger.logError("The file " + location + " is not a in the stored script registry");
				}
			}
		}

		return null;
	}
}
