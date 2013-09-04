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
package org.eclipse.escriptmonkey.scripting.ui.macro.ui;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

/**
 * Editor input for JavaScript code not stored in a local file. Takes input from a {@link Macro} and prepares it to be passed to the JavaScript editor.
 */
public class MacroEditorInput implements IStorageEditorInput {

    private final Macro mMacro;

    /**
     * Constructor. Takes text from macro.
     * 
     * @param macro
     *            macro to extract text from
     */
    public MacroEditorInput(final Macro macro) {
        mMacro = macro;
    }

    @Override
    public final boolean equals(final Object other) {
        return (other instanceof MacroEditorInput) && mMacro.equals(((MacroEditorInput) other).mMacro);
    }

    @Override
    public final Object getAdapter(final Class adapter) {
        return null;
    }

    @Override
    public final IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public final boolean exists() {
        return true;
    }

    @Override
    public final IStorage getStorage() {
        return new IStorage() {
            @Override
            public Object getAdapter(final Class adapter) {
                return null;
            }

            @Override
            public boolean isReadOnly() {
                return false;
            }

            @Override
            public String getName() {
                return MacroEditorInput.this.getName();
            }

            @Override
            public IPath getFullPath() {
                return null;
            }

            @Override
            public InputStream getContents() throws CoreException {
                return new StringBufferInputStream(mMacro.getContent());
            }
        };
    }

    @Override
    public final ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public final String getName() {
        return "Macro: " + mMacro.getName();
    }

    @Override
    public final String getToolTipText() {
        return "Macro editor";
    }
}
