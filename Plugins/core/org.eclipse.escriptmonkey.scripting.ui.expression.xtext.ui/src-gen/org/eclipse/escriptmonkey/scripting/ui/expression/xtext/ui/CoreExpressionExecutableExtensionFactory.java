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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.internal.CoreExpressionActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CoreExpressionExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CoreExpressionActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CoreExpressionActivator.getInstance().getInjector(CoreExpressionActivator.ORG_ECLIPSE_ESCRIPTMONKEY_SCRIPTING_UI_EXPRESSION_XTEXT_COREEXPRESSION);
	}
	
}
