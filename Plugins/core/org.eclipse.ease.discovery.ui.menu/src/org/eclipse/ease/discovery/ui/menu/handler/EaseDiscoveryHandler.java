/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.ease.discovery.ui.menu.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ease.discovery.ui.wizards.DiscoveryComponent;

/**
 * Handler for the EASE discovery action
 */
public class EaseDiscoveryHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public EaseDiscoveryHandler() {
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		DiscoveryComponent.execute();
		return null;
	}
}
