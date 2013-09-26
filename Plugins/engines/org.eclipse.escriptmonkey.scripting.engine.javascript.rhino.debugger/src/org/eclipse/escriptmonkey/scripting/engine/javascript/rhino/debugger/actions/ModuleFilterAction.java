package org.eclipse.escriptmonkey.scripting.engine.javascript.rhino.debugger.actions;

import org.eclipse.debug.core.DebugException;
import org.eclipse.escriptmonkey.scripting.debugging.ScriptDebugVariable;
import org.eclipse.escriptmonkey.scripting.modules.AbstractScriptModule;
import org.eclipse.jface.viewers.Viewer;

public class ModuleFilterAction extends ViewFilterAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.jsdt.debug.internal.ui.actions.ViewFilterAction#getPreferenceKey()
	 */
	@Override
	protected String getPreferenceKey() {
		return "org.eclipse.escriptmonkey.scripting.ui.show_modules";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
		if(element instanceof ScriptDebugVariable) {
			try {
				Object value = ((ScriptDebugVariable)element).getValue().getValue();
				if(value instanceof AbstractScriptModule)
					return getValue();
			} catch (DebugException e) {
			}
		}

		return true;
	}

}