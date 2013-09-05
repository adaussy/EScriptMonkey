/*
 * Menu: Examples > IO > JS > Web Sample
 * Kudos: Paul Colton, Aptana, Inc.
 * License: EPL 1.0
 * Description : You can use this script to display into a dialog a http request result.
 * DOM: http://download.eclipse.org/technology/dash/update/org.eclipse.eclipsemonkey.lang.javascript
 */
  
function main() 
{
	var req = new WebRequest();
	
	req.open("GET", "http://xml.weather.yahoo.com/forecastrss?p=94103");
	
	var text = req.send();
	
	Packages.org.eclipse.jface.dialogs.MessageDialog.openInformation( 	
		window.getShell(), 	
		"San Francisco Weather Feed", 
		text	
	);
	
}
