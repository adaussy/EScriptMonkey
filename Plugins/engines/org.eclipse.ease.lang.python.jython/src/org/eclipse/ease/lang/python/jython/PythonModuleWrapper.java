/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *     Christian Pontesegger - simplified to use base class
 *******************************************************************************/
package org.eclipse.ease.lang.python.jython;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ease.Activator;
import org.eclipse.ease.Logger;
import org.eclipse.ease.modules.AbstractModuleWrapper;
import org.eclipse.ease.modules.IEnvironment;
import org.eclipse.ease.modules.IScriptFunctionModifier;

public class PythonModuleWrapper extends AbstractModuleWrapper {

	public static List<String> RESERVED_KEYWORDS = new ArrayList<String>();

	static {
		RESERVED_KEYWORDS.add("and");
		RESERVED_KEYWORDS.add("as");
		RESERVED_KEYWORDS.add("assert");
		RESERVED_KEYWORDS.add("break");
		RESERVED_KEYWORDS.add("class");
		RESERVED_KEYWORDS.add("continue");
		RESERVED_KEYWORDS.add("def");
		RESERVED_KEYWORDS.add("del");
		RESERVED_KEYWORDS.add("elif");
		RESERVED_KEYWORDS.add("else");
		RESERVED_KEYWORDS.add("except");
		RESERVED_KEYWORDS.add("exec");
		RESERVED_KEYWORDS.add("finally");
		RESERVED_KEYWORDS.add("for");
		RESERVED_KEYWORDS.add("from");
		RESERVED_KEYWORDS.add("global");
		RESERVED_KEYWORDS.add("if");
		RESERVED_KEYWORDS.add("import");
		RESERVED_KEYWORDS.add("in");
		RESERVED_KEYWORDS.add("is");
		RESERVED_KEYWORDS.add("lambda");
		RESERVED_KEYWORDS.add("not");
		RESERVED_KEYWORDS.add("or");
		RESERVED_KEYWORDS.add("pass");
		RESERVED_KEYWORDS.add("print");
		RESERVED_KEYWORDS.add("raise");
		RESERVED_KEYWORDS.add("return");
		RESERVED_KEYWORDS.add("try");
		RESERVED_KEYWORDS.add("while");
		RESERVED_KEYWORDS.add("with");
		RESERVED_KEYWORDS.add("yield");
	}

	@Override
	public String createFunctionWrapper(final IEnvironment environment, final String moduleVariable, final Method method) {

		StringBuilder pythonCode = new StringBuilder();

		// parse parameters
		List<Parameter> parameters = parseParameters(method);

		// build parameter string
		StringBuilder methodSignature = new StringBuilder();
		StringBuilder methodCall = new StringBuilder();
		for (Parameter parameter : parameters) {
			methodSignature.append(", ").append(parameter.getName());
			methodCall.append(", ").append(parameter.getName());
			if (parameter.isOptional())
				methodSignature.append(" = ").append(getDefaultValue(parameter));
		}

		if (methodSignature.length() > 2) {
			methodSignature.delete(0, 2);
			methodCall.delete(0, 2);
		}

		StringBuilder body = new StringBuilder();

		// insert hooked pre execution code
		body.append(getPreExecutionCode(environment, method));

		// insert method call
		body.append('\t').append(IScriptFunctionModifier.RESULT_NAME).append(" = ").append(moduleVariable).append('.').append(method.getName()).append('(');
		body.append(methodCall);
		body.append(")\n");

		// insert hooked post execution code
		body.append(getPostExecutionCode(environment, method));

		// insert return statement
		body.append("\treturn ").append(IScriptFunctionModifier.RESULT_NAME).append('\n');

		// build function declarations
		for (String name : getMethodNames(method)) {
			if (!isValidMethodName(name)) {
				Logger.logError("The method name \"" + name + "\" from the module \"" + moduleVariable + "\" can not be wrapped because it's name is reserved",
						Activator.PLUGIN_ID);

			} else if (!name.isEmpty()) {
				pythonCode.append("def ").append(name).append('(').append(methodSignature).append("):\n");
				pythonCode.append(body);
				pythonCode.append('\n');
			}
		}

		return pythonCode.toString();
	}

	@Override
	public String getSaveVariableName(final String variableName) {
		return JythonScriptEngine.getSaveName(variableName);
	}

	@Override
	public String classInstantiation(final Class<?> clazz, final String[] parameters) {
		StringBuilder code = new StringBuilder();
		code.append(clazz.getCanonicalName());
		code.append('(');

		if (parameters != null) {
			for (String parameter : parameters) {
				code.append(parameter);
				code.append(", ");
			}
			if (parameters.length > 0)
				code.delete(code.length() - 2, code.length());
		}

		code.append(')');

		return code.toString();
	}

	public boolean isValidMethodName(final String methodName) {
		return JythonScriptEngine.isSaveName(methodName) && !RESERVED_KEYWORDS.contains(methodName);
	}

	@Override
	protected String getNullString() {
		return "None";
	}

	@Override
	public String createStaticFieldWrapper(final IEnvironment environment, final Field field) {
		return JythonScriptEngine.getSaveName(field.getName()) + " = " + field.getDeclaringClass().getName() + '.' + field.getName() + '\n';
	}
}
