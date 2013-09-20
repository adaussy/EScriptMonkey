package org.eclipse.escriptmonkey.scripting.debugging.events;

public class ScriptStartRequest implements IModelRequest {

	private final Thread mThread;

	public ScriptStartRequest(final Thread thread) {
		mThread = thread;
	}
}
