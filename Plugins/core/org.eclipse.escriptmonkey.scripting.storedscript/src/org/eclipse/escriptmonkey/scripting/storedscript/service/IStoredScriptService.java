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
package org.eclipse.escriptmonkey.scripting.storedscript.service;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IStoredScriptListener;
import org.eclipse.escriptmonkey.scripting.storedscript.service.impl.StoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;



public interface IStoredScriptService {

	public abstract Set<IStoredScript> getStoredScript();

	public abstract IStoredScript getStoreScript(String uri);

	public abstract IStoredScript getFileStoredScript(URI uri);

	public abstract void addListener(IStoredScriptListener listener);

	public abstract void removeListener(IStoredScriptListener listener);

	public abstract void removeStoreScript(IStoredScript storeScript);

	public abstract void processNewOrChangedScript(String uri);

	public abstract org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType getScriptType(String type);

	public abstract org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType getMatchingScriptType(IStoredScript script);

	/**
	 * Remove all script found into the workspace. (So keep the one from alternative file)
	 * 
	 * @throws CoreException
	 */
	public abstract void rescanAllFiles() throws CoreException;

	public abstract Collection<String> getHandleFileExtension();

	public static final IStoredScriptService INSTANCE = StoredScriptService.getInstance();

}
