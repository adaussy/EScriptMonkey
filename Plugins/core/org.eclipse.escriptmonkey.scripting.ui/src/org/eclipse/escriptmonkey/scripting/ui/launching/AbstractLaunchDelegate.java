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
package org.eclipse.escriptmonkey.scripting.ui.launching;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.ui.console.ScriptConsole;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Quick launcher for JavaScript files.
 */
public abstract class AbstractLaunchDelegate implements ILaunchShortcut, ILaunchShortcut2, ILaunchConfigurationDelegate {

	/**
	 * Retrieve the source file from an {@link ILaunchConfiguration}.
	 * 
	 * @param configuration
	 *        configuration to use
	 * @return source file or <code>null</code>
	 * @throws CoreException
	 */
	public static IFile getSourceFile(final ILaunchConfiguration configuration) throws CoreException {
		final String projectName = configuration.getAttribute(LaunchConstants.PROJECT, "");
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

		if(project.exists()) {
			final String fileName = configuration.getAttribute(LaunchConstants.FILE_LOCATION, "");
			final IFile file = project.getFile(fileName);

			if(file.exists())
				return file;
		}

		return null;
	}

	// **********************************************************************
	// ILaunchShortcut
	// **********************************************************************

	@Override
	public final void launch(final IEditorPart editor, final String mode) {
		launch(getLaunchableResource(editor), mode);
	}

	@Override
	public final void launch(final ISelection selection, final String mode) {
		launch(getLaunchableResource(selection), mode);
	}

	// **********************************************************************
	// ILaunchShortcut2
	// **********************************************************************

	@Override
	public final IResource getLaunchableResource(final IEditorPart editorpart) {
		final IEditorInput input = editorpart.getEditorInput();
		if(input instanceof FileEditorInput)
			return ((FileEditorInput)input).getFile();

		return null;
	}

	@Override
	public final IResource getLaunchableResource(final ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			for(final Object element : ((IStructuredSelection)selection).toArray()) {
				if(element instanceof IFile)
					return (IResource)element;
			}
		}

		return null;
	}

	@Override
	public final ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editorpart) {
		return getLaunchConfgurations(getLaunchableResource(editorpart));
	}

	@Override
	public final ILaunchConfiguration[] getLaunchConfigurations(final ISelection selection) {
		return getLaunchConfgurations(getLaunchableResource(selection));
	}

	// **********************************************************************
	// ILaunchConfigurationDelegate
	// **********************************************************************

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		final IFile file = getSourceFile(configuration);
		if(file != null) {
			// we have a valid script, lets feed it to the script engine
			launch(file, configuration, mode, launch, monitor);
		}
	}

	// **********************************************************************
	// internal stuff
	// **********************************************************************

	/**
	 * Get all launch configurations that target a dedicated resource file.
	 * 
	 * @param resource
	 *        root file to execute
	 * @return {@link ILaunchConfiguration}s using resource
	 */
	private ILaunchConfiguration[] getLaunchConfgurations(final IResource resource) {
		final List<ILaunchConfiguration> configurations = new ArrayList<ILaunchConfiguration>();

		final ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType type = manager.getLaunchConfigurationType(getLaunchConfigurationType());

		// try to find existing configurations using the same file
		try {
			for(final ILaunchConfiguration configuration : manager.getLaunchConfigurations(type)) {
				try {
					final IFile file = getSourceFile(configuration);
					if(resource.equals(file))
						configurations.add(configuration);

				} catch (final CoreException e) {
					// could not read configuration, ignore
				}
			}
		} catch (final CoreException e) {
			// could not load configurations, ignore
		}

		return configurations.toArray(new ILaunchConfiguration[configurations.size()]);
	}

	/**
	 * Launch a resource. Try to launch using a launch configuration. Used for
	 * contextual launches
	 * 
	 * @param file
	 *        source file
	 * @param mode
	 *        launch mode
	 */
	private void launch(final IResource file, final String mode) {

		if(file instanceof IFile) {
			// try to save dirty editors
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);

			try {
				ILaunchConfiguration[] configurations = getLaunchConfgurations(file);
				if(configurations.length == 0) {
					// no configuration found, create new one
					final ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
					final ILaunchConfigurationType type = manager.getLaunchConfigurationType(getLaunchConfigurationType());

					final ILaunchConfigurationWorkingCopy configuration = type.newInstance(null, file.getName());
					configuration.setAttribute(LaunchConstants.PROJECT, file.getProject().getName());
					configuration.setAttribute(LaunchConstants.FILE_LOCATION, file.getProjectRelativePath().toPortableString());

					// save and return new configuration
					configuration.doSave();

					configurations = new ILaunchConfiguration[]{ configuration };
				}

				// launch
				configurations[0].launch(mode, new NullProgressMonitor());

			} catch (final CoreException e) {
				// could not create launch configuration, run file directly
				launch((IFile)file, null, mode, null, new NullProgressMonitor());
			}
		}
	}

	/**
	 * Execute script code from an {@link IFile}.
	 * 
	 * @param file
	 *        file to execute
	 * @param configuration
	 *        launch configuration
	 * @param mode
	 *        launch mode
	 * @param launch
	 * @param monitor
	 */
	private void launch(final IFile file, final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) {

		final IScriptEngine engine = getScriptEngine(configuration, mode);

		final ScriptConsole console = ScriptConsole.create(engine.getName() + ": " + file.getFullPath(), engine);
		engine.setOutputStream(console.getOutputStream());
		engine.setErrorStream(console.getErrorStream());

		engine.setTerminateOnIdle(true);

		if(ILaunchManager.DEBUG_MODE.equals(mode))
			setupDebugger(engine, configuration, launch);

		engine.executeAsync(file);

		engine.schedule();
	}

	protected abstract void setupDebugger(IScriptEngine engine, ILaunchConfiguration configuration, ILaunch launch);

	protected abstract IScriptEngine getScriptEngine(ILaunchConfiguration configuration, String mode);

	protected abstract String getLaunchConfigurationType();
}
