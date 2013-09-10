package org.eclipse.escriptmonkey.scripting.ui.view;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.escriptmonkey.scripting.ui.ScriptGraphService;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;


public class ScriptEplorerView extends ViewPart {

	public static final String ID = "org.eclipse.escriptmonkey.scripting.ui.view.ScriptEplorerView"; //$NON-NLS-1$

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private TreeViewer treeViewer;

	public ScriptEplorerView() {
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
			treeViewer.setInput(ScriptGraphService.getInstance().getScriptGraph());
		}

		createActions();
		initializeToolBar();
		initializeMenu();
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
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
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
