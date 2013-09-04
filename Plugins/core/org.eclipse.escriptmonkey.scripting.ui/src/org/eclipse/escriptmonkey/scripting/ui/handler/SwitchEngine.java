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
package org.eclipse.escriptmonkey.scripting.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.escriptmonkey.scripting.ui.view.ScriptShell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class SwitchEngine extends AbstractHandler implements IHandler {

    public static final String COMMAND_ID = "org.eclipse.escriptmonkey.commands.scriptShell.switchEngine";
    public static final String PARAMETER_ID = COMMAND_ID + ".id";

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {

        IWorkbenchPart part = HandlerUtil.getActivePart(event);
        if (part instanceof ScriptShell)
            ((ScriptShell) part).setEngine(event.getParameter(PARAMETER_ID));

        return null;
    }
}
