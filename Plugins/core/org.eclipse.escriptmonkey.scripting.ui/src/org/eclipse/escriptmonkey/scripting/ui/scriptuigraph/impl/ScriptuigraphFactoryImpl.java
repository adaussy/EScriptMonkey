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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptGraph;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphFactory;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptuigraphFactoryImpl extends EFactoryImpl implements ScriptuigraphFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScriptuigraphFactory init() {
		try {
			ScriptuigraphFactory theScriptuigraphFactory = (ScriptuigraphFactory)EPackage.Registry.INSTANCE.getEFactory(ScriptuigraphPackage.eNS_URI);
			if (theScriptuigraphFactory != null) {
				return theScriptuigraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScriptuigraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptuigraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScriptuigraphPackage.SCRIPT_GRAPH: return createScriptGraph();
			case ScriptuigraphPackage.SCRIPT_SET_UI: return createScriptSetUI();
			case ScriptuigraphPackage.STORED_SCRIPT_UI: return createStoredScriptUI();
			case ScriptuigraphPackage.ROOT: return createRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptGraph createScriptGraph() {
		ScriptGraphImpl scriptGraph = new ScriptGraphImpl();
		return scriptGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptSetUI createScriptSetUI() {
		ScriptSetUIImpl scriptSetUI = new ScriptSetUIImpl();
		return scriptSetUI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredScriptUI createStoredScriptUI() {
		StoredScriptUIImpl storedScriptUI = new StoredScriptUIImpl();
		return storedScriptUI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptuigraphPackage getScriptuigraphPackage() {
		return (ScriptuigraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScriptuigraphPackage getPackage() {
		return ScriptuigraphPackage.eINSTANCE;
	}

} //ScriptuigraphFactoryImpl
