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
package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.escriptmonkey.scripting.Activator;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.modules.AbstractModuleWrapper;
import org.eclipse.escriptmonkey.scripting.modules.EnvironmentModule;
import org.eclipse.escriptmonkey.scripting.modules.OptionalParameter;


public class PythonModuleWrapper extends AbstractModuleWrapper {

	private static final String NULL_IN_PYHTON = "None";

	public PythonModuleWrapper() {
	}

	@Override
	public String getSaveVariableName(String variableName) {
		return getSaveName(variableName);
	}

	@Override
	public String createFunctionWrapper(String moduleVariable, Method method, Set<String> functionNames, String resultName, String preExecutionCode, String postExecutionCode) {
		StringBuilder engineCode = new StringBuilder();

		// create body
		StringBuffer body = new StringBuffer("\t");

		// insert hooked pre execution code
		if(preExecutionCode != null) {
			body.append(preExecutionCode);
		}

		// insert method call
		body.append(generateCallMethodOnDefinedVariableInfo(moduleVariable, method.getName(), resultName, generateParameterCall(method)));

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
		for(int parameterIndex = 0; parameterIndex < parametersTypes.length; parameterIndex++) {
			Annotation[] annots = parameterAnnotations[parameterIndex];
			String parameterName = getParameterName(annots);
			if(parameterName == null) {
				parameterName = "a" + parameterIndex;
			}
			Class<?> type = parametersTypes[parameterIndex];
			parametersSignature.append(parameterName);
			if(annots.length > 0) {
				for(Annotation a : annots) {
					if(a instanceof OptionalParameter) {
						parametersSignature.append(setOptionalParameterValue(type, (OptionalParameter)a));
					}
				}
			}
			if(parameterIndex != parametersTypes.length - 1) {
				parametersSignature.append(", ");
			}
		}
		return parametersSignature;
	}

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


	/**
	 * Set the default value of an optional parameter
	 * 
	 * @param parametersSignature
	 * @param type
	 * @param a
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
		} else {
			parametersSignature.append(getNullVariableName());
		}
		return parametersSignature;
	}


	@Override
	public String getConstantDefinition(String name, Field field) {
		return getSaveName(name) + " =" + field.getDeclaringClass().getName() + "." + field.getName() + ";\n";
	}

	@Override
	public String getEnvironmentModuleName() {
		return EnvironmentModule.getRegisteredModuleName(EnvironmentModule.ENVIRONMENT_MODULE_NAME);
	}

	@Override
	public String getVariableDefinition(String name, String content) {
		return getSaveName(name) + " = " + content + "\n";
	}

	@Override
	public String classInstantiation(Class<?> clazz, String[] parameters) {
		StringBuilder code = new StringBuilder();
		code.append(clazz.getCanonicalName());
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

	private String getSaveName(final String identifier) {
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

	public boolean isCorrectMethodName(String methodName) {
		return isSaveName(methodName) && !forbidenKeywork.contains(methodName);
	}

	public boolean isSaveName(final String identifier) {
		return Pattern.matches("[a-zA-Z_$][a-zA-Z0-9_$]*", identifier);
	}

	public static List<String> forbidenKeywork = new ArrayList<String>();

	static {
		forbidenKeywork.add("print");
		forbidenKeywork.add("for");
		forbidenKeywork.add("while");
		//Complete this list
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
		if(extendsClass != null && !extendsClass.isEmpty()) {
			classDef.append("(");
			ListIterator<? extends CharSequence> ite = extendsClass.listIterator();
			while(ite.hasNext()) {
				CharSequence extend = (CharSequence)ite.next();
				classDef.append(extend);
				if(ite.hasNext()) {
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
