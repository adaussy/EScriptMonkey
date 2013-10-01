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
package org.eclipse.escriptmonkey.scripting.integration.modeling.selector;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.escriptmonkey.scripting.module.platform.modules.ISelector;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * This selector is used to return object from a modeling editor (GMF or Generated from GenModel)
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractModelingSelector implements ISelector {

	public AbstractModelingSelector() {
		super();
	}

	@Override
	public Object getCustomSelection(Object selection) {
		if(selection instanceof ISelection) {
			if(selection instanceof IStructuredSelection) {
				List<EObject> result = new ArrayList<EObject>();
				Iterator<?> ite = ((IStructuredSelection)selection).iterator();
				while(ite.hasNext()) {
					Object next = ite.next();
					EObject eObject = getEObject(next);
					if(eObject != null) {
						result.add(eObject);
					}
				}
				return result;
			}
		}
		return null;
	}

	protected abstract EObject getEObject(Object in);

}
