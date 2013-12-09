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
package org.eclipse.ease.lang.python.jython;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.python.core.PySystemState;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ease.lang.python.jython"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);

		plugin = this;
		//		Properties preProperties = System.getProperties();
		Properties preProperties = PySystemState.getBaseProperties();

		Properties postProperties = new Properties();
		postProperties.put("python.home", getPluginRootDir());
		postProperties.put("python.modules.builtin", "errno");
		//		Py.getSystemState().setClassLoader(this.getClass().getClassLoader());
		PySystemState.initialize(preProperties, postProperties, new String[0]);

		//				PyObject load = org.python.core.imp.
		//		System.out.println(load);

		// set packageManager AFTER initialization as init will set it, too
		// FIXME for now caching is disabled. We need to track how the cache destination is calculated
		PySystemState.packageManager = new JythonPackageManager(null, PySystemState.registry);
	}

	private static String getPluginRootDir() {
		try {
			Bundle bundle = Platform.getBundle("org.jython");
			URL fileURL = FileLocator.find(bundle, new Path("."), null);
			return FileLocator.toFileURL(fileURL).getFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;

		super.stop(context);
	}

	public static List<File> getLibraryFolders() {
		ArrayList<File> folders = new ArrayList<File>();
		File rootFolder = new File(getPluginRootDir() + "/Lib");
		if(rootFolder.exists())
			folders.add(rootFolder);

		return folders;
	}
}
