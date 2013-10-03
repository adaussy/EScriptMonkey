/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.escriptmonkey.scripting.debugging.events.ScriptStartRequest;
import org.eclipse.escriptmonkey.scripting.debugging.events.StackFramesEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.SuspendedEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.TerminateRequest;
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

	private Thread mThread;

	private final boolean mShowDynamicCode;

	private int mRunMode;

	private List<IScriptDebugFrame> mResumedFrames;

	public RhinoDebugger(final RhinoScriptEngine engine, final boolean showDynamicCode) {
		mEngine = engine;
		mShowDynamicCode = showDynamicCode;
		mEngine.addExecutionListener(this);
	}

	public void setDispatcher(final EventDispatchJob dispatcher) {
		mDispatcher = dispatcher;
	}

	public class RhinoDebugFrame implements DebugFrame, IScriptDebugFrame {

		private int mLineNumber = 0;

		private final DebuggableScript mFnOrScript;

		public RhinoDebugFrame(final DebuggableScript fnOrScript) {
			mFnOrScript = fnOrScript;
		}

		@Override
		public void onEnter(final Context cx, final Scriptable activation, final Scriptable thisObj, final Object[] args) {
			if(!mFnOrScript.isFunction()) {
				// this is a new script source, no function call
				fireDispatchEvent(new ScriptReadyEvent(getScript(), mThread, mDebugFrames.size() == 1));
				suspend();
			}
		}

		@Override
		public void onLineChange(final Context cx, final int lineNumber) {
			mLineNumber = lineNumber;

			// check breakpoints
			// TODO use cache for faster lookup
			final List<IBreakpoint> breakpoints = mScriptBreakpoints.get(mFrameToSource.get(mFnOrScript));
			if(breakpoints != null) {
				for(final IBreakpoint breakpoint : breakpoints) {
					try {
						if(breakpoint.isEnabled()) {
							final int breakline = breakpoint.getMarker().getAttribute(IMarker.LINE_NUMBER, -1);
							if(breakline == lineNumber) {
								fireDispatchEvent(new SuspendedEvent(DebugEvent.BREAKPOINT, mThread, mDebugFrames));
								mRunMode = DebugEvent.CLIENT_REQUEST;
								suspend();
								return;
							}
						}
					} catch (final CoreException e) {
						// cannot query enabled property, ignore breakpoint
					}
				}
			}

			// no breakpoint, check for step into
			if(mRunMode == DebugEvent.STEP_INTO) {
				// this is the next chance to stop
				fireDispatchEvent(new SuspendedEvent(DebugEvent.STEP_END, mThread, mDebugFrames));
				suspend();
				return;
			}

			// check for step over
			if(mRunMode == DebugEvent.STEP_OVER) {
				// check call stack
				if(mResumedFrames.size() >= mDebugFrames.size()) {
					// call stack did not grow
					fireDispatchEvent(new SuspendedEvent(DebugEvent.STEP_END, mThread, mDebugFrames));
					suspend();
					return;
				}
			}
		}

		@Override
		public void onExceptionThrown(final Context cx, final Throwable ex) {
		}

		@Override
		public void onExit(final Context cx, final boolean byThrow, final Object resultOrException) {
			mDebugFrames.remove(this);

			// check for step return / step over
			if((mRunMode == DebugEvent.STEP_RETURN) || (mRunMode == DebugEvent.STEP_OVER)) {
				// check call stack
				if((mResumedFrames.size() > mDebugFrames.size()) && (!mDebugFrames.isEmpty())) {
					// call stack got smaller
					fireDispatchEvent(new SuspendedEvent(DebugEvent.STEP_END, mThread, mDebugFrames));
					suspend();
				}
			}
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
			return RhinoDebugger.this.getScript(mFnOrScript);
		}

		@Override
		public int getType() {
			return mFnOrScript.isFunction() ? TYPE_FUNCTION : TYPE_FILE;
		}

		@Override
		public String getName() {
			if(mFnOrScript.isFunction())
				return mFnOrScript.getFunctionName() + "()";

			else {
				final Object file = getScript().getFile();
				if(file != null) {
					if(file instanceof IFile)
						return ((IFile)file).getName();

					else if(file instanceof File)
						return ((File)file).getName();

				} else {
					// dynamic script
					final String title = getScript().getTitle();
					return (title != null) ? "Dynamic: " + title : "(Dynamic)";
				}
			}

			return "(unknown source)";
		}

		@Override
		public Map<String, Object> getVariables() {
			return mEngine.getVariables();
		}
	}

	@Override
	public void handleCompilationDone(final Context cx, final DebuggableScript fnOrScript, final String source) {
	}

	private void fireDispatchEvent(final IDebugEvent event) {
		System.out.println("Debugger: ----> " + event);
		synchronized(mDispatcher) {
			if(mDispatcher != null)
				mDispatcher.addEvent(event);
		}
	}

	@Override
	public DebugFrame getFrame(final Context cx, final DebuggableScript fnOrScript) {

		Script script = getScript(fnOrScript);
		if(script == null) {
			script = mLastScript;
			mLastScript = null;
		}

		if(script == null)
			return null;

		// ignore dynamic code if not requested by debug target
		if(!mShowDynamicCode && (isDynamicCode(script))) {
			return null;
		}

		// register script source
		DebuggableScript parentScript = getParentScript(fnOrScript);
		if(!mFrameToSource.containsKey(parentScript))
			mFrameToSource.put(parentScript, script);

		// create debug frame
		final RhinoDebugFrame debugFrame = new RhinoDebugFrame(fnOrScript);
		mDebugFrames.add(0, debugFrame);

		return debugFrame;
	}

	@Override
	public void handleEvent(final IDebugEvent event) {
		System.out.println("     Debugger:  " + event);

		if(event instanceof ResumeRequest) {
			// store resume mode
			mRunMode = ((ResumeRequest)event).getType();
			// store debug frame stack on resume event (to detect step into/over/return) 
			if(mRunMode != DebugEvent.CLIENT_REQUEST)
				// only for step commands
				mResumedFrames = new ArrayList<IScriptDebugFrame>(mDebugFrames);

			resume();

		} else if(event instanceof ScriptStartRequest) {
			resume();

		} else if(event instanceof BreakpointRequest) {
			final Script script = ((BreakpointRequest)event).getScript();
			if(!mScriptBreakpoints.containsKey(script))
				mScriptBreakpoints.put(script, new ArrayList<IBreakpoint>());

			mScriptBreakpoints.get(script).add(((BreakpointRequest)event).getBreakpoint());

		} else if(event instanceof GetStackFramesRequest) {
			fireDispatchEvent(new StackFramesEvent(mDebugFrames, mThread));

		} else if(event instanceof TerminateRequest) {
			// TODO implement
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
			synchronized(mDispatcher) {
				mDispatcher = null;
			}
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

			fireDispatchEvent(new ResumedEvent(Thread.currentThread(), mRunMode));
		}
	}

	private Script getScript(final DebuggableScript rhinoScript) {
		return mFrameToSource.get(getParentScript(rhinoScript));
	}

	private static DebuggableScript getParentScript(DebuggableScript rhinoScript) {
		while(rhinoScript.getParent() != null)
			rhinoScript = rhinoScript.getParent();

		return rhinoScript;
	}

	private static boolean isDynamicCode(final Script script) {
		return (script.getFile() == null);
	}
}
