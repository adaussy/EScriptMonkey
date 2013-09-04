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
package org.eclipse.escriptmonkey.scripting.ui.preferences;

/**
 * Constant definitions for plug-in preferences.
 */
public interface PreferenceConstants {

    String VALUE_OUTPUT_CONSOLE = "Console";
    String VALUE_OUTPUT_SHELL = "Shell";
    String VALUE_OUTPUT_NONE = "None";

    String SHELL_BASE = "org.eclipse.escriptmonkey.scripting.shell.prefs";

    String INIT_COMMANDS = "org.eclipse.escriptmonkey.scripting.shell.prefs.initCommands";

    String CONSOLE_BASE = "org.eclipse.escriptmonkey.scripting.console.prefs";
    String CONSOLE_OPEN_ON_OUT = "consoleOpenOnOut";
    String CONSOLE_OPEN_ON_ERR = "consoleOpenOnErr";
}
