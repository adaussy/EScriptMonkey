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
package org.eclipse.escriptmonkey.scripting.engine.python.jython.debug;

import org.eclipse.core.runtime.Platform;


public interface ITracingConstant {


	public static final boolean PYTHON_BOOT_STRAPPER_TRACING = org.eclipse.escriptmonkey.scripting.Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.escriptmonkey.scripting.engine.python.jython/debug/PythonBootStrapper"));


}
