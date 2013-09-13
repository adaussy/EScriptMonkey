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

import java.net.URISyntaxException;

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

	public static URI createFileURI(String uri) {
		return URI.createURI(uri);
	}

	public static URI createPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	public static String createPlatformString(IPath path) {
		return getStringFromURI(createPlatformURI(path));
	}

	public static String createStringURI(IPath path) {
		return URI.createFileURI(path.toString()).toString();
	}

	public static java.net.URI createJavaNetURI(URI uri) {
		try {
			return new java.net.URI(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static IPath createIPathFromURI(URI uri) {
		return new Path(uri.toFileString());
	}

	public static String getStringFromURI(URI uri) {
		return uri.toString();
	}
}
