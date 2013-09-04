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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

public class LibrariesTab extends AbstractLaunchConfigurationTab implements ILaunchConfigurationTab {

    private static String serializeLibraries(final List<File> libraries) {
        final StringBuffer result = new StringBuffer();
        for (final File file : libraries) {
            result.append(File.pathSeparator);
            result.append(file.getAbsolutePath());
        }

        if (result.length() > 0)
            result.delete(0, File.pathSeparator.length());

        return result.toString();
    }

    private static Collection<File> unserializeLibraries(final String libraries) {
        final String[] elements = libraries.split(File.pathSeparator);
        final List<File> result = new ArrayList<File>(elements.length);
        for (final String element : elements)
            if (!element.trim().isEmpty())
                result.add(new File(element.trim()));

        return result;
    }

    private final List<File> mLibraries = new ArrayList<File>();
    private ListViewer listViewer;

    @Override
    public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(LaunchConstants.LIBRARIES, "");
    }

    @Override
    public void initializeFrom(final ILaunchConfiguration configuration) {
        mLibraries.clear();

        try {
            final String libraries = configuration.getAttribute(LaunchConstants.LIBRARIES, "");
            mLibraries.addAll(unserializeLibraries(libraries));
        } catch (final CoreException e) {
        }

        listViewer.refresh();
    }

    @Override
    public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(LaunchConstants.LIBRARIES, serializeLibraries(mLibraries));
    }

    @Override
    public String getMessage() {
        return "Please select JAR files to load within the interpreter.";
    }

    @Override
    public String getName() {
        return "Libraries";
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void createControl(final Composite parent) {
        final Composite topControl = new Composite(parent, SWT.NONE);
        topControl.setLayout(new GridLayout(2, false));

        final Label lblStartupCode = new Label(topControl, SWT.NONE);
        lblStartupCode.setText("Additional libraries:");

        setControl(topControl);
        new Label(topControl, SWT.NONE);

        listViewer = new ListViewer(topControl, SWT.BORDER | SWT.V_SCROLL);
        final org.eclipse.swt.widgets.List list = listViewer.getList();
        list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        listViewer.setLabelProvider(new LabelProvider());
        listViewer.setContentProvider(ArrayContentProvider.getInstance());
        listViewer.setInput(mLibraries);

        final Composite composite = new Composite(topControl, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
        final FillLayout fl_composite = new FillLayout(SWT.VERTICAL);
        fl_composite.spacing = 10;
        composite.setLayout(fl_composite);

        final Button btnNewButton = new Button(composite, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                final FileDialog dialog = new FileDialog(parent.getShell(), SWT.OPEN | SWT.MULTI);
                dialog.setFilterExtensions(new String[] { "*.jar" });
                dialog.setFilterNames(new String[] { "Java Archives" });
                final String filePath = dialog.open();
                if (filePath != null) {
                    for (final String filename : dialog.getFileNames())
                        mLibraries.add(new File(filename));

                    listViewer.refresh();
                    updateLaunchConfigurationDialog();
                }
            }
        });
        btnNewButton.setText("Add JARs...");

        final Button btnNewButton_1 = new Button(composite, SWT.NONE);
        btnNewButton_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                final IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
                final Object element = selection.getFirstElement();
                if (element instanceof File) {
                    mLibraries.remove(element);
                    listViewer.refresh();
                    updateLaunchConfigurationDialog();
                }
            }
        });
        btnNewButton_1.setText("Remove");
    }
}
