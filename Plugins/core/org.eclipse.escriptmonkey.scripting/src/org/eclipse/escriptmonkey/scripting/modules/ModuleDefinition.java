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
package org.eclipse.escriptmonkey.scripting.modules;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

public class ModuleDefinition {

    private static final String VISIBLE = "visible";

    private static final String DEPENDENCY = "dependency";

    /** Module dependency parameter name. */
    private static final String CONFIG_DEPENDENCY_NAME = "module";

    private static final String NAME = "name";
    private static final String CLASS = "class";
    private final IConfigurationElement mConfig;

    public ModuleDefinition(final IConfigurationElement config) {
        mConfig = config;
    }

    public String getName() {
        return mConfig.getAttribute(NAME);
    }

    public Collection<String> getDependencies() {
        Set<String> dependencies = new HashSet<String>();

        for (final IConfigurationElement element : mConfig.getChildren(DEPENDENCY))
            dependencies.add(element.getAttribute(CONFIG_DEPENDENCY_NAME));

        return dependencies;
    }

    public String getModuleClassName() {
        return mConfig.getAttribute(CLASS);
    }

    public IScriptModule getModuleInstance() {
        try {
            Object clazz = mConfig.createExecutableExtension(CLASS);
            if (clazz instanceof IScriptModule)
                return (IScriptModule) clazz;
        } catch (CoreException e) {
            // could not create class, ignore
        }

        return null;
    }

    public boolean isVisible() {
        return Boolean.parseBoolean(mConfig.getAttribute(VISIBLE));
    }
}
