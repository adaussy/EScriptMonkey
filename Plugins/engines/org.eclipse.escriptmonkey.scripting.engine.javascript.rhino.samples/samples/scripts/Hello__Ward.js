/*
 * Thread: UI
 * Menu: Examples > Hello > JS > Ward
 * Kudos: Ward Cunningham & Bjorn Freeman-Benson
 * Description: {You can use this script to display a message into a dialog box. Display dialog message using java classes.
 * This script need to be run into the UI (see Thread metadata).}
 * License: EPL 1.0
 */
loadModule("WorkbenchModule")

text = "Hello Ward\n\n";
text += "The quick brown fox jumped over the lazy dog's back.";
text += "Now is the time for all good men to come to the aid of their country."

Packages.org.eclipse.jface.dialogs.MessageDialog.openInformation( 	
	org.eclipse.swt.widgets.Display.getDefault().getActiveShell(), 	
	"Monkey Dialog", 
	text	
	)

	
	
