/*******************************************************************************
 * Copyright (c) 2006 Eclipse Foundation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bjorn Freeman-Benson - initial implementation
 *     Ward Cunningham - initial implementation
 *******************************************************************************/

package org.eclipse.escriptmonkey.scripting.storedscript.impl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.ScriptMetadata;

/**
 * StoredScript
 * Representation of a script that is stored (as a file)
 */
public class StoredScript implements IStoredScript {

	/**
	 * 
	 */
	protected IPath scriptPath;

	/**
	 * 
	 */
	protected ScriptMetadata metadata;


	@Override
	public IPath getPath() {
		return scriptPath;
	}

	@Override
	public ScriptMetadata getMetadata() {
		return metadata;
	}


	/**
	 * @param scriptPath
	 *        the scriptPath to set
	 */
	@Override
	public void setScriptPath(IPath scriptPath) {
		this.scriptPath = scriptPath;
	}


	/**
	 * @param metadata
	 *        the metadata to set
	 */
	@Override
	public void setMetadata(ScriptMetadata metadata) {
		this.metadata = metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StoredScript {scriptPath=" + scriptPath + "\n, metadata=" + metadata + "}";
	}




}
