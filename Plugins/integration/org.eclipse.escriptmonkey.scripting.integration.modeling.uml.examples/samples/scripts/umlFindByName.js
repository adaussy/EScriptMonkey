/*
 * Menu: Examples > Modeling > UML > Find element by name
 * License: EPL 1.0
 * EnableWhen::[And {
 *   With activeEditor {
 *        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
 *    },
 *    With selection {
 *        Iterable {
 *            AdaptTo "org.eclipse.emf.ecore.EObject"{
 *                InstanceOf "org.eclipse.uml2.uml.Element"
 *            }
 *        }
 *    }
 *}]::
 * Description: {This script searches inside a model (starting from the current selection) for
 * all the elements whose name matches a string (or regular expression) provided
 * by the user. It reports the element it found on the Topcased Scripting
 * console.}
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
	var name; // The name to search for.
	var matchFunction; // The function used to match elements.
	var elements; // The elements found.
	
	var start = uml.getSelection();
	if (start == null) {
		output.error("No starting point selected.");
		return;
	}
	name = input.askSimpleString("Search string:");
	if (input.askQuestion("Type of search", "Use as a regular expression?")) {
		matchFunction = function (elt) {
			var re = new RegExp(name);
			var matches = re.exec(elt.getName());
			return matches != null && matches.length > 0;
		};
	} else {
		matchFunction = function (elt) {
			return elt.getName().equals(name);
		};
	}
	elements = find(start, matchFunction);
	reportResults(elements);
}

function find(elt, matcher) {
	var result = [];
	var children;
	var i;
	
	if (uml.eInstanceOf(elt, "NamedElement") && matcher(elt)) {
		result.push(elt);
	}
	children = elt.getOwnedElements();
	for (i = 0; i < children.size(); i++) {
		result = result.concat(find(children.get(i), matcher));
	}
	return result;
}

function reportResults(elements)
{
	print("Search result:")
	for (var i = 0; i < elements.length; i++) {
		print("- " + elements[i].getQualifiedName());
	}
}

uml = loadModule("UMLModule");
input = loadModule("InputModule");
output = loadModule("DialogModule");
main();
