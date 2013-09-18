#
# Thread:UI
# Menu: Examples >IO > Web Sample
# Kudos: Paul Colton, Aptana, Inc.
# Description: You can use this script to display into a dialog a http request result.
# License: EPL 1.0
#

import urllib

import org.eclipse.jface.dialogs

workbench = loadModule("WorkbenchModule")
req = urllib.urlopen("http://xml.weather.yahoo.com/forecastrss?p=94103")
text = req.read()

org.eclipse.jface.dialogs.MessageDialog.openInformation(
	WINDOW.getShell(), 	
	"San Francisco Weather Feed", 
	text
)
