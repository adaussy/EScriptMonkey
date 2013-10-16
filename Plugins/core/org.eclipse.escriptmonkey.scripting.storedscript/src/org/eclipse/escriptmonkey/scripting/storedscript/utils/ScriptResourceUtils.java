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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.escriptmonkey.scripting.EngineDescription;
import org.eclipse.escriptmonkey.scripting.ScriptType;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.EScriptMonkeyMonkeyProjectNature;

/**
 * Helper to handle script resources
 * 
 * @author adaussy
 * 
 */
public class ScriptResourceUtils {

	protected ScriptResourceUtils() {
	}

	public static boolean isEclipseMonkeyProject(IProject project) {
		if(project != null && project.isAccessible()) {
			try {
				return project.hasNature(EScriptMonkeyMonkeyProjectNature.ESCRIPT_MONKEY_NATURE);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean isEclipseMonkeyResource(IResource resource) {
		if(resource != null) {
			IProject project = resource.getProject();
			if(project.exists()) {
				return isEclipseMonkeyProject(project) && isCorrectFileExtension(resource);
			} else {
				//Handle case when file is outside eclipse or the IProject has been deleted
				return isCorrectFileExtension(resource);
			}
		}
		return false;
	}

	public static boolean isCorrectFileExtension(IResource resource) {
		String fileExtension = resource.getFileExtension();
		if(fileExtension != null) {
			for(EngineDescription desc : ScriptService.getInstance().getEngines()) {
				for(ScriptType type : desc.getSupportedScriptTypes()) {
					if(fileExtension.equals(type.getExtension())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void addEclipseMoneyNature(IProject project) throws CoreException {
		if(project != null) {
			if(!isEclipseMonkeyProject(project)) {
				addNature(project, EScriptMonkeyMonkeyProjectNature.ESCRIPT_MONKEY_NATURE);
			}
		}
	}

	public static void addNature(IProject project, String nature) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = nature;
		description.setNatureIds(newNatures);
		project.setDescription(description, new NullProgressMonitor());
	}

}
