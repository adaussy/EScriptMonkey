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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AdaptExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AndExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.BooleanExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CompositeExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionFactory;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.EqualExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Expression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.InstanceExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.NotExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.OrExpresison;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.ValuedExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreexpressionPackageImpl extends EPackageImpl implements CoreexpressionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orExpresisonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adaptExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CoreexpressionPackageImpl() {
		super(eNS_URI, CoreexpressionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CoreexpressionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CoreexpressionPackage init() {
		if (isInited) return (CoreexpressionPackage)EPackage.Registry.INSTANCE.getEPackage(CoreexpressionPackage.eNS_URI);

		// Obtain or create and register package
		CoreexpressionPackageImpl theCoreexpressionPackage = (CoreexpressionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CoreexpressionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CoreexpressionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCoreexpressionPackage.createPackageContents();

		// Initialize created meta-data
		theCoreexpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCoreexpressionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CoreexpressionPackage.eNS_URI, theCoreexpressionPackage);
		return theCoreexpressionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceExpression() {
		return instanceExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeExpression() {
		return compositeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeExpression_Expressions() {
		return (EReference)compositeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndExpression() {
		return andExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrExpresison() {
		return orExpresisonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanExpression() {
		return booleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotExpression() {
		return notExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterableExpression() {
		return iterableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterableExpression_Operand() {
		return (EAttribute)iterableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterableExpression_IfEmpty() {
		return (EAttribute)iterableExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWithExpression() {
		return withExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWithExpression_Variable() {
		return (EAttribute)withExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdaptExpression() {
		return adaptExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValuedExpression() {
		return valuedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValuedExpression_Value() {
		return (EAttribute)valuedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualExpression() {
		return equalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_Expression() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariable() {
		return variableEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperator() {
		return operatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreexpressionFactory getCoreexpressionFactory() {
		return (CoreexpressionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		expressionEClass = createEClass(EXPRESSION);

		instanceExpressionEClass = createEClass(INSTANCE_EXPRESSION);

		compositeExpressionEClass = createEClass(COMPOSITE_EXPRESSION);
		createEReference(compositeExpressionEClass, COMPOSITE_EXPRESSION__EXPRESSIONS);

		andExpressionEClass = createEClass(AND_EXPRESSION);

		orExpresisonEClass = createEClass(OR_EXPRESISON);

		booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

		notExpressionEClass = createEClass(NOT_EXPRESSION);

		iterableExpressionEClass = createEClass(ITERABLE_EXPRESSION);
		createEAttribute(iterableExpressionEClass, ITERABLE_EXPRESSION__OPERAND);
		createEAttribute(iterableExpressionEClass, ITERABLE_EXPRESSION__IF_EMPTY);

		withExpressionEClass = createEClass(WITH_EXPRESSION);
		createEAttribute(withExpressionEClass, WITH_EXPRESSION__VARIABLE);

		adaptExpressionEClass = createEClass(ADAPT_EXPRESSION);

		valuedExpressionEClass = createEClass(VALUED_EXPRESSION);
		createEAttribute(valuedExpressionEClass, VALUED_EXPRESSION__VALUE);

		equalExpressionEClass = createEClass(EQUAL_EXPRESSION);

		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__EXPRESSION);

		// Create enums
		variableEEnum = createEEnum(VARIABLE);
		operatorEEnum = createEEnum(OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		instanceExpressionEClass.getESuperTypes().add(this.getExpression());
		instanceExpressionEClass.getESuperTypes().add(this.getValuedExpression());
		compositeExpressionEClass.getESuperTypes().add(this.getExpression());
		andExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		andExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		orExpresisonEClass.getESuperTypes().add(this.getCompositeExpression());
		orExpresisonEClass.getESuperTypes().add(this.getBooleanExpression());
		booleanExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		booleanExpressionEClass.getESuperTypes().add(this.getExpression());
		notExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		notExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		iterableExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		withExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		adaptExpressionEClass.getESuperTypes().add(this.getCompositeExpression());
		adaptExpressionEClass.getESuperTypes().add(this.getValuedExpression());
		valuedExpressionEClass.getESuperTypes().add(this.getExpression());
		equalExpressionEClass.getESuperTypes().add(this.getValuedExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceExpressionEClass, InstanceExpression.class, "InstanceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeExpressionEClass, CompositeExpression.class, "CompositeExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeExpression_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, CompositeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orExpresisonEClass, OrExpresison.class, "OrExpresison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanExpressionEClass, BooleanExpression.class, "BooleanExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterableExpressionEClass, IterableExpression.class, "IterableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterableExpression_Operand(), this.getOperator(), "operand", null, 0, 1, IterableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterableExpression_IfEmpty(), ecorePackage.getEBoolean(), "ifEmpty", null, 0, 1, IterableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withExpressionEClass, WithExpression.class, "WithExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWithExpression_Variable(), this.getVariable(), "variable", null, 0, 1, WithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adaptExpressionEClass, AdaptExpression.class, "AdaptExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valuedExpressionEClass, ValuedExpression.class, "ValuedExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValuedExpression_Value(), ecorePackage.getEString(), "value", null, 1, 1, ValuedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalExpressionEClass, EqualExpression.class, "EqualExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_Expression(), this.getExpression(), null, "expression", null, 1, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableEEnum, Variable.class, "Variable");
		addEEnumLiteral(variableEEnum, Variable.ACTIVE_CONTEXTS);
		addEEnumLiteral(variableEEnum, Variable.ACTIVE_EDITOR);
		addEEnumLiteral(variableEEnum, Variable.ACTIVE_EDITOR_ID);
		addEEnumLiteral(variableEEnum, Variable.ACTIVE_PART_ID);
		addEEnumLiteral(variableEEnum, Variable.ACTIVE_SITE);
		addEEnumLiteral(variableEEnum, Variable.SELECTION);

		initEEnum(operatorEEnum, Operator.class, "Operator");
		addEEnumLiteral(operatorEEnum, Operator.AND);
		addEEnumLiteral(operatorEEnum, Operator.OR);

		// Create resource
		createResource(eNS_URI);
	}

} //CoreexpressionPackageImpl
