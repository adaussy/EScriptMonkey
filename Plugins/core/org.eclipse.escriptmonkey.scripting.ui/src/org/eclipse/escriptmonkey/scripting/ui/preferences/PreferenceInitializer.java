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
package org.eclipse.escriptmonkey.scripting.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 *      initializeDefaultPreferences()
	 */
	@Override
	public final void initializeDefaultPreferences() {
		// final IPreferenceStore store =
		// Activator.getDefault().getPreferenceStore();
		// store.setDefault(PreferenceConstants.INIT_COMMANDS, "");
		// store.setDefault(PreferenceConstants.TARGET_STDOUT,
		// PreferenceConstants.VALUE_OUTPUT_CONSOLE);
		// store.setDefault(PreferenceConstants.TARGET_RESULT,
		// PreferenceConstants.VALUE_OUTPUT_SHELL);
		// store.setDefault(PreferenceConstants.TARGET_ERRORS,
		// PreferenceConstants.VALUE_OUTPUT_CONSOLE);
	}
}
