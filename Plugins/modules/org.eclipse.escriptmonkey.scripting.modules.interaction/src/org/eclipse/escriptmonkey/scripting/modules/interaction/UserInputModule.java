/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.modules.interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

public class UserInputModule extends AbstractScriptModule {

	/**
	 * Opens a simple dialog box to ask the user a simple string.
	 * 
	 * @param title
	 *        the title of the dialog box
	 * @param message
	 *        the message for the dialog box
	 * @param defaultValue
	 *        the default value, used as an initial value
	 * @return the text entered by the user, or <code>null</code> if the dialog box was canceled
	 */
	@WrapToScript
	public String askSimpleString(String title, String message, String defaultValue) {
		InputDialog dlg = new InputDialog(getShell(), title, message, defaultValue, null);
		int result = dlg.open();
		if(result == InputDialog.OK) {
			return dlg.getValue();
		} else {
			return null;
		}
	}

	/**
	 * Opens a simple dialog box to ask the user a simple string with an empty default value.
	 * 
	 * @param title
	 *        the title of the dialog box
	 * @param message
	 *        the message for the dialog box
	 * @return the text entered by the user, or <code>null</code> if the dialog box was canceled
	 */
	@WrapToScript
	public String askSimpleString(String title, String message) {
		return askSimpleString(title, message, "");
	}

	/**
	 * Opens a simple dialog box to ask the user a simple string with an empty default value and default dialog title.
	 * 
	 * @param message
	 *        the message for the dialog box
	 * @return the text entered by the user, or <code>null</code> if the dialog box was canceled
	 */
	@WrapToScript
	public String askSimpleString(String message) {
		return askSimpleString("Script input", message, "");
	}

	/**
	 * Opens a simple dialog box to ask the user a simple string with an empty default value and default dialog title.
	 * 
	 * @param message
	 *        the message for the dialog box
	 * @return the text entered by the user, or <code>null</code> if the dialog box was canceled
	 */
	@WrapToScript
	public String ask(String message) {
		return askSimpleString(message);
	}

	/**
	 * Opens a dialog box to ask a confirmation to the user (e.g. before a destructive or expensive operation).
	 * 
	 * @param title
	 *        the title of the dialog box
	 * @param question
	 *        the question to ask confirmation for
	 * @return <code>true</code> if the user confirmed the question (agreed), <code>false</code> otherwise.
	 */
	@WrapToScript
	public boolean askConfirmation(String title, String question) {
		return MessageDialog.openConfirm(getShell(), title, question);
	}

	/**
	 * Opens a dialog box to ask a simple Yes/No question to the user.
	 * 
	 * @param title
	 *        the title of the dialog box.
	 * @param question
	 *        the question to ask.
	 * @return <code>true</code> if the user answers "Yes", <code>false</code> otherwise.
	 */
	@WrapToScript
	public boolean askQuestion(String title, String question) {
		return MessageDialog.openQuestion(getShell(), title, question);
	}

	/**
	 * Opens a dialog box which allows the user to select a container (project or folder) in the workspace.
	 * 
	 * @param title
	 *        the title to use for the dialog box
	 * @param message
	 *        a message to show in the dialog box
	 * @return
	 */
	@WrapToScript
	public Object selectContainer(String title, String message) {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), null, true, title);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.open();
		Object[] result = dialog.getResult();
		return result;
	}

	/**
	 * Opens a dialog but which allows the user to select a resource from the workspace.
	 * 
	 * @param title
	 *        the title of the dialog box
	 * @param message
	 *        a message to show in the dialog box
	 * @return
	 */
	@WrapToScript
	public Object selectResource(String title, String message) {
		ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), message);
		dialog.setTitle(title);
		dialog.open();
		return dialog.getResult();
	}

	/**
	 * Opens a dialog but which allows the user to select a resource from the workspace with a default title and
	 * message.
	 * 
	 * @return
	 */
	@WrapToScript
	public Object selectResource() {
		return selectResource("Resource selection", "Choose a resource:");
	}

	/**
	 * Reads the contents of a text file from the workspace into a string.
	 * 
	 * @param loc
	 *        the location of the text file to read, which must be in the workspace. It can be a string (workspace
	 *        relative path), an Eclipse IFile object (obtained from an Eclipse API), or an array containing one of
	 *        those (as returned by {@link #selectResource()} for example).
	 * 
	 * @return the contents of the text file, or <code>null</code> if it could not be read.
	 */
	@WrapToScript
	public String readFile(Object loc) {
		if(loc instanceof Object[]) {
			if(((Object[])loc).length == 1) {
				return readFile(((Object[])loc)[0]);
			} else {
				return null;
			}
		} else if(loc instanceof IFile) {
			return readFile((IFile)loc);
		} else if(loc instanceof String) {
			return readFile((String)loc);
		} else {
			return null;
		}
	}

	/**
	 * Reads the contents of a text file into a string.
	 * 
	 * @param workspacePath
	 *        the workspace-relative path to the file to read (e.g. <code>"/MyProject/myfile.txt"</code>).
	 * @return the contents of the specified text file, or <code>null</code> if it could not be read.
	 */
	@WrapToScript
	public String readFile(String workspacePath) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(workspacePath));
		return readFile(file);
	}

	/**
	 * Reads the contents of a text file into a string.
	 * 
	 * @param file
	 *        the file to read.
	 * @return the contents of the specified text file, or <code>null</code> if it could not be read.
	 */
	@WrapToScript
	public String readFile(IFile file) {
		InputStream input = null;
		try {
			input = file.getContents();
			int count = input.available();
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			char[] cbuf = new char[count];
			in.read(cbuf);
			in.close();
			return new String(cbuf);
		} catch (CoreException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// Â Ignore.
				}
			}
		}

	}

	private Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

}
