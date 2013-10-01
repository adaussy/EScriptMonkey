#
# Menu: Examples > Modeling > GMF > Display Element in Papyrus
# Kudos: Arthur Daussy
# Description: Dispay the semantic object selected
#EnableWen::[With activeEditor {
#    Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
#}]::
# License: EPL 1.0
#
loadModule("SelectionModule")

# Print the selection use custom selector
print "Get selection using priority order of the Custom Selector Service\n"
print getCustomSelection()
print "Get the selection using a specific Selector (Semantic Selector)\n"
print getCustomSelectionFromSelector("GMFSemanticSeletor")
print "Get the selection using a specific Selector (Notation Selector)\n"
print getCustomSelectionFromSelector("GMFNotationSelector")