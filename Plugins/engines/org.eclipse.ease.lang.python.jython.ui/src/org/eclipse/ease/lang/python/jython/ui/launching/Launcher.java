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
package org.eclipse.ease.lang.python.jython.ui.launching;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.ease.IScriptEngine;
import org.eclipse.ease.IScriptService;
import org.eclipse.ease.ui.launching.AbstractLaunchDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * Quick launcher for JavaScript files.
 */
public class Launcher extends AbstractLaunchDelegate {

	@Override
	protected IScriptEngine getScriptEngine(final ILaunchConfiguration configuration, final String mode) {
		final IScriptService scriptService = (IScriptService)PlatformUI.getWorkbench().getService(IScriptService.class);

		return scriptService.createEngineByID("org.eclipse.ease.python.jython");
	}

	@Override
	protected String getLaunchConfigurationType() {
		return "org.eclipse.escriptmonkey.launchConfigurationType.jython";
	}

	@Override
	protected void setupDebugger(final IScriptEngine engine, final ILaunchConfiguration configuration, final ILaunch launch) {
	}
}
