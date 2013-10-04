#
# Thread: UI
# Menu: Examples > Modeling > Fill a UML model
# Kudos: Arthur Daussy
# Description: Fill an UML model when UML class is selected
# EnableWen::[And {
#   With activeEditor {
#        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
#    },
#    With selection {
#        Iterable {
#            AdaptTo "org.eclipse.emf.ecore.EObject"{
#                InstanceOf "org.eclipse.uml2.uml.Class"
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
        print "Creating class in "+currentParent.getName()
        clazz = getFactory().createClass()
        clazz.setName(name)
        currentParent.getNestedClassifiers().add(clazz)
        return clazz
    
    def run(self):
        print 'Init UML Metamodel'
        parent = selection
        for i in range(depth) :
             text = parent.getName()+"_"
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
if (not isinstance(selection,Clazz)):
    print "Please select a class"
op = MyRunnable()
runOperation(op,"Run modification in a transaction")
save()


         


