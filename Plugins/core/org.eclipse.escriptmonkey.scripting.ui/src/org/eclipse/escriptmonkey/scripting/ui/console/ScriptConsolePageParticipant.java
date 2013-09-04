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
package org.eclipse.escriptmonkey.scripting.ui.console;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.IStreamsProxy2;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.RemoveAllTerminatedConsolesAction;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.RemoveCurrentConsoleAction;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.ShowStandardErrorAction;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.ShowStandardOutAction;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.ShowWhenContentChangesAction;
import org.eclipse.escriptmonkey.scripting.ui.console.actions.TerminateConsoleAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;

/**
 * Creates and manages JavaScript console specific actions
 * 
 */
public class ScriptConsolePageParticipant implements IConsolePageParticipant, IShowInSource, IShowInTargetList, IDebugContextListener {

    // actions
    private TerminateConsoleAction fTerminate;
    private RemoveCurrentConsoleAction fRemoveTerminated;
    private RemoveAllTerminatedConsolesAction fRemoveAllTerminated;
    private ShowWhenContentChangesAction fStdOut;
    private ShowWhenContentChangesAction fStdErr;

    private ScriptConsole fConsole;

    private IPageBookViewPage fPage;

    private IConsoleView fView;

    private EOFHandler fEOFHandler;
    private final String fContextId = "org.eclipse.debug.ui.console"; //$NON-NLS-1$;
    private IContextActivation fActivatedContext;
    private IHandlerActivation fActivatedHandler;

    /**
     * Handler to send EOF
     */
    private class EOFHandler extends AbstractHandler {
        @Override
        public Object execute(final ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
            IStreamsProxy proxy = getProcess().getStreamsProxy();
            if (proxy instanceof IStreamsProxy2) {
                IStreamsProxy2 proxy2 = (IStreamsProxy2) proxy;
                try {
                    proxy2.closeInputStream();
                } catch (IOException e1) {
                }
            }
            return null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.console.IConsolePageParticipant#init(IPageBookViewPage, IConsole)
     */
    @Override
    public void init(final IPageBookViewPage page, final IConsole console) {
        fPage = page;
        fConsole = (ScriptConsole) console;
        fConsole.setPageParticipant(this);

        fRemoveTerminated = new RemoveCurrentConsoleAction(fConsole);
        fRemoveAllTerminated = new RemoveAllTerminatedConsolesAction();
        fTerminate = new TerminateConsoleAction(page.getSite().getWorkbenchWindow(), fConsole);
        fStdOut = new ShowStandardOutAction(console);
        fStdErr = new ShowStandardErrorAction(console);

        fView = (IConsoleView) fPage.getSite().getPage().findView(IConsoleConstants.ID_CONSOLE_VIEW);

        DebugUITools.getDebugContextManager().getContextService(fPage.getSite().getWorkbenchWindow()).addDebugContextListener(this);

        // contribute to toolbar
        IActionBars actionBars = fPage.getSite().getActionBars();
        configureToolBar(actionBars.getToolBarManager());

        // create handler and submissions for EOF
        fEOFHandler = new EOFHandler();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.console.IConsolePageParticipant#dispose()
     */
    @Override
    public void dispose() {
        fConsole.setPageParticipant(null);

        DebugUITools.getDebugContextManager().getContextService(fPage.getSite().getWorkbenchWindow()).removeDebugContextListener(this);
        fRemoveTerminated = null;
        fRemoveAllTerminated = null;

        if (fTerminate != null) {
            fTerminate.dispose();
            fTerminate = null;
        }
        if (fStdOut != null) {
            fStdOut.dispose();
            fStdOut = null;
        }
        if (fStdErr != null) {
            fStdErr.dispose();
            fStdErr = null;
        }
        fConsole = null;
    }

    /**
     * Contribute actions to the toolbar
     */
    protected void configureToolBar(final IToolBarManager mgr) {
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fTerminate);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fRemoveTerminated);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fRemoveAllTerminated);
        mgr.appendToGroup(IConsoleConstants.OUTPUT_GROUP, fStdOut);
        mgr.appendToGroup(IConsoleConstants.OUTPUT_GROUP, fStdErr);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @Override
    public Object getAdapter(final Class required) {
        if (IShowInSource.class.equals(required)) {
            return this;
        }
        if (IShowInTargetList.class.equals(required)) {
            return this;
        }
        // CONTEXTLAUNCHING
        if (ILaunchConfiguration.class.equals(required)) {
            ILaunch launch = getProcess().getLaunch();
            if (launch != null) {
                return launch.getLaunchConfiguration();
            }
            return null;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.IShowInSource#getShowInContext()
     */
    @Override
    public ShowInContext getShowInContext() {
        IProcess process = getProcess();
        if (process == null) {
            return null;
        }
        IDebugTarget target = (IDebugTarget) process.getAdapter(IDebugTarget.class);
        ISelection selection = null;
        if (target == null) {
            selection = new TreeSelection(new TreePath(new Object[] { DebugPlugin.getDefault().getLaunchManager(), process.getLaunch(), process }));
        } else {
            selection = new TreeSelection(new TreePath(new Object[] { DebugPlugin.getDefault().getLaunchManager(), target.getLaunch(), target }));
        }
        return new ShowInContext(null, selection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.IShowInTargetList#getShowInTargetIds()
     */
    @Override
    public String[] getShowInTargetIds() {
        return new String[] { IDebugUIConstants.ID_DEBUG_VIEW };
    }

    protected IProcess getProcess() {
        // FIXME implement
        // return fConsole != null ? fConsole.getProcess() : null;
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.console.IConsolePageParticipant#activated()
     */
    @Override
    public void activated() {
        // add EOF submissions
        IPageSite site = fPage.getSite();
        if ((fActivatedContext == null) && (fActivatedHandler == null)) {
            IHandlerService handlerService = (IHandlerService) site.getService(IHandlerService.class);
            IContextService contextService = (IContextService) site.getService(IContextService.class);
            fActivatedContext = contextService.activateContext(fContextId);
            fActivatedHandler = handlerService.activateHandler("org.eclipse.debug.ui.commands.eof", fEOFHandler); //$NON-NLS-1$
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.console.IConsolePageParticipant#deactivated()
     */
    @Override
    public void deactivated() {
        // remove EOF submissions
        IPageSite site = fPage.getSite();
        IHandlerService handlerService = (IHandlerService) site.getService(IHandlerService.class);
        IContextService contextService = (IContextService) site.getService(IContextService.class);
        handlerService.deactivateHandler(fActivatedHandler);
        contextService.deactivateContext(fActivatedContext);
        fActivatedContext = null;
        fActivatedHandler = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.internal.ui.contexts.provisional.IDebugContextListener#contextEvent(org.eclipse.debug.internal.ui.contexts.provisional.DebugContextEvent
     * )
     */
    @Override
    public void debugContextChanged(final DebugContextEvent event) {
        if ((event.getFlags() & DebugContextEvent.ACTIVATED) > 0) {
            if ((fView != null) && getProcess().equals(DebugUITools.getCurrentProcess())) {
                fView.display(fConsole);
            }
        }

    }

    public void engineChanged() {
        if (fTerminate != null)
            fTerminate.update();
    }
}