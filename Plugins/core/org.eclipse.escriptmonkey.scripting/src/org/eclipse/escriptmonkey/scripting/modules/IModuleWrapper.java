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
package org.eclipse.escriptmonkey.scripting.modules;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public interface IModuleWrapper {

    String getSaveVariableName(String variableName);

    String createFunctionWrapper(String moduleVariable, Method method, Set<String> functionNames, String resultName, String preExecutionCode,
            String postExecutionCode);

    String getConstantDefinition(String name, Field field);

    String getEnvironmentModuleName();

    String getVariableDefinition(String name, String content);

    String classInstantiation(Class<?> clazz, String[] parameters);
}
