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
		if(mInstance == null)
			mInstance = new ScriptService();

		return mInstance;
	}

	private ScriptService() {
	}

	@Override
	public IScriptEngine createEngineByID(final String engineID) {
		EngineDescription enginDescription = getEnginesDescription().get(engineID);
		if(enginDescription != null) {
			return createEngine(enginDescription);
		}

		return null;
	}

	private IScriptEngine createEngine(final EngineDescription description) {
		try {
			Object engine = description.createEngine();

			if(engine instanceof IScriptEngine) {
				// configure engine
				if(engine instanceof AbstractScriptEngine)
					((AbstractScriptEngine)engine).setEngineDescription(description);

				// engine loaded, now load launch extensions
				for(final IScriptEngineLaunchExtension extension : getLaunchExtensions(((IScriptEngine)engine).getID()))
					extension.createEngine((IScriptEngine)engine);

				return (IScriptEngine)engine;
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
		for(EngineDescription description : engines) {
			if(description.getSupportedScriptTypes().contains(scriptType)) {
				// engine found, launch
				IScriptEngine engine = createEngine(description);
				if(engine != null)
					return engine;

				// we could not create engine for some reason, try next one
			}
		}

		return null;
	}

	public static List<IScriptEngineLaunchExtension> getLaunchExtensions(final String engineID) {
		final List<IScriptEngineLaunchExtension> extensions = new LinkedList<IScriptEngineLaunchExtension>();

		final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

		for(final IConfigurationElement e : config) {
			try {
				if(LAUNCH_EXTENSION.equals(e.getName())) {
					if(e.getAttribute(ENGINE_ID).equals(engineID)) {
						final Object extension = e.createExecutableExtension("class");
						if(extension instanceof IScriptEngineLaunchExtension)
							extensions.add((IScriptEngineLaunchExtension)extension);
					}
				}
			} catch (final InvalidRegistryObjectException e1) {
			} catch (final CoreException e1) {
			}
		}

		return extensions;
	}

	private Map<String, EngineDescription> enginesDescription = null;

	protected Map<String, EngineDescription> getEnginesDescription() {
		if(enginesDescription == null) {
			enginesDescription = new HashMap<String, EngineDescription>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

			for(final IConfigurationElement e : config) {
				if(ENGINE.equals(e.getName())) {
					EngineDescription engine = new EngineDescription(e);
					enginesDescription.put(engine.getID(), engine);
				}
			}
		}
		return enginesDescription;
	}

	@Override
	public Collection<EngineDescription> getEngines() {
		return getEnginesDescription().values();
	}

	protected Map<String, IModuleWrapper> moduleWrapper = null;

	protected Map<String, IModuleWrapper> getAllModuleWrapper() {
		if(moduleWrapper == null) {
			moduleWrapper = new HashMap<String, IModuleWrapper>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);

			for(final IConfigurationElement e : config) {
				try {
					if(MODULE_WRAPPER.equals(e.getName())) {
						final Object extension = e.createExecutableExtension("class");
						String engineID = e.getAttribute(ENGINE_ID);
						if(extension instanceof IModuleWrapper && engineID != null) {
							if(moduleWrapper.containsKey(engineID)) {
								/*
								 * TODO should log an error instead of print err. Need activator
								 */
								System.err.println("The engine id " + engineID + " is already used");
							}
							moduleWrapper.put(engineID, (IModuleWrapper)extension);
						}
					}
				} catch (final InvalidRegistryObjectException e1) {
				} catch (final CoreException e1) {
				}
			}
		}
		return moduleWrapper;
	}

	@Override
	public IModuleWrapper getModuleWrapper(final String engineID) {
		return getAllModuleWrapper().get(engineID);
	}

	protected Map<String, ModuleDefinition> availableModule = null;

	@Override
	public Map<String, ModuleDefinition> getAvailableModules() {
		if(availableModule == null) {
			availableModule = new HashMap<String, ModuleDefinition>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_MODULE_ID);
			for(final IConfigurationElement e : config) {
				if(e.getName().equals(EXTENSION_MODULE)) {
					// module extension detected
					ModuleDefinition definition = new ModuleDefinition(e);
					availableModule.put(definition.getName(), definition);
				}
			}
		}
		return availableModule;
	}
}
