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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.ui.PlatformUI;

public class MacroURLConnection extends URLConnection {

    private final Macro mMacro;

    public MacroURLConnection(final URL url, final Macro macro) {
        super(url);
        mMacro = macro;
    }

    @Override
    public void connect() throws IOException {
    }

    @Override
    public InputStream getInputStream() throws IOException {
        IMacroService macroService = (IMacroService) PlatformUI.getWorkbench().getService(IMacroService.class);

        if (macroService != null)
            return new ByteArrayInputStream(mMacro.getContent().getBytes());

        throw new IOException("Cannot read from macro");
    }
}
