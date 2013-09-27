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
package org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.EqualExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equal Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EqualExpressionImpl extends ValuedExpressionImpl implements EqualExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EqualExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoreexpressionPackage.Literals.EQUAL_EXPRESSION;
	}

} //EqualExpressionImpl
