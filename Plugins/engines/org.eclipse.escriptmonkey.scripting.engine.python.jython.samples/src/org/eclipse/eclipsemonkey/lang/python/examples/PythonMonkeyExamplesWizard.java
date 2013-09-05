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
