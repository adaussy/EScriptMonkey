/**
 * Copyright (c) 2013 Atos
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 * 
 * Contributors:
 *     Arthur Daussy - initial implementation
 */
package org.eclipse.ease.lang.python.jython.ui.preferences;

import org.eclipse.ease.lang.python.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PathEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PythonLibraryPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private Composite parent;

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(org.eclipse.ease.lang.python.Activator.getDefault().getPreferenceStore());
		setDescription("List of external library used for Jython Engine [Implementation no optimized for now]");

	}

	@Override
	protected Control createContents(Composite parent) {
		this.parent = parent;
		return super.createContents(parent);
	}

	@Override
	public void dispose() {
		super.dispose();
		parent = null;
	}

	@Override
	protected void createFieldEditors() {
		addField(new PathEditor(IPreferenceConstants.PYTHON_LIBRARIES, "External library location", "Select a folder for an external library", parent));
	}
}
