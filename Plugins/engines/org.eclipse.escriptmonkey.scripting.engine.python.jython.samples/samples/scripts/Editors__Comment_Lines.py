#
# Menu: Examples > Editors > Py > Comment Lines
# Kudos: Jose Fonseca & Paul Colton
# Description: You can use this script to comment a line in the current active editor.(Only work with text editor)
# License: EPL 1.0
#

from org.eclipse.jface.text import DocumentRewriteSessionType

comment = "//"
commentLength = len(comment)

editor = window.getActivePage().getActiveEditor()
document = editor.getDocumentProvider().getDocument(editor.getEditorInput())

# get range of lines in the selection (or at the cursor position)
selection = editor.getSelectionProvider().getSelection()
startLine = document.getLineOfOffset(selection.getOffset())
endLine = document.getLineOfOffset(selection.getOffset() + selection.getLength())
	
# determine if we're adding or removing comments
source = document.get()
offset = document.getLineOffset(startLine)
addComment = source[offset : offset + commentLength] != comment
adjust = 0

session = document.startRewriteSession(DocumentRewriteSessionType.SEQUENTIAL)

if addComment:
	for i in range(startLine, endLine + 1):
		offset = document.getLineOffset(i)
		document.replace(offset, 0, comment)
else:
	for i in range(startLine, endLine + 1):
		offset = document.getLineOffset(i)
		if source[offset + adjust : offset + adjust + commentLength] == comment:
			document.replace(offset, commentLength, "")
			adjust += commentLength

document.stopRewriteSession(session)
