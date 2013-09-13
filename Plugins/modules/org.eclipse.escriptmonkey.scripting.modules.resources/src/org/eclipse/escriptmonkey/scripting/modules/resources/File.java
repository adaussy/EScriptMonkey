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
 *******************************************************************************/

package org.eclipse.escriptmonkey.scripting.modules.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * File
 */
public class File {

	private IFile file;

	/**
	 * @param resource
	 */
	public File(IResource resource) {
		file = (IFile)resource;
	}

	/**
	 * getEclipseObject
	 * 
	 * @return The Eclipse IFile object
	 */
	public IFile getEclipseObject() {
		return file;
	}

	/**
	 * getLines
	 * 
	 * @return The lines in the file
	 */
	public Line[] getLines() {
		try {
			List<Line> result = new ArrayList<Line>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			String text;
			int lineNumber = 0;
			while((text = reader.readLine()) != null) {
				lineNumber++;
				result.add(new Line(text, lineNumber, this));
			}
			reader.close();
			int i = 0;
			Line[] rtrn = new Line[result.size()];
			for(Iterator<Line> iter = result.iterator(); iter.hasNext();) {
				Line element = iter.next();
				rtrn[i++] = element;
			}
			return rtrn;
		} catch (CoreException x) {
			return new Line[0];
		} catch (IOException x) {
			return new Line[0];
		}
	}

	/**
	 * removeMyTasks
	 * 
	 * @throws CoreException
	 */
	public void removeMyTasks() throws CoreException {
		IMarker[] markers = file.findMarkers(IMarker.TASK, false, 0);
		String key = this.getMarkerKey();
		for(int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			Object value = marker.getAttribute(ResourcesModule.standardMarkerName);
			if(key.equals(value)) {
				marker.delete();
			}
		}
	}

	String getMarkerKey() {
		return "From Script";
	}
}
