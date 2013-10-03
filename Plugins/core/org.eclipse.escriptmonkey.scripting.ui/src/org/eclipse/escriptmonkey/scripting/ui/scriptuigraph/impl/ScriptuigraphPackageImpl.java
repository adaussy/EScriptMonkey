/**
 *   Copyright (c) 2013 Atos
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *       Arthur Daussy - initial implementation
 */
package org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphFactory;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptuigraphPackageImpl extends EPackageImpl implements ScriptuigraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptSetUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storedScriptUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

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
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScriptuigraphPackageImpl() {
		super(eNS_URI, ScriptuigraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScriptuigraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScriptuigraphPackage init() {
		if (isInited) return (ScriptuigraphPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptuigraphPackage.eNS_URI);

		// Obtain or create and register package
		ScriptuigraphPackageImpl theScriptuigraphPackage = (ScriptuigraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScriptuigraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScriptuigraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StoredscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theScriptuigraphPackage.createPackageContents();

		// Initialize created meta-data
		theScriptuigraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScriptuigraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScriptuigraphPackage.eNS_URI, theScriptuigraphPackage);
		return theScriptuigraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptGraph() {
		return scriptGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptGraph_Nodes() {
		return (EReference)scriptGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentNode() {
		return parentNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentNode_Children() {
		return (EReference)parentNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParentNode__AddScript__EList() {
		return parentNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParentNode__GetChildren__EList() {
		return parentNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParentNode__RemoveScript__StoredScriptUI() {
		return parentNodeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubNode() {
		return subNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubNode_Parent() {
		return (EReference)subNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptSetUI() {
		return scriptSetUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoredScriptUI() {
		return storedScriptUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStoredScriptUI_Description() {
		return (EAttribute)storedScriptUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoredScriptUI_Script() {
		return (EReference)storedScriptUIEClass.getEStructuralFeatures().get(1);
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
	public ScriptuigraphFactory getScriptuigraphFactory() {
		return (ScriptuigraphFactory)getEFactoryInstance();
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
		scriptGraphEClass = createEClass(SCRIPT_GRAPH);
		createEReference(scriptGraphEClass, SCRIPT_GRAPH__NODES);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__NAME);

		parentNodeEClass = createEClass(PARENT_NODE);
		createEReference(parentNodeEClass, PARENT_NODE__CHILDREN);
		createEOperation(parentNodeEClass, PARENT_NODE___ADD_SCRIPT__ELIST);
		createEOperation(parentNodeEClass, PARENT_NODE___GET_CHILDREN__ELIST);
		createEOperation(parentNodeEClass, PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI);

		subNodeEClass = createEClass(SUB_NODE);
		createEReference(subNodeEClass, SUB_NODE__PARENT);

		scriptSetUIEClass = createEClass(SCRIPT_SET_UI);

		storedScriptUIEClass = createEClass(STORED_SCRIPT_UI);
		createEAttribute(storedScriptUIEClass, STORED_SCRIPT_UI__DESCRIPTION);
		createEReference(storedScriptUIEClass, STORED_SCRIPT_UI__SCRIPT);

		rootEClass = createEClass(ROOT);
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

		// Obtain other dependent packages
		StoredscriptPackage theStoredscriptPackage = (StoredscriptPackage)EPackage.Registry.INSTANCE.getEPackage(StoredscriptPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		parentNodeEClass.getESuperTypes().add(this.getNode());
		subNodeEClass.getESuperTypes().add(this.getNode());
		scriptSetUIEClass.getESuperTypes().add(this.getParentNode());
		scriptSetUIEClass.getESuperTypes().add(this.getSubNode());
		storedScriptUIEClass.getESuperTypes().add(this.getSubNode());
		rootEClass.getESuperTypes().add(this.getParentNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(scriptGraphEClass, ScriptGraph.class, "ScriptGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, ScriptGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parentNodeEClass, ParentNode.class, "ParentNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentNode_Children(), this.getSubNode(), this.getSubNode_Parent(), "children", null, 0, -1, ParentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getParentNode__AddScript__EList(), this.getStoredScriptUI(), "addScript", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 1, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParentNode__GetChildren__EList(), this.getSubNode(), "getChildren", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 1, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParentNode__RemoveScript__StoredScriptUI(), null, "removeScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStoredScriptUI(), "script", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(subNodeEClass, SubNode.class, "SubNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubNode_Parent(), this.getParentNode(), this.getParentNode_Children(), "parent", null, 0, 1, SubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptSetUIEClass, ScriptSetUI.class, "ScriptSetUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storedScriptUIEClass, StoredScriptUI.class, "StoredScriptUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStoredScriptUI_Description(), ecorePackage.getEString(), "description", null, 0, 1, StoredScriptUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoredScriptUI_Script(), theStoredscriptPackage.getIStoredScript(), null, "script", null, 1, 1, StoredScriptUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ScriptuigraphPackageImpl
