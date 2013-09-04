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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.jface.menus.IMenuStateIds;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;

/**
 * Use this handler for style="toggle" command contributions. You need to
 * declare a state for your command to use ToggleHandler:
 * 
 * <pre>
 * &lt;command id=&quot;somecommand&quot; name=&quot;SomeCommand&quot;&gt;
 *    &lt;state class=&quot;org.eclipse.jface.commands.ToggleState&quot; id=&quot;STYLE&quot;/&gt;
 * &lt;/command&gt;
 * </pre>
 * 
 * The id="STYLE" was chosen because of IMenuStateIds.STYLE - maybe this will
 * work without any Handler foo in later Eclipse versions.
 * 
 * See http://www.ralfebert.de/eclipse/2009_01_21_togglehandler/
 * http://eclipsesource.com/blogs/2009/01/15/toggling-a-command-contribution/
 * 
 * @author Ralf Ebert
 */
public abstract class ToggleHandler extends AbstractHandler implements IElementUpdater {

    private String commandId;

    @Override
    public final Object execute(final ExecutionEvent event) throws ExecutionException {
        final ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        commandId = event.getCommand().getId();

        // update toggled state
        final State state = event.getCommand().getState(IMenuStateIds.STYLE);
        if (state == null)
            throw new ExecutionException("You need to declare a ToggleState with id=STYLE for your command to use ToggleHandler!");
        final boolean currentState = (Boolean) state.getValue();
        final boolean newState = !currentState;
        state.setValue(newState);

        // trigger element update
        executeToggle(event, newState);
        commandService.refreshElements(event.getCommand().getId(), null);

        // return value is reserved for future apis
        return null;
    }

    protected abstract void executeToggle(ExecutionEvent event, boolean checked);

    /**
     * Update command element with toggle state
     */
    @Override
    public void updateElement(final UIElement element, final Map parameters) {
        if (commandId != null) {
            final ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
            final Command command = commandService.getCommand(commandId);
            final State state = command.getState(IMenuStateIds.STYLE);
            if (state != null)
                element.setChecked((Boolean) state.getValue());
        }
    }

}