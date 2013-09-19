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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.ui.launching;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptService;
import org.eclipse.escriptmonkey.scripting.debugging.EventDispatchJob;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.RhinoScriptEngine;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.RhinoDebugger;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model.RhinoDebugTarget;
import org.eclipse.escriptmonkey.scripting.ui.launching.AbstractLaunchDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * Quick launcher for JavaScript files.
 */
public class Launcher extends AbstractLaunchDelegate {

	@Override
	protected IScriptEngine getScriptEngine(final ILaunchConfiguration configuration, final String mode) {
		final IScriptService scriptService = (IScriptService)PlatformUI.getWorkbench().getService(IScriptService.class);

		return scriptService.createEngineByID("org.eclipse.escriptmonkey.scripting.javascript.rhino");
	}

	@Override
	protected String getLaunchConfigurationType() {
		return "org.eclipse.escriptmonkey.launchConfigurationType.rhino";
	}

	@Override
	protected void setupDebugger(final IScriptEngine engine, final ILaunchConfiguration configuration, final ILaunch launch) {
		if(engine instanceof RhinoScriptEngine) {

			final RhinoDebugTarget debugTarget = new RhinoDebugTarget(launch);
			launch.addDebugTarget(debugTarget);

			final RhinoDebugger debugger = new RhinoDebugger((RhinoScriptEngine)engine);
			((RhinoScriptEngine)engine).setDebugger(debugger);

			final EventDispatchJob dispatcher = new EventDispatchJob(debugTarget, debugger);
			debugTarget.setDispatcher(dispatcher);
			debugger.setDispatcher(dispatcher);
			dispatcher.schedule();
		}
	}
}
