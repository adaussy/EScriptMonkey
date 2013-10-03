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
package org.eclipse.escriptmonkey.scripting.debugging;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class ScriptDebugProcess extends ScriptDebugElement implements IProcess {

	private final Map<String, String> mAttributes = new HashMap<String, String>();

	public ScriptDebugProcess(final ScriptDebugTarget target) {
		super(target);
	}

	@Override
	public String getLabel() {
		return "virtual Script Process";
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	@Override
	public void setAttribute(final String key, final String value) {
		mAttributes.put(key, value);
	}

	@Override
	public String getAttribute(final String key) {
		return mAttributes.get(key);
	}

	@Override
	public int getExitValue() throws DebugException {
		return 0;
	}

	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	@Override
	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	@Override
	public boolean isStepping() {
		return getDebugTarget().isStepping();
	}
}
