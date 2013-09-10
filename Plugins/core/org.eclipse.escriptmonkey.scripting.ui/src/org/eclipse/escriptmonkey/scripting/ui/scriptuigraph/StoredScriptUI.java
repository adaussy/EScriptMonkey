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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stored Script UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#getStoredScriptUI()
 * @model
 * @generated
 */
public interface StoredScriptUI extends SubNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#getStoredScriptUI_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#getStoredScriptUI_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // StoredScriptUI
