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
package org.eclipse.escriptmonkey.scripting.storedscript.notification;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.storedscript.service.StoredScriptService;


/**
 * Delta resource change visitor to collect or remove stored script
 * 
 * @author adaussy
 * 
 */
public class ScriptDeltaResourceVisitor implements IResourceDeltaVisitor {

	private boolean change = false;


	/**
	 * @return the change
	 */
	public boolean isChange() {
		return change;
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if(resource instanceof IFile) {
			IFile file = (IFile)resource;
			if(org.eclipse.escriptmonkey.scripting.storedscript.utils.ScriptResourceUtils.isEclipseMonkeyResource(file)) {
				handleScriptResourceChange(delta, file);
			} else if(".project".equals(file.getName())) {
				//When the .project is modify then look for scripts
				if(delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
					StoredScriptService.getInstance().findScriptsInContainer(resource.getProject(), true);
					change = true;
				}
			}
		}
		return true;
	}

	protected void handleScriptResourceChange(IResourceDelta delta, IFile file) {
		URI fileURI = org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils.getAbsoluteURI(delta);
		switch(delta.getKind()) {
		case IResourceDelta.ADDED:
			StoredScriptService.getInstance().processNewOrChangedScript(file.getLocation(), true);
			break;
		case IResourceDelta.REMOVED:
			StoredScriptService.getInstance().removeStoreScript(file.getLocation());
			break;
		case IResourceDelta.CHANGED:
			if((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
				StoredScriptService.getInstance().removeStoreScript(delta.getMovedFromPath());
				//						StoredScriptService.getInstance().processNewOrChangedScript(delta.getMovedToPath(), true);
			}
			if((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
				//						StoredScriptService.getInstance().removeStoreScript(delta.getMovedFromPath());
				StoredScriptService.getInstance().processNewOrChangedScript(delta.getMovedToPath(), true);
			}
			if((delta.getFlags() & IResourceDelta.REPLACED) != 0) {
				StoredScriptService.getInstance().processNewOrChangedScript(file.getLocation(), true);
			}
			if((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
				StoredScriptService.getInstance().processNewOrChangedScript(file.getLocation(), true);
			}
			break;
		}
		change = true;
	}
}
