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
package org.eclipse.escriptmonkey.scripting.ui.view;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.escriptmonkey.scripting.IExecutionListener;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngineProvider;
import org.eclipse.escriptmonkey.scripting.IScriptService;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.console.ScriptConsole;
import org.eclipse.escriptmonkey.scripting.ui.dnd.ShellDropTarget;
import org.eclipse.escriptmonkey.scripting.ui.macro.IMacroSupport;
import org.eclipse.escriptmonkey.scripting.ui.macro.MacroContributionFactory;
import org.eclipse.escriptmonkey.scripting.ui.macro.ui.MacroComposite;
import org.eclipse.escriptmonkey.scripting.ui.preferences.PreferenceConstants;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * The JavaScript shell allows to interactively execute JavaScript code.
 */
public class ScriptShell extends ViewPart implements IMacroSupport, IPropertyChangeListener, IScriptEngineProvider, IExecutionListener {

	public static final String VIEW_ID = "org.eclipse.escriptmonkey.views.scriptShell";

	private SashForm sashForm;

	private static final int HISTORY_LENGTH = 30;

	private static final String XML_HISTORY_NODE = "history";

	protected static final int TYPE_ERROR = 1;

	protected static final int TYPE_OUTPUT = 2;

	protected static final int TYPE_RESULT = 3;

	private static final int TYPE_COMMAND = 4;

	private Combo mInputCombo;

	private StyledText mOutputText;

	private boolean mScrollLock = false;

	private boolean mPrintLock = false;

	private LocalResourceManager mResourceManager = null;

	private int[] mSashWeights = new int[]{ 70, 30 };

	private IScriptEngine mScriptEngine;

	private IMemento mInitMemento;

	private ScriptConsole mConsole = null;

	private MacroComposite mMacroComposite;

	static {
		// add dynamic context menu for engine switching
		EngineContributionFactory.addContextMenu();

		// add dynamic context menu for module loading
		ModuleContributionFactory.addContextMenu();
	}

	/**
	 * Default constructor.
	 */
	public ScriptShell() {
		super();

		// setup Script engine
		setEngine("org.eclipse.escriptmonkey.scripting.javascript.rhino");

		// add dynamic context menu for macros
		MacroContributionFactory.addContextMenu("org.eclipse.escriptmonkey.commands.javascript.shell.showMacroManager.popup");

		// FIXME add preferences lookup
		Activator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/**
	 * Configure output streams for RhinoRunner.
	 */
	private void configureOutputStreams() {
		// set stdout/stderr stream
		mScriptEngine.setOutputStream(getConsole().getOutputStream());
		mScriptEngine.setErrorStream(getConsole().getOutputStream());
	}

	/**
	 * Get the JavaScript console for this shell.
	 * 
	 * @return instance of JavaScript console
	 */
	private ScriptConsole getConsole() {
		if(mConsole == null) {
			// create console

			mConsole = ScriptConsole.create(mScriptEngine.getName() + " Script Shell", mScriptEngine);
			mConsole.addPropertyChangeListener(new IPropertyChangeListener() {

				@Override
				public void propertyChange(final PropertyChangeEvent event) {
					if(ScriptConsole.CONSOLE_ACTIVE.equals(event.getProperty())) {
						mConsole = null;
						configureOutputStreams();
					}
				}
			});
		}
		return mConsole;
	}

	@Override
	public final void init(final IViewSite site, final IMemento memento) throws PartInitException {
		super.init(site, memento);

		// cannot restore command history right now, do this in
		// createPartControl()
		mInitMemento = memento;
	}

	@Override
	public final void saveState(final IMemento memento) {
		// save command history
		for(final String item : mInputCombo.getItems())
			memento.createChild(XML_HISTORY_NODE).putTextData(item);

		super.saveState(memento);
	}

	@Override
	public final void createPartControl(final Composite parent) {

		// setup resource manager
		mResourceManager = new LocalResourceManager(JFaceResources.getResources(), parent);

		// setup layout
		parent.setLayout(new GridLayout());

		sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		mOutputText = new StyledText(sashForm, SWT.V_SCROLL | SWT.READ_ONLY | SWT.BORDER);
		mOutputText.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(final KeyEvent e) {
				if((e.keyCode == 'v') && ((e.stateMask & SWT.CONTROL) != 0)) {
					// CTRL-v pressed
					final Clipboard clipboard = new Clipboard(Display.getDefault());
					final Object content = clipboard.getContents(TextTransfer.getInstance());
					if(content != null)
						mInputCombo.setText(mInputCombo.getText() + content.toString());

					mInputCombo.setFocus();
					mInputCombo.setSelection(new Point(mInputCombo.getText().length(), mInputCombo.getText().length()));
				}
			}

			@Override
			public void keyPressed(final KeyEvent e) {
				if(!((e.keyCode == 'c') && ((e.stateMask & SWT.CONTROL) != 0)) && (e.keyCode != SWT.CONTROL)) {
					mInputCombo.setText(mInputCombo.getText() + e.character);
					mInputCombo.setFocus();
					mInputCombo.setSelection(new Point(mInputCombo.getText().length(), mInputCombo.getText().length()));
				}
			}
		});

