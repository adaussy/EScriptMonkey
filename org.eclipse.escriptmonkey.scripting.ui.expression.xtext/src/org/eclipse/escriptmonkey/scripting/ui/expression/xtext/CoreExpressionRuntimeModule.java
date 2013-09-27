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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext;

import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class CoreExpressionRuntimeModule extends org.eclipse.escriptmonkey.scripting.ui.expression.xtext.AbstractCoreExpressionRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return org.eclipse.escriptmonkey.scripting.ui.expression.xtext.Converter.class;
	}
}
