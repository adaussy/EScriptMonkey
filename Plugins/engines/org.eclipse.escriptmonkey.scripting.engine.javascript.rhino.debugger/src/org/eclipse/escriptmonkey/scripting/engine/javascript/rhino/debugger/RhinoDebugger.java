package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.escriptmonkey.scripting.IExecutionListener;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.debugging.EventDispatchJob;
import org.eclipse.escriptmonkey.scripting.debugging.IEventProcessor;
import org.eclipse.escriptmonkey.scripting.debugging.IScriptDebugFrame;
import org.eclipse.escriptmonkey.scripting.debugging.events.BreakpointRequest;
import org.eclipse.escriptmonkey.scripting.debugging.events.EngineStartedEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.EngineTerminatedEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.GetStackFramesRequest;
import org.eclipse.escriptmonkey.scripting.debugging.events.IDebugEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.ResumeRequest;
import org.eclipse.escriptmonkey.scripting.debugging.events.ResumedEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.ScriptReadyEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.StackFramesEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.SuspendedEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.RhinoScriptEngine;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

public class RhinoDebugger implements Debugger, IEventProcessor, IExecutionListener {

	private RhinoScriptEngine mEngine;

	private EventDispatchJob mDispatcher;

	private boolean mSuspended;

	private final Map<DebuggableScript, Script> mFrameToSource = new HashMap<DebuggableScript, Script>();

	private final List<IScriptDebugFrame> mDebugFrames = new ArrayList<IScriptDebugFrame>();

	private final Map<Script, List<IBreakpoint>> mScriptBreakpoints = new HashMap<Script, List<IBreakpoint>>();

	private Script mLastScript = null;

	private ResumeRequest mLastResumeRequest;

	private Thread mThread;

	public RhinoDebugger(final RhinoScriptEngine engine) {
		mEngine = engine;
		mEngine.addExecutionListener(this);
	}

	public void setDispatcher(final EventDispatchJob dispatcher) {
		mDispatcher = dispatcher;
	}

	public class RhinoDebugFrame implements DebugFrame, IScriptDebugFrame {

		private int mLineNumber = 0;

		private final DebuggableScript mFnOrScript;

		private boolean started = false;

		public RhinoDebugFrame(final DebuggableScript fnOrScript) {
			mFnOrScript = fnOrScript;
		}

		@Override
		public void onEnter(final Context cx, final Scriptable activation, final Scriptable thisObj, final Object[] args) {
			final int[] lineNumbers = mFnOrScript.getLineNumbers();
			if(lineNumbers.length == 0) {
				// script contains no executable code (eg only functions or comments)
				started = true;
				fireDispatchEvent(new ScriptReadyEvent(getScript(), mThread));
				suspend();
			}
		}

		@Override
		public void onLineChange(final Context cx, final int lineNumber) {
			mLineNumber = lineNumber;

			// see if we need to break
			// TODO use cache for faster lookup
			final List<IBreakpoint> breakpoints = mScriptBreakpoints.get(mFrameToSource.get(mFnOrScript));
			if(breakpoints != null) {
				for(final IBreakpoint breakpoint : breakpoints) {
					try {
						if(breakpoint.isEnabled()) {
							final int breakline = breakpoint.getMarker().getAttribute(IMarker.LINE_NUMBER, -1);
							if(breakline == lineNumber) {
								fireDispatchEvent(new SuspendedEvent(DebugEvent.BREAKPOINT, mThread));
								suspend();
								started = true;
							}
						}
					} catch (final CoreException e) {
						// cannot query enabled property, ignore breakpoint
					}
				}
			}

			// suspend on script load
			if(!started) {
				started = true;
				fireDispatchEvent(new ScriptReadyEvent(getScript(), mThread));
				suspend();
			}
		}

		@Override
		public void onExceptionThrown(final Context cx, final Throwable ex) {
		}

		@Override
		public void onExit(final Context cx, final boolean byThrow, final Object resultOrException) {
			mDebugFrames.remove(this);
		}

		@Override
		public void onDebuggerStatement(final Context cx) {
		}

		@Override
		public int getLineNumber() {
			return mLineNumber;
		}

		@Override
		public Script getScript() {
			// find root script (eg for function calls)
			DebuggableScript root = mFnOrScript;
			while(root.getParent() != null)
				root = root.getParent();

			return mFrameToSource.get(root);
		}

		@Override
		public int getType() {
			return mFnOrScript.isFunction() ? TYPE_FUNCTION : TYPE_FILE;
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

		if(fnOrScript.isFunction()) {
			// function called
		} else {
			if(!mFrameToSource.containsKey(fnOrScript)) {
				if(mLastScript == null)
					throw new RuntimeException("LastScript cannot be null");
				mFrameToSource.put(fnOrScript, mLastScript);
				mLastScript = null;
			}
		}

		final RhinoDebugFrame debugFrame = new RhinoDebugFrame(fnOrScript);
		mDebugFrames.add(0, debugFrame);

		return debugFrame;
	}

	@Override
	public void handleEvent(final IDebugEvent event) {
		System.out.println("     Debugger:  " + event);

		if(event instanceof ResumeRequest) {
			resume((ResumeRequest)event);

		} else if(event instanceof BreakpointRequest) {
			final Script script = ((BreakpointRequest)event).getScript();
			if(!mScriptBreakpoints.containsKey(script))
				mScriptBreakpoints.put(script, new ArrayList<IBreakpoint>());

			mScriptBreakpoints.get(script).add(((BreakpointRequest)event).getBreakpoint());

		} else if(event instanceof GetStackFramesRequest) {
			fireDispatchEvent(new StackFramesEvent(mDebugFrames, mThread));
		}
	}

	@Override
	public void notify(final IScriptEngine engine, final Script script, final int status) {
		switch(status) {
		case ENGINE_START:
			fireDispatchEvent(new EngineStartedEvent());
			mThread = Thread.currentThread();
			break;

		case ENGINE_END:
			fireDispatchEvent(new EngineTerminatedEvent());

			// allow for garbage collection
			mEngine = null;
			mDispatcher = null;
			break;

		case SCRIPT_START:
			// fall through
		case SCRIPT_INJECTION_START:
			if(mLastScript != null)
				throw new RuntimeException("LastScript has to be null");

			mLastScript = script;
			break;

		case SCRIPT_END:
			// fall through
		case SCRIPT_INJECTION_END:
			// nothing to do
			break;

		default:
			// unknown event
			break;
		}
	}

	private void resume(final ResumeRequest event) {
		mLastResumeRequest = event;

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

			fireDispatchEvent(new ResumedEvent(Thread.currentThread(), mLastResumeRequest));
		}
	}
}
