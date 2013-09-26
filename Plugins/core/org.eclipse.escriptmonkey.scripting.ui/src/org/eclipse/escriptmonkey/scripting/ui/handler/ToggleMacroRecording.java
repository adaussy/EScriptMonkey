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
package org.eclipse.escriptmonkey.scripting.ui.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.escriptmonkey.scripting.IExecutionListener;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.IScriptEngineProvider;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.escriptmonkey.scripting.ui.tools.StringTools;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

/**
 * Toggle macro recording command. Start/stop macro recording.
 */
public class ToggleMacroRecording extends ToggleHandler implements IHandler, IElementUpdater, IExecutionListener {

	private boolean mChecked = false;

	private static final Map<Object, StringBuffer> mRecordings = new HashMap<Object, StringBuffer>();

	@Override
	protected final void executeToggle(final ExecutionEvent event, final boolean checked) {
		final IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if(part instanceof IScriptEngineProvider) {
			final IScriptEngine engine = ((IScriptEngineProvider)part).getScriptEngine();
			if(engine != null) {
				if(checked) {
					// start recording, eventually overrides a running recording of the same provider
					mRecordings.put(engine, new StringBuffer());
					engine.addExecutionListener(this);
				} else {
					// stop recording
					final StringBuffer buffer = mRecordings.get(engine);
					if(buffer.length() > 0) {
						final InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event), "Save Macro", "Enter a unique name for your macro (use '/' as path delimiter)", "", new IInputValidator() {

							@Override
							public String isValid(final String name) {
								if(name.indexOf(';') >= 0)
									return "Invalid character ';' detected in macro name";

								final IMacroService macroService = (IMacroService)PlatformUI.getWorkbench().getService(IMacroService.class);
								if(macroService == null)
									return "Cannot store macro, Macro service unavailable";

								if(macroService.getMacro(name) != null)
									return "Macro name <" + name + "> already in use. Choose a different one.";

								return null;
							}
						});

						if(dialog.open() == Window.OK) {
							final IMacroService macroService = (IMacroService)PlatformUI.getWorkbench().getService(IMacroService.class);

							if(macroService != null)
								macroService.addMacro(dialog.getValue(), engine, buffer.toString());
						}
					}
				}
			}
		}

		mChecked = checked;
	}

	@Override
	public final void updateElement(final UIElement element, @SuppressWarnings("rawtypes") final Map parameters) {
		super.updateElement(element, parameters);

		if(mChecked)
			element.setIcon(Activator.getImageDescriptor(Activator.PLUGIN_ID, "/images/stop_record_macro.gif"));

		else
			element.setIcon(Activator.getImageDescriptor(Activator.PLUGIN_ID, "/images/start_record_macro.gif"));
	}

	@Override
	public void notify(final IScriptEngine engine, final Script script, final int status) {
		if(IExecutionListener.SCRIPT_END == status) {
			try {
				final StringBuffer buffer = mRecordings.get(engine);
				if(buffer != null) {
					// TODO add support to add trailing returns and ;
					buffer.append(script.getCode());
					buffer.append(StringTools.LINE_DELIMITER);
				} else
					engine.removeExecutionListener(this);

			} catch (final FileNotFoundException e) {
				// cannot record / execute macro when file is not found
			} catch (final CoreException e) {
				// cannot record / execute macro when file is not found
			} catch (final IOException e) {
				// cannot extract string from getCode()
			} catch (final Exception e) {
				// TODO handle this exception (but for now, at least know it happened)
				throw new RuntimeException(e);
			}
		}
	}
}
