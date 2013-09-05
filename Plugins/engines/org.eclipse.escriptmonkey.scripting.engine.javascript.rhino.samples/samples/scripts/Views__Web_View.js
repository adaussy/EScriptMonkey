/*
 * Menu: Examples > Views > JS > Google Web View
 * Kudos: Paul Colton
 * License: EPL 1.0
 * Description : You can use this script to open the Web View.
 * DOM: http://localhost/org.eclipse.eclipsemonkey.lang.javascript
 */

function main()
{
	webView = views.getView("GoogleWebView");
	webView.showView(true);
	webView.setTitle("Google");
	webView.url = "http://www.google.com";
	webView.addEventListener("LocationChanging", onLocationChanging);
}

function onLocationChanging(event)
{
	var location = event.innerEvent.location;
	
	// Print out the location to the Java console
	Packages.java.lang.System.out.println("You clicked on: " + location);
}
