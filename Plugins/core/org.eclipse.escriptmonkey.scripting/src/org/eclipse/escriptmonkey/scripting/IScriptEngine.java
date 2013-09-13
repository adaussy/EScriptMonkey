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

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

/**
 * Interface for a script engine. A script engine is capable of interpreting script code at runtime. Script engines shall be derived from
 * {@link Thread} and
 * therefore run separately from other code. An engine shall be started by calling {@link #schedule()}.
 */
public interface IScriptEngine {

	/**
	 * Execute script code asynchronously. The code provided will be scheduled and executed as soon as all previously scheduled code is executed. If
	 * <i>content</i> is a {@link Reader} object, or a {@link File} special treatment is done, otherwise the toString() method is used to extract
	 * script code.
	 * 
	 * @param content
	 *        content to be executed.
	 * @return execution result
	 */
	ScriptResult executeAsync(final Object content);

	/**
	 * Execute script code synchronously. The code provided will be scheduled and executed as soon as all previously scheduled code is executed.If
	 * <i>content</i> is a {@link Reader} object, or a {@link File} special treatment is done, otherwise the toString() method is used to extract
	 * script code.
	 * The calling thread is stalled until the script code is processed.
	 * 
	 * @param content
	 *        content to be executed.
	 * @return execution result
	 * @throws InterruptedException
	 *         when execution is interrupted
	 */
	ScriptResult executeSync(final Object content) throws InterruptedException;

	/**
	 * Inject script code and execute synchronously. Code passed to this method will be invoked immediately. It might interrupt a currently running
	 * execution
	 * requested asynchronously.
	 * 
	 * @param content
	 *        content to be executed.
	 * @return execution result
	 */
	ScriptResult inject(final Object content);

	/**
	 * Get the currently executed file instance.
	 * 
	 * @return currently executed file
	 */
	Object getExecutedFile();

	/**
	 * Set the default output stream for the interpreter.
	 * 
	 * @param outputStream
	 *        default output stream
	 */
	void setOutputStream(final OutputStream outputStream);

	/**
	 * Set the default error stream for the interpreter.
	 * 
	 * @param outputStream
	 *        default error stream
	 */
	void setErrorStream(final OutputStream outputStream);

	/**
	 * Set the default input stream for the interpreter.
	 * 
	 * @param inputStream
	 *        default input stream
	 */
	void setInputStream(final InputStream inputStream);

	PrintStream getOutputStream();

	PrintStream getErrorStream();

	InputStream getInputStream();

	/**
	 * Set a marker that the interpreter should terminate instead entering IDLE mode. If set, the interpreter will execute all pending requests and
	 * terminate
	 * afterwards.
	 * 
	 * @param terminate
	 *        true to request termination
	 */
	void setTerminateOnIdle(final boolean terminate);

	/**
	 * Get termination condition when engine is idle.
	 * 
	 * @return <code>true</code> when engine is terminated when idle
	 */
	boolean getTerminateOnIdle();

	/**
	 * Schedule script execution. This will start the script engine that either waits for input or immediate starts execution of previously scheduled
	 * input.
	 */
	void schedule();

	/**
	 * Terminate this interpreter. Addresses a request to terminate current script execution. When the request will be handled is implementation
	 * specific.
	 */
	void terminate();

	/**
	 * Stops the currently executed piece of code. Will continue to execute the next scheduled piece of code.
	 */
	void terminateCurrent();

	public void addExecutionListener(IExecutionListener listener);

	void removeExecutionListener(IExecutionListener listener);

	/**
	 * Set to true if the thread as to be launch in the UI thread
	 * 
	 * @param isUI
	 */
	public void setIsUI(boolean isUI);

	/**
	 * Return true is the engine will be launch in the UI Thread
	 * 
	 * @return
	 */
	public boolean isUI();

	/**
	 * Resets the script engine to a fresh state (removes all variables and code history).
	 */
	void reset();

	/**
	 * Returns the execution state of the engine. If the engine is processing code or is terminated this will return <code>false</code>. If the engine
	 * is
	 * waiting for further scripts to execute this will return <code>true</code>.
	 * 
	 * @return execution state.
	 */
	boolean isIdle();

	/**
	 * Get the current file trace. A trace is a stack starting with the root file executed by the engine. Files called via include command will be put
	 * on top of
	 * that stack. Each entry may contain a pointer to the current line number executed. Traces might be created dynamically on demand or accumulated
	 * during
	 * execution depending on the underlying engine.
	 * 
	 * @return current FileTrace
	 */
	FileTrace getFileTrace();

	/**
	 * Get the engine ID.
	 * 
	 * @return engine ID
	 */
	String getID();

	/**
	 * Get the engine name.
	 * 
	 * @return engine name
	 */
	String getName();
}
