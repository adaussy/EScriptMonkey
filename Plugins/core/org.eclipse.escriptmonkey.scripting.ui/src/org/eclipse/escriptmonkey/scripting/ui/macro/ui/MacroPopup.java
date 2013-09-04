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

import java.util.HashMap;

import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.handler.Run;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

public class MacroPopup extends AbstractPopupItem {

	private final Macro mMacro;

	public MacroPopup(final Macro macro) {
		mMacro = macro;
	}

	@Override
	public CommandContributionItemParameter getContributionParameter() {
		final CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(null, null, Run.COMMAND_ID,
				CommandContributionItem.STYLE_PUSH);

		final HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put(Run.PARAMETER_NAME, mMacro.getName());

		contributionParameter.parameters = parameters;

		contributionParameter.icon = Activator.getImageDescriptor("/images/macro.gif");

		return contributionParameter;
	}

	@Override
	public String getDisplayName() {
		return mMacro.getBaseName();
	}
}
