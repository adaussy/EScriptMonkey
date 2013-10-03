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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.debugging.ScriptDebugTarget;
import org.eclipse.escriptmonkey.scripting.debugging.events.IDebugEvent;

public class RhinoDebugTarget extends ScriptDebugTarget {

	public RhinoDebugTarget(final ILaunch launch, final boolean suspendOnStartup) {
		super(launch, suspendOnStartup);

		fireCreationEvent();
	}

	@Override
	public String getName() throws DebugException {
		return "eScriptMonkey Rhino Debugger";
	}

	// ************************************************************
	// IEventProcessor
	// ************************************************************

	@Override
	public void handleEvent(final IDebugEvent event) {
		//		System.out.println("     Target:    " + event);

		super.handleEvent(event);

	}

	@Override
	protected IBreakpoint[] getBreakpoints(final Script script) {
		return DebugPlugin.getDefault().getBreakpointManager().getBreakpoints("org.eclipse.wst.jsdt.debug.model");
	}

}
