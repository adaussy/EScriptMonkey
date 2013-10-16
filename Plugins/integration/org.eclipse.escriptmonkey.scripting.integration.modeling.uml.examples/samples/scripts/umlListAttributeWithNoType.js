/*
 * Menu: Examples > Modeling > UML > List attribute with no type
 * License: EPL 1.0
 * Description: {This script lists the attribute anywhere in the current model which do not
 * have a specified type. It illustrates how to obtain the top-level Model, how to navigate inside a whole model
 * (recursively) and detect elements which match some criterion, and how to
 * report results in the console.}
 */

function main() {
	var op = new java.lang.Runnable({
		run: function () {
			run();
		}
	});
	uml.runOperation(op, "Rename element");
}

function run() {
	var attributes;
	var current = uml.getModel();
	if (current == null) {
		output.error("Unable to retreive the model element");
		return;
	}

	attributes = findAttributes(current);
	reportResult(attributes);
}

function findAttributes(elt) {
	var result = [];
	var children;

	if (uml.eInstanceOf(elt, "Property") && elt.getType() == null) {
		result.push(elt);
	}
	children = elt.getOwnedElements();
	for ( var i = 0; i < children.size(); i++) {
		result = result.concat(findAttributes(children.get(i)));
	}
	return result;
}

function reportResult(attributes) {
	var attr;
	print("The following attributes do not have a specified type:");
	for ( var i = 0; i < attributes.length; i++) {
		attr = attributes[i];
		uml.addInfoMarker(attr,attr.getQualifiedName()+" has no type")
		print(" - " + attr.getClass_().getName() + "#"
				+ attr.getName());
	}
	showView("org.eclipse.ui.views.ProblemView");
}


uml = loadModule("UMLModule");
input = loadModule("InputModule");
output = loadModule("DialogModule");
workbench = loadModule("WorkbenchModule")
main();