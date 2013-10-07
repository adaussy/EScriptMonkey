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

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.URIScriptUtils;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.Utilities;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stored Script</b></em>'.
 * 
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl#getMetadatas <em>Metadatas</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptImpl#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoredScriptImpl extends MinimalEObjectImpl.Container implements StoredScript {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetadatas() <em>Metadatas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadatas()
	 * @generated
	 * @ordered
	 */
	protected EList<ScriptMetadata> metadatas;

	/**
	 * The cached value of the '{@link #getScriptType() <em>Script Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected ScriptType scriptType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoredScriptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoredscriptPackage.Literals.STORED_SCRIPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.STORED_SCRIPT__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScriptMetadata> getMetadatas() {
		if (metadatas == null) {
			metadatas = new EObjectContainmentWithInverseEList<ScriptMetadata>(ScriptMetadata.class, this, StoredscriptPackage.STORED_SCRIPT__METADATAS, StoredscriptPackage.SCRIPT_METADATA__SCRIPT);
		}
		return metadatas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType getScriptType() {
		if (scriptType != null && scriptType.eIsProxy()) {
			InternalEObject oldScriptType = (InternalEObject)scriptType;
			scriptType = (ScriptType)eResolveProxy(oldScriptType);
			if (scriptType != oldScriptType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE, oldScriptType, scriptType));
			}
		}
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType basicGetScriptType() {
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptType(ScriptType newScriptType) {
		ScriptType oldScriptType = scriptType;
		scriptType = newScriptType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE, oldScriptType, scriptType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredScriptRegistry getRegistry() {
		if (eContainerFeatureID() != StoredscriptPackage.STORED_SCRIPT__REGISTRY) return null;
		return (StoredScriptRegistry)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistry(StoredScriptRegistry newRegistry, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRegistry, StoredscriptPackage.STORED_SCRIPT__REGISTRY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistry(StoredScriptRegistry newRegistry) {
		if (newRegistry != eInternalContainer() || (eContainerFeatureID() != StoredscriptPackage.STORED_SCRIPT__REGISTRY && newRegistry != null)) {
			if (EcoreUtil.isAncestor(this, newRegistry))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRegistry != null)
				msgs = ((InternalEObject)newRegistry).eInverseAdd(this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS, StoredScriptRegistry.class, msgs);
			msgs = basicSetRegistry(newRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoredscriptPackage.STORED_SCRIPT__REGISTRY, newRegistry, newRegistry));
	}




	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public ScriptMetadata getMetadata(String metadataName) {
		if(metadataName != null) {
			for(ScriptMetadata m : getMetadatas()) {
				if(metadataName.equals(m.getKey())) {
					return m;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetadatas()).basicAdd(otherEnd, msgs);
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
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
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				return ((InternalEList<?>)getMetadatas()).basicRemove(otherEnd, msgs);
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
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
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
				return eInternalContainer().eInverseRemove(this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS, StoredScriptRegistry.class, msgs);
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
			case StoredscriptPackage.STORED_SCRIPT__URI:
				return getUri();
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				return getMetadatas();
			case StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE:
				if (resolve) return getScriptType();
				return basicGetScriptType();
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
				return getRegistry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoredscriptPackage.STORED_SCRIPT__URI:
				setUri((String)newValue);
				return;
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				getMetadatas().clear();
				getMetadatas().addAll((Collection<? extends ScriptMetadata>)newValue);
				return;
			case StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE:
				setScriptType((ScriptType)newValue);
				return;
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
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
			case StoredscriptPackage.STORED_SCRIPT__URI:
				setUri(URI_EDEFAULT);
				return;
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				getMetadatas().clear();
				return;
			case StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE:
				setScriptType((ScriptType)null);
				return;
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
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
			case StoredscriptPackage.STORED_SCRIPT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case StoredscriptPackage.STORED_SCRIPT__METADATAS:
				return metadatas != null && !metadatas.isEmpty();
			case StoredscriptPackage.STORED_SCRIPT__SCRIPT_TYPE:
				return scriptType != null;
			case StoredscriptPackage.STORED_SCRIPT__REGISTRY:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StoredscriptPackage.STORED_SCRIPT___GET_METADATA__STRING:
				return getMetadata((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

	@Override
	public URI createURI() {
		return URIScriptUtils.createFileURI(getUri());
	}

	@Override
	public InputStream getInputStream() throws IOException {
		URIConverter uriConveter = this.eResource().getResourceSet().getURIConverter();
		return uriConveter.createInputStream(URI.createURI(uri));
	}

	public String getContent() throws CoreException, IOException {


		return Utilities.getFileContents(getInputStream());

	}
} //StoredScriptImpl
