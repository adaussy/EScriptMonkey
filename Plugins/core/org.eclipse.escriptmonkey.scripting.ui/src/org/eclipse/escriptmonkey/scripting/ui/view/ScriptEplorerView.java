package org.eclipse.escriptmonkey.scripting.ui.view;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.ui.ScriptGraphService;
import org.eclipse.escriptmonkey.scripting.ui.actions.EditScriptAction;
import org.eclipse.escriptmonkey.scripting.ui.actions.RefreshStoredScriptAction;
import org.eclipse.escriptmonkey.scripting.ui.actions.RunScriptAction;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Node;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.provider.ScriptCellLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;


public class ScriptEplorerView extends ViewPart {

	public static final String ID = "org.eclipse.escriptmonkey.scripting.ui.view.ScriptEplorerView"; //$NON-NLS-1$

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private TreeViewer treeViewer;

	private RunScriptAction playScriptAction;

	private RefreshStoredScriptAction refreshStoreAction;

	private EditScriptAction editScriptAction;

	private Action expandAllAction;

	private Action collapseAll;

	public ScriptEplorerView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		{
			PatternFilter patternFilter = new PatternFilter();
			//Composite, int, PatternFilter, boolean
			final FilteredTree filter = new FilteredTree(parent, SWT.NONE, patternFilter, true);
			//			viewer = ;
			treeViewer = filter.getViewer();
			ColumnViewerToolTipSupport.enableFor(treeViewer);
			Tree tree = treeViewer.getTree();
			toolkit.paintBordersFor(tree);
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

			treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			treeViewer.setLabelProvider(new ScriptCellLabelProvider());
			treeViewer.setInput(ScriptGraphService.getInstance().getScriptGraph());
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
		treeViewer.setComparator(new ViewerComparator() {

			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if(e1 instanceof Node && e2 instanceof Node) {
					return ((Node)e1).getName().compareTo(((Node)e2).getName());
				}
				return super.compare(viewer, e1, e2);
			}
		});

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	private IStoredScript getStoredScriptFromSelection(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection select = (IStructuredSelection)selection;
			Object first = select.getFirstElement();
			if(first instanceof StoredScriptUI) {
				StoredScriptUI storeScriptUI = (StoredScriptUI)first;
				IStoredScript storedScrip = storeScriptUI.getScript();
				if(storedScrip != null) {
					return storedScrip;
				}
			}
		}
		return null;
	}

	private IStoredScript getStoredScriptFromSelection(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection select = (IStructuredSelection)selection;
			Object first = select.getFirstElement();
			if(first instanceof StoredScriptUI) {
				StoredScriptUI storeScriptUI = (StoredScriptUI)first;
				IStoredScript storedScrip = storeScriptUI.getScript();
				if(storedScrip != null) {
					return storedScrip;
				}
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
		{
			refreshStoreAction = new RefreshStoredScriptAction("Edit Script");
			refreshStoreAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "images/refresh.gif"));
			refreshStoreAction.setEnabled(true);
		}
		{
			expandAllAction = new Action("Expand ALl") {

				@Override
				public void run() {
					treeViewer.expandAll();
					super.run();
				}
			};
			expandAllAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "icons/full/obj16/expandall.gif"));
		}
		{
			collapseAll = new Action("Collapse All") {

				@Override
				public void run() {
					treeViewer.collapseAll();
					super.run();
				}
			};
			collapseAll.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.escriptmonkey.scripting.ui", "icons/full/obj16/collapseall-1.gif"));
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(expandAllAction);
		tbm.add(collapseAll);
		tbm.add(playScriptAction);
		tbm.add(editScriptAction);
		tbm.add(refreshStoreAction);

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
