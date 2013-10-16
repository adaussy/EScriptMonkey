#
# Thread: UI
# Menu: Examples > Modeling > Create resources
# Kudos: Arthur Daussy
# Description: { Demonstrate how to create and fill a resource.}
# License: EPL 1.0
#

import  org.eclipse.uml2.uml.Class as Clazz
from java.lang import Runnable

class MyRunnable(Runnable) :
    
    def fillModel(self,resource):
        model = createModel();
        resource.getContents().add(model)
        for i in range(1,50):
            newClass = createClass();
            newClass.setName("class_"+str(i));
            model.getPackagedElements().add(newClass)
        save(resource)
    
    def run(self):
        #Create resource dynamically
        newResource = createResource()
        self.fillModel(newResource)
        print newResource.getURI().toString()
         #Create resource semi automatically
        newResource = createResource(name="semeAutomatically.uml")
        self.fillModel(newResource)
        print newResource.getURI().toString()
                
        
loadModule("EcoreModule")
initEPackage("http://www.eclipse.org/uml2/4.0.0/UML")
# Get the selected EObject
op = MyRunnable()
runOperation(op,"Create resources")



         


