package org.eclipse.escriptmonkey.scripting.debugging.events;

public class ResumeRequest implements IModelRequest {

	private final int mType;

	public ResumeRequest(final int type, final Thread thread) {
		mType = type;
	}

	public int getType() {
		return mType;
	}
}
