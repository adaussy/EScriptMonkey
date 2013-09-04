package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import org.eclipse.wst.jsdt.debug.internal.rhino.debugger.ThreadData;
import org.mozilla.javascript.Context;

public class LocalThreadData extends ThreadData {

    private long currentContextId = 0L;

    private final Long mThreadId;

    private final LocalDebuggerImpl mDebugger;

    public LocalThreadData(final Long threadId, final LocalDebuggerImpl debugger) {
        super(threadId, debugger);
        mThreadId = threadId;
        mDebugger = debugger;
    }

    @Override
    public synchronized void contextCreated(final Context context) {

        super.contextCreated(context);
        LocalContextData infineonContextData = new LocalContextData(mThreadId, new Long(currentContextId++), mDebugger);
        context.setDebugger(mDebugger, infineonContextData);

    }

}
