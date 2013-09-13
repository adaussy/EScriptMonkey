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
package org.eclipse.escriptmonkey.scripting.storedscript.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.escriptmonkey.scripting.ScriptType;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.Activator;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IStoredScriptListener;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptFactory;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils;

import com.google.common.collect.Collections2;


/**
 * Service that will handle all stored script (A stored script is an existing file script identify by its path)
 * 
 * @author adaussy
 * 
 */
public class StoredScriptService implements IStoredScriptServiceInternal {

	private static class SingletonHolder {

		public static final StoredScriptService INSTANCE = new StoredScriptService();
	}

	private boolean init = false;;



	public static StoredScriptService getInstance() {
		if(!SingletonHolder.INSTANCE.init) {
			SingletonHolder.INSTANCE.init();
		}
		return SingletonHolder.INSTANCE;
	}

	private List<IStoredScriptListener> listeners = new ArrayList<IStoredScriptListener>();

	private UpdateMonkeyActionsResourceChangeListener workspaceListener = new UpdateMonkeyActionsResourceChangeListener();


	StoredScriptService() {

	}

	private ResourceSet resourceSet = null;

	private EContentAdapter modelAdapter;

	public void init() {
		try {
			init = true;
			resourceSet = new ResourceSetImpl();
			ResourceImpl resource = new ResourceImpl();
			resourceSet.getResources().add(resource);
			registry = StoredscriptFactory.eINSTANCE.createStoredScriptRegistry();
			modelAdapter = new EContentAdapter() {

				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					notifyScriptChanged(notification);
				};
			};


			registry.eAdapters().add(modelAdapter);
			resource.getContents().add(registry);
			//Init type for extension point
			for(ScriptType type : ScriptService.getInstance().getKownSwriptType().values()) {
				org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType scriptType = StoredscriptFactory.eINSTANCE.createScriptType();
				scriptType.setType(type.getScritpType());
				scriptType.setExtension(type.getExtension());
				registry.getScriptTypes().add(scriptType);
			}
			rescanAllFiles();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
		} catch (CoreException e) {
			e.printStackTrace();
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getStoredScript()
	 */
	@Override
	public Set<IStoredScript> getStoredScript() {
		if(registry != null) {
			return Collections.unmodifiableSet(new HashSet<IStoredScript>(registry.getScripts()));
		}
		return Collections.emptySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getStoreScript(java.lang.String)
	 */
	@Override
	public IStoredScript getStoreScript(String uri) {
		return registry.getStoredScript(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getFileStoredScript(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public IStoredScript getFileStoredScript(URI uri) {
		return getStoreScript(URIScriptUtils.getStringFromURI(uri));
	}

	public void notifyScriptChanged(Notification msg) {
		for(IStoredScriptListener l : listeners) {
			l.scriptChange(msg);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#addListener(org.eclipse.escriptmonkey.scripting.storedscript.
	 * notification.IStoredScriptListener)
	 */
	@Override
	public void addListener(IStoredScriptListener listener) {
		listeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#removeListener(org.eclipse.escriptmonkey.scripting.storedscript
	 * .notification.IStoredScriptListener)
	 */
	@Override
	public void removeListener(IStoredScriptListener listener) {
		listeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#removeStoreScript(org.eclipse.escriptmonkey.scripting.storedscript
	 * .storedscript.IStoredScript)
	 */
	@Override
	public void removeStoreScript(IStoredScript storeScript) {
		if(registry != null) {
			registry.getScripts().remove(storeScript);
		}
	}


	private StoredScriptRegistry registry = null;


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#processNewOrChangedScript(java.lang.String)
	 */
	@Override
	public void processNewOrChangedScript(String uri) {
		registry.processNewOrChangedScript(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getScriptType(java.lang.String)
	 */
	@Override
	public org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType getScriptType(String type) {
		return registry.getScriptType(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getMatchingScriptType(org.eclipse.escriptmonkey.scripting.
	 * storedscript.storedscript.IStoredScript)
	 */
	@Override
	public org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType getMatchingScriptType(IStoredScript script) {
		return ((StoredScriptRegistryImpl)registry).getMatchingScriptType(script);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#rescanAllFiles()
	 */
	@Override
	public void rescanAllFiles() throws CoreException {
		if(registry == null) {
			registry = StoredscriptFactory.eINSTANCE.createStoredScriptRegistry();
		} else {
			registry.getScripts().clear();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService#getHandleFileExtension()
	 */
	@Override
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
						IPath location = file.getFullPath();
						processNewOrChangedScript(URIScriptUtils.createPlatformString(location));
						scripts.add(file);
					}
				}
				return true;
			}
		});
		return scripts;
	}

	@Override
	public StoredScriptRegistry getRegistry() {
		return registry;
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
