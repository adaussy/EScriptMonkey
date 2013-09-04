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

import org.eclipse.escriptmonkey.scripting.ui.handler.Delete;
import org.eclipse.escriptmonkey.scripting.ui.handler.Edit;
import org.eclipse.escriptmonkey.scripting.ui.handler.Rename;
import org.eclipse.escriptmonkey.scripting.ui.handler.Run;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Provide context menu entries for macros.
 */
public class ContextMenuEntries extends AbstractContributionFactory {

    /**
     * Constructor.
     * 
     * @param location
     *            location to add factory to.
     */
    public ContextMenuEntries(final String location) {
        super(location, null);
    }

    @Override
    public final void createContributionItems(final IServiceLocator serviceLocator, final IContributionRoot additions) {
        final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
        if (selection instanceof IStructuredSelection) {
            if (!((IStructuredSelection) selection).isEmpty()) {

                final StringBuffer names = new StringBuffer();
                for (final Object object : ((IStructuredSelection) selection).toArray()) {
                    if (object instanceof Macro)
                        names.append(((Macro) object).getName()).append(';');
                }

                if (names.length() > 0) {
                    names.deleteCharAt(names.length() - 1);
                    final HashMap<String, String> parameters = new HashMap<String, String>();

                    // add "run" entry
                    parameters.put(Run.PARAMETER_NAME, names.toString());
                    final CommandContributionItemParameter contributionParameter = new CommandContributionItemParameter(serviceLocator, null, Run.COMMAND_ID,
                            CommandContributionItem.STYLE_PUSH);
                    contributionParameter.label = "Run";
                    contributionParameter.visibleEnabled = true;
                    contributionParameter.parameters = parameters;
                    CommandContributionItem contribution = new CommandContributionItem(contributionParameter);
                    additions.addContributionItem(contribution, null);

                    // add separator
                    additions.addContributionItem(new Separator(), null);

                    // add "edit" entry
                    parameters.clear();
                    parameters.put(Edit.PARAMETER_NAME, names.toString());
                    contributionParameter.commandId = Edit.COMMAND_ID;
                    contributionParameter.label = "Edit";
                    contribution = new CommandContributionItem(contributionParameter);
                    additions.addContributionItem(contribution, null);

                    // add "rename" entry
                    parameters.clear();
                    parameters.put(Rename.PARAMETER_NAME, names.toString());
                    contributionParameter.commandId = Rename.COMMAND_ID;
                    contributionParameter.label = "Rename";
                    contribution = new CommandContributionItem(contributionParameter);
                    additions.addContributionItem(contribution, null);

                    // add "delete" entry
                    parameters.clear();
                    parameters.put(Delete.PARAMETER_NAME, names.toString());
                    contributionParameter.commandId = Delete.COMMAND_ID;
                    contributionParameter.label = "Delete";
                    contribution = new CommandContributionItem(contributionParameter);
                    additions.addContributionItem(contribution, null);
                }
            }
        }
    }
}
