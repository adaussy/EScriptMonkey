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
package org.eclipse.escriptmonkey.scripting.storedscript.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.URIUtil;

/**
 * Utils class to handle URI
 * 
 * @author adaussy
 * 
 */
public class URIScriptUtils {

	public static URI getAbsoluteURI(IResourceDelta delta) {
		IResource resource = delta.getResource();
		URI worspaceURI = resource.getWorkspace().getRoot().getLocationURI();

		try {
			return URIUtil.makeAbsolute(new URI(delta.getFullPath().toString()), worspaceURI);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URI getAbsoluteURI(IResource resource) {

		URI worspaceURI = resource.getWorkspace().getRoot().getLocationURI();

		try {
			return URIUtil.makeAbsolute(new URI(resource.getFullPath().toString()), worspaceURI);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
