package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebugEvent;

public interface IEventProcessor {

	void handleEvent(IDebugEvent event);
}
