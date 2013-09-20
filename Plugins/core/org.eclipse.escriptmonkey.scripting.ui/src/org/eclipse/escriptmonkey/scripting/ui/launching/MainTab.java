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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class MainTab extends AbstractLaunchConfigurationTab implements ILaunchConfigurationTab {

	private Text txtFile;

	private boolean mDisableUpdate = false;

	private Text txtProject;

	private final String[] mExtensions;

	private Button chkSuspendOnScript;

	private Button chkShowDynamicScript;

	public MainTab(final String[] extensions) {
		mExtensions = extensions;
	}

	@Override
	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LaunchConstants.PROJECT, "");
		configuration.setAttribute(LaunchConstants.FILE_LOCATION, "");
		configuration.setAttribute(LaunchConstants.SUSPEND_ON_STARTUP, false);
		configuration.setAttribute(LaunchConstants.DISPLAY_DYNAMIC_CODE, false);
	}

	@Override
	public void initializeFrom(final ILaunchConfiguration configuration) {
		mDisableUpdate = true;

		txtProject.setText("");
		txtFile.setText("");
		chkShowDynamicScript.setSelection(false);
		chkSuspendOnScript.setSelection(false);

		try {
			txtProject.setText(configuration.getAttribute(LaunchConstants.PROJECT, ""));
			txtFile.setText(configuration.getAttribute(LaunchConstants.FILE_LOCATION, ""));
			chkShowDynamicScript.setSelection(configuration.getAttribute(LaunchConstants.DISPLAY_DYNAMIC_CODE, false));
			chkSuspendOnScript.setSelection(configuration.getAttribute(LaunchConstants.SUSPEND_ON_STARTUP, false));

		} catch (CoreException e) {
		}

		mDisableUpdate = false;
	}

	@Override
	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LaunchConstants.PROJECT, txtProject.getText());
		configuration.setAttribute(LaunchConstants.FILE_LOCATION, txtFile.getText());
		configuration.setAttribute(LaunchConstants.SUSPEND_ON_STARTUP, chkSuspendOnScript.getSelection());
		configuration.setAttribute(LaunchConstants.DISPLAY_DYNAMIC_CODE, chkShowDynamicScript.getSelection());
	}

	@Override
	public boolean isValid(final ILaunchConfiguration launchConfig) {
		// allow launch when a file is selected and file exists
		try {
			String projectName = launchConfig.getAttribute(LaunchConstants.PROJECT, "");
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if(project.exists()) {
				String scriptName = launchConfig.getAttribute(LaunchConstants.FILE_LOCATION, "");
				IFile script = project.getFile(scriptName);
				return script.exists();
			}

		} catch (Exception e) {
			// on any configuration error
			setErrorMessage("Invalid source file selected.");
		}

		return false;
	}

	@Override
	public boolean canSave() {
		// allow save when a file location is entered - no matter if the file
		// exists or not
		return (!txtProject.getText().isEmpty()) && (!txtFile.getText().isEmpty());
	}

	@Override
	public String getMessage() {
		return "Please select a script file.";
	}

	@Override
	public String getName() {
		return "Global";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(final Composite parent) {
		Composite topControl = new Composite(parent, SWT.NONE);
		topControl.setLayout(new GridLayout(1, false));

		Group group_1 = new Group(topControl, SWT.NONE);
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		group_1.setText("Project");
		group_1.setLayout(new GridLayout(2, false));

		txtProject = new Text(group_1, SWT.BORDER);
		txtProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnBrowseProject = new Button(group_1, SWT.NONE);
		btnBrowseProject.setText("Browse...");

		Group grpLaunch = new Group(topControl, SWT.NONE);
		grpLaunch.setLayout(new GridLayout(2, false));
		grpLaunch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpLaunch.setText("Main Script");

		txtFile = new Text(grpLaunch, SWT.BORDER);
		txtFile.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(final ModifyEvent e) {
				if(!mDisableUpdate)
					updateLaunchConfigurationDialog();
			}
		});
		txtFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnBrowseScript = new Button(grpLaunch, SWT.NONE);
		btnBrowseScript.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(parent.getShell(), new WorkbenchLabelProvider(), new EScriptFileContentProvider(mExtensions));
				dialog.setTitle("Select script source file");
				dialog.setMessage("Select the script file to execute:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				if(dialog.open() == Window.OK)
					txtFile.setText(((IFile)dialog.getFirstResult()).getFullPath().toPortableString());
			}
		});
		btnBrowseScript.setText("Browse...");

		// options only available in debug mode
		Group group = new Group(topControl, SWT.NONE);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group.setText("Debug Options");

		chkSuspendOnScript = new Button(group, SWT.CHECK);
		chkSuspendOnScript.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				if(!mDisableUpdate)
					updateLaunchConfigurationDialog();
			}
		});
		chkSuspendOnScript.setText("Suspend on script load");

		chkShowDynamicScript = new Button(group, SWT.CHECK);
		chkShowDynamicScript.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				if(!mDisableUpdate)
					updateLaunchConfigurationDialog();
			}
		});
		chkShowDynamicScript.setText("Show dynamic script content");

		setControl(topControl);
	}
}
