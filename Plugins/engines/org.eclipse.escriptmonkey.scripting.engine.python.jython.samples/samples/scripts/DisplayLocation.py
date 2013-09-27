#
# Menu: Examples > EnableWhen > Display Files Location
# Kudos: Arthur Daussy
# Description: You can use this script to open the Web View.
#EnableWen::[With selection {
#    Iterable {
#        InstanceOf "org.eclipse.core.resources.IFile"
#    }
#}]::
# License: EPL 1.0
#

selectionModule = loadModule("SelectionModule")

for file in selectionModule.getIterableSelection():
    print file.getFullPath()