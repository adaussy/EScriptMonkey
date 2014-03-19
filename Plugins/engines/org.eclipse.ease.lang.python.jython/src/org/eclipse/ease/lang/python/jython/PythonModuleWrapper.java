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
import java.util.Set;

import org.eclipse.ease.Activator;
import org.eclipse.ease.Logger;
import org.eclipse.ease.modules.AbstractModuleWrapper;

public class PythonModuleWrapper extends AbstractModuleWrapper {

	public static List<String> RESERVED_KEYWORDS = new ArrayList<String>();

	static {
		RESERVED_KEYWORDS.add("print");
		RESERVED_KEYWORDS.add("for");
		RESERVED_KEYWORDS.add("while");
		// TODO Complete this list
	}

	@Override
	public String createFunctionWrapper(final String moduleVariable, final Method method, final Set<String> functionNames, final String resultName,
			final String preExecutionCode, final String postExecutionCode) {

		StringBuilder javaScriptCode = new StringBuilder();

		// parse parameters
		List<Parameter> parameters = parseParameters(method);

		// build parameter string
		StringBuilder functionSignature = new StringBuilder();
		StringBuilder callSignature = new StringBuilder();
		for (Parameter parameter : parameters) {
			functionSignature.append(", ").append(parameter.getName());
			callSignature.append(", ").append(parameter.getName());
			if (parameter.isOptional())
				functionSignature.append(" = ").append(getDefaultValue(parameter));
		}

		if (functionSignature.length() > 2)
			functionSignature.delete(0, 2);

		if (callSignature.length() > 2)
			callSignature.delete(0, 2);

		StringBuilder body = new StringBuilder();

		// insert hooked pre execution code
		// TODO make sure code is correctly aligned
		if (preExecutionCode != null)
			body.append(preExecutionCode);

		// insert method call
		body.append("\t").append(resultName).append(" = ").append(moduleVariable).append('.').append(method.getName()).append('(');
		body.append(callSignature);
		body.append(")\n");

		// insert hooked post execution code
		// TODO make sure code is correctly aligned
		if (postExecutionCode != null)
			body.append(postExecutionCode);

		// insert return statement
		body.append("\treturn ").append(resultName).append("\n");

		// build function declarations
		for (String name : functionNames) {
			if (!isCorrectMethodName(name)) {
				Logger.logError("The method name \"" + name + "\" from the module \"" + moduleVariable + "\" can not be wrapped because it's name is reserved",
						Activator.PLUGIN_ID);

			} else if (!name.isEmpty()) {
				javaScriptCode.append("def ").append(name).append("(").append(functionSignature).append("):\n");
				javaScriptCode.append(body);
				javaScriptCode.append("\n");
			}
		}

		return javaScriptCode.toString();
	}

	@Override
	public String getSaveVariableName(final String variableName) {
		return JythonScriptEngine.getSaveName(variableName);
	}

	@Override
	public String getConstantDefinition(final String name, final Field field) {
		return JythonScriptEngine.getSaveName(name) + " =" + field.getDeclaringClass().getName() + "." + field.getName() + ";\n";
	}

	@Override
	public String getVariableDefinition(final String name, final String content) {
		return JythonScriptEngine.getSaveName(name) + " = " + content + "\n";
	}

	@Override
	public String classInstantiation(final Class<?> clazz, final String[] parameters) {
		StringBuilder code = new StringBuilder();
		code.append(clazz.getCanonicalName());
		code.append("(");

		if (parameters != null) {
			for (String parameter : parameters) {
				code.append('"');
				code.append(parameter);
				code.append('"');
				code.append(", ");
			}
			if (parameters.length > 0)
				code.replace(code.length() - 2, code.length(), "");
		}

		code.append(")");

		return code.toString();
	}

	public boolean isCorrectMethodName(final String methodName) {
		return JythonScriptEngine.isSaveName(methodName) && !RESERVED_KEYWORDS.contains(methodName);
	}

	@Override
	protected String getNullString() {
		return "None";
	}
}
