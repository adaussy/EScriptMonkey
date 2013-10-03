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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.util.ArrayList;
import java.util.List;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

public class LineNumberDebugger implements Debugger {

	/** Keeps stack immutable. */
	private boolean mFreezeStack = false;

	public class LineNumberDebugFrame implements DebugFrame {

		private int mLineNumber;

		private final DebuggableScript mScript;

		public LineNumberDebugFrame(final DebuggableScript fnOrScript) {
			mScript = fnOrScript;
		}

		@Override
		public void onEnter(final Context cx, final Scriptable activation, final Scriptable thisObj, final Object[] args) {
			mFreezeStack = false;
			mLineNumber = 1;
			mFrames.add(this);
		}

		@Override
		public void onLineChange(final Context cx, final int lineNumber) {
			// if stack was frozen, then we had some try/catch structure
			mFreezeStack = false;
			mLineNumber = lineNumber;
		}

		@Override
		public void onExceptionThrown(final Context cx, final Throwable ex) {
			// stack should be frozen when an exception is thrown
			mFreezeStack = true;
		}

		@Override
		public void onExit(final Context cx, final boolean byThrow, final Object resultOrException) {
			if(!mFreezeStack)
				mFrames.remove(mFrames.size() - 1);
		}

		@Override
		public void onDebuggerStatement(final Context cx) {
		}

		public int getLineNumber() {
			return mLineNumber;
		}

		public DebuggableScript getScript() {
			return mScript;
		}
	}

	private final List<LineNumberDebugFrame> mFrames = new ArrayList<LineNumberDebugFrame>();

	public Object getContextData() {
		return null;
	}

	@Override
	public void handleCompilationDone(final Context cx, final DebuggableScript fnOrScript, final String source) {
	}

	@Override
	public DebugFrame getFrame(final Context cx, final DebuggableScript fnOrScript) {
		return new LineNumberDebugFrame(fnOrScript);
	}

	public List<LineNumberDebugFrame> getFrames() {
		return mFrames;
	}
}
