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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.jface.resource.ImageDescriptor;

public class MacroPopupMenu extends AbstractPopupMenu {

	private final List<AbstractPopupItem> mItems = new ArrayList<AbstractPopupItem>();

	public MacroPopupMenu(final String name) {
		super(name);
	}

	public void addItem(final AbstractPopupItem item) {
		mItems.add(item);
	}

	@Override
	protected void populate() {
		for (final AbstractPopupItem item : mItems)
			addPopup(item);
	}

	/**
	 * @param segment
	 * @return
	 */
	public boolean hasSubMenu(final String name) {
		for (final AbstractPopupItem item : mItems) {
			if (item.getDisplayName().equals(name))
				return true;
		}

		return false;
	}

	/**
	 * @param segment
	 * @return
	 */
	public MacroPopupMenu getSubMenu(final String name) {
		for (final AbstractPopupItem item : mItems) {
			if ((item.getDisplayName().equals(name)) && (item instanceof MacroPopupMenu))
				return (MacroPopupMenu) item;
		}

		return null;
	}

	@Override
	protected ImageDescriptor getImageDescriptor() {
		return Activator.getImageDescriptor("/images/macro_folder.gif");
	}
}
