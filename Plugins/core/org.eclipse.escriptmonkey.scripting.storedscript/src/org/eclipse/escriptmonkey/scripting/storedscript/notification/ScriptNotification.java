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
 * Base implementation of a notification for store script changes
 * 
 * @author adaussy
 * 
 */
public class ScriptNotification implements IScriptNotification {

	private NotificationType type;

	private IPath newPath;

	private IPath oldPath;

	public ScriptNotification(NotificationType type, IPath newPath, IPath oldPath) {
		super();
		this.type = type;
		this.newPath = newPath;
		this.oldPath = oldPath;
	}

	@Override
	public IPath getNewScriptPath() {
		return newPath;
	}

	@Override
	public IPath getOldScriptPath() {
		return oldPath;
	}

	@Override
	public NotificationType getType() {
		return type;
	}


}
