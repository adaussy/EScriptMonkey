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

import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Action used to edit a script
 * @author adaussy
 *
 */
public class EditScriptAction extends AbstractStoredScriptAction {

	public EditScriptAction(String text) {
		super(text);
	}

	@Override
	public void run() {
		if(script != null) {
			org.eclipse.emf.common.util.URI createURI = script.createURI();
			URI javaNetURI = URIScriptUtils.createJavaNetURI(createURI);
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(javaNetURI);
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				//Put your exception handler here if you wish to
			}
		}
		super.run();
	}

}
