/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *     Arthur Daussy - Allow optional parameter
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.escriptmonkey.scripting.Activator;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.modules.AbstractModuleWrapper;
import org.eclipse.escriptmonkey.scripting.modules.EnvironmentModule;
import org.eclipse.escriptmonkey.scripting.modules.OptionalParameter;

public class RhinoModuleWrapper extends AbstractModuleWrapper {

	private static final String UNDIFINED_KEYWORD = "undifined";


	@Override
	public String getSaveVariableName(final String variableName) {
		return getSaveName(variableName);
	}

	@Override
	public String createFunctionWrapper(final String moduleVariable, final Method method, final Set<String> functionNames, final String resultName, final String preExecutionCode, final String postExecutionCode) {

		StringBuilder javaScriptCode = new StringBuilder();

		// create body
		StringBuffer body = new StringBuffer();

		// insert hooked pre execution code
		if(preExecutionCode != null) {
			body.append(preExecutionCode);
		}

		// create parameter string
		final StringBuilder parameters = new StringBuilder();
		for(int i = 0; i < method.getParameterTypes().length; i++) {
			parameters.append(", ");
			parameters.append((char)('a' + i));
		}
		if(parameters.length() > 0)
			parameters.replace(0, 2, "");

		// insert method call
		CharSequence generateParameterCall = generateParameterCall(method);
		body.append(generateOptionalParamterBodyPart(method));
		body.append(generateCallMethodOnDefinedVariableInfo(moduleVariable, method.getName(), resultName, generateParameterCall));

		// insert hooked post execution code
		if(postExecutionCode != null) {
			body.append(postExecutionCode);
		}

		// insert return statement
		body.append(generateReturnStatement(resultName));

		for(String name : functionNames) {
			if(!isCorrectMethodName(name)) {
				Logger.logError("The method name " + name + " from the module " + moduleVariable + "can not be used because it's name is not correct", Activator.PLUGIN_ID);
				return "";
			}
			if(!name.isEmpty()) {
				javaScriptCode.append(generateMethodDefinition(body, generateParameterCall, name));
			}
		}

		return javaScriptCode.toString();
	}

	/**
	 * Generate a part of a the body which handle optional argument.
	 * It will generate for example
	 * function name(a,b,c){
	 * a = a || null;
	 * b = b || "defaultStringValue";
	 * c = c || 16
	 * ...
	 * body
	 * ...
	 * }
	 * 
	 * @param method
	 * @return
	 */
	protected CharSequence generateOptionalParamterBodyPart(Method method) {
		StringBuilder defaultValueParameters = new StringBuilder();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Class<?>[] parametersTypes = method.getParameterTypes();
		for(int parameterIndex = 0; parameterIndex < parametersTypes.length; parameterIndex++) {
			Annotation[] annots = parameterAnnotations[parameterIndex];
			String parameterName = getParameterName(annots);
			if(parameterName == null) {
				parameterName = "a" + parameterIndex;
			}
			Class<?> type = parametersTypes[parameterIndex];
			if(annots.length > 0) {
				for(Annotation a : annots) {
					if(a instanceof OptionalParameter) {
						defaultValueParameters.append("\tvar ");
						defaultValueParameters.append(parameterName);
						defaultValueParameters.append(" = ");
						defaultValueParameters.append(parameterName);
						defaultValueParameters.append(" || ");
						CharSequence setOptionalParameterValue = setOptionalParameterValue(type, (OptionalParameter)a);
						if(setOptionalParameterValue != null) {
							defaultValueParameters.append(setOptionalParameterValue);
						} else {
							defaultValueParameters.append("null");
						}
						defaultValueParameters.append(";\n");
					}
				}
			}
		}
		return defaultValueParameters;
	}

