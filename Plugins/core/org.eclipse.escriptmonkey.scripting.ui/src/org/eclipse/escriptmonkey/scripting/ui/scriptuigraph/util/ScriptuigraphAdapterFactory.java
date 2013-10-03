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
package org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage
 * @generated
 */
public class ScriptuigraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScriptuigraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptuigraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ScriptuigraphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptuigraphSwitch<Adapter> modelSwitch =
		new ScriptuigraphSwitch<Adapter>() {
			@Override
			public Adapter caseScriptGraph(ScriptGraph object) {
				return createScriptGraphAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseParentNode(ParentNode object) {
				return createParentNodeAdapter();
			}
			@Override
			public Adapter caseSubNode(SubNode object) {
				return createSubNodeAdapter();
			}
			@Override
			public Adapter caseScriptSetUI(ScriptSetUI object) {
				return createScriptSetUIAdapter();
			}
			@Override
			public Adapter caseStoredScriptUI(StoredScriptUI object) {
				return createStoredScriptUIAdapter();
			}
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph <em>Script Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph
	 * @generated
	 */
	public Adapter createScriptGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode
	 * @generated
	 */
	public Adapter createParentNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode <em>Sub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode
	 * @generated
	 */
	public Adapter createSubNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI <em>Script Set UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI
	 * @generated
	 */
	public Adapter createScriptSetUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI <em>Stored Script UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI
	 * @generated
	 */
	public Adapter createStoredScriptUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ScriptuigraphAdapterFactory
