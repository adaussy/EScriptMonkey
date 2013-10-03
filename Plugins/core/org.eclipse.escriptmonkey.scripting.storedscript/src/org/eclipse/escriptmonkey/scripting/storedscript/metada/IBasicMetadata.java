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
package org.eclipse.escriptmonkey.scripting.storedscript.metada;


public interface IBasicMetadata {

	/**
	 * Use to difine the thread in which the thread
	 */
	public static final String THREAD_METADATA = "Thread";

	/**
	 * The value that as to be set in the Thread meta to launch a script in UI
	 */
	public static final String UI_THREAD_METADATA_VALUE = "UI";


	/**
	 * Unsused metadata for now (Inherited from Eclipse Monkey)
	 */
	public static final String LISTENER_METADATA = "Listener";

}
