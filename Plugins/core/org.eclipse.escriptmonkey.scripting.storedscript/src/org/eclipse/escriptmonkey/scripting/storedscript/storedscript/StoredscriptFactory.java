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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage
 * @generated
 */
public interface StoredscriptFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoredscriptFactory eINSTANCE = org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredscriptFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Stored Script Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stored Script Registry</em>'.
	 * @generated
	 */
	StoredScriptRegistry createStoredScriptRegistry();

	/**
	 * Returns a new object of class '<em>Stored Script</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stored Script</em>'.
	 * @generated
	 */
	StoredScript createStoredScript();

	/**
	 * Returns a new object of class '<em>Script Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Metadata</em>'.
	 * @generated
	 */
	ScriptMetadata createScriptMetadata();

	/**
	 * Returns a new object of class '<em>Script Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Type</em>'.
	 * @generated
	 */
	ScriptType createScriptType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StoredscriptPackage getStoredscriptPackage();

} //StoredscriptFactory
