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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.escriptmonkey.scripting.debugging.events.IDebugEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.IDebuggerEvent;
import org.eclipse.escriptmonkey.scripting.debugging.events.IModelRequest;

public class EventDispatchJob extends Job {

	private final List<IDebugEvent> mEvents = new ArrayList<IDebugEvent>();

	private boolean mTerminated = false;

	private final IEventProcessor mHost;

	private final IEventProcessor mDebugger;

	public EventDispatchJob(final IEventProcessor host, final IEventProcessor debugger) {
		super("Text Debugger event dispatcher");

		mHost = host;
		mDebugger = debugger;

		setSystem(true);
	}

	public void addEvent(final IDebugEvent event) {
		synchronized(mEvents) {
			if(!mEvents.contains(event))
				mEvents.add(event);
		}

		synchronized(this) {
			notifyAll();
		}
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		while(!mTerminated) {
			// wait for new events
			if(mEvents.isEmpty()) {
				try {
					synchronized(this) {
						wait();
					}
				} catch (final InterruptedException e) {
				}
			}

			if(!monitor.isCanceled()) {

				IDebugEvent event = null;
				synchronized(mEvents) {
					if(!mEvents.isEmpty())
						event = mEvents.remove(0);
				}

				if(event != null)
					handleEvent(event);

			} else
				terminate();
		}

		return Status.OK_STATUS;
	}

	private void handleEvent(final IDebugEvent event) {
		// forward event handling to target
		if(event instanceof IDebuggerEvent)
			mHost.handleEvent(event);

		else if(event instanceof IModelRequest)
			mDebugger.handleEvent(event);

		else
			throw new RuntimeException("Unknown event detected: " + event);
	}

	public void terminate() {
		mTerminated = true;

		// wake up job
		synchronized(this) {
			notifyAll();
		}
	}
}
