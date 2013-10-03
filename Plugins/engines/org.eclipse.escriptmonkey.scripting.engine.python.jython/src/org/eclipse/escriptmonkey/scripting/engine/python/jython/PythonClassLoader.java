/*******************************************************************************
 * Copyright (c) 2005-2006 Aptana, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 * 
 * Contributions:
 *    Kevin Lindsey based on code by Patrick Mueller
 *    José Fonseca - adapted for python
 *    Arthur Daussy - Addd better cash
 *******************************************************************************/

package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import org.osgi.framework.Bundle;
import org.python.core.PySystemState;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Kevin Lindsey based on code by Patrick Mueller
 *         This has to be improved !!
 */
public class PythonClassLoader extends ClassLoader {

	private ArrayList<Bundle> _bundles;

	/**
	 * ScriptClassLoader
	 */
	public PythonClassLoader() {
		super(PythonClassLoader.class.getClassLoader());

		this._bundles = new ArrayList<Bundle>();
	}

	/**
	 * addBundle
	 * 
	 * @param bundle
	 */
	public void addBundle(Bundle bundle) {
		if(bundle == null) {
			throw new IllegalArgumentException("ScriptClassLoader_Bundle_Not_Defined");
		}

		if(this._bundles.contains(bundle) == false) {
			addPackagesFromBundle(bundle);
		}
	}

	private void addPackagesFromBundle(Bundle bundle) {
		this._bundles.add(bundle);
		addPackage(bundle, "Provide-Package");
		addPackage(bundle, "Export-Package");
	}

	private static Multimap<String, Bundle> packageToBundle = null;

	protected Multimap<String, Bundle> getMapPackageToBundle() {
		if(packageToBundle == null) {
			packageToBundle = ArrayListMultimap.create();
		}
		return packageToBundle;
	}

	private void addPackage(Bundle b, String propName) {
		String packages = (String)b.getHeaders().get(propName);
		if(packages != null) {
			String[] names = packages.split(",");
			for(int j = 0; j < names.length; ++j) {
				String packageSpec = names[j];
				PySystemState.add_package(packageSpec);
				String[] pacakgeProperty = packageSpec.split(";");
				if(pacakgeProperty != null && pacakgeProperty.length > 0) {
					String packageName = pacakgeProperty[0].trim();
					getMapPackageToBundle().put(packageName, b);
				}
			}
		}
	}

	/**
	 * findClass
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class findClass(String name) throws ClassNotFoundException {
		Class result = this.loadClassFromBundles(name);

		if(result == null) {
			String message = "ScriptClassLoader_Unable_To_Find_Class: " + name;

			throw new ClassNotFoundException(message);
		}

		return result;
	}

	/**
	 * findResource
	 * 
	 * @param name
	 * @return URL
	 */
	@Override
	protected URL findResource(String name) {
		URL result = super.findResource(name);

		if(result == null) {
			Iterator<Bundle> iterator = this._bundles.iterator();

			while(iterator.hasNext()) {
				Bundle bundle = iterator.next();

				result = bundle.getResource(name);

				if(result != null) {
					break;
				}
			}
		}

		return result;
	}

	/**
	 * findResources
	 * 
	 * @param name
	 * @return Enumeration
	 * @throws IOException
	 */
	@Override
	protected Enumeration findResources(String name) throws IOException {
		Enumeration result = super.findResources(name);

		if(result == null) {
			Iterator<Bundle> iterator = this._bundles.iterator();

			while(iterator.hasNext()) {
				Bundle bundle = iterator.next();

				result = bundle.getResources(name);

				if(result != null) {
					break;
				}
			}
		}

		if(result == null) {
			String message = "ScriptClassLoader_Unable_To_Find_Resource: " + name;

			throw new IOException(message);
		}

		return result;
	}

	/**
	 * loadClass
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	@Override
	public Class loadClass(String name) throws ClassNotFoundException {
		Class result = null;
		try {
			result = super.loadClass(name);
		} catch (ClassNotFoundException e) {
			result = this.loadClassFromBundles(name);
		}

		if(result == null) {
			String message = "ScriptClassLoader_Unable_To_Load_Class: " + name;

			throw new ClassNotFoundException(message);
		}

		return result;
	}

	/**
	 * loadClass
	 * 
	 * @param name
	 * @param resolve
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	@Override
	protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class result = super.loadClass(name, resolve);

		if(result == null) {
			result = this.loadClassFromBundles(name);
		}

		if(result == null) {
			String message = "ScriptClassLoader_Unable_To_Load_Class: " + name;

			throw new ClassNotFoundException(message);
		}

		return result;
	}

	/**
	 * loadClassFromBundles
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	private Class loadClassFromBundles(String name) throws ClassNotFoundException {
		Class result = null;
		String pacakgeName = getPackageName(name);
		if(pacakgeName != null) {
			for(Bundle b : getMapPackageToBundle().get(pacakgeName)) {
				result = b.loadClass(name);
				if(result != null) {
					return result;
				}
			}
		}
		return result;
	}

	protected String getPackageName(String name) {
		String[] segments = name.split("\\.");
		if(segments != null && segments.length > 0) {
			String pacakgeName = name.replace("." + segments[segments.length - 1], "");
			return pacakgeName;
		}
		return null;
	}
}
