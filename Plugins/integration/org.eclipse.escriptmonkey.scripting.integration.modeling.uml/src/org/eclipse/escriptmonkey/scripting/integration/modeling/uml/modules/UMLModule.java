package org.eclipse.escriptmonkey.scripting.integration.modeling.uml.modules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.escriptmonkey.scripting.integration.modeling.EcoreModule;
import org.eclipse.escriptmonkey.scripting.module.platform.modules.DialogModule;
import org.eclipse.escriptmonkey.scripting.modules.WrapToScript;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * This module help to handle UML models
 * 
 * @author adaussy
 * 
 */
public class UMLModule extends EcoreModule {

	public UMLModule() {
		initEPackage(UMLPackage.eNS_URI);
	}

	/**
	 * Get the UML model from the current active editor
	 * 
	 * @return
	 */
	@WrapToScript
	public Model getModel() {
		EditingDomain editingDomain = getEditingDomain();
		if(editingDomain == null) {
			DialogModule.error("Unable to retreive editing domain");
		}
		ResourceSet resourceSet = editingDomain.getResourceSet();
		if(resourceSet == null) {
			DialogModule.error("Unable to retreive the resource set");
		}
		for(Resource r : resourceSet.getResources()) {
			Model result = lookForModel(r);
			if(result != null) {
				return result;
			}
		}
		return null;
	}

	private Model lookForModel(Resource r) {
		URI resourceURI = r.getURI();
		if(resourceURI != null) {
			if(UMLPackage.eNS_PREFIX.equals(resourceURI.fileExtension())) {
				EList<EObject> content = r.getContents();
				if(!content.isEmpty()) {
					EObject root = content.get(0);
					if(root instanceof Model) {
						return (Model)root;
					}
				}
			}
		}
		return null;
	}
}
