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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.escriptmonkey.lang.python.Activator;
import org.eclipse.escriptmonkey.lang.python.preferences.IPreferenceConstants;
import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.eclipse.escriptmonkey.scripting.IModifiableScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.jface.preference.IPreferenceStore;
import org.python.core.CompileMode;
import org.python.core.CompilerFlags;
import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyFloat;
import org.python.core.PyIgnoreMethodTag;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyLong;
import org.python.core.PyNone;
import org.python.core.PyObject;
import org.python.core.PyObjectDerived;
import org.python.core.PyString;
import org.python.util.InteractiveInterpreter;

public class JythonScriptEngine extends AbstractScriptEngine implements IModifiableScriptEngine {

	private InteractiveInterpreter mEngine;

	private PyObject mResult;

	private class DisplayHook extends PyObject {

		private static final long serialVersionUID = -6793040471701923706L;

		@Override
		public PyObject __call__(final PyObject arg0) {
			mResult = arg0;
			return Py.None;
		}
	}

	public JythonScriptEngine() {
		super("Jython");
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
		mEngine = new InteractiveInterpreter();

		// register display callback method to extract execution result
		DisplayHook displayHook = new DisplayHook();
		mEngine.getSystemState().__displayhook__ = displayHook;
		mEngine.getSystemState().__dict__.__setitem__("displayhook", displayHook);

		mEngine.getSystemState().__setattr__("_jy_interpreter", Py.java2py(mEngine));
		//		imp.load("site");
		mEngine.getSystemState().path.insert(0, Py.EmptyString);

		setOutputStream(getOutputStream());
		setInputStream(getInputStream());
		setErrorStream(getErrorStream());

		/*
		 * Not optimized for now.
		 * This should done at a Python System level
		 */
		for(String libraryPath : getPythonLibraries()) {
			if((libraryPath != null) && !libraryPath.isEmpty()) {
				PyString element = new PyString(libraryPath);
				PyList systemPath = mEngine.getSystemState().path;
				if(!systemPath.contains(element)) {
					systemPath.add(0, element);
				}
			}
		}

		mEngine.getSystemState().settrace(new JythonTracer());

		// FIXME ev we need to set the system path to make jython aware of the changes
		return true;
	}

	@Override
	protected boolean teardownEngine() {
		return true;
	}

	@Override
	protected Object execute(final Script script, final Object reference, final String fileName) throws Exception {
		mResult = Py.None;
		PyObject code = Py.compile_command_flags(script.getCode(), "(none)", CompileMode.exec, new CompilerFlags(), true);
		if(code == Py.None)
			throw new RuntimeException("Could not compile code");

		Py.exec(code, mEngine.getLocals(), null);
		return toJava(mResult);
	}

	private static Object toJava(final PyObject result) {
		if(result instanceof PyNone)
			return null;

		if(result instanceof PyObjectDerived)
			return result.__tojava__(Object.class);

		if(result instanceof PyBoolean)
			return ((PyBoolean)result).getBooleanValue();

		if(result instanceof PyInteger)
			return ((PyInteger)result).getValue();

		if(result instanceof PyFloat)
			return ((PyFloat)result).getValue();

		if(result instanceof PyLong)
			return ((PyLong)result).getValue();

		if(result instanceof PyString)
			return ((PyString)result).getString();

		if(result instanceof PyInteger)
			return ((PyInteger)result).getValue();

		return result;
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
	public void setVariable(final String name, final Object content) {
		mEngine.set(name, content);
	}

	@Override
	public Object getVariable(final String name) {
		return mEngine.get(name);
	}

	protected Collection<String> getPythonLibraries() {
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
