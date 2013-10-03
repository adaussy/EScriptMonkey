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

public class ScriptTerminatedEvent implements IDebuggerEvent {

	private final Script mScript;

	private final Thread mThread;

	public ScriptTerminatedEvent(final Script script, final Thread thread) {
		mScript = script;
		mThread = thread;
	}

	public Script getScript() {
		return mScript;
	}

	public Thread getThread() {
		return mThread;
	}
}
