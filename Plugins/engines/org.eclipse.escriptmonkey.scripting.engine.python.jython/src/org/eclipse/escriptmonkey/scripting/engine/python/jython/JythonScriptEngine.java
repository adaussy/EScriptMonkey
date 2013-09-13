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
package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.python.core.PyIgnoreMethodTag;
import org.python.util.PythonInterpreter;

public class JythonScriptEngine extends AbstractScriptEngine {

	private PythonInterpreter mEngine;

	public JythonScriptEngine() {
		super("Jython");
	}

	@Override
	public Object getExecutedFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void terminateCurrent() {
		try {
			mEngine.getSystemState().callExitFunc();
		} catch (PyIgnoreMethodTag e) {
			// TODO handle this exception (but for now, at least know it happened)
			throw new RuntimeException(e);
		}
	}

	@Override
	protected boolean setupEngine() {
		mEngine = new PythonInterpreter();
		setOutputStream(getOutputStream());
		setInputStream(getInputStream());
		setErrorStream(getErrorStream());

		return true;
	}

	@Override
	protected boolean teardownEngine() {
		return true;
	}

	@Override
	protected Object execute(final InputStream code, final Object reference, final String fileName) throws Exception {
		mEngine.execfile(code, fileName);

		return null;
	}

	@Override
	public void setOutputStream(final OutputStream outputStream) {
		super.setOutputStream(outputStream);

		if(mEngine != null)
			mEngine.setOut(getOutputStream());
	}

	@Override
	public void setInputStream(final InputStream inputStream) {
		super.setInputStream(inputStream);

		if(mEngine != null)
			mEngine.setIn(getInputStream());
	}

	@Override
	public void setErrorStream(final OutputStream errorStream) {
		super.setErrorStream(errorStream);

		if(mEngine != null)
			mEngine.setErr(getErrorStream());
	}


}
