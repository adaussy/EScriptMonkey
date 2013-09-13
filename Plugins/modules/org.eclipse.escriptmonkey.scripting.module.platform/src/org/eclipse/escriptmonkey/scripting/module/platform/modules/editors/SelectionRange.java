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
package org.eclipse.escriptmonkey.scripting.module.platform.modules.editors;

import org.eclipse.jface.text.ITextSelection;


public class SelectionRange {

	private ITextSelection ts;

	public SelectionRange(ITextSelection ts) {
		super();
		this.ts = ts;
	}

	public Integer getStartingOffset() {
		return new Integer(ts.getOffset());
	}

	public Integer getEndingOffset() {
		return new Integer(ts.getOffset() + ts.getLength());
	}

}
