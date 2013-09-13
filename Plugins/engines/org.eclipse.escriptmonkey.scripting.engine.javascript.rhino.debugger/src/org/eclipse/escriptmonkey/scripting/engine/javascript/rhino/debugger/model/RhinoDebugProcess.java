package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class RhinoDebugProcess extends RhinoDebugElement implements IProcess {

	private final Map<String, String> mAttributes = new HashMap<String, String>();

	public RhinoDebugProcess(final RhinoDebugTarget target) {
		super(target);
	}

	@Override
	public String getLabel() {
		return "virtual Rhino Process";
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	@Override
	public void setAttribute(final String key, final String value) {
		mAttributes.put(key, value);
	}

	@Override
	public String getAttribute(final String key) {
		return mAttributes.get(key);
	}

	@Override
	public int getExitValue() throws DebugException {
		return 0;
	}
}
