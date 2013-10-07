/*
 * Thread: UI
 * Menu: Examples > Workbench >Find System Prints
 * Kudos: Bjorn Freeman-Benson & Ward Cunningham & Arthur Daussy
 * Description: {Look into all java file in your workspace to find System.out.println or System.out.print call. And display task into the task view to remove it}
 * License: EPL 1.0
 */
  
function main() {
	
  loadModule("ResourcesModule");
  loadModule("WorkbenchModule");
  
  
  var files = filesMatching(".*\\.java");
  var match;
   
  for each( file in files ) { 
    file.removeMyTasks(  );
    for each( line in file.getLines() ) {
      if (match = line.string.match(/System\.out\.print(ln)? *\(.*\)/)) {
         line.addMyTask( match[0] );
      }
    }
  }
  getActivePage().showView("org.eclipse.ui.views.TaskList");
}

main()
