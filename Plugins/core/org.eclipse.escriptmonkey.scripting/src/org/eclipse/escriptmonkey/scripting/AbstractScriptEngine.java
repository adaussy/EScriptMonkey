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
package org.eclipse.escriptmonkey.scripting;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.escriptmonkey.scripting.FileTrace.Trace;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.misc.UIStats;
import org.eclipse.ui.internal.progress.ProgressMessages;

/**
 * Base implementation for a script engine. Handles Job implementation of script engine, adding script code for execution, module loading support and
 * a basic
 * online help system.
 */
public abstract class AbstractScriptEngine extends Job implements IScriptEngine {

	/** List of code junks to be executed. */
	private final List<Script> mCodePieces = Collections.synchronizedList(new ArrayList<Script>());

	private final ListenerList mExecutionListeners = new ListenerList();

	/** Indicator to terminate once this Job gets IDLE. */
	private boolean mTerminateOnIdle = true;

	private PrintStream mOutStream = null;

	private PrintStream mErrorStream = null;

	private InputStream mInStream = null;

	private FileTrace mFileTrace = new FileTrace();

	private String mID;

	private boolean isUI = false;

	/**
	 * Constructor. Contains a name for the underlying job and an indicator for the presence of online help.
	 * 
	 * @param name
	 *        name of script engine job
	 * @param helpAvailable
	 *        <code>true</code> when help code shall be generated on the fly
	 */
	public AbstractScriptEngine(final String name) {
		super(name);

		// make this a system job (not visible to the user)
		setSystem(true);
	}

	@Override
	public final ScriptResult executeAsync(final Object content) {
		final Script piece;
		if(content instanceof Script)
			piece = (Script)content;
		else
			piece = new Script(content);

		mCodePieces.add(piece);
		synchronized(this) {
			notifyAll();
		}

		return piece.getResult();
	}

	@Override
	public final ScriptResult executeSync(final Object content) throws InterruptedException {

		if(getState() == NONE)
			throw new RuntimeException("Engine is not started yet, cannot run code");

		final ScriptResult result = executeAsync(content);
		synchronized(result) {
			while(!result.isReady())
				result.wait();
		}

		return result;
	}

	@Override
	public final ScriptResult inject(final Object content) {
		final Script piece;
		if(content instanceof Script)
			piece = (Script)content;
		else
			piece = new Script(content);

		// injected code shall not trigger a new event, therefore notifyListerners needs to be false
		return inject(piece, false);
	}

	/**
	 * Inject script code to the script engine. Injected code is processed synchronous by the current thread. Therefore this is a blocking call.
	 * 
	 * @param script
	 *        script to be executed
	 * @return script execution result
	 */
	private ScriptResult inject(final Script script, final boolean newScriptEvent) {

		synchronized(script.getResult()) {

			try {
				mFileTrace.push(script.getFile());

				// execution
				if(newScriptEvent)
					notifyExecutionListeners(script, IExecutionListener.SCRIPT_START);
				else
					notifyExecutionListeners(script, IExecutionListener.SCRIPT_INJECTION_START);

				script.setResult(execute(script, script.getFile(), mFileTrace.peek().getFileName()));

			} catch (final ExitException e) {
				script.setResult(e.getCondition());

			} catch (final BreakException e) {
				script.setResult(e.getCondition());

			} catch (final Exception e) {
				script.setException(e);
				String message = e.getMessage();
				if(message != null) {

					getErrorStream().println("Message :" + message);
				} else {
					getErrorStream().println("Stack trace");
					e.printStackTrace(getErrorStream());
				}


			} finally {
				if(newScriptEvent)
					notifyExecutionListeners(script, IExecutionListener.SCRIPT_END);
				else
					notifyExecutionListeners(script, IExecutionListener.SCRIPT_INJECTION_END);

				mFileTrace.pop();
			}
		}

		return script.getResult();
	}

