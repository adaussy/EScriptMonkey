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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;


/**
 * Utils class to handle URI
 * 
 * @author adaussy
 * 
 */
public class URIScriptUtils {

	//	public static URI getAbsoluteURI(IResourceDelta delta) {
	//		IResource resource = delta.getResource();
	//		URI worspaceURI = resource.getWorkspace().getRoot().getLocationURI();
	//
	//		try {
	//			return URIUtil.makeAbsolute(new URI(delta.getFullPath().toString()), worspaceURI);
	//		} catch (URISyntaxException e) {
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//
	//	public static URI getAbsoluteURI(IResource resource) {
	//
	//		URI worspaceURI = resource.getWorkspace().getRoot().getLocationURI();
	//
	//		try {
	//			return URIUtil.makeAbsolute(new URI(resource.getFullPath().toString()), worspaceURI);
	//		} catch (URISyntaxException e) {
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

	public static URI createFileURI(String uri) {
		return URI.createFileURI(uri);
	}

	public static String createStringURI(IPath path) {
		return URI.createFileURI(path.toOSString()).toString();
	}

	public static IPath createIPathFromURI(URI uri) {
		return new Path(uri.toFileString());
	}

	public static String getStringFromURI(URI uri) {
		return uri.toFileString();
	}
}
