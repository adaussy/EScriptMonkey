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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionFactory
 * @model kind="package"
 * @generated
 */
public interface CoreexpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "coreexpression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://coreexpression/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "coreexpression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreexpressionPackage eINSTANCE = org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.InstanceExpressionImpl <em>Instance Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.InstanceExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getInstanceExpression()
	 * @generated
	 */
	int INSTANCE_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instance Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instance Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CompositeExpressionImpl <em>Composite Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CompositeExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getCompositeExpression()
	 * @generated
	 */
	int COMPOSITE_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EXPRESSION__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.BooleanExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__EXPRESSIONS = COMPOSITE_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = COMPOSITE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_OPERATION_COUNT = COMPOSITE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AndExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__EXPRESSIONS = BOOLEAN_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.OrExpresisonImpl <em>Or Expresison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.OrExpresisonImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getOrExpresison()
	 * @generated
	 */
	int OR_EXPRESISON = 4;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESISON__EXPRESSIONS = COMPOSITE_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Or Expresison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESISON_FEATURE_COUNT = COMPOSITE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Expresison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESISON_OPERATION_COUNT = COMPOSITE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.NotExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__EXPRESSIONS = BOOLEAN_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl <em>Iterable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getIterableExpression()
	 * @generated
	 */
	int ITERABLE_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_EXPRESSION__EXPRESSIONS = COMPOSITE_EXPRESSION__EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_EXPRESSION__OPERAND = COMPOSITE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>If Empty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_EXPRESSION__IF_EMPTY = COMPOSITE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iterable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_EXPRESSION_FEATURE_COUNT = COMPOSITE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Iterable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_EXPRESSION_OPERATION_COUNT = COMPOSITE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.WithExpressionImpl <em>With Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.WithExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getWithExpression()
	 * @generated
	 */
	int WITH_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXPRESSION__EXPRESSIONS = COMPOSITE_EXPRESSION__EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXPRESSION__VARIABLE = COMPOSITE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>With Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXPRESSION_FEATURE_COUNT = COMPOSITE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>With Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_EXPRESSION_OPERATION_COUNT = COMPOSITE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AdaptExpressionImpl <em>Adapt Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AdaptExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getAdaptExpression()
	 * @generated
	 */
	int ADAPT_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPT_EXPRESSION__EXPRESSIONS = COMPOSITE_EXPRESSION__EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPT_EXPRESSION__VALUE = COMPOSITE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Adapt Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPT_EXPRESSION_FEATURE_COUNT = COMPOSITE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Adapt Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPT_EXPRESSION_OPERATION_COUNT = COMPOSITE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ValuedExpressionImpl <em>Valued Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ValuedExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getValuedExpression()
	 * @generated
	 */
	int VALUED_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Valued Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Valued Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.EqualExpressionImpl <em>Equal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.EqualExpressionImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getEqualExpression()
	 * @generated
	 */
	int EQUAL_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_EXPRESSION__VALUE = VALUED_EXPRESSION__VALUE;

	/**
	 * The number of structural features of the '<em>Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_EXPRESSION_FEATURE_COUNT = VALUED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_EXPRESSION_OPERATION_COUNT = VALUED_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.RootImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 12;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable <em>Variable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 14;


	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.InstanceExpression <em>Instance Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.InstanceExpression
	 * @generated
	 */
	EClass getInstanceExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CompositeExpression <em>Composite Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CompositeExpression
	 * @generated
	 */
	EClass getCompositeExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CompositeExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CompositeExpression#getExpressions()
	 * @see #getCompositeExpression()
	 * @generated
	 */
	EReference getCompositeExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.OrExpresison <em>Or Expresison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expresison</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.OrExpresison
	 * @generated
	 */
	EClass getOrExpresison();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression <em>Iterable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterable Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression
	 * @generated
	 */
	EClass getIterableExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operand</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#getOperand()
	 * @see #getIterableExpression()
	 * @generated
	 */
	EAttribute getIterableExpression_Operand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#isIfEmpty <em>If Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>If Empty</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression#isIfEmpty()
	 * @see #getIterableExpression()
	 * @generated
	 */
	EAttribute getIterableExpression_IfEmpty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression <em>With Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression
	 * @generated
	 */
	EClass getWithExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression#getVariable()
	 * @see #getWithExpression()
	 * @generated
	 */
	EAttribute getWithExpression_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AdaptExpression <em>Adapt Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapt Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AdaptExpression
	 * @generated
	 */
	EClass getAdaptExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.ValuedExpression <em>Valued Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valued Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.ValuedExpression
	 * @generated
	 */
	EClass getValuedExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.ValuedExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.ValuedExpression#getValue()
	 * @see #getValuedExpression()
	 * @generated
	 */
	EAttribute getValuedExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.EqualExpression <em>Equal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.EqualExpression
	 * @generated
	 */
	EClass getEqualExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root#getExpression()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Expression();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable
	 * @generated
	 */
	EEnum getVariable();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreexpressionFactory getCoreexpressionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.InstanceExpressionImpl <em>Instance Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.InstanceExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getInstanceExpression()
		 * @generated
		 */
		EClass INSTANCE_EXPRESSION = eINSTANCE.getInstanceExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CompositeExpressionImpl <em>Composite Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CompositeExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getCompositeExpression()
		 * @generated
		 */
		EClass COMPOSITE_EXPRESSION = eINSTANCE.getCompositeExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_EXPRESSION__EXPRESSIONS = eINSTANCE.getCompositeExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AndExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.OrExpresisonImpl <em>Or Expresison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.OrExpresisonImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getOrExpresison()
		 * @generated
		 */
		EClass OR_EXPRESISON = eINSTANCE.getOrExpresison();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.BooleanExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.NotExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getNotExpression()
		 * @generated
		 */
		EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl <em>Iterable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.IterableExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getIterableExpression()
		 * @generated
		 */
		EClass ITERABLE_EXPRESSION = eINSTANCE.getIterableExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERABLE_EXPRESSION__OPERAND = eINSTANCE.getIterableExpression_Operand();

		/**
		 * The meta object literal for the '<em><b>If Empty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERABLE_EXPRESSION__IF_EMPTY = eINSTANCE.getIterableExpression_IfEmpty();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.WithExpressionImpl <em>With Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.WithExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getWithExpression()
		 * @generated
		 */
		EClass WITH_EXPRESSION = eINSTANCE.getWithExpression();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_EXPRESSION__VARIABLE = eINSTANCE.getWithExpression_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AdaptExpressionImpl <em>Adapt Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.AdaptExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getAdaptExpression()
		 * @generated
		 */
		EClass ADAPT_EXPRESSION = eINSTANCE.getAdaptExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ValuedExpressionImpl <em>Valued Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.ValuedExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getValuedExpression()
		 * @generated
		 */
		EClass VALUED_EXPRESSION = eINSTANCE.getValuedExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUED_EXPRESSION__VALUE = eINSTANCE.getValuedExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.EqualExpressionImpl <em>Equal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.EqualExpressionImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getEqualExpression()
		 * @generated
		 */
		EClass EQUAL_EXPRESSION = eINSTANCE.getEqualExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.RootImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__EXPRESSION = eINSTANCE.getRoot_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable <em>Variable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getVariable()
		 * @generated
		 */
		EEnum VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator
		 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.impl.CoreexpressionPackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();

	}

} //CoreexpressionPackage
