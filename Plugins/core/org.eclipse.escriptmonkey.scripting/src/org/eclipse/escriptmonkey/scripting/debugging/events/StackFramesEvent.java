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
