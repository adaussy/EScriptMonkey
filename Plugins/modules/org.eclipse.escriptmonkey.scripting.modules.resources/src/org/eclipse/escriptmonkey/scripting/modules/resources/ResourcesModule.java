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
 *     Michael Forster - bug 132810
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.modules.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;


/**
 * Module to handle resources
 * 
 * @author adaussy
 * 
 */
public class ResourcesModule extends AbstractScriptModule {

	public static String standardMarkerName = "Resource module marker";



	@WrapToScript
	public Object[] filesMatching(String patternString) {
		Pattern pattern = Pattern.compile(patternString);
		Collection<File> result = new ArrayList<File>();
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject[] projects = workspace.getRoot().getProjects();
			for(int i = 0; i < projects.length; i++) {
				IProject project = projects[i];
				walk(project, pattern, result);
			}
		} catch (CoreException x) {
			// ignore Eclipse internal errors
		}
		Object[] array = new Object[result.size()];
		int i = 0;
		for(Iterator<File> iter = result.iterator(); iter.hasNext();) {
			Object element = iter.next();
			array[i++] = element;
		}
		return array;
	}



	private void walk(IResource resource, Pattern pattern, Collection<File> result) throws CoreException {
		if(resource instanceof IFolder) {
			IResource[] children = ((IFolder)resource).members();
			for(int i = 0; i < children.length; i++) {
				IResource resource2 = children[i];
				walk(resource2, pattern, result);
			}
		} else if(resource instanceof IProject) {
			IProject project = (IProject)resource;
			if(!project.isOpen())
				return;
			IResource[] children = project.members();
			for(int i = 0; i < children.length; i++) {
				IResource resource2 = children[i];
				walk(resource2, pattern, result);
			}

		} else if(resource instanceof IFile) {
			String path = resource.getFullPath().toString();
			Matcher match = pattern.matcher(path);
			if(match.matches()) {
				result.add(new File(resource));
			}
		}
	}



}
