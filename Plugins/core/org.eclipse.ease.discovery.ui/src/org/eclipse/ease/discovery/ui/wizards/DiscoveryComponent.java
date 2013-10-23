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
package org.eclipse.ease.discovery.ui.wizards;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.ease.discovery.DiscoveryDefinition;
import org.eclipse.ease.discovery.ui.viewer.DiscoveryContentProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * Execution class for the execution of the discovery component
 */
public class DiscoveryComponent {

	/** URI of the model where all extra component features to be installed are referenced */
	public static final String DISCOVERY_EASE_URI = "platform:/plugin/org.eclipse.ease.discovery.ui/Category.xmi";

	public static final Object execute() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		DiscoveryContentProvider provider = new DiscoveryContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected DiscoveryDefinition load() {
				Resource res = new XMIResourceImpl(URI.createURI(DISCOVERY_EASE_URI));
				try {
					res.load(Collections.EMPTY_MAP);
				} catch (IOException e) {
					MessageDialog.openError(window.getShell(), Messages.DiscoveryComponent_CannotConnectToSource_title, Messages.DiscoveryComponent_CannotConnectToSource_label);
					throw new RuntimeException(e);
				}
				return (DiscoveryDefinition)res.getContents().get(0);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getDescription() {
				return Messages.DiscoveryComponent_description;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getTitle() {
				return Messages.DiscoveryComponent_title;
			}

		};


		DiscoveryWizard wizard = new DiscoveryWizard(provider);
		WizardDialog dialog = new WizardDialog(window.getShell(), wizard);
		return dialog.open();
	}

}
