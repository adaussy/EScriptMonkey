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
package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.python.core.PySystemState;


public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.escriptmonkey.scripting.engine.python.jython";

	private static Activator mInstance;

	public static Activator getDefault() {
		return mInstance;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);

		mInstance = this;
		Properties preProperties = System.getProperties();

		Properties postProperties = new Properties();
		postProperties.put("python.home", getPluginRootDir());


		PythonClassLoader classLoader = new PythonClassLoader();
		PySystemState.initialize(preProperties, postProperties, new String[0], classLoader);

		PySystemState.initialize(preProperties, postProperties, new String[0], Activator.getDefault().getClass().getClassLoader());
		Bundle[] bundles = context.getBundles();
		for(int i = 0; i < bundles.length; ++i) {
			classLoader.addBundle(bundles[i]);
		}
	}

	private String getPluginRootDir() {
		try {
			Bundle bundle = Platform.getBundle("org.jython");
			URL fileURL = FileLocator.find(bundle, new Path("."), null);
			return FileLocator.toFileURL(fileURL).getFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		mInstance = null;

		super.stop(context);
	}

}
