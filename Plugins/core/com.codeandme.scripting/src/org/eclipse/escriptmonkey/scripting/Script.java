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
package org.eclipse.escriptmonkey.scripting;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;

/**
 * Scriptable object. Consists of scriptable data and a result container.
 */
public class Script {
    /** command to be executed. */
    private final Object mCommand;

    /** script result returned from command. */
    private final ScriptResult mResult;

    /**
     * Constructor.
     * 
     * @param command
     *            command (sequence) to be executed
     */
    public Script(final Object command) {
        mCommand = command;
        mResult = new ScriptResult();
    }

    /**
     * Get the scriptable data.
     * 
     * @return scriptable data
     * @throws CoreException
     * @throws FileNotFoundException
     */
    public InputStream getCode() throws Exception {
        if (mCommand instanceof String)
            return new ByteArrayInputStream(((String) mCommand).getBytes());

        if (mCommand instanceof InputStream)
            return (InputStream) mCommand;

        // if we already have a scriptable
        if (mCommand instanceof IScriptable)
            return ((IScriptable) mCommand).getSourceCode();

        // try to adapt to scriptable
        Object scriptable = Platform.getAdapterManager().getAdapter(mCommand, IScriptable.class);
        if (scriptable != null)
            return ((IScriptable) scriptable).getSourceCode();

        // last resort, convert to String
        if (mCommand != null)
            return new ByteArrayInputStream(mCommand.toString().getBytes());

        return null;
    }

    public final Object getCommand() {
        return mCommand;
    }

    /**
     * Get execution result.
     * 
     * @return execution result.
     */
    public final ScriptResult getResult() {
        return mResult;
    }

    /**
     * Set the execution result.
     * 
     * @param result
     *            execution result
     */
    public final void setResult(final Object result) {
        mResult.setResult(result);

        // gracefully close input streams & readers
        if (mCommand instanceof InputStream) {
            try {
                ((InputStream) mCommand).close();
            } catch (IOException e) {
            }

        } else if (mCommand instanceof Reader) {
            try {
                ((Reader) mCommand).close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * Set an execution exception.
     * 
     * @param e
     *            exception
     */
    public final void setException(final Exception e) {
        mResult.setException(e);

        // gracefully close input streams & readers
        if (mCommand instanceof InputStream) {
            try {
                ((InputStream) mCommand).close();
            } catch (IOException ex) {
            }

        } else if (mCommand instanceof Reader) {
            try {
                ((Reader) mCommand).close();
            } catch (IOException ex) {
            }
        }
    }

    public Object getFile() {
        if ((mCommand instanceof IFile) || (mCommand instanceof File))
            return mCommand;

        return null;
    }
}
