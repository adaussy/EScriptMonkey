/*
 * Menu: Examples > Modeling > UML > Add class
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
 * Description: {This script create a new UML class in the current package. A package must be
 * selected in the current UML editor. It illustrates how to create new
 * elements. It creates a new class, sets its name, and adds it
 * into the specified package.}
 */

function main() {
	var op = new java.lang.Runnable({
		run: function () {
			run();
		}
	});
	uml.runOperation(op, "Rename element");
}


/**
 * Run the script itself
 */
function run() {
	var name;
	var parentPackage = uml.getSelection("Package");
	if (parentPackage == null) {
		dialog.error("A Package must be selected in the current UML editor to run this script.");
		return;
	}
	name = input.askSimpleString("New class", "Name of the new class:", "Class");
	dialog.info(name)
	if (name != null) {
		// An equivalent way using the generic UML factory would be:
		 var klass = uml.getFactory().createClass();
		 klass.setName(name);
		// klass.setName(name);
		 parentPackage.getPackagedElements().add(klass);
	}
}

uml = loadModule("UMLModule")
input = loadModule("InputModule")
dialog = loadModule("DialogModule")
main()
