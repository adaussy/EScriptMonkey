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
package org.eclipse.escriptmonkey.scripting.ui;

import java.util.Collection;

import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.ui.macro.IMacroListener;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;

public interface IMacroService {

    boolean removeMacro(String macroID);

    Macro getMacro(String macroID);

    /**
     * Adds a listener for macro events. If the listener was already added, this method does nothing.
     * 
     * @param listener
     *            listener to be added
     */
    void addMacroListener(final IMacroListener listener);

    /**
     * Removes a listener for macro events.
     * 
     * @param listener
     *            listener to be removed
     */
    void removeMacroListener(final IMacroListener listener);

    Collection<Macro> getMacros();

    void addMacro(String name, IScriptEngine engine, String content);
}
