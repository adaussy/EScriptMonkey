/*
 * Thread: UI
 * Menu: ScriptUtils > Create new Script Project
 * Kudos: Arthur Daussy.
 * License: EPL 1.0
 * Description : {This script can be use to create a new Script Project with a new Script.
 * This script also initialize the basics metadata of the script.}
 */



function addToHeader(metadata, value) {
	return " * " + metadata + ": " + value + "\n";
}

function createHeader(scriptName) {
	var scriptMenu = input.askSimpleString("Create a new script","Give me the menu path (Separator = >)","Category1 > Category1.1 > "+scriptName);
	var scriptDescription = input.askSimpleString("Create a new script","Give me a description","Put a description here");
	var header = "/*\n";
	header += addToHeader("Menu", scriptMenu);
	header += addToHeader("Description", scriptDescription);
	header += " */\n";
	return header;
}

function createScriptName(){
	return input.askSimpleString("Create a new script","Give me a script name","NewScript");
}

function createScript(project,scriptName) {
	return createFile("/" + project.getName() + "/scripts/" + scriptName+ ".js", createHeader(scriptName));
}

function main() {
	
	var project = openProjectWizard();
	addProjectNature(project,
			"org.eclipse.escriptmonkey.scripting.storedscript.EScript_Monkey_Nature");

	if (project != null) {
		createFolder("/" + project.getName() + "/scripts");
		var scriptName = createScriptName();
		var sourceFile = createScript(project,scriptName);
		openFile(sourceFile);

	} else
		displayMessage("Script aborted",
				"No project was created, script aborted.");
}
loadModule("WorkspaceResourceModule");
input = loadModule("InputModule");
main()
