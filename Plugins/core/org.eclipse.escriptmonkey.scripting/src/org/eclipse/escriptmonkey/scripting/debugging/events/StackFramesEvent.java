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

import java.util.List;

import org.eclipse.escriptmonkey.scripting.debugging.IScriptDebugFrame;

public class StackFramesEvent implements IDebuggerEvent {

	private final List<IScriptDebugFrame> mDebugFrames;

	private final Thread mThread;

	public StackFramesEvent(final List<IScriptDebugFrame> debugFrames, final Thread thread) {
		mDebugFrames = debugFrames;
		mThread = thread;
	}

	public List<IScriptDebugFrame> getDebugFrames() {
		return mDebugFrames;
	}

	public Thread getThread() {
		return mThread;
	}
}
