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
package org.eclipse.escriptmonkey.scripting.ui.macro;

/**
 * Interface for Macro listeners. Listeners will be informed of macro addition
 * and removals.
 */
public interface IMacroListener {

	/** Add macro event type. */
	int ADD_MACRO = 1;

	/** Delete macro event type. */
	int DELETE_MACRO = 2;

	/**
	 * Notify of Macro event.
	 * 
	 * @param event
	 *            event happened
	 * @param macro
	 *            macro affected by event
	 */
	void notify(final int event, final Macro macro);
}
