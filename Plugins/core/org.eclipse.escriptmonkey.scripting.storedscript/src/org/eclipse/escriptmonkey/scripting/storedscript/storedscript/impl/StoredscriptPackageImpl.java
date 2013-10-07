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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptFactory;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoredscriptPackageImpl extends EPackageImpl implements StoredscriptPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storedScriptRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStoredScriptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storedScriptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptMetadataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptTypeEClass = null;

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
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StoredscriptPackageImpl() {
		super(eNS_URI, StoredscriptFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StoredscriptPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StoredscriptPackage init() {
		if (isInited) return (StoredscriptPackage)EPackage.Registry.INSTANCE.getEPackage(StoredscriptPackage.eNS_URI);

		// Obtain or create and register package
		StoredscriptPackageImpl theStoredscriptPackage = (StoredscriptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StoredscriptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StoredscriptPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theStoredscriptPackage.createPackageContents();

		// Initialize created meta-data
		theStoredscriptPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStoredscriptPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StoredscriptPackage.eNS_URI, theStoredscriptPackage);
		return theStoredscriptPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoredScriptRegistry() {
		return storedScriptRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoredScriptRegistry_Scripts() {
		return (EReference)storedScriptRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoredScriptRegistry_ScriptTypes() {
		return (EReference)storedScriptRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStoredScriptRegistry__ProcessNewOrChangedScript__String() {
		return storedScriptRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStoredScriptRegistry__RemoveStoreScript__String() {
		return storedScriptRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStoredScriptRegistry__GetStoredScript__String() {
		return storedScriptRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStoredScriptRegistry__GetScriptType__String() {
		return storedScriptRegistryEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStoredScript() {
		return iStoredScriptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStoredScript_Uri() {
		return (EAttribute)iStoredScriptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStoredScript_Metadatas() {
		return (EReference)iStoredScriptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStoredScript_ScriptType() {
		return (EReference)iStoredScriptEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStoredScript_Registry() {
		return (EReference)iStoredScriptEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIStoredScript__GetMetadata__String() {
		return iStoredScriptEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoredScript() {
		return storedScriptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptMetadata() {
		return scriptMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMetadata_Key() {
		return (EAttribute)scriptMetadataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMetadata_Value() {
		return (EAttribute)scriptMetadataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMetadata_Script() {
		return (EReference)scriptMetadataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptType() {
		return scriptTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptType_Type() {
		return (EAttribute)scriptTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptType_Extension() {
		return (EAttribute)scriptTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptType_Registry() {
		return (EReference)scriptTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredscriptFactory getStoredscriptFactory() {
		return (StoredscriptFactory)getEFactoryInstance();
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
		storedScriptRegistryEClass = createEClass(STORED_SCRIPT_REGISTRY);
		createEReference(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY__SCRIPTS);
		createEReference(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY__SCRIPT_TYPES);
		createEOperation(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY___PROCESS_NEW_OR_CHANGED_SCRIPT__STRING);
		createEOperation(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY___REMOVE_STORE_SCRIPT__STRING);
		createEOperation(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY___GET_STORED_SCRIPT__STRING);
		createEOperation(storedScriptRegistryEClass, STORED_SCRIPT_REGISTRY___GET_SCRIPT_TYPE__STRING);

		iStoredScriptEClass = createEClass(ISTORED_SCRIPT);
		createEAttribute(iStoredScriptEClass, ISTORED_SCRIPT__URI);
		createEReference(iStoredScriptEClass, ISTORED_SCRIPT__METADATAS);
		createEReference(iStoredScriptEClass, ISTORED_SCRIPT__SCRIPT_TYPE);
		createEReference(iStoredScriptEClass, ISTORED_SCRIPT__REGISTRY);
		createEOperation(iStoredScriptEClass, ISTORED_SCRIPT___GET_METADATA__STRING);

		storedScriptEClass = createEClass(STORED_SCRIPT);

		scriptMetadataEClass = createEClass(SCRIPT_METADATA);
		createEAttribute(scriptMetadataEClass, SCRIPT_METADATA__KEY);
		createEAttribute(scriptMetadataEClass, SCRIPT_METADATA__VALUE);
		createEReference(scriptMetadataEClass, SCRIPT_METADATA__SCRIPT);

		scriptTypeEClass = createEClass(SCRIPT_TYPE);
		createEAttribute(scriptTypeEClass, SCRIPT_TYPE__TYPE);
		createEAttribute(scriptTypeEClass, SCRIPT_TYPE__EXTENSION);
		createEReference(scriptTypeEClass, SCRIPT_TYPE__REGISTRY);
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
		storedScriptEClass.getESuperTypes().add(this.getIStoredScript());

		// Initialize classes, features, and operations; add parameters
		initEClass(storedScriptRegistryEClass, StoredScriptRegistry.class, "StoredScriptRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoredScriptRegistry_Scripts(), this.getIStoredScript(), this.getIStoredScript_Registry(), "scripts", null, 0, -1, StoredScriptRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoredScriptRegistry_ScriptTypes(), this.getScriptType(), this.getScriptType_Registry(), "scriptTypes", null, 0, -1, StoredScriptRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getStoredScriptRegistry__ProcessNewOrChangedScript__String(), this.getIStoredScript(), "processNewOrChangedScript", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getStoredScriptRegistry__RemoveStoreScript__String(), null, "removeStoreScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getStoredScriptRegistry__GetStoredScript__String(), this.getIStoredScript(), "getStoredScript", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getStoredScriptRegistry__GetScriptType__String(), this.getScriptType(), "getScriptType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iStoredScriptEClass, IStoredScript.class, "IStoredScript", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIStoredScript_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, IStoredScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStoredScript_Metadatas(), this.getScriptMetadata(), this.getScriptMetadata_Script(), "metadatas", null, 0, -1, IStoredScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStoredScript_ScriptType(), this.getScriptType(), null, "scriptType", null, 1, 1, IStoredScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStoredScript_Registry(), this.getStoredScriptRegistry(), this.getStoredScriptRegistry_Scripts(), "registry", null, 1, 1, IStoredScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getIStoredScript__GetMetadata__String(), this.getScriptMetadata(), "getMetadata", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "metadataName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(storedScriptEClass, StoredScript.class, "StoredScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptMetadataEClass, ScriptMetadata.class, "ScriptMetadata", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptMetadata_Key(), ecorePackage.getEString(), "key", null, 1, 1, ScriptMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMetadata_Value(), ecorePackage.getEString(), "value", null, 1, 1, ScriptMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMetadata_Script(), this.getIStoredScript(), this.getIStoredScript_Metadatas(), "script", null, 1, 1, ScriptMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptTypeEClass, ScriptType.class, "ScriptType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptType_Type(), ecorePackage.getEString(), "type", null, 1, 1, ScriptType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptType_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, ScriptType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptType_Registry(), this.getStoredScriptRegistry(), this.getStoredScriptRegistry_ScriptTypes(), "registry", null, 1, 1, ScriptType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		//  http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b> http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = " http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (iStoredScriptEClass, 
		   source, 
		   new String[] {
			 "documentation", "@implements org.eclipse.escriptmonkey.scripting.storedscript.IContentProvider"
		   });
	}

} //StoredscriptPackageImpl
