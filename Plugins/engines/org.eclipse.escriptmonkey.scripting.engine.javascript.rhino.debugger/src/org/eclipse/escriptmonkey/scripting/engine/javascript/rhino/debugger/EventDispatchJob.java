package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebugEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IDebuggerEvent;
import org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.events.IModelEvent;

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

		else if(event instanceof IModelEvent)
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
