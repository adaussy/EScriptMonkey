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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.ui.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.escriptmonkey.scripting.ui.launching.MainTab;

public class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

    public LaunchConfigurationTabGroup() {
    }

    @Override
    public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
        setTabs(new ILaunchConfigurationTab[] { new MainTab(new String[] { "js", "javascript" }), new CommonTab() });
    }
}
