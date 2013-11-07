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
package com.codeandme.scripting.ruby.jruby;

import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.eclipse.escriptmonkey.scripting.IModifiableScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;
import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;

public class JRubyScriptEngine extends AbstractScriptEngine implements IModifiableScriptEngine {

	private ScriptingContainer mEngine;

	public JRubyScriptEngine() {
		super("JRuby");
	}

	@Override
	public Object getExecutedFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void terminateCurrent() {
	}

	@Override
	protected boolean setupEngine() {
		mEngine = new ScriptingContainer(LocalVariableBehavior.PERSISTENT);

		mEngine.setOutput(getOutputStream());
		mEngine.setError(getErrorStream());
		mEngine.setInput(getInputStream());

		return true;
	}

	@Override
	protected boolean teardownEngine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object execute(final Script script, final Object reference, final String fileName) throws Exception {
		return mEngine.runScriptlet(script.getCodeStream(), fileName);
	}

	@Override
	public void setVariable(final String name, final Object content) {
		mEngine.put(name.startsWith("$") ? name : "$" + name, content);
	}

	@Override
	public Object getVariable(final String name) {
		return mEngine.get(name.startsWith("$") ? name : "$" + name);
	}

}
