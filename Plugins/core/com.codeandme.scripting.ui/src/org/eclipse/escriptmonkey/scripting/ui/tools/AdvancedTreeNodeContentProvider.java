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
package org.eclipse.escriptmonkey.scripting.ui.tools;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public abstract class AdvancedTreeNodeContentProvider<T> implements ITreeContentProvider {

	private final AdvancedTreeNode<T> mRoot = new AdvancedTreeNode<T>();

	public AdvancedTreeNode<T> getRoot() {
		return mRoot;
	}

	@Override
	public Object[] getElements(final Object inputElement) {
		return getRoot().getChildren().toArray();
	}

	@Override
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// nothing to do
	}

	@Override
	public void dispose() {
		// nothing to do
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof AdvancedTreeNode<?>) {
			if (!((AdvancedTreeNode<T>) parentElement).isLoaded())
				loadNode((AdvancedTreeNode<T>) parentElement);

			return ((AdvancedTreeNode<?>) parentElement).getChildren().toArray();
		}

		return null;
	}

	protected void loadNode(final AdvancedTreeNode<T> element) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Object getParent(final Object element) {
		if (element instanceof AdvancedTreeNode<?>)
			return ((AdvancedTreeNode<?>) element).getParent();

		return AdvancedTreeNode.findParentNode(getRoot(), (T) element);
	}

	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof AdvancedTreeNode<?>) {
			if (!((AdvancedTreeNode<T>) element).isLoaded())
				loadNode((AdvancedTreeNode<T>) element);

			return !((AdvancedTreeNode<?>) element).getChildren().isEmpty();
		}

		return false;
	}
}
