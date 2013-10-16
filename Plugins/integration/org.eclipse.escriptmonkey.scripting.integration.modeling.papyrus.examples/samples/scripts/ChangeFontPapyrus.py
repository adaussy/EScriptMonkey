# Menu: Examples > Modeling > Papyrus > Change Class font to Tahoma (Papyrus)
# License: EPL 1.0
# EnableWhen::[And {
#   With activeEditor {
#        Equal "org.eclipse.papyrus.infra.core.papyrusEditor"
#    },
#    With selection {
#        Iterable {
#            AdaptTo "org.eclipse.gmf.runtime.notation.View"{
#                InstanceOf "org.eclipse.gmf.runtime.notation.Node"
#            } 
#        }
#    } 
#}]::
# Description: {Demonstrate how to modify the Notation model from a GMF Editor using NotationModule. In this script will we change the font of a selected node (From GMF editor) to Tahoma.}
#

from java.lang import Runnable
from org.eclipse.gmf.runtime.notation import Node
from org.eclipse.gmf.runtime.diagram.core.util import ViewUtil
from org.eclipse.gmf.runtime.notation import NotationPackage
from org.eclipse.swt.graphics import FontData
from org.eclipse.jface.resource import StringConverter
from org.eclipse.swt.SWT import NORMAL

from org.eclipse.uml2.uml import Class


def main():
    selection = notation.getSelection("Node")
    if selection == None:
        print "[ERROR] Please select a graphical node."
        return
    GMFresource = selection.eResource()
            
    class MyRunnable(Runnable) :
        def run(self):
            print "[INFO] Update Fonts"
            font = FontData("Tahoma", 8, NORMAL) 
            
            for elt in GMFresource.getAllContents():
                if isinstance(elt, Node):
                    object = elt.getElement()
                    
                    if isinstance(object, Class):
                        print "[INFO] " + object.eContainer().getName() + "::" + object.getName() + " has been updated."
                        
                        ViewUtil.setStructuralFeatureValue(elt, NotationPackage.eINSTANCE.getFontStyle_FontName(), StringConverter.asString(font))
    
    op = MyRunnable()
    notation.runOperation(op, "Change Class font to Tahoma")
    notation.save()
    print "[INFO] file " + GMFresource.getURI().toString() + " has been saved."


notation = loadModule("NotationModule")
main()
