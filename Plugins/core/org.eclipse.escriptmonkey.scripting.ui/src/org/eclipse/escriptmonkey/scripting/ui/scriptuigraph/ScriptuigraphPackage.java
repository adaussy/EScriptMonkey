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
package org.eclipse.escriptmonkey.scripting.ui.scriptuigraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphFactory
 * @model kind="package"
 * @generated
 */
public interface ScriptuigraphPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scriptuigraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://scriptuigraph/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scriptuigraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScriptuigraphPackage eINSTANCE = org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptGraphImpl <em>Script Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptGraphImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getScriptGraph()
	 * @generated
	 */
	int SCRIPT_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_GRAPH__NODES = 0;

	/**
	 * The number of structural features of the '<em>Script Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_GRAPH_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Script Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.NodeImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ParentNodeImpl <em>Parent Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ParentNodeImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getParentNode()
	 * @generated
	 */
	int PARENT_NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE__CHILDREN = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parent Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE___ADD_SCRIPT__ELIST = NODE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE___GET_CHILDREN__ELIST = NODE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Remove Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI = NODE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parent Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.SubNodeImpl <em>Sub Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.SubNodeImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getSubNode()
	 * @generated
	 */
	int SUB_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_NODE__PARENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sub Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptSetUIImpl <em>Script Set UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptSetUIImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getScriptSetUI()
	 * @generated
	 */
	int SCRIPT_SET_UI = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI__NAME = PARENT_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI__CHILDREN = PARENT_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI__PARENT = PARENT_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Script Set UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI_FEATURE_COUNT = PARENT_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI___ADD_SCRIPT__ELIST = PARENT_NODE___ADD_SCRIPT__ELIST;

	/**
	 * The operation id for the '<em>Get Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI___GET_CHILDREN__ELIST = PARENT_NODE___GET_CHILDREN__ELIST;

	/**
	 * The operation id for the '<em>Remove Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI___REMOVE_SCRIPT__STOREDSCRIPTUI = PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI;

	/**
	 * The number of operations of the '<em>Script Set UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_SET_UI_OPERATION_COUNT = PARENT_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.StoredScriptUIImpl <em>Stored Script UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.StoredScriptUIImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getStoredScriptUI()
	 * @generated
	 */
	int STORED_SCRIPT_UI = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI__NAME = SUB_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI__PARENT = SUB_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI__DESCRIPTION = SUB_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Script</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI__SCRIPT = SUB_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stored Script UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI_FEATURE_COUNT = SUB_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stored Script UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_UI_OPERATION_COUNT = SUB_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.RootImpl
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = PARENT_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CHILDREN = PARENT_NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = PARENT_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT___ADD_SCRIPT__ELIST = PARENT_NODE___ADD_SCRIPT__ELIST;

	/**
	 * The operation id for the '<em>Get Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT___GET_CHILDREN__ELIST = PARENT_NODE___GET_CHILDREN__ELIST;

	/**
	 * The operation id for the '<em>Remove Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT___REMOVE_SCRIPT__STOREDSCRIPTUI = PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = PARENT_NODE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph <em>Script Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Graph</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph
	 * @generated
	 */
	EClass getScriptGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph#getNodes()
	 * @see #getScriptGraph()
	 * @generated
	 */
	EReference getScriptGraph_Nodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent Node</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode
	 * @generated
	 */
	EClass getParentNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren()
	 * @see #getParentNode()
	 * @generated
	 */
	EReference getParentNode_Children();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#addScript(org.eclipse.emf.common.util.EList) <em>Add Script</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Script</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#addScript(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getParentNode__AddScript__EList();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren(org.eclipse.emf.common.util.EList) <em>Get Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Children</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getParentNode__GetChildren__EList();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#removeScript(org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI) <em>Remove Script</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Script</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#removeScript(org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI)
	 * @generated
	 */
	EOperation getParentNode__RemoveScript__StoredScriptUI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode <em>Sub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Node</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode
	 * @generated
	 */
	EClass getSubNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode#getParent()
	 * @see #getSubNode()
	 * @generated
	 */
	EReference getSubNode_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI <em>Script Set UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Set UI</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI
	 * @generated
	 */
	EClass getScriptSetUI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI <em>Stored Script UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stored Script UI</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI
	 * @generated
	 */
	EClass getStoredScriptUI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getDescription()
	 * @see #getStoredScriptUI()
	 * @generated
	 */
	EAttribute getStoredScriptUI_Description();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Script</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getScript()
	 * @see #getStoredScriptUI()
	 * @generated
	 */
	EReference getStoredScriptUI_Script();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScriptuigraphFactory getScriptuigraphFactory();

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
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptGraphImpl <em>Script Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptGraphImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getScriptGraph()
		 * @generated
		 */
		EClass SCRIPT_GRAPH = eINSTANCE.getScriptGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_GRAPH__NODES = eINSTANCE.getScriptGraph_Nodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.NodeImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ParentNodeImpl <em>Parent Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ParentNodeImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getParentNode()
		 * @generated
		 */
		EClass PARENT_NODE = eINSTANCE.getParentNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_NODE__CHILDREN = eINSTANCE.getParentNode_Children();

		/**
		 * The meta object literal for the '<em><b>Add Script</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARENT_NODE___ADD_SCRIPT__ELIST = eINSTANCE.getParentNode__AddScript__EList();

		/**
		 * The meta object literal for the '<em><b>Get Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARENT_NODE___GET_CHILDREN__ELIST = eINSTANCE.getParentNode__GetChildren__EList();

		/**
		 * The meta object literal for the '<em><b>Remove Script</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI = eINSTANCE.getParentNode__RemoveScript__StoredScriptUI();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.SubNodeImpl <em>Sub Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.SubNodeImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getSubNode()
		 * @generated
		 */
		EClass SUB_NODE = eINSTANCE.getSubNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_NODE__PARENT = eINSTANCE.getSubNode_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptSetUIImpl <em>Script Set UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptSetUIImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getScriptSetUI()
		 * @generated
		 */
		EClass SCRIPT_SET_UI = eINSTANCE.getScriptSetUI();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.StoredScriptUIImpl <em>Stored Script UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.StoredScriptUIImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getStoredScriptUI()
		 * @generated
		 */
		EClass STORED_SCRIPT_UI = eINSTANCE.getStoredScriptUI();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORED_SCRIPT_UI__DESCRIPTION = eINSTANCE.getStoredScriptUI_Description();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORED_SCRIPT_UI__SCRIPT = eINSTANCE.getStoredScriptUI_Script();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.RootImpl
		 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ScriptuigraphPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

	}

} //ScriptuigraphPackage
