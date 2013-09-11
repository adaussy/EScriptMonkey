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
package org.eclipse.escriptmonkey.scripting.storedscript.service.impl;

import org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;


/**
 * Internal interface to use for debug
 * @author adaussy
 *
 */
public interface IStoredScriptServiceInternal extends IStoredScriptService {

	public StoredScriptRegistry getRegistry();

}
