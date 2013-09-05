#
# Menu: Examples > IO > Py > File Sample
# Kudos: Paul Colton, Aptana, Inc.
# Description : You can use this script to display into a dialog box the current date.
# License: EPL 1.0
#

import time

import org.eclipse.jface.dialogs

date = time.strftime("%Y-%m-%d %H:%M:%S")

# Write out new file
file = open("myFile.txt", "wt")
file.write("Date: " + date)
file.close()

# Read lines from file
file = open("myFile.txt", "rt")
text = file.read()
file.close()

# Display what we read
org.eclipse.jface.dialogs.MessageDialog.openInformation( 	
	window.getShell(), 	
	"File I/O", 
	"Contents: " + text	
)
