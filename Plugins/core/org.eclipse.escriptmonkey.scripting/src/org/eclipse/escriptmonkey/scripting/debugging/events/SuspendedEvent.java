package org.eclipse.escriptmonkey.scripting.debugging.events;

public class SuspendedEvent implements IDebuggerEvent {

	private final int mType;

	private final Thread mThread;

	public SuspendedEvent(final int type, final Thread thread) {
		mType = type;
		mThread = thread;
	}

	public int getType() {
		return mType;
	}

	public Thread getThread() {
		return mThread;
	}
}
