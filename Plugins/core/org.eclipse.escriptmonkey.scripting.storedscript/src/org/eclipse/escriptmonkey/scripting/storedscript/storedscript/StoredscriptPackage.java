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
package org.eclipse.escriptmonkey.scripting.storedscript.storedscript;

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
 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptFactory
 * @model kind="package"
 * @generated
 */
public interface StoredscriptPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "storedscript";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://storedscript/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "storedscript";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoredscriptPackage eINSTANCE = org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl <em>Stored Script Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getStoredScriptRegistry()
	 * @generated
	 */
	int STORED_SCRIPT_REGISTRY = 0;

	/**
	 * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY__SCRIPTS = 0;

	/**
	 * The feature id for the '<em><b>Script Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY__SCRIPT_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Stored Script Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Process New Or Changed Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY___PROCESS_NEW_OR_CHANGED_SCRIPT__STRING = 0;

	/**
	 * The operation id for the '<em>Remove Store Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY___REMOVE_STORE_SCRIPT__STRING = 1;

	/**
	 * The operation id for the '<em>Get Stored Script</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY___GET_STORED_SCRIPT__STRING = 2;

	/**
	 * The operation id for the '<em>Get Script Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY___GET_SCRIPT_TYPE__STRING = 3;

	/**
	 * The number of operations of the '<em>Stored Script Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_REGISTRY_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript <em>IStored Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getIStoredScript()
	 * @generated
	 */
	int ISTORED_SCRIPT = 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT__URI = 0;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT__METADATAS = 1;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT__SCRIPT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT__REGISTRY = 3;

	/**
	 * The number of structural features of the '<em>IStored Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Metadata</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT___GET_METADATA__STRING = 0;

	/**
	 * The number of operations of the '<em>IStored Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTORED_SCRIPT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl <em>Stored Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getStoredScript()
	 * @generated
	 */
	int STORED_SCRIPT = 2;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT__URI = ISTORED_SCRIPT__URI;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT__METADATAS = ISTORED_SCRIPT__METADATAS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT__SCRIPT_TYPE = ISTORED_SCRIPT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT__REGISTRY = ISTORED_SCRIPT__REGISTRY;

	/**
	 * The number of structural features of the '<em>Stored Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_FEATURE_COUNT = ISTORED_SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Metadata</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT___GET_METADATA__STRING = ISTORED_SCRIPT___GET_METADATA__STRING;

	/**
	 * The number of operations of the '<em>Stored Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_SCRIPT_OPERATION_COUNT = ISTORED_SCRIPT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptMetadataImpl <em>Script Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptMetadataImpl
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getScriptMetadata()
	 * @generated
	 */
	int SCRIPT_METADATA = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_METADATA__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_METADATA__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Script</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_METADATA__SCRIPT = 2;

	/**
	 * The number of structural features of the '<em>Script Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_METADATA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Script Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_METADATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl <em>Script Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getScriptType()
	 * @generated
	 */
	int SCRIPT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TYPE__EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TYPE__REGISTRY = 2;

	/**
	 * The number of structural features of the '<em>Script Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Script Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry <em>Stored Script Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stored Script Registry</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry
	 * @generated
	 */
	EClass getStoredScriptRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScripts <em>Scripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scripts</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScripts()
	 * @see #getStoredScriptRegistry()
	 * @generated
	 */
	EReference getStoredScriptRegistry_Scripts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptTypes <em>Script Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Script Types</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptTypes()
	 * @see #getStoredScriptRegistry()
	 * @generated
	 */
	EReference getStoredScriptRegistry_ScriptTypes();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#processNewOrChangedScript(java.lang.String) <em>Process New Or Changed Script</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Process New Or Changed Script</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#processNewOrChangedScript(java.lang.String)
	 * @generated
	 */
	EOperation getStoredScriptRegistry__ProcessNewOrChangedScript__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#removeStoreScript(java.lang.String) <em>Remove Store Script</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Store Script</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#removeStoreScript(java.lang.String)
	 * @generated
	 */
	EOperation getStoredScriptRegistry__RemoveStoreScript__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getStoredScript(java.lang.String) <em>Get Stored Script</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Stored Script</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getStoredScript(java.lang.String)
	 * @generated
	 */
	EOperation getStoredScriptRegistry__GetStoredScript__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptType(java.lang.String) <em>Get Script Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Script Type</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptType(java.lang.String)
	 * @generated
	 */
	EOperation getStoredScriptRegistry__GetScriptType__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript <em>IStored Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IStored Script</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript
	 * @generated
	 */
	EClass getIStoredScript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getUri()
	 * @see #getIStoredScript()
	 * @generated
	 */
	EAttribute getIStoredScript_Uri();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getMetadatas <em>Metadatas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadatas</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getMetadatas()
	 * @see #getIStoredScript()
	 * @generated
	 */
	EReference getIStoredScript_Metadatas();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Script Type</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getScriptType()
	 * @see #getIStoredScript()
	 * @generated
	 */
	EReference getIStoredScript_ScriptType();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Registry</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry()
	 * @see #getIStoredScript()
	 * @generated
	 */
	EReference getIStoredScript_Registry();

	/**
	 * Returns the meta object for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getMetadata(java.lang.String) <em>Get Metadata</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metadata</em>' operation.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getMetadata(java.lang.String)
	 * @generated
	 */
	EOperation getIStoredScript__GetMetadata__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScript <em>Stored Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stored Script</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScript
	 * @generated
	 */
	EClass getStoredScript();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata <em>Script Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Metadata</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata
	 * @generated
	 */
	EClass getScriptMetadata();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getKey()
	 * @see #getScriptMetadata()
	 * @generated
	 */
	EAttribute getScriptMetadata_Key();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getValue()
	 * @see #getScriptMetadata()
	 * @generated
	 */
	EAttribute getScriptMetadata_Value();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Script</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getScript()
	 * @see #getScriptMetadata()
	 * @generated
	 */
	EReference getScriptMetadata_Script();

	/**
	 * Returns the meta object for class '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Type</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType
	 * @generated
	 */
	EClass getScriptType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getType()
	 * @see #getScriptType()
	 * @generated
	 */
	EAttribute getScriptType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getExtension()
	 * @see #getScriptType()
	 * @generated
	 */
	EAttribute getScriptType_Extension();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Registry</em>'.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry()
	 * @see #getScriptType()
	 * @generated
	 */
	EReference getScriptType_Registry();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoredscriptFactory getStoredscriptFactory();

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
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl <em>Stored Script Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getStoredScriptRegistry()
		 * @generated
		 */
		EClass STORED_SCRIPT_REGISTRY = eINSTANCE.getStoredScriptRegistry();

		/**
		 * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORED_SCRIPT_REGISTRY__SCRIPTS = eINSTANCE.getStoredScriptRegistry_Scripts();

		/**
		 * The meta object literal for the '<em><b>Script Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORED_SCRIPT_REGISTRY__SCRIPT_TYPES = eINSTANCE.getStoredScriptRegistry_ScriptTypes();

		/**
		 * The meta object literal for the '<em><b>Process New Or Changed Script</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STORED_SCRIPT_REGISTRY___PROCESS_NEW_OR_CHANGED_SCRIPT__STRING = eINSTANCE.getStoredScriptRegistry__ProcessNewOrChangedScript__String();

		/**
		 * The meta object literal for the '<em><b>Remove Store Script</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STORED_SCRIPT_REGISTRY___REMOVE_STORE_SCRIPT__STRING = eINSTANCE.getStoredScriptRegistry__RemoveStoreScript__String();

		/**
		 * The meta object literal for the '<em><b>Get Stored Script</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STORED_SCRIPT_REGISTRY___GET_STORED_SCRIPT__STRING = eINSTANCE.getStoredScriptRegistry__GetStoredScript__String();

		/**
		 * The meta object literal for the '<em><b>Get Script Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STORED_SCRIPT_REGISTRY___GET_SCRIPT_TYPE__STRING = eINSTANCE.getStoredScriptRegistry__GetScriptType__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript <em>IStored Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getIStoredScript()
		 * @generated
		 */
		EClass ISTORED_SCRIPT = eINSTANCE.getIStoredScript();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISTORED_SCRIPT__URI = eINSTANCE.getIStoredScript_Uri();

		/**
		 * The meta object literal for the '<em><b>Metadatas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTORED_SCRIPT__METADATAS = eINSTANCE.getIStoredScript_Metadatas();

		/**
		 * The meta object literal for the '<em><b>Script Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTORED_SCRIPT__SCRIPT_TYPE = eINSTANCE.getIStoredScript_ScriptType();

		/**
		 * The meta object literal for the '<em><b>Registry</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTORED_SCRIPT__REGISTRY = eINSTANCE.getIStoredScript_Registry();

		/**
		 * The meta object literal for the '<em><b>Get Metadata</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISTORED_SCRIPT___GET_METADATA__STRING = eINSTANCE.getIStoredScript__GetMetadata__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl <em>Stored Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getStoredScript()
		 * @generated
		 */
		EClass STORED_SCRIPT = eINSTANCE.getStoredScript();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptMetadataImpl <em>Script Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptMetadataImpl
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getScriptMetadata()
		 * @generated
		 */
		EClass SCRIPT_METADATA = eINSTANCE.getScriptMetadata();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_METADATA__KEY = eINSTANCE.getScriptMetadata_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_METADATA__VALUE = eINSTANCE.getScriptMetadata_Value();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_METADATA__SCRIPT = eINSTANCE.getScriptMetadata_Script();

		/**
		 * The meta object literal for the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl <em>Script Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl
		 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptPackageImpl#getScriptType()
		 * @generated
		 */
		EClass SCRIPT_TYPE = eINSTANCE.getScriptType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_TYPE__TYPE = eINSTANCE.getScriptType_Type();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_TYPE__EXTENSION = eINSTANCE.getScriptType_Extension();

		/**
		 * The meta object literal for the '<em><b>Registry</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_TYPE__REGISTRY = eINSTANCE.getScriptType_Registry();

	}

} //StoredscriptPackage
