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
 * A representation of the model object '<em><b>With Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getWithExpression()
 * @model
 * @generated
 */
public interface WithExpression extends CompositeExpression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable
	 * @see #setVariable(Variable)
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getWithExpression_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // WithExpression
