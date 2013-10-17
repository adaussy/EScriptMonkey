#
# Menu: Examples > EnableWhen > Display Files Location
# Kudos: Arthur Daussy
# Description: {This script can be use to display the location of script into the workspace.}
#EnableWhen::[With selection {
#    Iterable {
#        InstanceOf "org.eclipse.core.resources.IFile"
#    }
#}]::
# License: EPL 1.0
#

selectionModule = loadModule("SelectionModule")
print "Selected files location:\n"
for file in selectionModule.getIterableSelection():
    print file.getLocation()