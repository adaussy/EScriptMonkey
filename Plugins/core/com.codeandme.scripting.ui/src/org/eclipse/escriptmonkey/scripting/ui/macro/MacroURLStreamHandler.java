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

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.url.AbstractURLStreamHandlerService;

public class MacroURLStreamHandler extends AbstractURLStreamHandlerService {

    public MacroURLStreamHandler() {
    }

    @Override
    public URLConnection openConnection(final URL u) throws IOException {
        IMacroService macroService = (IMacroService) PlatformUI.getWorkbench().getService(IMacroService.class);
        if (macroService != null) {
            Macro macro = macroService.getMacro(u.getHost() + u.getFile());

            if (macro != null)
                return new MacroURLConnection(u, macro);

            throw new IOException("\"" + u.toString() + "\" not found");
        }

        u.getPath();
        // TODO Auto-generated method stub
        return null;
    }

}
