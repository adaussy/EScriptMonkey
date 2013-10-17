#
# Thread:UI
# Menu: Examples > Find System Prints
# Kudos: Bjorn Freeman-Benson & Ward Cunningham
# Description: {Look into all java file in your workspace to find System.out.println or System.out.print call. And display task into the task view to remove it}
# License: EPL 1.0
#


#Load module to handle workspace resources
resources=loadModule("ResourcesModule")
#load module to handle workbench
loadModule("WorkbenchModule")

files = resources.filesMatching('.*\\.java')
for file in files:
	file.removeMyTasks()
	for line in file.lines:
		if line.getString().find('System.out.print') != -1:
			line.addMyTask(line.getString().strip())
#This constant come from the WorkbenchModule and is declare as static
getActivePage().showView('org.eclipse.ui.views.TaskList')
