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

import org.eclipse.debug.internal.ui.DebugPluginImages;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.escriptmonkey.scripting.IExecutionListener;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.ui.console.ScriptConsole;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

/**
 * ConsoleRemoveTerminatedAction
 */
public class RemoveCurrentConsoleAction extends Action implements IExecutionListener {

    private final ScriptConsole mConsole;

    public RemoveCurrentConsoleAction(final ScriptConsole console) {
        super(ConsoleMessages.ConsoleRemoveTerminatedAction_0);
        setToolTipText(ConsoleMessages.ConsoleRemoveTerminatedAction_1);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.CONSOLE_REMOVE_LAUNCH);
        setImageDescriptor(DebugPluginImages.getImageDescriptor(IDebugUIConstants.IMG_LCL_REMOVE));
        setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_DLCL_REMOVE));
        setHoverImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_ELCL_REMOVE));

        mConsole = console;
        IScriptEngine engine = mConsole.getScriptEngine();
        if (engine != null)
            engine.addExecutionListener(this);

        setEnabled(engine == null);
    }

    @Override
    public synchronized void run() {
        IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
        manager.removeConsoles(new IConsole[] { mConsole });
    }

    @Override
    public void notify(final IScriptEngine engine, final Script script, final int status) {
        switch (status) {
            case ENGINE_END:
                // remove engine once terminated
                engine.removeExecutionListener(this);
                setEnabled(true);
                break;
        }
    }
}
