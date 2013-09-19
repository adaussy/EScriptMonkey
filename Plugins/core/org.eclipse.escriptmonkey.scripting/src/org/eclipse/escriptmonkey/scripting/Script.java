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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;

/**
 * Scriptable object. Consists of scriptable data and a result container.
 */
public class Script {

	/** command to be executed. */
	private final Object mCommand;

	/** script result returned from command. */
	private final ScriptResult mResult;

	private String mCodeBuffer = null;

	private final String mTitle;

	/**
	 * Constructor.
	 * 
	 * @param title
	 *        name of script object
	 * @param command
	 *        command (sequence) to be executed
	 */
	public Script(final String title, final Object command) {
		mTitle = title;
		mCommand = command;
		mResult = new ScriptResult();
	}

	/**
	 * Constructor.
	 * 
	 * @param command
	 *        command (sequence) to be executed
	 */
	public Script(final Object command) {
		this(null, command);
	}

	/**
	 * Get the scriptable data as {@link InputStream}. The caller needs to close the stream when it is not used anymore. Calling this method multiple
	 * times will return different streams with the same text content.
	 * 
	 * @return scriptable data
	 * @throws Exception
	 */
	public InputStream getCodeStream() throws Exception {
		return new ByteArrayInputStream(getCode().getBytes());
	}

	/**
	 * Get the scriptable data as {@link InputStream}. The caller needs to close the stream when it is not used anymore.
	 * 
	 * @return scriptable data
	 * @throws Exception
	 */
	public String getCode() throws Exception {
		if(mCodeBuffer != null)
			return mCodeBuffer;

		if(mCommand instanceof String)
			return (String)mCommand;

		if(mCommand instanceof InputStream)
			// streams can only be read once, therefore buffer
			return bufferStream((InputStream)mCommand);

		if(mCommand instanceof Reader)
			// readers can only be read once, therefore buffer
			return bufferReader((Reader)mCommand);

		// if we already have a scriptable
		if(mCommand instanceof IScriptable)
			return bufferStream(((IScriptable)mCommand).getSourceCode());

		// try to adapt to scriptable
		final Object scriptable = Platform.getAdapterManager().getAdapter(mCommand, IScriptable.class);
		if(scriptable != null)
			return bufferStream(((IScriptable)scriptable).getSourceCode());

		// last resort, convert to String
		if(mCommand != null) {
			// better buffer stuff, we do not know if toString() remains constant
			mCodeBuffer = mCommand.toString();
			return mCodeBuffer;
		}

		return null;

	}

	private String bufferReader(final Reader command) throws IOException {
		mCodeBuffer = toString(command);
		return mCodeBuffer;
	}

	private String bufferStream(final InputStream command) throws IOException {
		mCodeBuffer = toString(command);
		return mCodeBuffer;
	}

	public final Object getCommand() {
		return mCommand;
	}

	/**
	 * Get execution result.
	 * 
	 * @return execution result.
	 */
	public final ScriptResult getResult() {
		return mResult;
	}

	/**
	 * Set the execution result.
	 * 
	 * @param result
	 *        execution result
	 */
	public final void setResult(final Object result) {
		mResult.setResult(result);

		// gracefully close input streams & readers
		if(mCommand instanceof InputStream) {
			try {
				((InputStream)mCommand).close();
			} catch (final IOException e) {
			}

		} else if(mCommand instanceof Reader) {
			try {
				((Reader)mCommand).close();
			} catch (final IOException e) {
			}
		}
	}

	/**
	 * Set an execution exception.
	 * 
	 * @param e
	 *        exception
	 */
	public final void setException(final Exception e) {
		mResult.setException(e);

		// gracefully close input streams & readers
		if(mCommand instanceof InputStream) {
			try {
				((InputStream)mCommand).close();
			} catch (final IOException ex) {
			}

		} else if(mCommand instanceof Reader) {
			try {
				((Reader)mCommand).close();
			} catch (final IOException ex) {
			}
		}
	}

	public Object getFile() {
		if((mCommand instanceof IFile) || (mCommand instanceof File))
			return mCommand;

		return null;
	}

	/**
	 * Convert an input stream to a string.
	 * 
	 * @param stream
	 *        input string to read from
	 * @return string containing stream data
	 * @throws IOException
	 *         thrown on problems with input stream
	 */
	private static String toString(final InputStream stream) throws IOException {
		return toString(new InputStreamReader(stream));
	}

	/**
	 * Read characters from a {@link Reader} and return its string representation. Can be used to convert an {@link InputStream} to a string.
	 * 
	 * @param reader
	 *        reader to read from
	 * @return string content of reader
	 * @throws IOException
	 *         when reader is not accessible
	 */
	private static String toString(final Reader reader) throws IOException {
		final StringBuffer out = new StringBuffer();

		final char[] buffer = new char[1024];
		int bytes = 0;
		do {
			bytes = reader.read(buffer);
			if(bytes > 0)
				out.append(buffer, 0, bytes);
		} while(bytes != -1);

		return out.toString();
	}

	@Override
	public String toString() {
		if(mCommand instanceof IFile)
			return ((IFile)mCommand).getName();

		if(mCommand instanceof File)
			return ((File)mCommand).getName();

		return "(unknown script source)";
	}

	public String getTitle() {
		return mTitle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((mCodeBuffer == null) ? 0 : mCodeBuffer.hashCode());
		result = (prime * result) + ((mCommand == null) ? 0 : mCommand.hashCode());
		result = (prime * result) + ((mResult == null) ? 0 : mResult.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		final Script other = (Script)obj;
		if(mCodeBuffer == null) {
			if(other.mCodeBuffer != null)
				return false;
		} else if(!mCodeBuffer.equals(other.mCodeBuffer))
			return false;
		if(mCommand == null) {
			if(other.mCommand != null)
				return false;
		} else if(!mCommand.equals(other.mCommand))
			return false;
		if(mResult == null) {
			if(other.mResult != null)
				return false;
		} else if(!mResult.equals(other.mResult))
			return false;
		return true;
	}

}
