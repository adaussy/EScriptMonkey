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
package org.eclipse.escriptmonkey.scripting.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.escriptmonkey.scripting.AbstractScriptEngine;
import org.eclipse.escriptmonkey.scripting.EngineDescription;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngineLaunchExtension;
import org.eclipse.escriptmonkey.scripting.IScriptService;
import org.eclipse.escriptmonkey.scripting.modules.IModuleWrapper;
import org.eclipse.escriptmonkey.scripting.modules.ModuleDefinition;

public class ScriptService implements IScriptService {

    private static final String EXTENSION_MODULE_ID = "org.eclipse.escriptmonkey.scripting.language";
    private static final String ENGINE = "engine";
    private static final String LAUNCH_EXTENSION = "launchExtension";
    private static final String MODULE_WRAPPER = "moduleWrapper";
    private static final String ENGINE_ID = "engineID";
    private static final Object EXTENSION_MODULE = "module";

    private static ScriptService mInstance = null;

    public static ScriptService getInstance() {
        if (mInstance == null)
            mInstance = new ScriptService();

        return mInstance;
    }

    private ScriptService() {
    }

    @Override
    public IScriptEngine createEngineByID(final String engineID) {
        List<EngineDescription> engines = new ArrayList<EngineDescription>(getEngines());
        for (EngineDescription description : engines) {
            if (description.getID().equals(engineID))
                return createEngine(description);
        }

        return null;
    }

    private IScriptEngine createEngine(final EngineDescription description) {
        try {
            Object engine = description.createEngine();

            if (engine instanceof IScriptEngine) {
                // configure engine
                if (engine instanceof AbstractScriptEngine)
                    ((AbstractScriptEngine) engine).setEngineDescription(description);

                // engine loaded, now load launch extensions
                for (final IScriptEngineLaunchExtension extension : getLaunchExtensions(((IScriptEngine) engine).getID()))
                    extension.createEngine((IScriptEngine) engine);

                return (IScriptEngine) engine;
            }
        } catch (CoreException e) {
        }

        return null;
    }

    @Override
    public IScriptEngine createEngine(final String scriptType) {
        List<EngineDescription> engines = new ArrayList<EngineDescription>(getEngines());

        // sort by priority (highest first)
        Collections.sort(engines, new Comparator<EngineDescription>() {

            @Override
            public int compare(final EngineDescription o1, final EngineDescription o2) {
                return o2.getPriority() - o1.getPriority();
            }
        });

        // return first engine where ID matches or (in case no ID is provided)
        // scriptType matches
        for (EngineDescription description : engines) {
            if (description.getSupportedScriptTypes().contains(scriptType)) {
                // engine found, launch
                IScriptEngine engine = createEngine(description);
                if (engine != null)
                    return engine;

                // we could not create engine for some reason, try next one
            }
        }

        return null;
    }

    public static List<IScriptEngineLaunchExtension> getLaunchExtensions(final String engineID) {
        final List<IScriptEngineLaunchExtension> extensions = new LinkedList<IScriptEngineLaunchExtension>();

        final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

        for (final IConfigurationElement e : config) {
            try {
                if (LAUNCH_EXTENSION.equals(e.getName())) {
                    if (e.getAttribute(ENGINE_ID).equals(engineID)) {
                        final Object extension = e.createExecutableExtension("class");
                        if (extension instanceof IScriptEngineLaunchExtension)
                            extensions.add((IScriptEngineLaunchExtension) extension);
                    }
                }
            } catch (final InvalidRegistryObjectException e1) {
            } catch (final CoreException e1) {
            }
        }

        return extensions;
    }

    @Override
    public Collection<EngineDescription> getEngines() {
        final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

        HashSet<EngineDescription> engines = new HashSet<EngineDescription>();
        for (final IConfigurationElement e : config) {
            if (ENGINE.equals(e.getName()))
                engines.add(new EngineDescription(e));
        }

        return engines;
    }

    @Override
    public IModuleWrapper getModuleWrapper(final String engineID) {

        final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

        for (final IConfigurationElement e : config) {
            try {
                if (MODULE_WRAPPER.equals(e.getName())) {
                    if (engineID.equals(e.getAttribute(ENGINE_ID))) {

                        final Object extension = e.createExecutableExtension("class");
                        if (extension instanceof IModuleWrapper)
                            return (IModuleWrapper) extension;
                    }
                }
            } catch (final InvalidRegistryObjectException e1) {
            } catch (final CoreException e1) {
            }
        }

        return null;
    }

    @Override
    public Map<String, ModuleDefinition> getAvailableModules() {

        Map<String, ModuleDefinition> modules = new HashMap<String, ModuleDefinition>();

        final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);
        for (final IConfigurationElement e : config) {
            if (e.getName().equals(EXTENSION_MODULE)) {
                // module extension detected
                ModuleDefinition definition = new ModuleDefinition(e);
                modules.put(definition.getName(), definition);
            }
        }

        return modules;
    }
}