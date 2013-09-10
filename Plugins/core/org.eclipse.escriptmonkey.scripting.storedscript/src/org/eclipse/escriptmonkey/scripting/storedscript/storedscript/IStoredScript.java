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
 * A representation of the model object '<em><b>IStored Script</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getUri <em>Uri</em>}</li>
 * <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getMetadatas <em>Metadatas</em>}</li>
 * <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getScriptType <em>Script Type</em>}</li>
 * <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getIStoredScript()
 * @model interface="true" abstract="true"
 *        annotation=
 *        "\040http://www.eclipse.org/emf/2002/GenModel documentation='@implements org.eclipse.escriptmonkey.scripting.storedscript.IContentProvider'"
 * @generated
 */
public interface IStoredScript extends EObject, org.eclipse.escriptmonkey.scripting.storedscript.IContentProvider {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getIStoredScript_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Metadatas</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getScript
	 * <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metadatas</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Metadatas</em>' containment reference list.
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getIStoredScript_Metadatas()
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata#getScript
	 * @model opposite="script" containment="true"
	 * @generated
	 */
	EList<ScriptMetadata> getMetadatas();

	/**
	 * Returns the value of the '<em><b>Script Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Script Type</em>' reference.
	 * @see #setScriptType(ScriptType)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getIStoredScript_ScriptType()
	 * @model required="true"
	 * @generated
	 */
	ScriptType getScriptType();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getScriptType <em>Script Type</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Script Type</em>' reference.
	 * @see #getScriptType()
	 * @generated
	 */
	void setScriptType(ScriptType value);

	/**
	 * Returns the value of the '<em><b>Registry</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScripts
	 * <em>Scripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registry</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Registry</em>' container reference.
	 * @see #setRegistry(StoredScriptRegistry)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getIStoredScript_Registry()
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScripts
	 * @model opposite="scripts" required="true" transient="false"
	 * @generated
	 */
	StoredScriptRegistry getRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript#getRegistry <em>Registry</em>}'
	 * container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Registry</em>' container reference.
	 * @see #getRegistry()
	 * @generated
	 */
	void setRegistry(StoredScriptRegistry value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model metadataNameRequired="true"
	 * @generated
	 */
	ScriptMetadata getMetadata(String metadataName);

} // IStoredScript
