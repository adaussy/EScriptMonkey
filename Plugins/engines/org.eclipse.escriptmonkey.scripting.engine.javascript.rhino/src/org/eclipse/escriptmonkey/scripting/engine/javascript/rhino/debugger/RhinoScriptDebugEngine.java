package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.io.IOException;

import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.RhinoScriptEngine;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.tools.ToolErrorReporter;

public class RhinoScriptDebugEngine extends RhinoScriptEngine {

    private IContextConsumer mConsumer;
    private LocalDebuggerImpl mDebugger;

    public RhinoScriptDebugEngine() {
    }

    @Override
    protected synchronized boolean setupEngine() {

        super.setupEngine();

        Context context = getContext();

        context.setOptimizationLevel(-1);
        context.setGeneratingDebug(true);
        context.setGeneratingSource(true);

        if (mConsumer != null) {
            mConsumer.setContext(context);
            // consumer only needed once
            mConsumer = null;
        }

        context.setErrorReporter(new ToolErrorReporter(true));

        if (mDebugger == null) {
            LineNumberDebugger debugger = new LineNumberDebugger();
            context.setDebugger(debugger, null);
            mDebugger.contextCreated(context);
        }

        else {
            context.setDebugger(mDebugger, null);
            mDebugger.contextCreated(context);
        }

        return true;
    }

    @Override
    protected synchronized boolean teardownEngine() {
        if (mDebugger != null) {
            mDebugger.stop();
            mDebugger = null;
        }

        // gracefully close I/O streams
        try {
            if ((getInputStream() != null) && (!System.in.equals(getInputStream())))
                getInputStream().close();
        } catch (IOException e) {
        }
        try {
            if ((getOutputStream() != null) && (!System.out.equals(getOutputStream())))
                getOutputStream().close();
        } catch (Exception e) {
        }
        try {
            if ((getErrorStream() != null) && (!System.err.equals(getErrorStream())))
                getErrorStream().close();
        } catch (Exception e) {
        }

        return super.teardownEngine();
    }

    public void setContextConsumer(final IContextConsumer consumer) {
        mConsumer = consumer;
    }

    public void setDebugger(final LocalDebuggerImpl debugger) {
        mDebugger = debugger;
    }
}
