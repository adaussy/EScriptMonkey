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
