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
package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.escriptmonkey.scripting.debugging.DynamicContentEditorInput;
import org.eclipse.escriptmonkey.scripting.debugging.ScriptDebugStackFrame;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.part.FileEditorInput;

public class RhinoDebugModelPresentation implements IDebugModelPresentation {

	@Override
	public void setAttribute(final String attribute, final Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getText(final Object element) {
		if(element instanceof ScriptDebugStackFrame) {
			// FIXME  ScriptDebugStackFrame.getName needs refactoring
			return ((ScriptDebugStackFrame)element).getDebugFrame().getName();
		}

		return null;
	}

	@Override
	public void computeDetail(final IValue value, final IValueDetailListener listener) {
		Object adapter = value.getAdapter(String.class);
		if(adapter instanceof String)
			listener.detailComputed(value, (String)adapter);
	}

	@Override
	public void addListener(final ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(final ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEditorInput getEditorInput(final Object element) {
		if(element instanceof Script) {
			final Object file = ((Script)element).getFile();
			if(file instanceof IFile)
				return new FileEditorInput((IFile)file);

			else
				return new DynamicContentEditorInput((Script)element);
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEditorId(final IEditorInput input, final Object element) {
		if(element instanceof Script) {
			final Object file = ((Script)element).getFile();
			IEditorDescriptor editor;

			if(file instanceof IFile)
				// try to find native editor
				editor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(((IFile)file).getName());
			else
				// use JS default editor
				editor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor("foo.js");

			if(editor != null)
				return editor.getId();

			// use default text editor
			editor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(EditorsUI.DEFAULT_TEXT_EDITOR_ID);
			if(editor != null)
				return editor.getId();

			// use system default editor
			return IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID;

		}

		return null;
	}

	@Override
	public Image getImage(final Object element) {

		return null;
	}
}
