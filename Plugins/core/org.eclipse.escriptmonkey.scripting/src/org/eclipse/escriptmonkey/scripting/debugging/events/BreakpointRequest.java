package org.eclipse.escriptmonkey.scripting.debugging.events;

import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.escriptmonkey.scripting.Script;

public class BreakpointRequest implements IModelRequest {

	private final Script mScript;

	private final IBreakpoint mBreakpoint;

	public BreakpointRequest(final Script script, final IBreakpoint breakpoint) {
		mScript = script;
		mBreakpoint = breakpoint;
	}

	public Script getScript() {
		return mScript;
	}

	public IBreakpoint getBreakpoint() {
		return mBreakpoint;
	}
}
