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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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

    protected final static String MODE_RUN = "run";
    protected final static String MODE_DEBUG = "debug";

    @Override
    public final void launch(final ISelection selection, final String mode) {
        launch(getLaunchableResource(selection), mode);
    }

    @Override
    public final void launch(final IEditorPart editor, final String mode) {
        launch(getLaunchableResource(editor), mode);
    }

    @Override
    public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
        String projectName = configuration.getAttribute(LaunchConstants.PROJECT, "");
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

        if (project.exists()) {
            String scriptName = configuration.getAttribute(LaunchConstants.SCRIPT_LOCATION, "");
            IFile script = project.getFile(scriptName);

            if (script.exists())
                // we have a valid script, lets feed it to the script engine
                launch(script, configuration, mode);
        }
    }

    private void launch(final IResource scriptFile, final String mode) {
        if (scriptFile instanceof IFile) {
            // try to save dirty editors
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);

            try {
                ILaunchConfiguration configuration = createLaunchConfiguration((IFile) scriptFile, mode);
                // TODO add nice progress monitor
                configuration.launch(mode, null);

            } catch (CoreException e) {
                // could not create launch configuration, run script directly
                launch((IFile) scriptFile, null, mode);
            }
        }
    }

    /**
     * Execute script code from an {@link IFile}.
     * 
     * @param file
     *            file to execute
     */
    private void launch(final IFile file, final ILaunchConfiguration configuration, final String mode) {
        IScriptEngine engine = getScriptEngine(configuration, mode);

        ScriptConsole console = ScriptConsole.create(engine.getName() + ": " + file.getFullPath(), engine);
        engine.setOutputStream(console.getOutputStream());
        engine.setErrorStream(console.getErrorStream());

        engine.setTerminateOnIdle(true);
        engine.executeAsync(file);

        engine.schedule();
    }

    private ILaunchConfiguration createLaunchConfiguration(final IFile scriptFile, final String mode) throws CoreException {
        ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = manager.getLaunchConfigurationType(getLaunchConfigurationType());

        // try to find an existing configuration
        try {
            for (ILaunchConfiguration configuration : manager.getLaunchConfigurations(type)) {
                try {
                    String projectName = configuration.getAttribute(LaunchConstants.PROJECT, "");
                    String scriptLocation = configuration.getAttribute(LaunchConstants.SCRIPT_LOCATION, "");

                    IFile script = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getFile(scriptLocation);
                    if (scriptFile.equals(script))
                        return configuration;

                } catch (CoreException e) {
                    // could not read configuration, ignore
                }
            }
        } catch (CoreException e) {
            // could not load configurations, ignore
        }

        // configuration not found, create a new one
        ILaunchConfigurationWorkingCopy configuration = type.newInstance(null, scriptFile.getName());
        configuration.setAttribute(LaunchConstants.PROJECT, scriptFile.getProject().getName());
        configuration.setAttribute(LaunchConstants.SCRIPT_LOCATION, scriptFile.getProjectRelativePath().toPortableString());

        // save and return new configuration
        return configuration.doSave();
    }

    @Override
    public final ILaunchConfiguration[] getLaunchConfigurations(final ISelection selection) {
        return null;
    }

    @Override
    public final ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editorpart) {
        return null;
    }

    @Override
    public final IResource getLaunchableResource(final ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            for (final Object element : ((IStructuredSelection) selection).toArray()) {
                if (element instanceof IFile)
                    return (IResource) element;
            }
        }

        return null;
    }

    @Override
    public final IResource getLaunchableResource(final IEditorPart editorpart) {
        final IEditorInput input = editorpart.getEditorInput();
        if (input instanceof FileEditorInput)
            return ((FileEditorInput) input).getFile();

        return null;
    }

    protected abstract IScriptEngine getScriptEngine(ILaunchConfiguration configuration, String mode);

    protected abstract String getLaunchConfigurationType();
}
