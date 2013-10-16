#
# Thread: UI
# Menu: Examples > Modeling > Compute references
# Kudos: Arthur Daussy
# Description: { Demonstrate how to compute all model element referencing a target model element. Can Apply with any selection that is an EObject}
# EnableWhen::[And {
#    With selection {
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

class MyRunnable(Runnable) :
    
    def run(self):
        print 'Referencing elements (Element \t---(FeatureName)--->\t targetObject):\n'
        for eObject,eStructuralFeature in getUsages(selection):
            print ePrint(eObject) + "\t----(" + eStructuralFeature.getName() +")-->\t"+ePrint(selection)
                
        
loadModule("SelectionModule")
loadModule("EcoreModule")
initEPackage("http://www.eclipse.org/uml2/4.0.0/UML")
# Get the selected EObject
selection =  getCustomSelection()
op = MyRunnable()
runOperation(op,"Run modification in a transaction")
save()


         


