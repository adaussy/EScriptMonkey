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
package org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#isIfEmpty <em>If Empty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getIterableExpression()
 * @model
 * @generated
 */
public interface IterableExpression extends CompositeExpression {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' attribute.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator
	 * @see #setOperand(Operator)
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getIterableExpression_Operand()
	 * @model
	 * @generated
	 */
	Operator getOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#getOperand <em>Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' attribute.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(Operator value);

	/**
	 * Returns the value of the '<em><b>If Empty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Empty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Empty</em>' attribute.
	 * @see #setIfEmpty(boolean)
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getIterableExpression_IfEmpty()
	 * @model
	 * @generated
	 */
	boolean isIfEmpty();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#isIfEmpty <em>If Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Empty</em>' attribute.
	 * @see #isIfEmpty()
	 * @generated
	 */
	void setIfEmpty(boolean value);

} // IterableExpression
