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

public class SuspendedEvent implements IDebuggerEvent {

	private final int mType;

	private final Thread mThread;

	private final List<IScriptDebugFrame> mDebugFrames;

	public SuspendedEvent(final int type, final Thread thread, final List<IScriptDebugFrame> debugFrames) {
		mType = type;
		mThread = thread;
		mDebugFrames = debugFrames;
	}

	public int getType() {
		return mType;
	}

	public Thread getThread() {
		return mThread;
	}

	public List<IScriptDebugFrame> getDebugFrames() {
		return mDebugFrames;
	}
}
