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
package org.eclipse.escriptmonkey.scripting.module.platform.modules;


/**
 * Interface use to provide a selector. A selector is an object that is able to return from a selection another object
 * 
 * @author adaussy
 * 
 */
public interface ISelector {

	public Object getCustomSelection(Object selection);

}
