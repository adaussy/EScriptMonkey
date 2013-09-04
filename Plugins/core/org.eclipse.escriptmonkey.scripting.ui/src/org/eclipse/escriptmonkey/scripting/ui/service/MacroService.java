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
package org.eclipse.escriptmonkey.scripting.ui.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.escriptmonkey.scripting.IScriptEngine;
import org.eclipse.escriptmonkey.scripting.ui.Activator;
import org.eclipse.escriptmonkey.scripting.ui.IMacroService;
import org.eclipse.escriptmonkey.scripting.ui.macro.IMacroListener;
import org.eclipse.escriptmonkey.scripting.ui.macro.Macro;
import org.eclipse.escriptmonkey.scripting.ui.tools.StringTools;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.w3c.dom.DOMException;

public class MacroService implements IMacroService {

    private static final String MACRO_EXTENSION = ".macro";
    private static final String XML_NODE_NAME = "name";
    private static final String XML_NODE_ENGINE = "engine";
    private static final String XML_ROOT = "config";
    private static MacroService mInstance = null;

    /** Listeners for macro events. */
    private final ListenerList mListeners = new ListenerList();

    public static MacroService getInstance() {
        if (mInstance == null)
            mInstance = new MacroService();

        return mInstance;
    }

    private final HashSet<Macro> mMacros = new HashSet<Macro>();

    private MacroService() {
        IPath location = Activator.getDefault().getStateLocation();
        File file = location.toFile();
        if (file.isDirectory()) {
            File[] macros = file.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(final File dir, final String name) {
                    return name.toLowerCase().endsWith(MACRO_EXTENSION);
                }
            });

            for (File source : macros) {
                // load macro
                try {
                    FileInputStream inputStream = new FileInputStream(source);
                    String data = StringTools.toString(inputStream);

                    String attributes = data.substring(2, data.indexOf('\n')).trim();
                    XMLMemento memento = XMLMemento.createReadRoot(new StringReader(attributes));

                    String name = memento.getChild(XML_NODE_NAME).getTextData();
                    String engine = memento.getChild(XML_NODE_ENGINE).getTextData();

                    Macro macro = new Macro(name, engine, data.substring(data.indexOf('\n') + 1));
                    addMacro(macro, false);

                } catch (FileNotFoundException e) {
                    // TODO handle this exception (but for now, at least know it happened)
                    throw new RuntimeException(e);
                } catch (WorkbenchException e) {
                    // TODO handle this exception (but for now, at least know it happened)
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    // TODO handle this exception (but for now, at least know it happened)
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void addMacro(final Macro macro, final boolean save) {
        mMacros.add(macro);

        if (save)
            saveMacro(macro);

        // inform listeners
        fireEvent(IMacroListener.ADD_MACRO, macro);
    }

    private void saveMacro(final Macro macro) {
        IPath location = Activator.getDefault().getStateLocation();
        File file = location.toFile();
        if (file.isDirectory()) {
            File macroFile = new File(file, toSaveName(macro.getName() + MACRO_EXTENSION));
            try {
                FileWriter writer = new FileWriter(macroFile);

                XMLMemento memento = XMLMemento.createWriteRoot(XML_ROOT);
                memento.createChild(XML_NODE_NAME).putTextData(macro.getName());
                memento.createChild(XML_NODE_ENGINE).putTextData(macro.getEngine());
                writer.write("// ");
                writer.write(memento.toString().replaceAll("\\r?\\n", ""));
                writer.write(StringTools.LINE_DELIMITER);

                writer.write(macro.getContent());
                writer.close();

            } catch (DOMException e) {
                // TODO handle this exception (but for now, at least know it happened)
                throw new RuntimeException(e);
            } catch (IOException e) {
                // TODO handle this exception (but for now, at least know it happened)
                throw new RuntimeException(e);
            }
        }
    }

    private static String toSaveName(final String identifier) {
        return identifier.replaceAll("/", "_");
    }

    @Override
    public boolean removeMacro(final String macroID) {
        Macro macro = getMacro(macroID);
        if (macro != null) {
            // inform listeners
            fireEvent(IMacroListener.DELETE_MACRO, macro);

            return mMacros.remove(macro);
        }

        return false;
    }

    @Override
    public Macro getMacro(final String macroID) {
        for (Macro macro : getMacros()) {
            if (macro.getName().equals(macroID))
                return macro;
        }

        return null;
    }

    @Override
    public void addMacroListener(final IMacroListener listener) {
        mListeners.add(listener);
    }

    @Override
    public void removeMacroListener(final IMacroListener listener) {
        mListeners.remove(listener);
    }

    @Override
    public Collection<Macro> getMacros() {
        return Collections.unmodifiableCollection(mMacros);
    }

    /**
     * Fire a macro event. Events are listed in IMacroListener.
     * 
     * @param event
     *            event identifier
     * @param macro
     *            affected macro
     */
    private void fireEvent(final int event, final Macro macro) {
        for (final Object listener : mListeners.getListeners()) {
            ((IMacroListener) listener).notify(event, macro);
        }
    }

    @Override
    public void addMacro(final String name, final IScriptEngine engine, final String content) {
        addMacro(new Macro(name, engine.getID(), content), true);
    }
}