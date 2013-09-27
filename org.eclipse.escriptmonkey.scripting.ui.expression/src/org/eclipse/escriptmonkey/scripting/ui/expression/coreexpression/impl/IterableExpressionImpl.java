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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterable Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl#isIfEmpty <em>If Empty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterableExpressionImpl extends CompositeExpressionImpl implements IterableExpression {
	/**
	 * The default value of the '{@link #getOperand() <em>Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperand()
	 * @generated
	 * @ordered
	 */
	protected static final Operator OPERAND_EDEFAULT = Operator.AND;

	/**
	 * The cached value of the '{@link #getOperand() <em>Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperand()
	 * @generated
	 * @ordered
	 */
	protected Operator operand = OPERAND_EDEFAULT;

	/**
	 * The default value of the '{@link #isIfEmpty() <em>If Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIfEmpty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IF_EMPTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIfEmpty() <em>If Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIfEmpty()
	 * @generated
	 * @ordered
	 */
	protected boolean ifEmpty = IF_EMPTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterableExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoreexpressionPackage.Literals.ITERABLE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperand() {
		return operand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperand(Operator newOperand) {
		Operator oldOperand = operand;
		operand = newOperand == null ? OPERAND_EDEFAULT : newOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoreexpressionPackage.ITERABLE_EXPRESSION__OPERAND, oldOperand, operand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIfEmpty() {
		return ifEmpty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfEmpty(boolean newIfEmpty) {
		boolean oldIfEmpty = ifEmpty;
		ifEmpty = newIfEmpty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoreexpressionPackage.ITERABLE_EXPRESSION__IF_EMPTY, oldIfEmpty, ifEmpty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoreexpressionPackage.ITERABLE_EXPRESSION__OPERAND:
				return getOperand();
			case CoreexpressionPackage.ITERABLE_EXPRESSION__IF_EMPTY:
				return isIfEmpty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CoreexpressionPackage.ITERABLE_EXPRESSION__OPERAND:
				setOperand((Operator)newValue);
				return;
			case CoreexpressionPackage.ITERABLE_EXPRESSION__IF_EMPTY:
				setIfEmpty((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CoreexpressionPackage.ITERABLE_EXPRESSION__OPERAND:
				setOperand(OPERAND_EDEFAULT);
				return;
			case CoreexpressionPackage.ITERABLE_EXPRESSION__IF_EMPTY:
				setIfEmpty(IF_EMPTY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CoreexpressionPackage.ITERABLE_EXPRESSION__OPERAND:
				return operand != OPERAND_EDEFAULT;
			case CoreexpressionPackage.ITERABLE_EXPRESSION__IF_EMPTY:
				return ifEmpty != IF_EMPTY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operand: ");
		result.append(operand);
		result.append(", ifEmpty: ");
		result.append(ifEmpty);
		result.append(')');
		return result.toString();
	}

} //IterableExpressionImpl
