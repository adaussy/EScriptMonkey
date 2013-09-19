package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.escriptmonkey.scripting.debugging.events.IDebugEvent;

public interface IEventProcessor {

	void handleEvent(IDebugEvent event);
}
