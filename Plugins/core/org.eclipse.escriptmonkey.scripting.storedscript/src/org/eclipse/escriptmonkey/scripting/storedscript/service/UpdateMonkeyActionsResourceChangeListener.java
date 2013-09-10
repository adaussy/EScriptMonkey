/*******************************************************************************
 * Copyright (c) 2005, 2006 Eclipse Foundation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bjorn Freeman-Benson - initial implementation
 *     Ward Cunningham - initial implementation
 *******************************************************************************/

package org.eclipse.escriptmonkey.scripting.storedscript.service;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.ScriptDeltaResourceVisitor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * UpdateMonkeyActionsResourceChangeListener
 * This listener listen workspace change an interact with {@link StoredScriptService}
 */
public class UpdateMonkeyActionsResourceChangeListener implements IResourceChangeListener {


	UpdateMonkeyActionsResourceChangeListener() {
	}

	/**
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		if(event != null) {
			boolean changed = false;

			IResourceDeltaVisitor visitor = new ScriptDeltaResourceVisitor();

			try {
				IResourceDelta delta = event.getDelta();
				if(delta != null) {
					delta.accept(visitor);
				}
				if(changed) {
					createTheMonkeyMenu();
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * TODO Make it work
	 */
	public static void createTheMonkeyMenu() {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for(int i = 0; i < windows.length; i++) {
			final IWorkbenchWindow window = windows[i];
			window.getShell().getDisplay().asyncExec(new Runnable() {

				public void run() {
					//TODO
					//					RecreateMonkeyMenuAction action = new RecreateMonkeyMenuAction();
					//					action.init(window);
					//					action.run(null);
				}
			});
		}
	}

}
