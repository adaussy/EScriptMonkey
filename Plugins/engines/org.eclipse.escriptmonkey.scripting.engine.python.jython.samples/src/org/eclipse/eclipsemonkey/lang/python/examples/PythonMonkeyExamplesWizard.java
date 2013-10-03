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
package org.eclipse.eclipsemonkey.lang.python.examples;

import org.osgi.framework.Bundle;

public class PythonMonkeyExamplesWizard extends org.eclipse.escriptmonkey.scripting.ui.wizard.AbstractEScriptMonkeyNewSampleWizard {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getManifestPath() {
		return "samples/manifest.txt";
	}

	@Override
	protected String getScriptContainerFolder() {
		return "samples/";
	}

	@Override
	protected String getInitalProjectName() {
		return "EScript Monkey Python scripts Example";
	}

}
