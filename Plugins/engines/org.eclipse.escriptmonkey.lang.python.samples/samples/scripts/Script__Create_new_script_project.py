#
# Thread: UI
# Menu: ScriptUtils > Create new Script Project
# Kudos: Arthur Daussy.
# License: EPL 1.0
# Description: {This script is used to show an example for Workspace basic manipulation.}
# EnableWhen::[With activePartId {
#	Equal "org.eclipse.ui.navigator.ProjectExplorer"
#}]::




def addToHeader(metadata, value) :
	return " # " + metadata + ": " + value + "\n";


def createHeader(scriptName) :
	scriptMenu = input.askSimpleString("Create a new script","Give me the menu path (Separator = >)","Category1 > Category1.1 > "+scriptName);
	scriptDescription = input.askSimpleString("Create a new script","Give me a description","Put a descript here");
	header = "#\n";
	header += addToHeader("Menu", scriptMenu);
	header += addToHeader("Description", scriptDescription);
	header += " #\n";
	return header;


def createScriptName(): 
	return input.askSimpleString("Create a new script","Give me a script name","NewScript");


def createScript(project,scriptName) :
	return createFile("/" + project.getName() + "/scripts/" + scriptName+ ".py", createHeader(scriptName));


def main() :
	
	project = openProjectWizard();
	addProjectNature(project,"org.eclipse.escriptmonkey.scripting.storedscript.EScript_Monkey_Nature");

	if project != None :
		createFolder("/" + project.getName() + "/scripts");
		scriptName = createScriptName();
		sourceFile = createScript(project,scriptName);
		openFile(sourceFile);

	else :
		dialog.error("Script aborted","No project was created, script aborted.");

loadModule("WorkspaceResourceModule");
dialog = loadModule("DialogModule")
input = loadModule("InputModule");
main()
