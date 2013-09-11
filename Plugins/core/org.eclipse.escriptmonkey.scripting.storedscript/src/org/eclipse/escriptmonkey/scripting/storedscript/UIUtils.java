/**
 * Copyright (c) 2005-2006 Aptana, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 */
package org.eclipse.escriptmonkey.scripting.storedscript;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * 
 * @author Paul Colton
 * 
 */
public class UIUtils {

	/**
	 * Create an editor input from path
	 * 
	 * @param path
	 * @return
	 */
	public static IEditorInput createEditorInput(IPath path) {
		if(path != null) {
			IFile t = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
			return createEditorInput(t);
		}
		return null;
	}

	/**
	 * Create an editor input from file
	 * 
	 * @param t
	 * @return
	 */
	private static IEditorInput createEditorInput(IFile t) {
		if(t != null) {
			return new FileEditorInput(t);
		}
		return null;
	}



}
