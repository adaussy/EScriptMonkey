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
package org.eclipse.escriptmonkey.scripting.ui.service;

import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

public class MacroServiceFactory extends AbstractServiceFactory {

    public MacroServiceFactory() {
    }

    @Override
    public Object create(final Class serviceInterface, final IServiceLocator parentLocator, final IServiceLocator locator) {
        if (serviceInterface.equals(IMacroService.class))
            return MacroService.getInstance();

        return null;
    }
}