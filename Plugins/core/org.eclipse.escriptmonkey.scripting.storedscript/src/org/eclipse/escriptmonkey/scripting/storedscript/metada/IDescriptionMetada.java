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


/**
 * Metadata providing a description of a script
 * 
 * @author adaussy
 * 
 */
public interface IDescriptionMetada {

	public static String DESCRIPTION_KEY = "DESCRIPTION_KEY";

	public String getDescription();

	public void setDescription(String description);
}
