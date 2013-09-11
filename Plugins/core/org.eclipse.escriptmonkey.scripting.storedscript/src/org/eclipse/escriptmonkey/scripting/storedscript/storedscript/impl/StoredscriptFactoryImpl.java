/**
 *   Copyright (c) 2013 Atos
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Arthur Daussy - initial implementation
 */
package org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoredscriptFactoryImpl extends EFactoryImpl implements StoredscriptFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoredscriptFactory init() {
		try {
			StoredscriptFactory theStoredscriptFactory = (StoredscriptFactory)EPackage.Registry.INSTANCE.getEFactory(StoredscriptPackage.eNS_URI);
			if (theStoredscriptFactory != null) {
				return theStoredscriptFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoredscriptFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredscriptFactoryImpl() {
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY: return createStoredScriptRegistry();
			case StoredscriptPackage.STORED_SCRIPT: return createStoredScript();
			case StoredscriptPackage.SCRIPT_METADATA: return createScriptMetadata();
			case StoredscriptPackage.SCRIPT_TYPE: return createScriptType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredScriptRegistry createStoredScriptRegistry() {
		StoredScriptRegistryImpl storedScriptRegistry = new StoredScriptRegistryImpl();
		return storedScriptRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredScript createStoredScript() {
		StoredScriptImpl storedScript = new StoredScriptImpl();
		return storedScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMetadata createScriptMetadata() {
		ScriptMetadataImpl scriptMetadata = new ScriptMetadataImpl();
		return scriptMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType createScriptType() {
		ScriptTypeImpl scriptType = new ScriptTypeImpl();
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredscriptPackage getStoredscriptPackage() {
		return (StoredscriptPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StoredscriptPackage getPackage() {
		return StoredscriptPackage.eINSTANCE;
	}

} //StoredscriptFactoryImpl
