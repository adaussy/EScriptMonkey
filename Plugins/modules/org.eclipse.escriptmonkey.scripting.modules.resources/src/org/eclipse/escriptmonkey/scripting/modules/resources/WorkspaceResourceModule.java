/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.modules.resources;

import java.io.ByteArrayInputStream;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.escriptmonkey.scripting.storedscript.utils.ScriptResourceUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * Is module is an helper to interact with the workspace
 * 
 * @author adaussy
 * 
 */
public class WorkspaceResourceModule extends AbstractScriptModule {

	private final class WizardRunnable implements Runnable {

		private IProject mProject = null;

		@Override
		public void run() {

			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(BasicNewProjectResourceWizard.WIZARD_ID);
			try {
				if(descriptor != null) {
					IWizard wizard = descriptor.createWizard();
					((BasicNewProjectResourceWizard)wizard).init(PlatformUI.getWorkbench(), null);

					WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
					dialog.setTitle(wizard.getWindowTitle());
					dialog.open();

					mProject = ((BasicNewProjectResourceWizard)wizard).getNewProject();
				}
			} catch (CoreException e) {
			}
		}

		public IProject getProject() {
			return mProject;
		}
	}

	private static final String EXTENSION_VIEWS_ID = "org.eclipse.ui.views";

	private static final Object EXTENSION_VIEW = "view";

	private static final String EXTENSION_ID = "id";

	private static final String EXTENSION_NAME = "name";

	public WorkspaceResourceModule() {
	}

	@WrapToScript
	public void displayMessage(final String title, final String message) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message);
			}
		});
	}

	@WrapToScript
	public void openView(final String identifier) {

		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				// try to open view with matching ID
				try {
					IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(identifier);

				} catch (PartInitException ex) {
					// not found, try to match pattern
					Pattern pattern = Pattern.compile(identifier);

					final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_VIEWS_ID);
					for(final IConfigurationElement e : config) {
						if(EXTENSION_VIEW.equals(e.getName())) {
							String id = e.getAttribute(EXTENSION_ID);
							String name = e.getAttribute(EXTENSION_NAME);

							try {
								if((pattern.matcher(id).matches()) || (pattern.matcher(name).matches()))
									PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
							} catch (PartInitException e1) {
							}
						}
					}
				}
			}
		});
	}

	@WrapToScript
	public IProject openProjectWizard() {
		WizardRunnable runnable = new WizardRunnable();
		Display.getDefault().syncExec(runnable);

		return runnable.getProject();
	}

	@WrapToScript
	public IFolder createFolder(final String path) {
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(path));
		try {
			if(!folder.exists())
				folder.create(false, true, null);

			return folder;

		} catch (CoreException e) {
		}

		return null;
	}

	@WrapToScript
	public void addProjectNature(IProject project, String nature) {
		if(project != null && project.exists()) {
			try {
				if(project.getNature(nature) == null) {
					ScriptResourceUtils.addNature(project, nature);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@WrapToScript
	public IFile createFile(final String path, final String content) {
		IFile file = getFile(path);

		try {
			if(file.exists())
				file.setContents(new ByteArrayInputStream(content.getBytes()), false, true, null);
			else
				file.create(new ByteArrayInputStream(content.getBytes()), false, null);

			return file;
		} catch (CoreException e) {
		}

		return null;
	}

	@WrapToScript
	public IFile getFile(final String path) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
	}

	@WrapToScript
	public void openFile(final IFile file) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				try {
					IEditorDescriptor editor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
					if(editor == null)
						editor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(EditorsUI.DEFAULT_TEXT_EDITOR_ID);

					if(editor != null)
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(file), editor.getId());
				} catch (PartInitException e) {
				}
			}
		});
	}
}
