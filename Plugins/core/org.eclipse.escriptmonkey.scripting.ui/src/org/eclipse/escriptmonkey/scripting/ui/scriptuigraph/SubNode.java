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
 * A representation of the model object '<em><b>Sub Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#getSubNode()
 * @model abstract="true"
 * @generated
 */
public interface SubNode extends Node {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ParentNode)
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage#getSubNode_Parent()
	 * @see org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	ParentNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ParentNode value);

} // SubNode
