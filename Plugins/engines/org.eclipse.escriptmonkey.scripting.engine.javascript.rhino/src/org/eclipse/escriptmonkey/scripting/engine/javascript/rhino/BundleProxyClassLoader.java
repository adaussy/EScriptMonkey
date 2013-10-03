/*******************************************************************************
 * taken from http://wiki.eclipse.org/BundleProxyClassLoader_recipe
 * 
 * 
 * Eclipse-BuddyPolicy: global
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.osgi.framework.Bundle;

public class BundleProxyClassLoader extends ClassLoader {

	private final Bundle mBundle;

	private ClassLoader mParent;

	public BundleProxyClassLoader(final Bundle bundle) {
		this.mBundle = bundle;
	}

	public BundleProxyClassLoader(final Bundle bundle, final ClassLoader parent) {
		super(parent);
		mParent = parent;
		mBundle = bundle;
	}

	// Note: Both ClassLoader.getResources(...) and bundle.getResources(...) consult
	// the boot classloader. As a result, BundleProxyClassLoader.getResources(...)
	// might return duplicate results from the boot classloader. Prior to Java 5
	// Classloader.getResources was marked final. If your target environment requires
	// at least Java 5 you can prevent the occurence of duplicate boot classloader
	// resources by overriding ClassLoader.getResources(...) instead of
	// ClassLoader.findResources(...).
	@Override
	public Enumeration findResources(final String name) throws IOException {
		return mBundle.getResources(name);
	}

	@Override
	public URL findResource(final String name) {
		return mBundle.getResource(name);
	}

	@Override
	public Class findClass(final String name) throws ClassNotFoundException {
		return mBundle.loadClass(name);
	}

	@Override
	public URL getResource(final String name) {
		return (mParent == null) ? findResource(name) : super.getResource(name);
	}

	@Override
	protected Class loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
		Class clazz = (mParent == null) ? findClass(name) : super.loadClass(name, false);
		if(resolve)
			super.resolveClass(clazz);

		return clazz;
	}
}
