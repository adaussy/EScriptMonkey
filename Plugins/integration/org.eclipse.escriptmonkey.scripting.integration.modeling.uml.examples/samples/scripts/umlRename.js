/*
 * Menu: Examples > Modeling > UML > Rename element
 * License: EPL 1.0
 * EnableWhen::[And {
 *   With activeEditor {
 *        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
 *    },
 *    With selection {
 *        Iterable {
 *            AdaptTo "org.eclipse.emf.ecore.EObject"{
 *                InstanceOf "org.eclipse.uml2.uml.NamedElement"
 *            }
 *        }
 *    }
 *}]::
 * Description: {This script expects a NamedElement to be selected, and asks the user for a new new to use.
 * This illustrates how a script can modify an existing model element when literal values can be used.}
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
	var elt = uml.getSelection("NamedElement");
	if (elt == null) {
		output.error("A NamedElement must be selected.");
	}
	var newName = input.askSimpleString("Rename", "New name:", elt.getName());
	if (newName != null) {
		elt.setName(newName);
	}
}

uml = loadModule("UMLModule")
output = loadModule("DialogModule")
input = loadModule("InputModule")

main()