		// set monospaced font
		final Object os = Platform.getOS();
		if("win32".equals(os))
			mOutputText.setFont(mResourceManager.createFont(FontDescriptor.createFrom("Courier New", 10, SWT.NONE)));

		else if("linux".equals(os))
			mOutputText.setFont(mResourceManager.createFont(FontDescriptor.createFrom("Monospace", 10, SWT.NONE)));

		mOutputText.setEditable(false);

		mMacroComposite = new MacroComposite(this, getSite(), sashForm, SWT.NONE);
		mMacroComposite.setEngine(mScriptEngine.getID());

		sashForm.setWeights(mSashWeights);
		mInputCombo = new Combo(parent, SWT.NONE);
		mInputCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetDefaultSelected(final SelectionEvent e) {
				final String input = mInputCombo.getText();
				mInputCombo.setText("");

				addToHistory(input);
				mScriptEngine.executeAsync(input);
			}
		});

		mInputCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// restore command history
		if(mInitMemento != null) {
			for(final IMemento node : mInitMemento.getChildren(XML_HISTORY_NODE)) {
				if(node.getTextData() != null)
					mInputCombo.add(node.getTextData());
			}
		}

		// clear reference as we are done with initialization
		mInitMemento = null;

		// add DND support
		ShellDropTarget.addDropSupport(mOutputText, this);

		// run startup commands
		final IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(PreferenceConstants.SHELL_BASE);
		final String initCommands = prefs.get(PreferenceConstants.INIT_COMMANDS, "");
		if((initCommands != null) && (!initCommands.isEmpty()))
			mScriptEngine.executeAsync(initCommands);

		// set view title
		setPartName(mScriptEngine.getName() + " " + super.getTitle());
	}

	/**
	 * Add a command to the command history. History is stored in a ring buffer, so old entries will drop out once new entries are added. History will
	 * be
	 * preserved over program sessions.
	 * 
	 * @param input
	 *        command to be stored to history.
	 */
	private void addToHistory(final String input) {
		if(mInputCombo.getSelectionIndex() != -1)
			mInputCombo.remove(mInputCombo.getSelectionIndex());

		else {
			// new element; check if we already have such an element in our
			// history
			for(int index = 0; index < mInputCombo.getItemCount(); index++) {
				if(mInputCombo.getItem(index).equals(input)) {
					mInputCombo.remove(index);
					break;
				}
			}
		}

		// avoid history overflows
		if(mInputCombo.getItemCount() >= HISTORY_LENGTH)
			mInputCombo.remove(mInputCombo.getItemCount() - 1);

		mInputCombo.add(input, 0);
	}

	@Override
	public final void dispose() {
		if(mScriptEngine != null) {
			mScriptEngine.removeExecutionListener(this);
			mScriptEngine.terminate();
		}

		mConsole = null;

		mResourceManager.dispose();

		super.dispose();
	}

	@Override
	public final void setFocus() {
		mInputCombo.setFocus();
	}

	/**
	 * Clear the output text.
	 */
	public final void clearOutput() {
		mOutputText.setText("");
		mOutputText.setStyleRanges(new StyleRange[0]);
	}

	/**
	 * Set/unset the scroll lock feature.
	 * 
	 * @param lock
	 *        true when auto scrolling shall be locked
	 */
	public final void setScrollLock(final boolean lock) {
		mScrollLock = lock;
	}

	/**
	 * Set/unset the print lock feature. When
	 * 
	 * @param lock
	 *        true when printing shall be disabled
	 */
	public final void setPrintLock(final boolean lock) {
		mPrintLock = lock;
	}

	/**
	 * Print to the output pane or to console. Text in the output pane may be formatted in different styles depending on the style flag. Printing is
	 * executed if
	 * printLock is turned off or in case of error output.
	 * 
	 * @param text
	 *        text to print
	 * @param style
	 *        style to use (see JavaScriptShell.STYLE_* constants)
	 */

	private void localPrint(final String message, final int style) {
		if(message != null) {
			if((!mPrintLock) || (style == TYPE_ERROR)) {
				// // print to output pane
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						String out = message;
						if(style != TYPE_COMMAND)
							// indent message
							out = "\t" + message.replaceAll("\\r?\\n", "\n\t");

						mOutputText.append("\n");

						// create new style range
						final StyleRange styleRange = getStyle(style, mOutputText.getText().length(), out.length());

						mOutputText.append(out);
						mOutputText.setStyleRange(styleRange);

						// scroll to end of window
						if(!mScrollLock) {
							mOutputText.setHorizontalPixel(0);
							mOutputText.setTopPixel(mOutputText.getLineHeight() * mOutputText.getLineCount());
						}
					}
				});
			}
		}
	}

	/**
	 * 
	 * @param style
	 *        style to use (see JavaScriptShell.STYLE_* constants)
	 * @param start
	 *        start of text to be styled
	 * @param length
	 *        length of text to be styled
	 * @return StyleRange for text
	 */
	private StyleRange getStyle(final int style, final int start, final int length) {

		final StyleRange styleRange = new StyleRange();
		styleRange.start = start;
		styleRange.length = length;

		switch(style) {
		case TYPE_RESULT:
			styleRange.foreground = mResourceManager.createColor(ColorDescriptor.createFrom(getViewSite().getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY)));
			break;

		case TYPE_COMMAND:
			styleRange.foreground = mResourceManager.createColor(ColorDescriptor.createFrom(getViewSite().getShell().getDisplay().getSystemColor(SWT.COLOR_BLUE)));
			styleRange.fontStyle = SWT.BOLD;
			break;

		case TYPE_ERROR:
			styleRange.foreground = mResourceManager.createColor(ColorDescriptor.createFrom(getViewSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED)));
			styleRange.fontStyle = SWT.ITALIC;
			break;

		case TYPE_OUTPUT:
			styleRange.foreground = mResourceManager.createColor(ColorDescriptor.createFrom(getViewSite().getShell().getDisplay().getSystemColor(SWT.COLOR_BLACK)));
			break;

		default:
			break;
		}

		return styleRange;
	}

	/**
	 * Get the text selected in the output pane. if no text is selected, the whole content will be returned.
	 * 
	 * @return selected text of output pane
	 */
	public final String getSelectedText() {
		final String text = mOutputText.getSelectionText();
		if(text.isEmpty())
			return mOutputText.getText();

		return text;
	}

	@Override
	public final void toggleMacroManager() {
		if(sashForm.getWeights()[1] == 0)
			sashForm.setWeights(mSashWeights);

		else {
			mSashWeights = sashForm.getWeights();
			sashForm.setWeights(new int[]{ 100, 0 });
		}
	}

	@Override
	public final void propertyChange(final PropertyChangeEvent event) {
		// a preference property changed, do we need to adjust output paths?

		// FIXME does not work as it is accessed by an external thread
		// configureOutputStreams();
	}

	public StyledText getOutput() {
		return mOutputText;
	}

	public void stopScriptEngine() {
		mScriptEngine.terminateCurrent();
	}

	@Override
	public IScriptEngine getScriptEngine() {
		return mScriptEngine;
	}

	@Override
	public void notify(final IScriptEngine engine, final Script script, final int status) {

		try {
			if(status == IExecutionListener.SCRIPT_START)
				localPrint(script.getCode(), TYPE_COMMAND);
			else if(script.getResult().hasException())
				localPrint(script.getResult().getException().getLocalizedMessage(), TYPE_ERROR);
			else {
				final Object result = script.getResult().getResult();
				if(result != null)
					localPrint(script.getResult().getResult().toString(), TYPE_RESULT);
			}

		} catch (final Exception e) {
		}
	}

	public void setEngine(final String id) {
		if(mScriptEngine != null) {
			mScriptEngine.removeExecutionListener(this);
			mScriptEngine.terminate();
		}

		final IScriptService scriptService = (IScriptService)PlatformUI.getWorkbench().getService(IScriptService.class);
		mScriptEngine = scriptService.createEngineByID(id);
		mScriptEngine.setTerminateOnIdle(false);

		configureOutputStreams();
		getConsole().setScriptEngine(mScriptEngine);

		mScriptEngine.schedule();

		// set view title
		setPartName(mScriptEngine.getName() + " Script Shell");

		// register at script engine
		mScriptEngine.addExecutionListener(this);

		if(mMacroComposite != null)
			mMacroComposite.setEngine(mScriptEngine.getID());
	}
}
