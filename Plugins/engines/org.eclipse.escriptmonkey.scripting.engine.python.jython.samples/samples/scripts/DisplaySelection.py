#
# Menu: Examples > EnableWhen > Display Selection
# Kudos: Arthur Daussy
# Description: You can use this script to open the Web View.
#EnableWhen::[With selection {
#        InstanceOf "org.eclipse.jface.viewers.ISelection"{
#            }
#}]::
# License: EPL 1.0
#


selectionModule = loadModule("SelectionModule")

print selectionModule.getSelection()
