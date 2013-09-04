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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;

public class AdvancedTreeNode<T> implements Comparable<Object> {

	private final String mName;

	private final List<AdvancedTreeNode<T>> mChildren = new ArrayList<AdvancedTreeNode<T>>();
	private final List<T> mLeafs = new ArrayList<T>();
	private AdvancedTreeNode<T> mParent = null;
	private Image mImage = null;
	private boolean mLoaded = false;

	public AdvancedTreeNode() {
		this(null);
	}

	public AdvancedTreeNode(final String name) {
		this(name, true);
	}

	public AdvancedTreeNode(final String name, final boolean loaded) {
		mName = name;
		mLoaded = loaded;
	}

	@Override
	public final String toString() {
		return (mName != null) ? mName : "null";
	}

	public final void addNode(final AdvancedTreeNode<T> node) {
		mChildren.add(node);
		node.setParent(this);
		setLoaded(true);
	}

	public final void addLeaf(final T leaf) {
		mLeafs.add(leaf);
		setLoaded(true);
	}

	public void setLoaded(final boolean loaded) {
		mLoaded = loaded;
	}

	private void setParent(final AdvancedTreeNode<T> parent) {
		mParent = parent;
	}

	public final AdvancedTreeNode<T> getParent() {
		return mParent;
	}

	public final List<AdvancedTreeNode<T>> getNodes() {
		return mChildren;
	}

	public final List<T> getLeafs() {
		return mLeafs;
	}

	public final List<Object> getChildren() {
		final List<Object> values = new ArrayList<Object>();

		values.addAll(getNodes());
		values.addAll(getLeafs());

		return values;
	}

	public final void setImage(final Image image) {
		mImage = image;
	}

	public final Image getImage() {
		return mImage;
	}

	/**
	 * Find a {@link TreeNode} holding a specific needle.
	 * 
	 * @param root
	 *            root node to start search from
	 * @param needle
	 *            object to look for
	 * @return {@link TreeNode} containing needle
	 */
	// public static <T> AdvancedTreeNode<T> findTreeNode(final
	// AdvancedTreeNode<T> root, final Object needle) {
	// assert (root != null) : "root node not set";
	// assert (needle != null) : "needle node not set";
	//
	// if (needle.equals(root.getValue()))
	// return root;
	//
	// for (final AdvancedTreeNode<T> child : root.getChildren()) {
	// final AdvancedTreeNode<T> result = findTreeNode(child, needle);
	// if (result != null)
	// return result;
	// }
	//
	// return null;
	// }

	public final void clear() {
		mChildren.clear();
		mLeafs.clear();
	}

	public boolean isLoaded() {
		return mLoaded;
	}

	// public static <T> AdvancedTreeNode<T> findTreeNodeByName(final
	// AdvancedTreeNode<T> root, final String name) {
	// assert (root != null) : "root node not set";
	// assert (name != null) : "display name not set";
	//
	// if (name.equals(root.toString()))
	// return root;
	//
	// final Collection<AdvancedTreeNode<T>> children = root.getChildren();
	//
	// for (final AdvancedTreeNode<T> child : children) {
	// final AdvancedTreeNode<T> result = findTreeNodeByName(child, name);
	// if (result != null)
	// return result;
	// }
	//
	// return null;
	// }

	// public final AdvancedTreeNode<T> findChild(final String name) {
	// assert (name != null) : "child name not set";
	//
	// for (final AdvancedTreeNode<T> child : getChildren()) {
	// if (name.equals(child.toString()))
	// return child;
	// }
	//
	// return null;
	// }

	public final AdvancedTreeNode<T> findNode(final IPath path, final boolean createIfNecessary) {

		if (path.segmentCount() == 0)
			return this;

		final String name = path.segment(0);

		for (final AdvancedTreeNode<T> child : getNodes()) {
			if (name.equals(child.toString()))
				return child.findNode(path.removeFirstSegments(1), createIfNecessary);
		}

		// element not found
		if (createIfNecessary) {
			// create new element
			final AdvancedTreeNode<T> child = new AdvancedTreeNode<T>(name);
			addNode(child);

			return child.findNode(path.removeFirstSegments(1), createIfNecessary);
		}

		// element does not exist
		return null;
	}

	// public final void removeChild(final AdvancedTreeNode<T> child) {
	// mChildren.remove(child);
	// }

	// public AdvancedTreeNode<T> getChild(final String nodeName) {
	// for (final AdvancedTreeNode<T> child : getChildren()) {
	// if (child.mName.equals(nodeName))
	// return child;
	// }
	//
	// return null;
	// }

	// @Override
	// public boolean equals(final Object o) {
	// if (o instanceof AdvancedTreeNode<?>) {
	// if (mValue != null)
	// return mValue.equals(((AdvancedTreeNode<?>) o).mValue);
	//
	// return mName.equals(((AdvancedTreeNode<?>) o).mName);
	// }
	//
	// return super.equals(o);
	// }

	// @Override
	// public int hashCode() {
	// if (mValue != null)
	// return mValue.hashCode();
	//
	// return mName.hashCode();
	// }

	@Override
	public int compareTo(final Object o) {
		return toString().compareTo(o.toString());
	}

	/**
	 * @param root
	 * @param test
	 * @return
	 */
	// public static <T> AdvancedTreeNode<T> findParent(final
	// AdvancedTreeNode<T> root, final T test) {
	// return null;
	// }

	/**
	 * @return
	 */
	public List<T> getTreeLeafs() {
		final List<T> leafs = new ArrayList<T>();

		leafs.addAll(getLeafs());
		for (final AdvancedTreeNode<T> node : getNodes())
			leafs.addAll(node.getTreeLeafs());

		return leafs;
	}

	/**
	 * @param root
	 * @param tag
	 */
	public static <T> AdvancedTreeNode<T> findParentNode(final AdvancedTreeNode<T> node, final T element) {
		// look in leafs
		for (final T leaf : node.getLeafs()) {
			if (leaf.equals(element))
				return node;
		}

		// not found, delegate to child nodes
		for (final AdvancedTreeNode<T> child : node.getNodes()) {
			final AdvancedTreeNode<T> found = findParentNode(child, element);
			if (found != null)
				return found;
		}

		return null;
	}
}
