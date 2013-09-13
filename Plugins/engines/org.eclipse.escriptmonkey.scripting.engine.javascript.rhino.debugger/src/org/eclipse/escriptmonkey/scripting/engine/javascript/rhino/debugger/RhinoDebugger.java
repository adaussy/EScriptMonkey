package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import org.eclipse.escriptmonkey.scripting.IExecutionListener;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.RhinoScriptEngine;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebugEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.EngineStartedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.EngineTerminatedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.ResumedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.ScriptReadyEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.debugger.ScriptTerminatedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.model.ResumeEvent;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

public class RhinoDebugger implements Debugger, IEventProcessor, IExecutionListener {

	private RhinoScriptEngine mEngine;

	private EventDispatchJob mDispatcher;

	private boolean mSuspended;

	public RhinoDebugger(final RhinoScriptEngine engine) {
		mEngine = engine;
		mEngine.addExecutionListener(this);
	}

	public void setDispatcher(final EventDispatchJob dispatcher) {
		mDispatcher = dispatcher;
	}

	public class RhinoDebugFrame implements DebugFrame {

		private int mLineNumber;

		private final DebuggableScript mScript;

		public RhinoDebugFrame(final DebuggableScript fnOrScript) {
			mScript = fnOrScript;
		}

		@Override
		public void onEnter(final Context cx, final Scriptable activation, final Scriptable thisObj, final Object[] args) {
			mLineNumber = 1;
		}

		@Override
		public void onLineChange(final Context cx, final int lineNumber) {
			mLineNumber = lineNumber;
		}

		@Override
		public void onExceptionThrown(final Context cx, final Throwable ex) {
		}

		@Override
		public void onExit(final Context cx, final boolean byThrow, final Object resultOrException) {
		}

		@Override
		public void onDebuggerStatement(final Context cx) {
		}

		public int getLineNumber() {
			return mLineNumber;
		}

		public DebuggableScript getScript() {
			return mScript;
		}
	}

	@Override
	public void handleCompilationDone(final Context cx, final DebuggableScript fnOrScript, final String source) {
	}

	private void fireDispatchEvent(final IDebugEvent event) {
		System.out.println("Debugger: ----> " + event);
		mDispatcher.addEvent(event);
	}

	@Override
	public DebugFrame getFrame(final Context cx, final DebuggableScript fnOrScript) {
		return new RhinoDebugFrame(fnOrScript);
	}

	@Override
	public void handleEvent(final IDebugEvent event) {
		System.out.println("     Debugger:  " + event);

		if(event instanceof ResumeEvent) {
			resume();
		}
	}

	@Override
	public void notify(final IScriptEngine engine, final Script script, final int status) {
		switch(status) {
		case ENGINE_START:
			fireDispatchEvent(new EngineStartedEvent());
			break;

		case ENGINE_END:
			fireDispatchEvent(new EngineTerminatedEvent());

			// allow for garbage collection
			mEngine = null;
			mDispatcher = null;
			break;

		case SCRIPT_START:
			fireDispatchEvent(new ScriptReadyEvent(script, Thread.currentThread()));
			suspend();
			break;

		case SCRIPT_END:
			fireDispatchEvent(new ScriptTerminatedEvent(script));
			break;

		default:
			// unknown event
			break;
		}
	}

	private void resume() {

		synchronized(mEngine) {
			mSuspended = false;
			mEngine.notifyAll();
		}
	}

	private void suspend() {
		synchronized(mEngine) {
			mSuspended = true;

			try {
				while(mSuspended)
					mEngine.wait();

			} catch (final InterruptedException e) {
				mSuspended = false;
			}

			fireDispatchEvent(new ResumedEvent());
		}
	}
}
