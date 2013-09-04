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
package org.eclipse.escriptmonkey.scripting.ui.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.escriptmonkey.scripting.IScriptEngineProvider;

public class ScriptEnginePropertyTester extends PropertyTester {

    private static final String PROPERTY_ENGINE_ID = "engineID";

    public ScriptEnginePropertyTester() {
    }

    @Override
    public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
        if (receiver instanceof IScriptEngineProvider) {
            if (PROPERTY_ENGINE_ID.equals(property))
                return ((IScriptEngineProvider) receiver).getScriptEngine().getID().equals(expectedValue);
        }

        return false;
    }
}
