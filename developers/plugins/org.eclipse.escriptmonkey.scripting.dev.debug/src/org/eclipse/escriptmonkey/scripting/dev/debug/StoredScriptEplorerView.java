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
package org.eclipse.escriptmonkey.scripting.dev.debug;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.escriptmonkey.scripting.storedscript.service.IStoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.service.impl.IStoredScriptServiceInternal;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.ui.actions.EditScriptAction;
import org.eclipse.escriptmonkey.scripting.ui.actions.RunScriptAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;


public class StoredScriptEplorerView extends ViewPart {

	public static final String ID = "org.eclipse.escriptmonkey.scripting.ui.view.ScriptEplorerView"; //$NON-NLS-1$

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private TreeViewer treeViewer;

	private RunScriptAction playScriptAction;

	private EditScriptAction editScriptAction;

	public StoredScriptEplorerView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			treeViewer = new TreeViewer(container, SWT.BORDER);
			Tree tree = treeViewer.getTree();
			toolkit.paintBordersFor(tree);
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

			treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			treeViewer.setInput(((IStoredScriptServiceInternal)IStoredScriptService.INSTANCE).getRegistry());
			treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					IStoredScript storedScript = getStoredScriptFromSelection(event);
					if(storedScript != null) {
						playScriptAction.setScript(storedScript);
						playScriptAction.setEnabled(true);
						editScriptAction.setEnabled(true);
						editScriptAction.setScript(storedScript);
					} else {
						playScriptAction.setScript(null);
						playScriptAction.setEnabled(false);
						editScriptAction.setEnabled(false);
						editScriptAction.setScript(null);
					}

				}
			});
			treeViewer.addDoubleClickListener(new IDoubleClickListener() {

				@Override
				public void doubleClick(DoubleClickEvent event) {
					IStoredScript script = getStoredScriptFromSelection(event);
					if(script != null) {
						RunScriptAction action = new RunScriptAction("Run script");
						action.setScript(script);
						action.setEnabled(true);
						action.run();
					}

				}
			});
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	private IStoredScript getStoredScriptFromSelection(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection select = (IStructuredSelection)selection;
			Object first = select.getFirstElement();
			if(first instanceof IStoredScript) {
				IStoredScript storeScript = (IStoredScript)first;
				return storeScript;
			}
		}
		return null;
	}

	private IStoredScript getStoredScriptFromSelection(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection select = (IStructuredSelection)selection;
			Object first = select.getFirstElement();
			if(first instanceof IStoredScript) {
				IStoredScript storeScript = (IStoredScript)first;
				return storeScript;
			}
		}
		return null;
	}



	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			playScriptAction = new RunScriptAction("PlayScript");
			playScriptAction.setEnabled(false);
			playScriptAction.setDisabledImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "images/start_script_disable.gif"));
			playScriptAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "images/start_script.gif"));
		}
		{
			editScriptAction = new EditScriptAction("Edit Script");
			editScriptAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "images/editor.gif"));
			editScriptAction.setEnabled(false);
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(playScriptAction);
		tbm.add(editScriptAction);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
