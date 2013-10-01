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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.PlatformUI;


/**
 * This selector is used to retreive an EObject from the selection
 * 
 * @author adaussy
 * 
 */
public class GMFSemanticSeletor extends AbstractModelingSelector {

	public GMFSemanticSeletor() {
	}

	@Override
	protected EObject getEObject(Object in) {
		if(in instanceof EObject) {
			return (EObject)in;
		} else if(in instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)in).resolveSemanticElement();
		} else if(in instanceof IAdaptable) {
			return (EObject)((IAdaptable)in).getAdapter(EObject.class);
		} else {
			IAdapterManager adapterService = (IAdapterManager)PlatformUI.getWorkbench().getService(IAdapterManager.class);
			return (EObject)adapterService.getAdapter(in, EObject.class);

		}
	}

}
