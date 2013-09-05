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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Status;
import org.eclipse.escriptmonkey.scripting.ScriptType;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.Activator;
import org.eclipse.escriptmonkey.scripting.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.impl.StoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IScriptNotification;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IScriptNotification.NotificationType;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IStoredScriptListener;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.ScriptNotification;

import com.google.common.collect.Collections2;


/**
 * Service that will handle all stored script (A stored script is an existing file script identify by its path)
 * 
 * @author adaussy
 * 
 */
public class StoredScriptService {

	private List<IStoredScriptListener> listeners = new ArrayList<IStoredScriptListener>();

	private UpdateMonkeyActionsResourceChangeListener workspaceListener = new UpdateMonkeyActionsResourceChangeListener();

	StoredScriptService() {
		init();
	}


	public void init() {
		try {
			rescanAllFiles();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
		} catch (CoreException e) {
			e.printStackTrace();
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
	}


	private static class SingletonHolder {

		public static final StoredScriptService INSTANCE = new StoredScriptService();
	}

	public static StoredScriptService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Map<IPath, StoredScript> storedScript = null;


	public Set<IStoredScript> getStoredScript() {
		if(storedScript != null) {
			return Collections.unmodifiableSet(new HashSet<IStoredScript>(storedScript.values()));
		}
		return Collections.emptySet();
	}

	public IStoredScript getStoreScript(IPath path) {
		return storedScript.get(path);
	}

	public void notifyChange(IScriptNotification notification) {
		for(IStoredScriptListener l : listeners) {
			l.scriptChange(notification);
		}
	}

	public void removeStoreScript(IPath path) {
		if(path != null) {
			// TODO Auto-generated method stub
			notifyChange(new ScriptNotification(NotificationType.DELETE, null, path));
		}
	}

	public void processNewOrChangedScript(IPath path) {
		processNewOrChangedScript(path, true);
	}


	public void processNewOrChangedScript(IPath path, boolean notify) {
		if(path != null) {
			IStoredScript storedScript = getStoreScript(path);
			if(storedScript == null) {
				StoredScript store = new StoredScript();
				store.setScriptPath(path);
				this.storedScript.put(path, store);
				if(notify) {
					StoredScriptService.getInstance().notifyChange(new ScriptNotification(NotificationType.ADD, path, null));
				}
			} else {
				if(notify) {
					StoredScriptService.getInstance().notifyChange(new ScriptNotification(NotificationType.CHANGE, path, path));
				}
			}
		}
	}

	/**
	 * Remove all script found into the workspace. (So keep the one from alternative file)
	 * 
	 * @throws CoreException
	 */
	public void rescanAllFiles() throws CoreException {
		if(storedScript == null) {
			storedScript = new HashMap<IPath, StoredScript>();
		} else {
			ArrayList<StoredScript> scriptToRemove = new ArrayList<StoredScript>(storedScript.values());
			for(Iterator iterator = scriptToRemove.iterator(); iterator.hasNext();) {
				StoredScript storedScript = (StoredScript)iterator.next();
				removeStoreScript(storedScript.getPath());
			}
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		findScriptsInContainer(getHandleFileExtension(), workspace.getRoot(), false);
		/*
		 * TODO
		 */
		//		findScriptsInalternatePath(extensions, alternatePaths, false);
	}

	public Collection<IFile> findScriptsInContainer(IContainer container, boolean notify) throws CoreException {
		Collection<String> handleScriptType = Collections2.transform(ScriptService.getInstance().getHandleScriptType(), new ScriptType.ToExtensionFile());
		return findScriptsInContainer(handleScriptType, container, notify);
	}

	public Collection<String> getHandleFileExtension() {
		return Collections2.transform(ScriptService.getInstance().getHandleScriptType(), new ScriptType.ToExtensionFile());
	}

	protected Collection<IFile> findScriptsInContainer(final Collection<String> extensions, IContainer container, final boolean notify) throws CoreException {
		final Collection<IFile> scripts = new ArrayList<IFile>();

		container.accept(new IResourceVisitor() {

			@Override
			public boolean visit(IResource resource) throws CoreException {
				if(resource instanceof IProject) {
					IProject p = (IProject)resource;
					return org.eclipse.escriptmonkey.scripting.storedscript.utils.ScriptResourceUtils.isEclipseMonkeyProject(p);
				} else if(resource instanceof IFile) {
					IFile file = (IFile)resource;
					if(extensions.contains(file.getFileExtension())) {
						IPath location = file.getLocation();
						processNewOrChangedScript(location, notify);
						scripts.add(file);
					}
				}
				return true;
			}
		});
		return scripts;
	}
	/*
	 * TODO add extension point to add alternative path
	 */

	//	protected void findScriptsInalternatePath(Collection<String> extensions, Collection<URI> alternatePaths, boolean notify) {
	//		for(Iterator<URI> iterator = alternatePaths.iterator(); iterator.hasNext();) {
	//			URI path = (URI)iterator.next();
	//
	//			File folder = new File(path);
	//			String[] files = folder.list();
	//
	//			for(int j = 0; j < files.length; j++) {
	//
	//				String fullPath = folder.getAbsolutePath() + File.separator + files[j];
	//				File f = new File(fullPath);
	//
	//				if(f.isFile()) {
	//					Iterator<String> extensionIterator = extensions.iterator();
	//					while(extensionIterator.hasNext()) {
	//						String ext = (String)extensionIterator.next();
	//						if(f.getName().toLowerCase().endsWith("." + ext)) {
	//							Path p = new Path(f.getAbsolutePath());
	//							processNewOrChangedScript(p, notify);
	//						}
	//					}
	//				}
	//			}
	//		}
	//	}

}
