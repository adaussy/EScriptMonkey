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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;


/**
 * Selector used to retrieve a view from the selection
 * 
 * @author adaussy
 * 
 */
public class GMFNotationSelector extends AbstractModelingSelector {

	@Override
	protected EObject getEObject(Object in) {
		Object result = null;
		if(in instanceof View) {
			result = (View)in;
		} else if(in instanceof IGraphicalEditPart) {
			result = (EObject)((IGraphicalEditPart)in).getModel();
		} else if(in instanceof IAdaptable) {
			result = (EObject)((IAdaptable)in).getAdapter(EObject.class);
		} else {
			IAdapterManager adapterService = (IAdapterManager)PlatformUI.getWorkbench().getService(IAdapterManager.class);
			result = adapterService.getAdapter(in, View.class);
		}
		if(result instanceof View) {
			return (View)result;
		}
		return null;
	}

}
