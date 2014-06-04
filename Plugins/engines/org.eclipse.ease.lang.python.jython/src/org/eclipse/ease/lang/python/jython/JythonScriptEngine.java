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
package org.eclipse.ease.lang.python.jython;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.ease.AbstractScriptEngine;
import org.eclipse.ease.Script;
import org.eclipse.ease.lang.python.preferences.IPreferenceConstants;
import org.eclipse.ease.tools.RunnableWithResult;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
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

public class JythonScriptEngine extends AbstractScriptEngine {

	private InteractiveInterpreter mEngine;

	private PyObject mResult;

	private final Map<String, Object> mBufferedVariables = new HashMap<String, Object>();

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
		// imp.load("site");
		mEngine.getSystemState().path.insert(0, Py.EmptyString);

		setOutputStream(getOutputStream());
		setInputStream(getInputStream());
		setErrorStream(getErrorStream());

		// engine is initialized, set buffered variables
		for (final String name : mBufferedVariables.keySet())
			setVariable(name, mBufferedVariables.get(name));

		mBufferedVariables.clear();

		/*
		 * Not optimized for now. This should done at a Python System level
		 */
		for (String libraryPath : getPythonLibraries()) {
			if ((libraryPath != null) && !libraryPath.isEmpty()) {
				PyString element = new PyString(libraryPath);
				PyList systemPath = mEngine.getSystemState().path;
				if (!systemPath.contains(element)) {
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
	protected Object execute(final Script script, final Object reference, final String fileName, final boolean uiThread) throws Exception {
		if (uiThread) {
			// run in UI thread
			RunnableWithResult<Entry<Object, Exception>> runnable = new RunnableWithResult<Entry<Object, Exception>>() {

				@Override
				public void run() {

					// call execute again, now from correct thread
					try {
						setResult(new AbstractMap.SimpleEntry<Object, Exception>(internalExecute(script, reference, fileName), null));
					} catch (Exception e) {
						setResult(new AbstractMap.SimpleEntry<Object, Exception>(null, e));
					}
				}
			};

			Display.getDefault().syncExec(runnable);

			// evaluate result
			Entry<Object, Exception> result = runnable.getResult();
			if (result.getValue() != null)
				throw (result.getValue());

			return result.getKey();

		} else
			// run in engine thread
			return internalExecute(script, reference, fileName);
	}

	private Object internalExecute(final Script script, final Object reference, final String fileName) throws Exception {
		mResult = Py.None;

		PyObject code = Py.compile_command_flags(script.getCode(), "(none)", CompileMode.exec, new CompilerFlags(), true);
		if (code == Py.None)
			throw new RuntimeException("Could not compile code");
		Object file = script.getFile();
		File f = null;
		if (file instanceof IFile) {
			f = ((IFile) file).getLocation().toFile();
		} else if (file instanceof File) {
			f = ((File) file);

		}
		PyString newString = null;
		if (f != null) {
			String absolutePath = f.getAbsolutePath();
			setVariable("__File__", absolutePath);
			String containerPart = f.getParent();
			newString = Py.newString(containerPart);
			Py.getSystemState().path.insert(0, newString);
		}
		Py.exec(code, mEngine.getLocals(), null);
		if (newString != null) {
			Py.getSystemState().path.remove(newString);
		}
		return toJava(mResult);
	}

	private static Object toJava(final PyObject result) {
		if (result instanceof PyNone)
			return null;

		if (result instanceof PyObjectDerived)
			return result.__tojava__(Object.class);

		if (result instanceof PyBoolean)
			return ((PyBoolean) result).getBooleanValue();

		if (result instanceof PyInteger)
			return ((PyInteger) result).getValue();

		if (result instanceof PyFloat)
			return ((PyFloat) result).getValue();

		if (result instanceof PyLong)
			return ((PyLong) result).getValue();

		if (result instanceof PyString)
			return ((PyString) result).getString();

		if (result instanceof PyInteger)
			return ((PyInteger) result).getValue();

		return result;
	}

	@Override
	public void setOutputStream(final OutputStream outputStream) {
		super.setOutputStream(outputStream);

		if (mEngine != null)
			mEngine.setOut(getOutputStream());
	}

	@Override
	public void setInputStream(final InputStream inputStream) {
		super.setInputStream(inputStream);

		if (mEngine != null)
			mEngine.setIn(getInputStream());
	}

	@Override
	public void setErrorStream(final OutputStream errorStream) {
		super.setErrorStream(errorStream);

		if (mEngine != null)
			mEngine.setErr(getErrorStream());
	}

	protected Collection<String> getPythonLibraries() {
		List<String> result = new ArrayList<String>();
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		String libraries = preferences.getString(IPreferenceConstants.PYTHON_LIBRARIES);
		String[] libs = libraries.split(";");
		for (String lib : libs) {
			result.add(lib);
		}
		return result;
	}

	@Override
	public boolean hasVariable(final String name) {
		return mEngine.get(name) != null;
	}

	@Override
	public void setVariable(final String name, final Object content) {
		if (!isSaveName(name))
			throw new RuntimeException("\"" + name + "\" is not a valid Python variable name");

		if (mEngine != null)
			mEngine.set(name, content);

		else
			mBufferedVariables.put(name, content);
	}

	@Override
	public Object getVariable(final String name) {
		if (mEngine != null)
			return mEngine.get(name);

		throw new RuntimeException("Cannot retrieve variable, engine not initialized");
	}

	@Override
	public String getSaveVariableName(final String name) {
		return getSaveName(name);
	}

	public static String getSaveName(final String identifier) {
		// check if name is already valid
		if (isSaveName(identifier))
			return identifier;

		// not valid, convert string to valid format
		final StringBuilder buffer = new StringBuilder(identifier.replaceAll("[^a-zA-Z0-9]", "_"));

		// remove '_' at the beginning
		while ((buffer.length() > 0) && (buffer.charAt(0) == '_'))
			buffer.deleteCharAt(0);

		// remove trailing '_'
		while ((buffer.length() > 0) && (buffer.charAt(buffer.length() - 1) == '_'))
			buffer.deleteCharAt(buffer.length() - 1);

		// check for valid first character
		if (buffer.length() > 0) {
			final char start = buffer.charAt(0);
			if ((start < 65) || ((start > 90) && (start < 97)) || (start > 122))
				buffer.insert(0, '_');
		} else
			// buffer is empty
			buffer.insert(0, '_');

		return buffer.toString();
	}

	public static boolean isSaveName(final String identifier) {
		return Pattern.matches("[a-zA-Z_$][a-zA-Z0-9_$]*", identifier);
	}

	@Override
	public Object removeVariable(final String name) {
		throw new RuntimeException("not supported");
	}

	@Override
	public Map<String, Object> getVariables() {
		throw new RuntimeException("not supported");
	}

	@Override
	public void registerJar(final URL url) {
		// FIXME implement jar classloader
		throw new RuntimeException("Registering JARs is not supported for python");
	}
}
