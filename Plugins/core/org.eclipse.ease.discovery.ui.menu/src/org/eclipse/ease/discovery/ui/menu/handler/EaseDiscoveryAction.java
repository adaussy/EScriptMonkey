/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ease.discovery.ui.menu.handler;

import org.eclipse.ease.discovery.ui.wizards.DiscoveryComponent;
import org.eclipse.jface.action.Action;

/**
 * Action used for discovery 
 */
public class EaseDiscoveryAction extends Action {
	/**
	 * The constructor.
	 */
	public EaseDiscoveryAction() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		DiscoveryComponent.execute();
	}
}
