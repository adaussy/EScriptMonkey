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

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TreeDragSourceEffect;

/**
 * Source for a macro D&D event.
 */
public class MacroDragSource extends TreeDragSourceEffect {

    private final TreeViewer mTree;

    /**
     * Constructor. Gets its macros from a tree selection.
     * 
     * @param tree
     *            tree to read from
     */
    public MacroDragSource(final TreeViewer tree) {
        super(tree.getTree());
        mTree = tree;
    }

    /**
     * Does everything to add drag support to a given tree.
     * 
     * @param treeViewer
     *            tree to add drag support to
     */
    public static final void addDragSupport(final TreeViewer treeViewer) {
        final DragSource source = new DragSource(treeViewer.getTree(), DND.DROP_MOVE | DND.DROP_COPY);
        source.setTransfer(new Transfer[] { LocalSelectionTransfer.getTransfer() });
        source.addDragListener(new MacroDragSource(treeViewer));
    }

    @Override
    public final void dragSetData(final DragSourceEvent event) {
        LocalSelectionTransfer.getTransfer().setSelection(mTree.getSelection());
    }
}
