package org.eclipse.escriptmonkey.scripting.integration.modeling.papyrus;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.escriptmonkey.scripting.integration.modeling.EcoreModule;
import org.eclipse.escriptmonkey.scripting.integration.modeling.NotationModule;
import org.eclipse.escriptmonkey.scripting.integration.modeling.uml.modules.UMLModule;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;


public class PapyrusModule extends EcoreModule {

	private UMLModule umlModule = new UMLModule();

	private NotationModule notationModule = new NotationModule();

	@WrapToScript
	public ModelSet getModelSet() {
		EditingDomain editingDomain = getEditingDomain();
		if(editingDomain == null) {
			Logger.logError("Unable to get the editing domain");
			return null;
		}
		ResourceSet resourceSet = editingDomain.getResourceSet();
		if(resourceSet instanceof ModelSet) {
			return (ModelSet)resourceSet;

		}
		Logger.logError("The resource set is not a model set");
		return null;
	}

	@WrapToScript
	public Model getModel() {
		return umlModule.getModel();
	}

	@WrapToScript
	public View getSelectionView() {
		EObject v = notationModule.getSelection();
		if(v instanceof View) {
			return (View)v;
		}
		return null;
	}

	@WrapToScript
	public Element getSelectionElement() {
		EObject elem = umlModule.getSelection();
		if(elem instanceof Element) {
			return (Element)elem;
		}
		return null;
	}

}
