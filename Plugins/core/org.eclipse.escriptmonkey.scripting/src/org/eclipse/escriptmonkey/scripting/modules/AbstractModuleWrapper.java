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
package org.eclipse.escriptmonkey.scripting.modules;

import java.lang.annotation.Annotation;


public abstract class AbstractModuleWrapper implements IModuleWrapper {


	public AbstractModuleWrapper() {
	}

	/**
	 * Get the parameter name from a annotation. Use for engine which can have named variable
	 * 
	 * @param parameterAnnotations
	 * @return
	 */
	protected String getParameterName(Annotation[] parameterAnnotations) {
		for(Annotation annot : parameterAnnotations) {
			if(annot instanceof NamedParameter) {
				NamedParameter namedParameter = (NamedParameter)annot;
				return namedParameter.name();
			}
		}
		return null;
	}

	@Override
	public String getEnvironmentModuleName() {
		return EnvironmentModule.getRegisteredModuleName(EnvironmentModule.ENVIRONMENT_MODULE_NAME);
	}

}