	public final IStatus runUIThread(final IProgressMonitor monitor) {
		if(monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}
		Display asyncDisplay = getDisplay();
		if(asyncDisplay == null || asyncDisplay.isDisposed()) {
			return Status.CANCEL_STATUS;
		}
		asyncDisplay.asyncExec(new Runnable() {

			public void run() {
				IStatus result = null;
				Throwable throwable = null;
				try {
					//As we are in the UI Thread we can
					//always know what to tell the job.
					setThread(Thread.currentThread());
					if(monitor.isCanceled()) {
						result = Status.CANCEL_STATUS;
					} else {
						UIStats.start(UIStats.UI_JOB, getName());
						result = runCode(monitor);
					}

				} catch (Throwable t) {
					throwable = t;
				} finally {
					UIStats.end(UIStats.UI_JOB, AbstractScriptEngine.this, getName());
					if(result == null) {
						result = new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, IStatus.ERROR, ProgressMessages.InternalError, throwable);
					}
					done(result);
				}
			}
		});
		return Job.ASYNC_FINISH;
	}


	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus status = null;
		if(isUI()) {
			status = runUIThread(monitor);
		} else {
			status = runCode(monitor);
		}
		return status;
	}


	protected Display getDisplay() {
		return PlatformUI.getWorkbench().getDisplay();
	}

	public final IStatus runCode(final IProgressMonitor monitor) {
		if(setupEngine()) {
			mFileTrace = new FileTrace();

			notifyExecutionListeners(null, IExecutionListener.ENGINE_START);

			// main loop
			while((!monitor.isCanceled()) && (!isTerminated())) {

				// execute code
				if(!mCodePieces.isEmpty()) {
					final Script piece = mCodePieces.remove(0);
					inject(piece, true);

				} else {

					synchronized(this) {
						if(!isTerminated()) {
							try {
								wait();
							} catch (final InterruptedException e) {
							}
						}
					}
				}
			}

			// discard pending code pieces
			synchronized(mCodePieces) {
				for(final Script script : mCodePieces)
					script.setException(new ExitException());
			}

			mCodePieces.clear();

			notifyExecutionListeners(null, IExecutionListener.ENGINE_END);

			teardownEngine();
		}

		if(isTerminated())
			return Status.OK_STATUS;

		return Status.CANCEL_STATUS;
	}

	@Override
	public PrintStream getOutputStream() {
		return (mOutStream != null) ? mOutStream : System.out;
	}

	@Override
	public void setOutputStream(final OutputStream outputStream) {
		if(outputStream instanceof PrintStream)
			mOutStream = (PrintStream)outputStream;

		else
			mOutStream = new PrintStream(outputStream);
	}

	@Override
	public InputStream getInputStream() {
		return (mInStream != null) ? mInStream : System.in;
	}

	@Override
	public void setInputStream(final InputStream inputStream) {
		mInStream = inputStream;
	}

	@Override
	public PrintStream getErrorStream() {
		return (mErrorStream != null) ? mErrorStream : System.err;
	}

	@Override
	public void setErrorStream(final OutputStream errorStream) {
		if(errorStream instanceof PrintStream)
			mErrorStream = (PrintStream)errorStream;

		else
			mErrorStream = new PrintStream(errorStream);
	}

	@Override
	public final void setTerminateOnIdle(final boolean terminate) {
		mTerminateOnIdle = terminate;
	}

	@Override
	public boolean getTerminateOnIdle() {
		return mTerminateOnIdle;
	}

	/**
	 * Get termination status of the interpreter. A terminated interpreter cannot be restarted.
	 * 
	 * @return true if interpreter is terminated.
	 */
	private boolean isTerminated() {
		return mTerminateOnIdle && mCodePieces.isEmpty();
	}

	/**
	 * Get idle status of the interpreter. The interpreter is IDLE if there are no pending execution requests and the interpreter is not terminated.
	 * 
	 * @return true if interpreter is IDLE
	 */
	@Override
	public boolean isIdle() {
		return mCodePieces.isEmpty();
	}

	@Override
	public void addExecutionListener(final IExecutionListener listener) {
		mExecutionListeners.add(listener);
	}

	@Override
	public void removeExecutionListener(final IExecutionListener listener) {
		mExecutionListeners.remove(listener);
	}

	protected void notifyExecutionListeners(final Script script, final int status) {
		for(final Object listener : mExecutionListeners.getListeners())
			((IExecutionListener)listener).notify(this, script, status);
	}

	@Override
	public void terminate() {
		setTerminateOnIdle(true);
		mCodePieces.clear();
		terminateCurrent();

		// ask thread to terminate
		cancel();
		if(getThread() != null)
			getThread().interrupt();
	}

	@Override
	public void reset() {
		// make sure that everybody gets notified that script engine got a reset
		for(final Script script : mCodePieces)
			script.setException(new ExitException("Script engine got resetted."));

		mCodePieces.clear();

		// re-enable launch extensions to register themselves
		for(final IScriptEngineLaunchExtension extension : ScriptService.getLaunchExtensions(getID()))
			extension.createEngine(this);
	}

	@Override
	public FileTrace getFileTrace() {
		return mFileTrace;
	}

	@Override
	public Object getExecutedFile() {
		for(Trace trace : getFileTrace()) {
			Object file = trace.getFile();
			if(file != null)
				return file;
		}

		return null;
	}

	public void setEngineDescription(final EngineDescription description) {
		mID = description.getID();
	}

	@Override
	public String getID() {
		return mID;
	}

	public void setIsUI(boolean isUI) {
		this.isUI = isUI;
	}

	public boolean isUI() {
		return isUI;
	}

	/**
	 * Setup method for script engine. Run directly after the engine is activated. Needs to return <code>true</code>. Otherwise the engine will
	 * terminate
	 * instantly.
	 * 
	 * @return <code>true</code> when setup succeeds
	 */
	protected abstract boolean setupEngine();

	/**
	 * Teatdown engine. Called immediately before the engine terminates. This method is not called when {@link #setupEngine()} fails.
	 * 
	 * @return teardown result
	 */
	protected abstract boolean teardownEngine();

	/**
	 * Execute script code.
	 * 
	 * @param fileName
	 *        name of file executed
	 * @param reader
	 *        reader for script data to be executed
	 * @return execution result
	 * @throws Exception
	 *         any exception thrown during script execution
	 */
	protected abstract Object execute(Script script, Object reference, String fileName) throws Exception;
}
