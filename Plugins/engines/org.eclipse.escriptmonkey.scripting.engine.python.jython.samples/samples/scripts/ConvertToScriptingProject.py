#
# Thread: UI
# Menu: ScriptUtils > Resource > Convert to scripting project
# Kudos: Arthur Daussy.
# License: EPL 1.0
# Description : {This script is used to convert the selected IProject to script project.}
# EnableWhen::[With selection {
#    Iterable {
#        InstanceOf "org.eclipse.core.resources.IProject"
#    }
#}]::

import org.eclipse.core.resources.IProject

loadModule("WorkspaceResourceModule")
selectionHelper = loadModule("SelectionModule")
selection = selectionHelper.getIterableSelection()
print selection
for s in selection:
	if isinstance(s,org.eclipse.core.resources.IProject):
		print "Add script nature to "+ s.getName()
		addProjectNature(s,"org.eclipse.escriptmonkey.scripting.storedscript.EScript_Monkey_Nature")
	else:
		print s +" is not a IProject"
