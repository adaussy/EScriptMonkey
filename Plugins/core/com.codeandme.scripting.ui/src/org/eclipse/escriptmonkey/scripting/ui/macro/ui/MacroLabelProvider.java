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
package org.eclipse.escriptmonkey.scripting.ui.macro.ui;

import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Label provider for macro tree view.
 */
public class MacroLabelProvider extends LabelProvider {

    @Override
    public final Image getImage(final Object element) {
        if (element instanceof Macro)
            return Activator.getImage(Activator.PLUGIN_ID, "/images/macro.gif", true);
        else
            return Activator.getImage(Activator.PLUGIN_ID, "/images/macro_folder.gif", true);
    }
}
