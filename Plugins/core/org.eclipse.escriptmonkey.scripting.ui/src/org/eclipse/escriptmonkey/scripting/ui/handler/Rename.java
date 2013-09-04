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

public class Rename extends AbstractHandler implements IHandler {

	public static final String COMMAND_ID = "org.eclipse.escriptmonkey.commands.macro.rename";
	public static final String PARAMETER_NAME = "org.eclipse.escriptmonkey.commands.macro.rename.name";

	@Override
	public final Object execute(final ExecutionEvent event) throws ExecutionException {

		final String[] macros = event.getParameter(PARAMETER_NAME).split(";");

		for (final String macroID : macros) {
			// TODO implement dialog
			// final Macro macro = MacroManager.getDefault().getMacro(macroID);
			// MacroManager.getDefault().removeMacro(macro);
		}

		return null;
	}
}
