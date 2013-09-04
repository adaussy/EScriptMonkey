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
package org.eclipse.escriptmonkey.scripting.ui.macro;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.escriptmonkey.scripting.ui.macro.ui.MacroEditorInput;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * A macro contains a short script of reproducible steps. Generally this is any kind of text data.
 */
public class Macro {

    /**
     * Delimiter for macro names. Using delimiters will create a folder-like structure.
     */
    public static final String NAME_DELIMITER = "/";

    /**
     * name of this macro.
     */
    private final String mName;

    /**
     * macro content.
     */
    private String mContent;

    private final boolean mSaveable;

    private final String mEngine;

    /**
     * Macro constructor.
     * 
     * @param name
     *            fully qualified name of the macro (including path info)
     * @param content
     *            macro content
     * @param saveable
     *            indicator if macro should be stored permanently
     */
    public Macro(final String name, final String engine, final String content, final boolean saveable) {
        mName = name;
        mEngine = engine;
        mSaveable = saveable;
        setContent(content);
    }

    /**
     * Macro constructor.
     * 
     * @param name
     *            fully qualified name of the macro (including path info)
     * @param content
     *            macro content
     */
    public Macro(final String name, final String engine, final String content) {
        this(name, engine, content, true);
    }

    /**
     * Get the name of this macro. Includes full path information.
     * 
     * @return full qualified name of this macro
     * @see #getBaseName()
     */
    public final String getName() {
        return mName;
    }

    public boolean isSaveable() {
        return mSaveable;
    }

    /**
     * Get the base name of this macro. Path info is stripped from the name
     * 
     * @return name of this macro
     * @see #getName()
     */
    public final String getBaseName() {
        final int pos = getName().lastIndexOf(NAME_DELIMITER);
        if (pos != -1)
            return getName().substring(pos + NAME_DELIMITER.length());

        return getName();
    }

    /**
     * Get macro content.
     * 
     * @return macro content
     */
    public final String getContent() {
        return mContent;
    }

    /**
     * Set the macro content.
     * 
     * @param content
     *            content of macro
     */
    public final void setContent(final String content) {
        mContent = content;
    }

    /**
     * Open JavaScript editor as a macro content editor.
     */
    public final void edit() {
        final IEditorDescriptor editorDescriptor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor("foo.js");

        final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final IEditorInput editorInput = new MacroEditorInput(this);

        try {
            final IEditorPart editor = page.openEditor(editorInput, editorDescriptor.getId(), true);
            editor.addPropertyListener(new IPropertyListener() {
                @Override
                public void propertyChanged(final Object source, final int propId) {

                    // check for changes of PROP_DIRTY from true to false,
                    // meaning the editor saved the String
                    if (IEditorPart.PROP_DIRTY == propId) {
                        if ((editor instanceof AbstractDecoratedTextEditor) && (!editor.isDirty())) {
                            final IDocumentProvider documentProvider = ((AbstractTextEditor) editor).getDocumentProvider();
                            final String newSource = documentProvider.getDocument(editorInput).get();
                            setContent(newSource);
                            save();
                        }
                    }
                }
            });
        } catch (final PartInitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Get the path this macro is stored to. The path is created by separating the full macro name into chunks separated by "/". The path does not contain the
     * macro name (last part of full macro name).
     * 
     * @return macro path
     */
    public final IPath getPath() {
        final Path path = new Path(getName());

        if (path.segmentCount() > 1)
            return path.removeLastSegments(1);

        return new Path("");
    }

    @Override
    public final String toString() {
        return getBaseName();
    }

    private void save() {
        // FIXME implement
    }

    public String getEngine() {
        return mEngine;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((mName == null) ? 0 : mName.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Macro other = (Macro) obj;
        if (mName == null) {
            if (other.mName != null)
                return false;
        } else if (!mName.equals(other.mName))
            return false;
        return true;
    }
}
