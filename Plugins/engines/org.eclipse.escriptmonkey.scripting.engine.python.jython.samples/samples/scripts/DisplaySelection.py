#
# Menu: Examples > EnableWhen > Display Selection
# Kudos: Arthur Daussy
# Description: {Use this script to display the current selection}.
#EnableWhen::[With selection {
#        InstanceOf "org.eclipse.jface.viewers.ISelection"{
#            }
#}]::
# License: EPL 1.0
#


selectionModule = loadModule("SelectionModule")

print selectionModule.getSelection()
