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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.ScriptTypeImpl#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptTypeImpl extends MinimalEObjectImpl.Container implements ScriptType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoredscriptPackage.Literals.SCRIPT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.SCRIPT_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.SCRIPT_TYPE__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredScriptRegistry getRegistry() {
		if (eContainerFeatureID() != StoredscriptPackage.SCRIPT_TYPE__REGISTRY) return null;
		return (StoredScriptRegistry)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistry(StoredScriptRegistry newRegistry, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRegistry, StoredscriptPackage.SCRIPT_TYPE__REGISTRY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistry(StoredScriptRegistry newRegistry) {
		if (newRegistry != eInternalContainer() || (eContainerFeatureID() != StoredscriptPackage.SCRIPT_TYPE__REGISTRY && newRegistry != null)) {
			if (EcoreUtil.isAncestor(this, newRegistry))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRegistry != null)
				msgs = ((InternalEObject)newRegistry).eInverseAdd(this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES, StoredScriptRegistry.class, msgs);
			msgs = basicSetRegistry(newRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.SCRIPT_TYPE__REGISTRY, newRegistry, newRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRegistry((StoredScriptRegistry)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				return basicSetRegistry(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				return eInternalContainer().eInverseRemove(this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES, StoredScriptRegistry.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__TYPE:
				return getType();
			case StoredscriptPackage.SCRIPT_TYPE__EXTENSION:
				return getExtension();
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				return getRegistry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__TYPE:
				setType((String)newValue);
				return;
			case StoredscriptPackage.SCRIPT_TYPE__EXTENSION:
				setExtension((String)newValue);
				return;
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				setRegistry((StoredScriptRegistry)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case StoredscriptPackage.SCRIPT_TYPE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				setRegistry((StoredScriptRegistry)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoredscriptPackage.SCRIPT_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case StoredscriptPackage.SCRIPT_TYPE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case StoredscriptPackage.SCRIPT_TYPE__REGISTRY:
				return getRegistry() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //ScriptTypeImpl
