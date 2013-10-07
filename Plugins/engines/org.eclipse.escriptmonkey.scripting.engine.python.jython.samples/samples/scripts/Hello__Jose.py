#
# Thread: UI
# Menu: Examples >Hello > Jose
# Kudos: Ward Cunningham & Bjorn Freeman-Benson
# Description: {You can use this script to display a message into a dialog box. This script only use Java classes.}
# License: EPL 1.0
#

import org.eclipse.jface.dialogs

text = "Hello Jose\n\n";
text += "The quick brown fox jumped over the lazy dog's back.";
text += "Now is the time for all good men to come to the aid of their country."

print text

org.eclipse.jface.dialogs.MessageDialog.openInformation(
	org.eclipse.swt.widgets.Display.getDefault().getActiveShell(), 	
	"Monkey Dialog", 
	text	
)
