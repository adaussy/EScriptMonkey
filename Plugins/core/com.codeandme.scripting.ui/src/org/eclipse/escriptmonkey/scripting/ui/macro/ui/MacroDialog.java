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
package org.eclipse.escriptmonkey.scripting.ui.macro.ui;

import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngineProvider;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

public class MacroDialog extends Dialog {

    private final IWorkbenchPartSite dialogSite;
    private Macro mSelectedMacro = null;

    /**
     * Construct Macro dialog that shows all Macros in Environment and then you can choose Macro to run
     * 
     * @param parentShell
     *            Shell from Parent
     * 
     * @param iWorkbenchPartSite
     *            Workbench Site
     */
    public MacroDialog(final Shell parentShell, final IWorkbenchPartSite iWorkbenchPartSite) {
        super(parentShell);
        dialogSite = iWorkbenchPartSite;
        setShellStyle(parentShell.getStyle() | SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        setBlockOnOpen(true);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        composite.setLayout(new GridLayout(1, false));

        Composite mComposite = new MacroComposite(new IScriptEngineProvider() {

            @Override
            public IScriptEngine getScriptEngine() {
                return null;
            }
        }, dialogSite, composite, SWT.NONE);
        mComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        return composite;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Macro Browser");
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        super.createButtonsForButtonBar(parent);

        final Button ok = getButton(IDialogConstants.OK_ID);
        ok.setText("Open");
        setButtonLayoutData(ok);

        final Button cancel = getButton(IDialogConstants.CANCEL_ID);
        cancel.setText("Cancel");
        setButtonLayoutData(cancel);
    }

    @Override
    public void okPressed() {
        final IStructuredSelection output = (IStructuredSelection) dialogSite.getSelectionProvider().getSelection();
        mSelectedMacro = (Macro) output.getFirstElement();
        close();
    }

    /**
     * @return the selected Macro
     */
    public Macro getMacro() {
        return mSelectedMacro;
    }

}
