/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.escriptmonkey.scripting.ui.metadata.UIMetadataUtils;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * Cell label provider for scripts
 * 
 * @author adaussy
 * 
 */
public class ScriptCellLabelProvider extends CellLabelProvider implements org.eclipse.jface.viewers.ILabelProvider {

	ILabelProvider adapter = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public String getToolTipText(Object element) {
		if(element instanceof StoredScriptUI) {
			StoredScriptUI script = (StoredScriptUI)element;
			return UIMetadataUtils.getDescription(script.getScript());
		}
		return null;
	}

	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 500;
	}

	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 10000;
	}

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		cell.setText(adapter.getText(element));
		cell.setImage(adapter.getImage(element));

	}

	@Override
	public Image getImage(Object element) {
		return adapter.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return adapter.getText(element);
	}

}
