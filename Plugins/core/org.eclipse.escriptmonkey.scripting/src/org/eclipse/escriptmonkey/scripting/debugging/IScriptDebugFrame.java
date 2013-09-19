package org.eclipse.escriptmonkey.scripting.debugging;

import org.eclipse.escriptmonkey.scripting.Script;

public interface IScriptDebugFrame {

	int TYPE_FILE = 1;

	int TYPE_FUNCTION = 2;

	int getLineNumber();

	Script getScript();

	int getType();
}