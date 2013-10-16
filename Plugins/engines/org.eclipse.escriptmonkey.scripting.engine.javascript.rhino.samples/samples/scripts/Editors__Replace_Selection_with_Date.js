/*
 * Thread: UI
 * Menu:   Examples > Editors > Replace Selection with Date
 * Kudos: Paul Colton (Aptana, Inc.) & Arthur Daussy
 * Description: {You can use this script to replace the current selection of the active text editor with the current date}
 * License: EPL 1.0
 * EnableWhen::[With selection {
 *        InstanceOf "org.eclipse.jface.text.TextSelection"{
 *            }
 * }]::
 */
 
function main() {
	loadModule("TextEditorModule")
	var sourceEditor = getActiveEditor();

	var valid = true;
	
	// make sure we have an editor
	if (sourceEditor === undefined) {
		valid = false;
		showError("No active editor");
	}
	
	// inject
	if (valid) {
	
			var range = sourceEditor.selectionRange;
			var offset = range.startingOffset;
			var deleteLength = range.endingOffset - range.startingOffset;
			var source = sourceEditor.source;
			
			var text = new Date();
			
			sourceEditor.applyEdit(offset, deleteLength, text);

	}
}

main()
