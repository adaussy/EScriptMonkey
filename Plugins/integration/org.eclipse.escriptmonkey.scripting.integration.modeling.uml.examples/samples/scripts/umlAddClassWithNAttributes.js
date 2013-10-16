/*
 * Menu: Examples > Modeling > UML > Add class with N attributes
 * License: EPL 1.0
 * EnableWhen::[And {
 *   With activeEditor {
 *        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
 *    },
 *    With selection {
 *        Iterable {
 *            AdaptTo "org.eclipse.emf.ecore.EObject"{
 *                InstanceOf "org.eclipse.uml2.uml.Package"
 *            }
 *        }
 *    }
 *}]::
 * Description: {This script creates a new UML class (in the currently selected package) which
 * initially contains a user-specified number of attributes.}
 */

function main() {
	var op = new java.lang.Runnable({
		run: function () {
			run();
		}
	});
	uml.runOperation(op, "Rename element");
}

function createClassInPackage(parentPackage,name){
	 output.console("Creating class "+name+" in "+parentPackage.getName());
	 var klass = createClass(); 
	 klass.setName(name);
	 parentPackage.getPackagedElements().add(klass);
	 return klass;
}
/**
 * Run the script itself
 */
function run() {
	var name, nbAttributes, prefix, newClass, attr;
	
	var parent = uml.getSelection("Package");
	if (parent == null) {
		output.error("The parent package of the new class must be selected.");
		return;
	}
	name = input.ask("Name of the new class:");
	if (name != null) {
		nbAttributes = input.ask("Number of attributes to create:");
		prefix = input.ask("Prefix for the attributes names:");
		newClass = createClassInPackage(parent,name);
		for (i = 0; i < nbAttributes; i++) {
			attr = uml.getFactory().createProperty();
			attr.setName(prefix + i);
			newClass.getOwnedAttributes().add(attr);
		}
	}
}
uml = loadModule("UMLModule");
input = loadModule("InputModule");
output = loadModule("OutputModule");
main()
