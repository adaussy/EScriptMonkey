package org.eclipse.escriptmonkey.scripting.debugging.events;

public class ResumedEvent implements IDebuggerEvent {

	private final Thread mThread;

	private final ResumeRequest mRequest;

	public ResumedEvent(final Thread thread, final ResumeRequest request) {
		mThread = thread;
		mRequest = request;
	}

	public Thread getThread() {
		return mThread;
	}

	public ResumeRequest getRequest() {
		return mRequest;
	}
}
