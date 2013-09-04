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
package org.eclipse.escriptmonkey.scripting;

/**
 * Interface to be implemented by any class interested in getting notified of script execution event.
 */
public interface IExecutionListener {

    /** Event script execution started */
    public static final int SCRIPT_START = 1;

    /** Event script execution ended */
    public static final int SCRIPT_END = 2;

    /** Event execution ended */
    public static final int ENGINE_START = 3;

    /** Event execution ended */
    public static final int ENGINE_END = 4;

    /**
     * Notifies the listeners when script execution started/ended or when the engine itself is started/ended.
     * 
     * @param engine
     *            Script Engine
     * @param script
     *            Script or <code>null</code>
     * @param status
     *            Event Status
     */
    void notify(IScriptEngine engine, Script script, int status);
}
