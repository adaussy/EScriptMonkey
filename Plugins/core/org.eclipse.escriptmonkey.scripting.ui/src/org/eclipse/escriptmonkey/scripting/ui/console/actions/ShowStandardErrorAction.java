/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Christian Pontesegger - adaption to EScript project
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.ui.console.actions;

import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.preferences.PreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsole;

/**
 * Toggles preference show the console when output is written to standard error stream.
 * 
 * @since 3.3
 */
public class ShowStandardErrorAction extends ShowWhenContentChangesAction {

    /**
     * Constructs an action to toggle console auto activation preferences
     * 
     * @param console
     */
    public ShowStandardErrorAction(final IConsole console) {
        super(ConsoleMessages.ShowStandardErrorAction_0, console);
        setId(Activator.PLUGIN_ID + ".ShowWhenStderrChangesAction"); //$NON-NLS-1$
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.SHOW_WHEN_STDERR_CHANGES_ACTION);
        setImageDescriptor(DebugUITools.getImageDescriptor(IInternalDebugUIConstants.IMG_ELCL_STANDARD_ERR));
    }

    @Override
    protected String getKey() {
        return PreferenceConstants.CONSOLE_OPEN_ON_ERR;
    }
}
