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
package org.eclipse.escriptmonkey.scripting.ui;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class Activator extends EclipseUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.escriptmonkey.scripting.ui";

	private static Activator mInstance;

	public static Activator getDefault() {
		return mInstance;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);

		mInstance = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		mInstance = null;

		super.stop(context);
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param path
	 *        the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(final String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static ImageDescriptor getImageDescriptor(final String bundleID, final String path) {
		assert (bundleID != null) : "No bundle defined";
		assert (path != null) : "No path defined";

		// if the bundle is not ready then there is no image
		final Bundle bundle = Platform.getBundle(bundleID);
		final int bundleState = bundle.getState();
		if((bundleState != Bundle.ACTIVE) && (bundleState != Bundle.STARTING) && (bundleState != Bundle.RESOLVED))
			return null;

		// look for the image (this will check both the plugin and fragment
		// folders
		final URL imagePath = FileLocator.find(bundle, new Path(path), null);

		if(imagePath != null)
			return ImageDescriptor.createFromURL(imagePath);

		return null;
	}

	public static Image getImage(final String bundleID, final String path, final boolean storeToImageRegistry) {
		assert (bundleID != null) : "No bundle defined";
		assert (path != null) : "No path defined";

		Image image = getDefault().getImageRegistry().get(bundleID + path);
		if(image == null) {
			ImageDescriptor descriptor = getImageDescriptor(bundleID, path);
			if(descriptor != null) {
				image = descriptor.createImage();

				if(storeToImageRegistry)
					getDefault().getImageRegistry().put(bundleID + path, image);
			}
		}

		return image;
	}

	protected final File getConfigurationFile(final String name) {
		return getStateLocation().append(name).toFile();
	}

	/**
	 * 
	 * This method returns an <code>org.eclipse.swt.graphics.Image</code> identified by its pluginId and iconPath.<BR>
	 */
	public static Image getPluginIconImage(String pluginId, String iconPath) {
		String key = pluginId + iconPath;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = getImageDescriptor(pluginId, iconPath);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	public static Image getLocalPluginIconImage(String iconPath) {
		return getPluginIconImage(PLUGIN_ID, iconPath);
	}


	public static ImageDescriptor getLocalImageDescriptor(String iconPath) {
		return getImageDescriptor(PLUGIN_ID, iconPath);
	}

}