	/**
	 * Generate code for optional parameter (and handle default value)
	 * 
	 * @param type
	 * @param a
	 * @return
	 */
	protected CharSequence setOptionalParameterValue(Class<?> type, OptionalParameter a) {
		Object defaultValue = OptionalParameter.OptionalParameterHelper.getDefaultValue(a, type);
		StringBuilder parametersSignature = new StringBuilder();
		parametersSignature.append("=");
		if(defaultValue != null) {
			if(defaultValue instanceof String) {
				parametersSignature.append("\"" + defaultValue + "\"");
			} else {
				parametersSignature.append(defaultValue.toString());
			}
		}
		return null;
	}

	protected String getNullVariableName() {
		return UNDIFINED_KEYWORD;
	}

	public static List<String> forbidenKeywork = new ArrayList<String>();


	public boolean isCorrectMethodName(String methodName) {
		return isSaveName(methodName) && !forbidenKeywork.contains(methodName);
	}


	static {
		forbidenKeywork.add("for");
		forbidenKeywork.add("while");
		//Complete this list
	}



	/**
	 * Generate method definition.
	 * function name (parametersSignature){
	 * ...
	 * body
	 * ...
	 * }
	 * 
	 * @param body
	 *        the body
	 * @param parametersSignature
	 *        the parameters signature
	 * @param name
	 *        the name
	 * @return the char sequence
	 */
	protected CharSequence generateMethodDefinition(CharSequence body, CharSequence parametersSignature, String name) {
		StringBuilder methodDef = new StringBuilder();
		methodDef.append("function ");
		methodDef.append(name);
		methodDef.append("(");
		methodDef.append(parametersSignature);
		methodDef.append(") {\n");
		methodDef.append(body);
		methodDef.append("}\n");
		return methodDef.toString();
	}


	/**
	 * @param method
	 * @return
	 */
	protected CharSequence generateParameterCall(Method method) {
		StringBuilder parameters = new StringBuilder();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Class<?>[] parametersTypes = method.getParameterTypes();
		for(int parameterIndex = 0; parameterIndex < parametersTypes.length; parameterIndex++) {
			Annotation[] annots = parameterAnnotations[parameterIndex];
			String parameterName = getParameterName(annots);
			if(parameterName == null) {
				parameterName = "a" + parameterIndex;
			}
			parameters.append(parameterName);
			if(parameterIndex != parametersTypes.length - 1) {
				parameters.append(", ");
			}
		}
		return parameters;
	}

	@Override
	public String getConstantDefinition(final String name, final Field field) {
		return "const " + getSaveName(name) + " = Packages." + field.getDeclaringClass().getName() + "." + field.getName() + ";\n";
	}

	@Override
	public String getEnvironmentModuleName() {
		return EnvironmentModule.getRegisteredModuleName(EnvironmentModule.ENVIRONMENT_MODULE_NAME);
	}

	@Override
	public String getVariableDefinition(final String name, final String content) {
		return "var " + getSaveName(name) + " = " + content + ";";
	}

	@Override
	public String classInstantiation(final Class<?> clazz, final String[] parameters) {
		StringBuilder code = new StringBuilder();
		code.append("new Packages.");
		code.append(clazz.getName());
		code.append("(");

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
		if(isSaveName(identifier))
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

	public static boolean isSaveName(final String identifier) {
		return Pattern.matches("[a-zA-Z_$][a-zA-Z0-9_$]*", identifier);
	}

	protected String generateReturnStatement(String resultName) {
		StringBuilder returnStatment = new StringBuilder();
		returnStatment.append("\treturn ");
		returnStatment.append(resultName);
		returnStatment.append(";\n");
		return returnStatment.toString();
	}

	protected CharSequence generateCallMethodOnDefinedVariableInfo(String moduleVariable, String methodName, String resultName, CharSequence parameters) {
		StringBuilder body = new StringBuilder();
		body.append("\tvar ");
		body.append(resultName);
		body.append(" = ");
		body.append(moduleVariable);
		body.append(".");
		body.append(methodName);
		body.append("(");
		body.append(parameters);
		body.append(");\n");
		return body;
	}

}
