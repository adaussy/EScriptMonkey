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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.escriptmonkey.scripting.ExitException;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;

public class ObservingContextFactory extends ContextFactory {

	private final Set<Context> mTerminationRequests = new HashSet<Context>();

	@Override
	protected synchronized void observeInstructionCount(final Context cx, final int instructionCount) {
		if(mTerminationRequests.remove(cx))
			throw new ExitException();

		super.observeInstructionCount(cx, instructionCount);
	}

	public synchronized void terminate(final Context context) {
		mTerminationRequests.add(context);
	}

	public void cancelTerminate(final Context context) {
		mTerminationRequests.remove(context);
	}
}
