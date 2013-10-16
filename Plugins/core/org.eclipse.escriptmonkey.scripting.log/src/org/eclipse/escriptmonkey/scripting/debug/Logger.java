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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


public class Logger {


	public static void logError(String message) {
		logError(message, Activator.PLUGIN_ID);
	}

	public static void logError(String message, String pluginID) {
		Activator.getDefault().getLog().log(createErrorStatus(message, pluginID));
	}

	public static IStatus createErrorStatus(String message, String pluginID) {
		return createStatus(Status.ERROR, pluginID, message);
	}

	public static IStatus createStatus(int statusError, String message, String pluginID) {
		return new Status(statusError, pluginID, message);
	}

	public static IStatus createWarningStatus(String message, String pluginID) {
		return createStatus(Status.WARNING, pluginID, message);
	}

	public static void logWarning(String message) {
		logWarning(message, Activator.PLUGIN_ID);
	}

	public static void logWarning(String message, String pluginID) {
		Activator.getDefault().getLog().log(createWarningStatus(message, pluginID));
	}



}
