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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.labeling;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
public class CoreExpressionDescriptionLabelProvider extends org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider {

	// Labels and icons can be computed like this:

	//	String text(IEObjectDescription ele) {
	//	   return ele.getName();
	//	}
	//	 
	//  String image(IEObjectDescription ele) {
	//     return ele.getEClass().getName() + ".gif";
	//  }	 
}
