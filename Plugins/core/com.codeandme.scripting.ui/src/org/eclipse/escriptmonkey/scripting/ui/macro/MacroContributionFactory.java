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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.escriptmonkey.scripting.ui.macro.ui.MacroPopup;
import org.eclipse.escriptmonkey.scripting.ui.macro.ui.MacroPopupMenu;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Factory adding macros to dynamically populated menu.
 */
public final class MacroContributionFactory extends AbstractContributionFactory {

    /**
     * Add a context menu to a given element.
     * 
     * @param menuID
     *            ID of menu to create (typically: popup:view.id)
     */
    public static void addContextMenu(final String menuID) {
        final IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
        menuService.addContributionFactory(new MacroContributionFactory(menuID));
    }

    /**
     * Private constructor.
     * 
     * @param menuID
     *            menu ID to create contribution factory for.
     */
    private MacroContributionFactory(final String menuID) {
        super("menu:" + menuID, null);
    }

    @Override
    public void createContributionItems(final IServiceLocator serviceLocator, final IContributionRoot additions) {

        IMacroService macroService = (IMacroService) PlatformUI.getWorkbench().getService(IMacroService.class);

        if (macroService != null) {
            final List<Macro> macros = new ArrayList<Macro>(macroService.getMacros());

            Collections.sort(macros, new Comparator<Macro>() {

                @Override
                public int compare(final Macro o1, final Macro o2) {
                    IPath path1 = o1.getPath();
                    IPath path2 = o2.getPath();
                    if (path1.isEmpty() && !path2.isEmpty())
                        return 1;

                    else if (!path1.isEmpty() && path2.isEmpty())
                        return -1;

                    else
                        return o1.getName().compareToIgnoreCase(o2.getName());
                }
            });

            final Map<String, MacroPopupMenu> rootMenus = new HashMap<String, MacroPopupMenu>();

            for (final Macro macro : macros) {
                final IPath path = macro.getPath();
                MacroPopupMenu parent = null;

                for (final String segment : path.segments()) {
                    if (parent == null) {
                        if (rootMenus.containsKey(segment))
                            parent = rootMenus.get(segment);

                        else {
                            parent = new MacroPopupMenu(segment);
                            additions.addContributionItem(parent.getContribution(serviceLocator), null);
                            rootMenus.put(segment, parent);
                        }

                    } else {
                        if (parent.hasSubMenu(segment))
                            parent = parent.getSubMenu(segment);

                        else {
                            final MacroPopupMenu menu = new MacroPopupMenu(segment);
                            parent.addItem(menu);
                            parent = menu;
                        }
                    }
                }

                final MacroPopup popup = new MacroPopup(macro);
                if (parent != null)
                    // macro in sub folder
                    parent.addItem(popup);

                else
                    // macro in root folder
                    additions.addContributionItem(popup.getContribution(serviceLocator), null);
            }
        }
    }
}
