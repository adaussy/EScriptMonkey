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
package org.eclipse.escriptmonkey.scripting.debugging.events;

import org.eclipse.escriptmonkey.scripting.Script;

public class ScriptReadyEvent implements IDebuggerEvent {

	private final Script mScript;

	private final Thread mThread;

	private final boolean mRoot;

	public ScriptReadyEvent(final Script script, final Thread thread, final boolean root) {
		mScript = script;
		mThread = thread;
		mRoot = root;
	}

	public Script getScript() {
		return mScript;
	}

	public Thread getThread() {
		return mThread;
	}

	public boolean isRoot() {
		return mRoot;
	}
}
