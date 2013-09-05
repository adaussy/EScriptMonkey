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
package org.eclipse.escriptmonkey.scripting.storedscript.notification;

import org.eclipse.core.runtime.IPath;


/**
 * Notification used to acknowledge changes on stored Script
 * 
 * @author adaussy
 * 
 */
public interface IScriptNotification {

	public enum NotificationType {
		ADD, DELETE, CHANGE, MOVE
	}

	public IPath getNewScriptPath();

	public IPath getOldScriptPath();

	public NotificationType getType();
}
