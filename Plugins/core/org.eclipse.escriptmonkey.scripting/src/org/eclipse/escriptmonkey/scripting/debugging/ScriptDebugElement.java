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
package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDisconnect;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.core.model.ITerminate;

public abstract class ScriptDebugElement extends DebugElement implements ITerminate, ISuspendResume, IDisconnect, IStep {

	protected enum State {
		NOT_STARTED, SUSPENDED, RESUMED, STEPPING, TERMINATED
	}

	public ScriptDebugElement(final ScriptDebugTarget target) {
		super(target);
	}

	@Override
	public ScriptDebugTarget getDebugTarget() {
		return (ScriptDebugTarget)super.getDebugTarget();
	}

	@Override
	public String getModelIdentifier() {
		return "org.eclipse.escriptmonkey.debugModelPresentation.rhino";
	}

	// ************************************************************
	// ITerminate
	// ************************************************************

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return false;
	}

	@Override
	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	@Override
	public void suspend() throws DebugException {
		// FIXME add correct plugin id
		throw new DebugException(new Status(IStatus.ERROR, "Activator.PLUGIN_ID", "getMemoryBlock() not supported by " + getDebugTarget().getName()));
	}

	// ************************************************************
	// ISuspendResume
	// ************************************************************

	@Override
	public boolean canDisconnect() {
		return !isDisconnected();
	}

	@Override
	public void disconnect() throws DebugException {
		getDebugTarget().disconnect();
	}

	@Override
	public boolean isDisconnected() {
		return isTerminated();
	}

	// ************************************************************
	// IStep
	// ************************************************************

	@Override
	public boolean canStepInto() {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			return threads[0].canStepInto();

		return false;
	}

	@Override
	public boolean canStepOver() {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			return threads[0].canStepOver();

		return false;
	}

	@Override
	public boolean canStepReturn() {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			return threads[0].canStepReturn();

		return false;
	}

	@Override
	public void stepInto() throws DebugException {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			threads[0].stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			threads[0].stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		final ScriptDebugThread[] threads = getDebugTarget().getThreads();
		if(threads.length == 1)
			threads[0].stepReturn();
	}
}
