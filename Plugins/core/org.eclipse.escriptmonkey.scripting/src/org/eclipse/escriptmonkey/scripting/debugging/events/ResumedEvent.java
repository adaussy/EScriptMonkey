package org.eclipse.escriptmonkey.scripting.debugging.events;

public class ResumedEvent implements IDebuggerEvent {

	private final Thread mThread;

	private final int mType;

	public ResumedEvent(final Thread thread, final int type) {
		mThread = thread;
		mType = type;
	}

	public Thread getThread() {
		return mThread;
	}

	public int getType() {
		return mType;
	}
}
