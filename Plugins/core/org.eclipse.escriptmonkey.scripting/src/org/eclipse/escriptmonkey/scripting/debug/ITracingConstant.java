/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.debug;

import org.eclipse.core.runtime.Platform;


/**
 * Store constant used to display or not trace
 * 
 * @author adaussy
 * 
 */
public interface ITracingConstant {


	/**
	 * If true trace stuff about module wrapping
	 */
	public static final boolean MODULE_WRAPPER_TRACING = org.eclipse.escriptmonkey.scripting.Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.escriptmonkey.scripting/debug/moduleWrapper"));

	/**
	 * If true trace stuff about Environment Module
	 */
	public static final boolean ENVIRONEMENT_MODULE_WRAPPER_TRACING = org.eclipse.escriptmonkey.scripting.Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.escriptmonkey.scripting/debug/EnvironementmoduleWrapper"));

}
