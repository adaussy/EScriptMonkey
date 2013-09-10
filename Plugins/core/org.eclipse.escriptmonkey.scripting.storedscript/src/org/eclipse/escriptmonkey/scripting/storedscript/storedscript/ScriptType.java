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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getScriptType()
 * @model
 * @generated
 */
public interface ScriptType extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getScriptType_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getScriptType_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Registry</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptTypes <em>Script Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registry</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registry</em>' container reference.
	 * @see #setRegistry(StoredScriptRegistry)
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage#getScriptType_Registry()
	 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry#getScriptTypes
	 * @model opposite="scriptTypes" required="true" transient="false"
	 * @generated
	 */
	StoredScriptRegistry getRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType#getRegistry <em>Registry</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registry</em>' container reference.
	 * @see #getRegistry()
	 * @generated
	 */
	void setRegistry(StoredScriptRegistry value);

} // ScriptType
