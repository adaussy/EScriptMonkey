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
package org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ParentNode;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphFactory;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphPackage;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parent Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.impl.ParentNodeImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParentNodeImpl extends NodeImpl implements ParentNode {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2013 Atos\r\n  All rights reserved. This program and the accompanying materials\r\n  are made available under the terms of the Eclipse Public License v1.0\r\n  which accompanies this distribution, and is available at\r\n  http://www.eclipse.org/legal/epl-v10.html\r\n \r\n  Contributors:\r\n      Arthur Daussy - initial implementation";

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SubNode> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParentNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptuigraphPackage.Literals.PARENT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<SubNode>(SubNode.class, this, ScriptuigraphPackage.PARENT_NODE__CHILDREN, ScriptuigraphPackage.SUB_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public StoredScriptUI addScript(EList<String> path) {

		if(path != null && !path.isEmpty()) {
			ParentNode currentParent = this;
			ListIterator<String> ite = path.listIterator();
			while(ite.hasNext()) {
				String segment = (String)ite.next();
				SubNode subNode = currentParent.getChildren(new BasicEList<String>(Collections.singleton(segment)));
				if(subNode instanceof ParentNode) {
					currentParent = (ParentNode)subNode;
				} else {
					if(ite.hasNext()) {
						ScriptSetUI newNode = ScriptuigraphFactory.eINSTANCE.createScriptSetUI();
						newNode.setName(segment);
						currentParent.getChildren().add(newNode);
						currentParent = newNode;
					} else {
						StoredScriptUI newNode = ScriptuigraphFactory.eINSTANCE.createStoredScriptUI();
						newNode.setName(segment);
						currentParent.getChildren().add(newNode);
						return newNode;
					}
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
	public SubNode getChildren(EList<String> path) {
		if(path != null && !path.isEmpty()) {
			String nextPath = path.get(0);
			for(SubNode node : getChildren()) {
				if(nextPath.equals(node.getName())) {
					if(path.size() == 1) {
						return node;
					} else {
						if(node instanceof ParentNode) {
							return ((ParentNode)node).getChildren(new BasicEList<String>(path.subList(1, path.size())));
						}
					}
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
	public void removeScript(StoredScriptUI store) {
		removeScriptInternal(store);
	}

	public void removeScriptInternal(SubNode store) {
		ParentNode parent = store.getParent();
		parent.getChildren().remove(store);
		if(parent.getChildren().isEmpty() && parent instanceof SubNode) {
			removeScriptInternal((SubNode)parent);
		}
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				return getChildren();
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SubNode>)newValue);
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				getChildren().clear();
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
			case ScriptuigraphPackage.PARENT_NODE__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScriptuigraphPackage.PARENT_NODE___ADD_SCRIPT__ELIST:
				return addScript((EList<String>)arguments.get(0));
			case ScriptuigraphPackage.PARENT_NODE___GET_CHILDREN__ELIST:
				return getChildren((EList<String>)arguments.get(0));
			case ScriptuigraphPackage.PARENT_NODE___REMOVE_SCRIPT__STOREDSCRIPTUI:
				removeScript((StoredScriptUI)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ParentNodeImpl
