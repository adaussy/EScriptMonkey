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

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.services.IServiceLocator;

public abstract class AbstractPopupMenu extends AbstractPopupItem implements IMenuListener {

	private final MenuManager mMenuManager;
	private IServiceLocator mServiceLocator;
	private boolean mSeparatorRequested = false;

	public AbstractPopupMenu(final String name) {
		super();

		mMenuManager = new MenuManager(name, getImageDescriptor(), null);
		mMenuManager.setRemoveAllWhenShown(true);
		mMenuManager.addMenuListener(this);
	}

	@Override
	public final IContributionItem getContribution(final IServiceLocator serviceLocator) {
		mServiceLocator = serviceLocator;
		return mMenuManager;
	}

	@Override
	public final void menuAboutToShow(final IMenuManager manager) {
		mSeparatorRequested = false;
		populate();
	}

	protected final void addPopup(final AbstractPopupItem item) {
		if (item == null)
			mSeparatorRequested = true;

		else if (item.isVisible()) {
			if (mSeparatorRequested) {
				mMenuManager.add(new Separator());
				mSeparatorRequested = false;
			}

			mMenuManager.add(item.getContribution(mServiceLocator));
		}
	}

	protected final void addSeparator() {
		addPopup(null);
	}

	@Override
	public CommandContributionItemParameter getContributionParameter() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return mMenuManager.getMenuText();
	}

	protected ImageDescriptor getImageDescriptor() {
		return null;
	}

	protected abstract void populate();
}
