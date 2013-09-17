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
package org.eclipse.escriptmonkey.scripting;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.escriptmonkey.scripting";

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

}
