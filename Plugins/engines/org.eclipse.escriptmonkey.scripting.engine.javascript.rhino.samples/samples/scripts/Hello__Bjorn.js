/*
 * Menu: Examples > Hello > JS > Bjorn
 * Kudos: Ward Cunningham & Bjorn Freeman-Benson & arthur daussy
 * Description: You can use this script to display a message into a dialog box.
 * License: EPL 1.0
 */
 function main(){
	 
	 dialoghelper = loadModule("DialogModule");
	 
	 text = "Hello Bjorn\n\n";
	 text += "The quick brown fox jumped over the lazy dog's back.";
	 text += "Now is the time for all good men to come to the aid of their country."
		 
	dialoghelper.openInformationDialog(text)
 }
 
main()

	

	
