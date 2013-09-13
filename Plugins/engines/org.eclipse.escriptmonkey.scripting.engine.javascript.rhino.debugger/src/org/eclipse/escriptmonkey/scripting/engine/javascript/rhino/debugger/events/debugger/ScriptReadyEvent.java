package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger;

import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebuggerEvent;

public class ScriptReadyEvent implements IDebuggerEvent {

	private final Script mScript;

	private final Thread mThread;

	public ScriptReadyEvent(final Script script, final Thread thread) {
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
