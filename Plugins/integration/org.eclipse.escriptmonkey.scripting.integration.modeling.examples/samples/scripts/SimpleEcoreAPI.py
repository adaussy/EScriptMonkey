#
# Thread: UI
# Menu: Examples > Modeling > Simple EMF API
# Kudos: Arthur Daussy
# Description: { Demonstrate how to a simple API for any generated EMF metamodel}
# EnableWhen::[And {
# With selection {
#        Iterable {
#            AdaptTo "org.eclipse.emf.ecore.EObject"{
#            }
#        }
#    }
#}]::
# License: EPL 1.0
#

import  org.eclipse.uml2.uml.Class as Clazz
from java.lang import Runnable

depth=5
numberOfElement=100


class MyRunnable(Runnable) :
    
    def createClass(self,currentParent,name):
        print "Creating class in "+str(currentParent.getName())
        clazz = getFactory().createClass() # or use directly createClass()
        clazz.setName(name)
        if eInstanceOf(currentParent,"Model"):
            currentParent.getPackagedElements().add(clazz)
        else:
            currentParent.getNestedClassifiers().add(clazz)
        return clazz
    
    def run(self):
        print 'Init UML Metamodel'
        parent = selection
        for i in range(depth) :
             text = str(parent.getName())+"_"
             text+= str(i)
             child = self.createClass(parent,text)
             for j in range(numberOfElement):
                  childName = child.getName() +"_"
                  childName+=str(j)
                  self.createClass(child,childName)
                
        
loadModule("SelectionModule")
loadModule("EcoreModule")
initEPackage("http://www.eclipse.org/uml2/4.0.0/UML")
# Get the selected EObject
print "Get selection using priority order of the Custom Selector Service\n"
selection =  getCustomSelection()
if (not eInstanceOf(selection,"Model")):
    raise Exception("Please select a class") 
op = MyRunnable()
runOperation(op,"Run modification in a transaction")
save()


         


