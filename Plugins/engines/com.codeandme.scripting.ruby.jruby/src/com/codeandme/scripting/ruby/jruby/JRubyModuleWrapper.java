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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.escriptmonkey.scripting.modules.EnvironmentModule;
import org.eclipse.escriptmonkey.scripting.modules.IModuleWrapper;

public class JRubyModuleWrapper implements IModuleWrapper {

	@Override
	public String getSaveVariableName(final String variableName) {
		return getSaveName(variableName);
	}

	@Override
	public String createFunctionWrapper(final String moduleVariable, final Method method, final Set<String> functionNames, final String resultName, final String preExecutionCode, final String postExecutionCode) {

		StringBuilder rubyScriptCode = new StringBuilder();

		// use reflection to access methods

		// create body
		StringBuffer body = new StringBuffer();

		// insert hooked pre execution code
		body.append(preExecutionCode);

		// create parameter string
		final StringBuilder parameters = new StringBuilder();
		for(int i = 0; i < method.getParameterTypes().length; i++) {
			parameters.append(", ");
			parameters.append((char)('a' + i));
		}
		if(parameters.length() > 0)
			parameters.replace(0, 2, "");

		// insert method call
		body.append("\t$");
		body.append(resultName);
		body.append(" = $");
		body.append(moduleVariable);
		body.append(".");
		body.append(method.getName());
		body.append("(");
		body.append(parameters);
		body.append(");\n");

		// insert hooked post execution code
		body.append(postExecutionCode);

		// insert return statement
		body.append("\treturn $");
		body.append(resultName);
		body.append(";\n");

		for(String name : functionNames) {
			if(!name.isEmpty()) {
				rubyScriptCode.append("def ");
				rubyScriptCode.append(name);
				rubyScriptCode.append("(");
				rubyScriptCode.append(parameters);
				rubyScriptCode.append(")\n");
				rubyScriptCode.append(body);
				rubyScriptCode.append("end\n");
			}
		}

		return rubyScriptCode.toString();
	}

	@Override
	public String getConstantDefinition(final String name, final Field field) {
		return name.substring(0, 1).toUpperCase() + name.substring(1) + " = " + field.getClass().getName() + "." + field.getName();
	}

	@Override
	public String getEnvironmentModuleName() {
		return "$" + EnvironmentModule.getRegisteredModuleName(EnvironmentModule.ENVIRONMENT_MODULE_NAME);
	}

	@Override
	public String getVariableDefinition(final String name, final String content) {
		return "$" + name + " = " + content;
	}

	@Override
	public String classInstantiation(final Class<?> clazz, final String[] parameters) {
		StringBuilder code = new StringBuilder();
		code.append(clazz.getName());
		code.append(".new(");

		if(parameters != null) {
			for(String parameter : parameters) {
				code.append('"');
				code.append(parameter);
				code.append('"');
				code.append(", ");
			}
			if(parameters.length > 0)
				code.replace(code.length() - 2, code.length(), "");
		}

		code.append(")");

		return code.toString();
	}

	private static String getSaveName(final String identifier) {
		// check if name is already valid
		if(Pattern.matches("[a-zA-Z_$][a-zA-Z0-9_$]*", identifier))
			return identifier;

		// not valid, convert string to valid format
		final StringBuilder buffer = new StringBuilder(identifier.replaceAll("[^a-zA-Z0-9]", "_"));

		// remove '_' at the beginning
		while((buffer.length() > 0) && (buffer.charAt(0) == '_'))
			buffer.deleteCharAt(0);

		// remove trailing '_'
		while((buffer.length() > 0) && (buffer.charAt(buffer.length() - 1) == '_'))
			buffer.deleteCharAt(buffer.length() - 1);

		// check for valid first character
		if(buffer.length() > 0) {
			final char start = buffer.charAt(0);
			if((start < 65) || ((start > 90) && (start < 97)) || (start > 122))
				buffer.insert(0, '_');
		} else
			// buffer is empty
			buffer.insert(0, '_');

		return buffer.toString();
	}
}
