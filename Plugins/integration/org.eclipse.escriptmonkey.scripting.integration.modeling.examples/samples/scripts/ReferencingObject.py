#
# Thread: UI
# Menu: Examples > Modeling > Print references
# Kudos: Arthur Daussy
# Description: { Demonstrate how to compute all model element referencing a target model element.}
# EnableWhen::[And {
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
    
    def run(self):
        print 'Referencing elements (Element \t---(FeatureName)--->\t targetObject):\n'
        for eObject,eStructuralFeature in getUsages(selection):
            print ePrint(eObject) + "\t----(" + eStructuralFeature.getName() +")-->\t"+ePrint(selection)
                
        
loadModule("SelectionModule")
loadModule("EcoreModule")
initEPackage("http://www.eclipse.org/uml2/4.0.0/UML")
# Get the selected EObject
selection =  getCustomSelection()
if (not isinstance(selection,Clazz)):
    print "Please select a class"
op = MyRunnable()
runOperation(op,"Run modification in a transaction")
save()


         


