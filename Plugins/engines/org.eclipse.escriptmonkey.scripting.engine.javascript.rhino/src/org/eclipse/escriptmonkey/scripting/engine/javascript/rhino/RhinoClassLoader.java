/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;

/**
 * A class loader for the Rhino runtime. This class loader will find classes from javascript and from the RCP. As it needs to use <i>buddy class
 * loading</i>
 * creating new objects might be an expensive operation. Activate this class loader like this:
 * <code>ContextFactory.getGlobal().initApplicationClassLoader(new RhinoClassLoader());</code>
 */
public class RhinoClassLoader extends BundleProxyClassLoader {

	private static Map<RhinoScriptEngine, URLClassLoader> REGISTERED_JARS = new HashMap<RhinoScriptEngine, URLClassLoader>();

	/**
	 * Constructor for Rhino class loader.
	 */
	public RhinoClassLoader() {
		super(Platform.getBundle("org.mozilla.javascript"), RhinoClassLoader.class.getClassLoader());
	}

	@Override
	public Class<?> findClass(final String name) throws ClassNotFoundException {
		// try to load from jars
		final Job currentJob = Job.getJobManager().currentJob();
		final URLClassLoader classLoader = REGISTERED_JARS.get(currentJob);
		if(classLoader != null) {
			Class<?> clazz = classLoader.loadClass(name);
			if(clazz != null)
				return clazz;
		}

		// not found in jars, delegate to eclipse loader
		return super.findClass(name);
	}

	public static void registerURL(final RhinoScriptEngine engine, final URL url) {
		if(!REGISTERED_JARS.containsKey(engine))
			REGISTERED_JARS.put(engine, URLClassLoader.newInstance(new URL[]{ url }));

		else {
			List<URL> urls = Arrays.asList(REGISTERED_JARS.get(engine).getURLs());
			urls.add(url);
			REGISTERED_JARS.put(engine, URLClassLoader.newInstance(urls.toArray(new URL[urls.size()])));
		}
	}

	public static void unregisterEngine(final RhinoScriptEngine engine) {
		REGISTERED_JARS.remove(engine);
	}
}
