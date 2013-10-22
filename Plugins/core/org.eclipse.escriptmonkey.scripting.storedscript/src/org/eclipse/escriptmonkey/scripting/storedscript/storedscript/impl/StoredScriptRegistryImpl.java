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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.service.MetadaParserService;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptFactory;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stored Script Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl#getScripts <em>Scripts</em>}</li>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.storedscript.storedscript.impl.StoredScriptRegistryImpl#getScriptTypes <em>Script Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoredScriptRegistryImpl extends MinimalEObjectImpl.Container implements StoredScriptRegistry {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n     Arthur Daussy - initial implementation";

	/**
	 * The cached value of the '{@link #getScripts() <em>Scripts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScripts()
	 * @generated
	 * @ordered
	 */
	protected EList<IStoredScript> scripts;

	/**
	 * The cached value of the '{@link #getScriptTypes() <em>Script Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ScriptType> scriptTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoredScriptRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoredscriptPackage.Literals.STORED_SCRIPT_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IStoredScript> getScripts() {
		if (scripts == null) {
			scripts = new EObjectContainmentWithInverseEList<IStoredScript>(IStoredScript.class, this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS, StoredscriptPackage.ISTORED_SCRIPT__REGISTRY);
		}
		return scripts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScriptType> getScriptTypes() {
		if (scriptTypes == null) {
			scriptTypes = new EObjectContainmentWithInverseEList<ScriptType>(ScriptType.class, this, StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES, StoredscriptPackage.SCRIPT_TYPE__REGISTRY);
		}
		return scriptTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public IStoredScript processNewOrChangedScript(String uri) {
		if(uri != null) {
			IStoredScript storedScript = getStoredScript(uri);
			if(storedScript == null) {
				storedScript = createNewStoredScript(uri);
			}
			//Parse metadata
			try {
				MetadaParserService.getInstance().parseMetadata(storedScript);
			} catch (CoreException e) {
				e.printStackTrace();
				Logger.logError("Unable to pase metadata for script " + storedScript.getUri());
				this.getScripts().remove(storedScript);
				return null;
			}
			return storedScript;
		}
		return null;
	}

	protected IStoredScript createNewStoredScript(String uri) {
		IStoredScript storedScript;
		storedScript = StoredscriptFactory.eINSTANCE.createStoredScript();
		storedScript.setUri(uri);
		this.getScripts().add(storedScript);

		ScriptType type = getMatchingScriptType(storedScript);
		if(type == null) {
			Logger.logError("Unable to find a matching script type for the stored script " + uri);
		} else {
			storedScript.setScriptType(type);
		}
		return storedScript;
	}

	public org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType getMatchingScriptType(IStoredScript script) {
		String fileExtension = script.createURI().fileExtension();
		for(org.eclipse.escriptmonkey.scripting.ScriptType type : ScriptService.getInstance().getKownSwriptType().values()) {
			if(type.getExtension().equals(fileExtension)) {
				return getScriptType(type.getScritpType());
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public void removeStoreScript(String uri) {
		IStoredScript script = getStoredScript(uri);
		if(script != null) {
			getScripts().remove(script);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public IStoredScript getStoredScript(String uri) {
		if(uri != null) {
			for(IStoredScript script : getScripts()) {
				if(uri.equals(script.getUri())) {
					return script;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public ScriptType getScriptType(String type) {
		if(type != null) {
			for(ScriptType t : getScriptTypes()) {
				if(type.equals(t.getType())) {
					return t;
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScripts()).basicAdd(otherEnd, msgs);
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScriptTypes()).basicAdd(otherEnd, msgs);
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				return ((InternalEList<?>)getScripts()).basicRemove(otherEnd, msgs);
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				return ((InternalEList<?>)getScriptTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				return getScripts();
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				return getScriptTypes();
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				getScripts().clear();
				getScripts().addAll((Collection<? extends IStoredScript>)newValue);
				return;
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				getScriptTypes().clear();
				getScriptTypes().addAll((Collection<? extends ScriptType>)newValue);
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				getScripts().clear();
				return;
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				getScriptTypes().clear();
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPTS:
				return scripts != null && !scripts.isEmpty();
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY__SCRIPT_TYPES:
				return scriptTypes != null && !scriptTypes.isEmpty();
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
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY___PROCESS_NEW_OR_CHANGED_SCRIPT__STRING:
				return processNewOrChangedScript((String)arguments.get(0));
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY___REMOVE_STORE_SCRIPT__STRING:
				removeStoreScript((String)arguments.get(0));
				return null;
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY___GET_STORED_SCRIPT__STRING:
				return getStoredScript((String)arguments.get(0));
			case StoredscriptPackage.STORED_SCRIPT_REGISTRY___GET_SCRIPT_TYPE__STRING:
				return getScriptType((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //StoredScriptRegistryImpl
