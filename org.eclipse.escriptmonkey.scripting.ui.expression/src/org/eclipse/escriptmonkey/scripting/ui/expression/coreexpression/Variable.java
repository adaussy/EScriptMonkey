/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage#getVariable()
 * @model
 * @generated
 */
public enum Variable implements Enumerator {
	/**
	 * The '<em><b>Active Contexts</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_CONTEXTS_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_CONTEXTS(0, "activeContexts", "activeContexts"),

	/**
	 * The '<em><b>Active Editor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_EDITOR_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_EDITOR(1, "activeEditor", "activeEditor"),

	/**
	 * The '<em><b>Active Editor Id</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_EDITOR_ID_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_EDITOR_ID(2, "activeEditorId", "activeEditorId"),

	/**
	 * The '<em><b>Active Part Id</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_PART_ID_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_PART_ID(3, "activePartId", "activePartId"),

	/**
	 * The '<em><b>Active Site</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_SITE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_SITE(4, "activeSite", "activeSite"),

	/**
	 * The '<em><b>Selection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	SELECTION(5, "selection", "selection");

	/**
	 * The '<em><b>Active Contexts</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Contexts</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_CONTEXTS
	 * @model name="activeContexts"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_CONTEXTS_VALUE = 0;

	/**
	 * The '<em><b>Active Editor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Editor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_EDITOR
	 * @model name="activeEditor"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_EDITOR_VALUE = 1;

	/**
	 * The '<em><b>Active Editor Id</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Editor Id</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_EDITOR_ID
	 * @model name="activeEditorId"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_EDITOR_ID_VALUE = 2;

	/**
	 * The '<em><b>Active Part Id</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Part Id</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_PART_ID
	 * @model name="activePartId"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_PART_ID_VALUE = 3;

	/**
	 * The '<em><b>Active Site</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Site</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_SITE
	 * @model name="activeSite"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_SITE_VALUE = 4;

	/**
	 * The '<em><b>Selection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Selection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELECTION
	 * @model name="selection"
	 * @generated
	 * @ordered
	 */
	public static final int SELECTION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Variable</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Variable[] VALUES_ARRAY =
		new Variable[] {
			ACTIVE_CONTEXTS,
			ACTIVE_EDITOR,
			ACTIVE_EDITOR_ID,
			ACTIVE_PART_ID,
			ACTIVE_SITE,
			SELECTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Variable> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Variable get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Variable result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Variable getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Variable result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Variable get(int value) {
		switch (value) {
			case ACTIVE_CONTEXTS_VALUE: return ACTIVE_CONTEXTS;
			case ACTIVE_EDITOR_VALUE: return ACTIVE_EDITOR;
			case ACTIVE_EDITOR_ID_VALUE: return ACTIVE_EDITOR_ID;
			case ACTIVE_PART_ID_VALUE: return ACTIVE_PART_ID;
			case ACTIVE_SITE_VALUE: return ACTIVE_SITE;
			case SELECTION_VALUE: return SELECTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Variable(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Variable
