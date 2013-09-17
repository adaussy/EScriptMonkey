/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *     Arthur Daussy - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.eclipse.escriptmonkey.scripting.IModifiableScriptEngine;
import org.eclipse.escriptmonkey.scripting.engine.python.jython.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
import org.python.core.PyCode;
import org.python.core.PyIgnoreMethodTag;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class JythonScriptEngine extends AbstractScriptEngine implements IModifiableScriptEngine {

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

		/*
		 * Not optimized for now.
		 * This should done at a Python System level
		 */
		for(String libraryPath : getPythonLibrairies()) {
			if(libraryPath != null && !libraryPath.isEmpty()) {
				PyString element = new PyString(libraryPath);
				PyList systemPath = mEngine.getSystemState().path;
				if(!systemPath.contains(element)) {
					systemPath.add(0, element);
				}
			}
		}

		return true;
	}

	private String getPluginRootDir() {
		try {
			Bundle bundle = Activator.getDefault().getBundle();
			URL fileURL = FileLocator.find(bundle, new Path("."), null);
			return FileLocator.toFileURL(fileURL).getFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected boolean teardownEngine() {
		return true;
	}

	@Override
	protected Object execute(final InputStream code, final Object reference, final String fileName) throws Exception {
		PyCode pyCode = mEngine.compile(new InputStreamReader(code));
		mEngine.exec(pyCode);
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

	@Override
	public void setVariable(String name, Object content) {
		mEngine.set(name, content);

	}

	@Override
	public Object getVariable(String name) {
		return mEngine.get(name);
	}

	protected Collection<String> getPythonLibrairies() {
		List<String> result = new ArrayList<String>();
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		String libraries = preferences.getString(IPreferenceConstants.PYTHON_LIBRARIES);
		String[] libs = libraries.split(";");
		for(String lib : libs) {
			result.add(lib);
		}
		return result;
	}


}
