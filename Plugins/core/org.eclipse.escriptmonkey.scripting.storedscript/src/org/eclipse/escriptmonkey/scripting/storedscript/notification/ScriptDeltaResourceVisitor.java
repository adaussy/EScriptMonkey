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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.storedscript.service.impl.StoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils;


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
		//		URI fileURI = org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils.getAbsoluteURI(delta);
		switch(delta.getKind()) {
		case IResourceDelta.ADDED:
			StoredScriptService.getInstance().processNewOrChangedScript(URIScriptUtils.createPlatformString(delta.getFullPath()));
			break;
		case IResourceDelta.REMOVED:
			StoredScriptService.getInstance().removeStoreScript(StoredScriptService.getInstance().getStoreScript(URIScriptUtils.createPlatformString(delta.getFullPath())));
			break;
		case IResourceDelta.CHANGED:
			if((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
				StoredScriptService.getInstance().removeStoreScript(StoredScriptService.getInstance().getStoreScript(URIScriptUtils.createStringURI(delta.getMovedFromPath())));
				//						StoredScriptService.getInstance().processNewOrChangedScript(delta.getMovedToPath(), true);
			}
			if((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
				//						StoredScriptService.getInstance().removeStoreScript(delta.getMovedFromPath());
				StoredScriptService.getInstance().processNewOrChangedScript(URIScriptUtils.createStringURI(delta.getMovedToPath()));
			}
			if((delta.getFlags() & IResourceDelta.REPLACED) != 0) {
				StoredScriptService.getInstance().processNewOrChangedScript(URIScriptUtils.createPlatformString(delta.getFullPath()));
			}
			if((delta.getFlags() & IResourceDelta.CONTENT) != 0) {

				//TODO Notify change only if metadata has changed
				//				IScriptMetadata newMetadata = MetadaParserService.getInstance().parseMetadata(StoredScriptService.getInstance().getStoreScript(delta.getFullPath()));
				//				delta.getResource()
				StoredScriptService.getInstance().processNewOrChangedScript(URIScriptUtils.createPlatformString(delta.getFullPath()));
			}
			break;
		}
		change = true;
	}
}
