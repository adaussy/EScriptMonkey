/**
 * Copyright (c) 2013 Atos
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 * 
 *  * Contributors:
 *     Arthur Daussy - initial implementation
 */
package org.eclipse.escriptmonkey.scripting.ui.wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.utils.ScriptResourceUtils;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.framework.Bundle;

/**
 * Base class used to define a wizard for sample creation
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractEScriptMonkeyNewSampleWizard extends BasicNewProjectResourceWizard {

	public AbstractEScriptMonkeyNewSampleWizard() {
		super();
	}

	protected void openError(String message) {
		ErrorDialog.openError(getShell(), "Eclipse Monkey example error", "Unable to create the Examples project\n" + message, new Status(Status.ERROR, Activator.PLUGIN_ID, message));
	}

	@Override
	public void addPage(IWizardPage page) {
		super.addPage(page);
		IWizardPage mainPage = getPage("basicNewProjectPage");
		if(mainPage instanceof WizardNewProjectCreationPage) {
			((WizardNewProjectCreationPage)mainPage).setInitialProjectName(getInitalProjectName().replace(" ", "_"));
		}
	}

	protected abstract String getInitalProjectName();

	/**
	 * Path to manifest file to find scripts (Relative path to the bundle)
	 * 
	 * @return
	 */
	protected abstract String getManifestPath();

	protected abstract Bundle getBundle();

	public boolean performFinish() {
		super.performFinish();
		IProject project = getNewProject();
		try {
			ScriptResourceUtils.addEScriptMoneyNature(project);
			Bundle bundle = getBundle();
			URL url = FileLocator.find(bundle, new Path(getManifestPath()), null);
			Object content = url.getContent();
			InputStream ins = (InputStream)content;
			int count = ins.available();
			BufferedReader in = new BufferedReader(new InputStreamReader(ins));
			char[] cbuf = new char[count];
			in.read(cbuf);
			in.close();
			String[] lines = new String(cbuf).split("\n");
			List<String> manifest = new ArrayList<String>();
			for(int i = 0; i < lines.length; i++) {
				String string = lines[i];
				string = string.trim();
				if(string.length() > 0)
					manifest.add(string);
			}

			if(!project.exists()) {
				project.create(null);
			}
			if(!project.isOpen()) {
				project.open(null);
			}

			String errors = "";
			for(Iterator<String> iter = manifest.iterator(); iter.hasNext();) {
				try {
					String name = (String)iter.next();
					String[] words = name.split("/");
					String pathName = "";
					IFolder folder = null;
					for(int i = 0; i < words.length - 1; i++) {
						String string = words[i];
						pathName = pathName + string + "/";
						folder = project.getFolder(pathName);
						if(!folder.exists())
							folder.create(IResource.NONE, true, null);
					}
					IPath path = new Path(getScriptContainerFolder() + name);

					InputStream stream = FileLocator.openStream(getBundle(), path, true);
					IFile file = folder.getFile(words[words.length - 1]);
					file.create(stream, false, null);
					stream.close();
				} catch (CoreException x) {
					errors += x.toString() + "\n";
				} catch (IOException x) {
					errors += x.toString() + "\n";
				}
			}
			if(errors.length() > 0) {
				openError(errors);
			}
		} catch (CoreException x) {
			openError(x.getMessage());
		} catch (IOException x) {
			openError(x.getMessage());
		}
		return true;
	}

	protected abstract String getScriptContainerFolder();

}
