package org.eclipse.escriptmonkey.scripting.debugging.events;

import org.eclipse.debug.core.DebugEvent;

public class ResumeRequest implements IModelRequest {

	private final int mType;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *        one of {@link DebugEvent#CLIENT_REQUEST}, {@link DebugEvent#STEP_INTO}, {@link DebugEvent#STEP_OVER}, {@link DebugEvent#STEP_RETURN}
	 * @param thread
	 *        thread to resume
	 */
	public ResumeRequest(final int type, final Thread thread) {
		mType = type;
	}

	public int getType() {
		return mType;
	}
}
