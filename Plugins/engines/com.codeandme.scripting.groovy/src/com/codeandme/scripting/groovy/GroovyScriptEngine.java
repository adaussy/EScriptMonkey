package com.codeandme.scripting.groovy;

import groovy.lang.GroovyShell;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.eclipse.escriptmonkey.scripting.IModifiableScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;

public class GroovyScriptEngine extends AbstractScriptEngine implements IModifiableScriptEngine {

	private GroovyShell mEngine;

	public GroovyScriptEngine() {
		super("Groovy");
	}

	@Override
	public void terminateCurrent() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean setupEngine() {
		mEngine = new GroovyShell();

		setOutputStream(getOutputStream());
		setErrorStream(getErrorStream());

		return true;
	}

	@Override
	public void setOutputStream(final OutputStream outputStream) {
		super.setOutputStream(outputStream);

		if(mEngine != null)
			mEngine.setProperty("out", getOutputStream());

	}

	@Override
	public void setErrorStream(final OutputStream errorStream) {
		super.setOutputStream(errorStream);

		if(mEngine != null)
			mEngine.setProperty("err", getErrorStream());
	}

	@Override
	protected boolean teardownEngine() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected Object execute(final Script script, final Object reference, final String fileName) throws Exception {
		InputStreamReader reader = null;
		Object result = null;
		try {
			reader = new InputStreamReader(script.getCodeStream());
			if((fileName == null) || (fileName.isEmpty()))
				result = mEngine.evaluate(reader);

			else
				result = mEngine.evaluate(reader, fileName);

		} catch (Exception e) {
			throw e;
		} finally {
			// gracefully close reader
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}

		return result;
	}

	@Override
	public void setVariable(final String name, final Object content) {
		mEngine.setVariable(name, content);
	}

	@Override
	public Object getVariable(final String name) {
		return mEngine.getVariable(name);
	}

}
