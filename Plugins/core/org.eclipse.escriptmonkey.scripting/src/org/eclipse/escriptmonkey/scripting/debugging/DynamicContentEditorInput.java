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
package org.eclipse.escriptmonkey.scripting.debugging;

import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.escriptmonkey.scripting.Script;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

/**
 * Editor input for dynamic script code not stored in a local file. Takes text input and prepares it to be passed to the Script editor.
 */
public class DynamicContentEditorInput implements IStorageEditorInput {

	private final Script mScript;

	/**
	 * Constructor. Takes text from a script.
	 * 
	 * @param script
	 *        script to extract text from
	 */
	public DynamicContentEditorInput(final Script script) {
		mScript = script;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((mScript == null) ? 0 : mScript.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		final DynamicContentEditorInput other = (DynamicContentEditorInput)obj;
		if(mScript == null) {
			if(other.mScript != null)
				return false;
		} else if(!mScript.equals(other.mScript))
			return false;
		return true;
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
		return false;
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
				return true;
			}

			@Override
			public String getName() {
				return DynamicContentEditorInput.this.getName();
			}

			@Override
			public IPath getFullPath() {
				return null;
			}

			@Override
			public InputStream getContents() throws CoreException {
				try {
					return mScript.getCodeStream();
				} catch (final Exception e) {
					// FIXME implement error handling
					throw new RuntimeException("not handled right now", e);
				}
			}
		};
	}

	@Override
	public final ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public final String getName() {
		return (mScript.getTitle() != null) ? mScript.getTitle() : "(dynamic script content)";
	}

	@Override
	public final String getToolTipText() {
		return "Script Editor";
	}
}
