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

import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngineProvider;
import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.escriptmonkey.scripting.ui.macro.IMacroListener;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IMenuService;

/**
 * SWT Composite that displays available macros. Implemented as a tree viewer.
 */
public class MacroComposite extends Composite implements IMacroListener {
    private final TreeViewer treeViewer;

    /**
     * Constructor creating the macro tree viewer.
     * 
     * @param supporter
     *            component providing macro support
     * @param site
     *            site to implement this component on
     * @param parent
     *            parent SWT element
     * @param style
     *            composite style flags
     */
    public MacroComposite(final IScriptEngineProvider engineProvider, final IWorkbenchPartSite site, final Composite parent, final int style) {
        super(parent, style);

        setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new TreeViewer(this, SWT.BORDER);

        treeViewer.setLabelProvider(new MacroLabelProvider());
        treeViewer.setContentProvider(new MacroContentProvider());
        treeViewer.setComparator(new ViewerComparator() {
            @Override
            public int category(final Object element) {
                // show folders before macros
                return (element instanceof Macro) ? 2 : 1;
            }
        });

        // set some dummy input. MacroContentProvider is clever enough to get
        // its data by itself
        treeViewer.setInput(this);

        final Tree tree = treeViewer.getTree();
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(final MouseEvent e) {
                final Object source = e.getSource();
                if (source.equals(tree)) {
                    final IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
                    final Object element = selection.getFirstElement();
                    if (element instanceof Macro) {
                        final IScriptEngine scriptEngine = engineProvider.getScriptEngine();
                        if (scriptEngine != null)
                            scriptEngine.executeAsync("include(\"macro://" + ((Macro) element).getName() + "\");");
                    }
                }
            }
        });

        // subscribe for add/delete macro events
        final IMacroService macroService = (IMacroService) PlatformUI.getWorkbench().getService(IMacroService.class);
        if (macroService != null) {
            macroService.addMacroListener(this);
            getShell().addDisposeListener(new DisposeListener() {

                @Override
                public void widgetDisposed(final DisposeEvent e) {
                    macroService.removeMacroListener(MacroComposite.this);
                }
            });
        }

        // add context menu support
        final MenuManager menuManager = new MenuManager();
        final Menu menu = menuManager.createContextMenu(tree);
        tree.setMenu(menu);
        site.registerContextMenu(menuManager, treeViewer);
        site.setSelectionProvider(treeViewer);

        // add dynamic context menu entries
        final IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
        menuService.addContributionFactory(new ContextMenuEntries("popup:" + site.getId()));
        menuManager.setRemoveAllWhenShown(true);

        // add DND support
        MacroDragSource.addDragSupport(treeViewer);

    }

    @Override
    public final void notify(final int event, final Macro macro) {
        final Object[] expanded = treeViewer.getExpandedElements();
        treeViewer.setInput("foo");
        treeViewer.setExpandedElements(expanded);
        treeViewer.refresh();
    }

    public void setEngine(final String engineID) {
        treeViewer.setFilters(new ViewerFilter[] { new ScriptEngineFilter(engineID) });
    }
}
