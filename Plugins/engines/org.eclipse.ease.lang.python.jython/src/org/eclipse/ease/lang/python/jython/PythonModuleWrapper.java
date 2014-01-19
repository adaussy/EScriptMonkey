/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.ease.lang.python.jython;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.ease.Activator;
import org.eclipse.ease.Logger;
import org.eclipse.ease.modules.AbstractModuleWrapper;
import org.eclipse.ease.modules.ScriptParameter;

public class PythonModuleWrapper extends AbstractModuleWrapper {

	private static final String NULL_IN_PYHTON = "None";

	public PythonModuleWrapper() {
	}

	@Override
	public String getSaveVariableName(String variableName) {
		return JythonScriptEngine.getSaveName(variableName);
	}

	@Override
	public String createFunctionWrapper(String moduleVariable, Method method, Set<String> functionNames, String resultName, String preExecutionCode,
			String postExecutionCode) {
		StringBuilder engineCode = new StringBuilder();

		// create body
		StringBuffer body = new StringBuffer("\t");

		// insert hooked pre execution code
		if (preExecutionCode != null) {
			body.append(preExecutionCode);
		}

		// insert method call
		body.append(generateCallMethodOnDefinedVariableInfo(moduleVariable, method.getName(), resultName, generateParameterCall(method)));

		// insert hooked post execution code
		if (postExecutionCode != null) {
			body.append(postExecutionCode);
		}

		// insert return statement
		body.append(generateReturnStatement(resultName));

		for (String name : functionNames) {
			if (!isCorrectMethodName(name)) {
				Logger.logError("The method name " + name + " from the module " + moduleVariable + "can not be used because it's name is not correct",
						Activator.PLUGIN_ID);
				return "";
			}
			if (!name.isEmpty()) {
				engineCode.append(generateMethodDefinition(body, generateParameterSignature(method), name));
			}
		}

		return engineCode.toString();
	}

	protected CharSequence generateMethodDefinition(StringBuffer body, CharSequence parametersSignature, String name) {
		StringBuilder methodDef = new StringBuilder();
		methodDef.append("def ");
		methodDef.append(name);
		methodDef.append("(");
		methodDef.append(parametersSignature);
		methodDef.append(") :\n");
		methodDef.append(body);
		return methodDef.toString();
	}

	protected CharSequence generateCallMethodOnDefinedVariableInfo(String moduleVariable, String methodName, String resultName, CharSequence parameters) {
		StringBuilder body = new StringBuilder();
		body.append(resultName);
		body.append(" = ");
		body.append(moduleVariable);
		body.append(".");
		body.append(methodName);
		body.append("(");
		body.append(parameters);
		body.append(")\n");
		return body;
	}

	protected CharSequence generateParameterSignature(Method method) {
		StringBuilder parametersSignature = new StringBuilder();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Class<?>[] parametersTypes = method.getParameterTypes();
		for (int parameterIndex = 0; parameterIndex < parametersTypes.length; parameterIndex++) {
			Annotation[] annots = parameterAnnotations[parameterIndex];
			String parameterName = getParameterName(annots);
			if (parameterName == null) {
				parameterName = "a" + parameterIndex;
			}
			Class<?> type = parametersTypes[parameterIndex];
			parametersSignature.append(parameterName);
			if (annots.length > 0) {
				for (Annotation a : annots) {
					if (a instanceof ScriptParameter) {
						if (((ScriptParameter) a).optional())
							parametersSignature.append(setOptionalParameterValue(type, (ScriptParameter) a));
					}
				}
			}
			if (parameterIndex != parametersTypes.length - 1) {
				parametersSignature.append(", ");
			}
		}
		return parametersSignature;
	}

	protected CharSequence generateParameterCall(Method method) {
		StringBuilder parameters = new StringBuilder();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Class<?>[] parametersTypes = method.getParameterTypes();
		for (int parameterIndex = 0; parameterIndex < parametersTypes.length; parameterIndex++) {
			Annotation[] annots = parameterAnnotations[parameterIndex];
			String parameterName = getParameterName(annots);
			if (parameterName == null) {
				parameterName = "a" + parameterIndex;
			}
			parameters.append(parameterName);
			if (parameterIndex != parametersTypes.length - 1) {
				parameters.append(", ");
			}
		}
		return parameters;
	}

	/**
	 * Set the default value of an optional parameter
	 * 
	 * @param parametersSignature
	 * @param type
	 * @param a
	 */
	protected CharSequence setOptionalParameterValue(Class<?> type, ScriptParameter a) {
		Object defaultValue = ScriptParameter.OptionalParameterHelper.getDefaultValue(a, type);
		StringBuilder parametersSignature = new StringBuilder();
		parametersSignature.append("=");
		if (defaultValue != null) {
			if (defaultValue instanceof String) {
				parametersSignature.append("\"" + defaultValue + "\"");
			} else {
				parametersSignature.append(defaultValue.toString());
			}
		} else {
			parametersSignature.append(getNullVariableName());
		}
		return parametersSignature;
	}

	@Override
	public String getConstantDefinition(String name, Field field) {
		return JythonScriptEngine.getSaveName(name) + " =" + field.getDeclaringClass().getName() + "." + field.getName() + ";\n";
	}

	@Override
	public String getVariableDefinition(String name, String content) {
		return JythonScriptEngine.getSaveName(name) + " = " + content + "\n";
	}

	@Override
	public String classInstantiation(Class<?> clazz, String[] parameters) {
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

	public boolean isCorrectMethodName(String methodName) {
		return JythonScriptEngine.isSaveName(methodName) && !forbidenKeywork.contains(methodName);
	}

	public static List<String> forbidenKeywork = new ArrayList<String>();

	static {
		forbidenKeywork.add("print");
		forbidenKeywork.add("for");
		forbidenKeywork.add("while");
		// Complete this list
	}

	protected String generateReturnStatement(String resultName) {
		StringBuilder returnStatment = new StringBuilder();
		returnStatment.append("\treturn ");
		returnStatment.append(resultName);
		returnStatment.append("\n");
		return returnStatment.toString();
	}

	protected CharSequence generateClass(String className, List<? extends CharSequence> extendsClass, CharSequence body) {
		StringBuilder classDef = new StringBuilder();
		classDef.append("class ").append(className);
		if (extendsClass != null && !extendsClass.isEmpty()) {
			classDef.append("(");
			ListIterator<? extends CharSequence> ite = extendsClass.listIterator();
			while (ite.hasNext()) {
				CharSequence extend = ite.next();
				classDef.append(extend);
				if (ite.hasNext()) {
					classDef.append(",");
				}
			}
			classDef.append(")");
		}
		classDef.append(":\n\t");
		String newBody = Pattern.compile("\n").matcher(body).replaceAll("\n\t");
		classDef.append(newBody);
		return classDef.toString();
	}

	protected String getNullVariableName() {
		return NULL_IN_PYHTON;
	}

}
