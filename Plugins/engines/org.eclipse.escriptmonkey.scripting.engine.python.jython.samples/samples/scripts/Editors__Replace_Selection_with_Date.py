#
# Thread:UI
# Menu: Examples >Editors > Replace Selection with Date
# Kudos: Jose Fonseca & Paul Colton & Arthur Daussy
# EnableWhen::[With selection {
#        InstanceOf "org.eclipse.jface.text.TextSelection"{
#            }
#}]::
# Description: {You can use this script to replace the current selection of the active text editor with the current date.}
# License: EPL 1.0
# 

import time 


workbench = loadModule("WorkbenchModule")
editor = workbench.getActiveEditor()

document = editor.getDocumentProvider().getDocument(editor.getEditorInput())

# get range of lines in the selection (or at the cursor position)
selection = editor.getSelectionProvider().getSelection()
offset = selection.getOffset()
deleteLength = selection.getLength()

text = time.strftime("%Y-%m-%d %H:%M:%S")
#text = "tata"
# apply edit and reveal in editor
source = document.get()
document.replace(offset, deleteLength, text)
editor.selectAndReveal(offset, len(text))
