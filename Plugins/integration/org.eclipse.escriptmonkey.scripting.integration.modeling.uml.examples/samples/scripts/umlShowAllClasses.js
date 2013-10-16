/*
 * Menu: Examples > Modeling > UML > Show all classes
 * License: EPL 1.0
 * EnableWhen::[And {
 *   With activeEditor {
 *        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
 *    },
 *    With selection {
 *        Iterable {
 *            AdaptTo "org.eclipse.emf.ecore.EObject"{
 *                InstanceOf "org.eclipse.uml2.uml.Namespace"
 *            }
 *        }
 *    }
 *}]::
 * Description:  {This script finds and prints all the UML classes contained inside the selected element, directly or indirectly.}
 */

/**
 */
function main()
{
	var op = new java.lang.Runnable({
		run: function () {
			run();
		}
	});
	uml.runOperation(op, "Rename element");
}

function run() {
  var start = uml.getSelection("Namespace");
  print("Searching for all classes inside " + start.getName());
  showClasses(start);
}

function showClasses(elt)
{
	var members;
	
	if (uml.eInstanceOf(elt, "Class")) {
		print(elt.getName());
	}
	
	if (uml.eInstanceOf(elt, "Namespace")) {
		members = elt.getMembers();
		for (var i = 0; i < members.size(); i++) {
			showClasses(members.get(i));
		}
	}
}

uml = loadModule("UMLModule")
output = loadModule("DialogModule")
input = loadModule("InputModule")

main()
