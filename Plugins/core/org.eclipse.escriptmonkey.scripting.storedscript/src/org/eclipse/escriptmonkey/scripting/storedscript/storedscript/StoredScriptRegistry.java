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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stored Script Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScripts <em>Scripts</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptTypes <em>Script Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getStoredScriptRegistry()
 * @model
 * @generated
 */
public interface StoredScriptRegistry extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * Returns the value of the '<em><b>Scripts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scripts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scripts</em>' containment reference list.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getStoredScriptRegistry_Scripts()
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry
	 * @model opposite="registry" containment="true"
	 * @generated
	 */
	EList<IStoredScript> getScripts();

	/**
	 * Returns the value of the '<em><b>Script Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Types</em>' containment reference list.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getStoredScriptRegistry_ScriptTypes()
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry
	 * @model opposite="registry" containment="true"
	 * @generated
	 */
	EList<ScriptType> getScriptTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" uriRequired="true"
	 * @generated
	 */
	IStoredScript processNewOrChangedScript(String uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model uriRequired="true"
	 * @generated
	 */
	void removeStoreScript(String uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" uriRequired="true"
	 * @generated
	 */
	IStoredScript getStoredScript(String uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeRequired="true"
	 * @generated
	 */
	ScriptType getScriptType(String type);

} // StoredScriptRegistry
