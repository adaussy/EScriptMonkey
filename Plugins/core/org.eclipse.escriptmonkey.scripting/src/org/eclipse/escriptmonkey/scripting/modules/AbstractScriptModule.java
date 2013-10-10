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

import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.escriptmonkey.scripting.IModifiableScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.ScriptResult;
import org.eclipse.escriptmonkey.scripting.injection.CodeInjectorUtils;
import org.eclipse.escriptmonkey.scripting.service.ScriptService;

public abstract class AbstractScriptModule implements IScriptModule {

	private String mName = "(undefined)";

	private IScriptEngine mEngine = null;

	private EnvironmentModule mEnvironmentModule = null;

	public AbstractScriptModule() {

		Map<String, ModuleDefinition> modules = ScriptService.getInstance().getAvailableModules();
		for(ModuleDefinition definition : modules.values()) {
			if(definition.getModuleClassName().equals(this.getClass().getName())) {
				mName = definition.getName();
				break;
			}
		}

		// detect engine
		final Job currentJob = Job.getJobManager().currentJob();
		if(currentJob instanceof IScriptEngine) {
			mEngine = (IScriptEngine)currentJob;

			// find environment module
			if(mEngine instanceof IModifiableScriptEngine) {
				// engine supports direct reading of variables
				Object module = ((IModifiableScriptEngine)mEngine).getVariable(getWrapper().getEnvironmentModuleName());
				if(module instanceof EnvironmentModule) {
					mEnvironmentModule = (EnvironmentModule)module;
					mEnvironmentModule.addModule(this);
				}

			} else {
				// need to query engine by executing code
				ScriptResult result = mEngine.inject(getWrapper().getEnvironmentModuleName());
				if(result.getResult() instanceof EnvironmentModule) {
					mEnvironmentModule = (EnvironmentModule)result.getResult();
					mEnvironmentModule.addModule(this);
				}
			}
		}
	}

	@Override
	public IScriptEngine getScriptEngine() {
		return mEngine;
	}

	@Override
	public String getModuleName() {
		return mName;
	}

	public IModuleWrapper getWrapper() {
		return CodeInjectorUtils.getWrapper(getScriptEngine());
	}
}
