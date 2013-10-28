 #
 # Menu: EclipseCon > Modeling > Fill library
 # Description: Create dynamically an Library from User Input
 # EnableWhen::[And {
 # With selection {
 #        Iterable {
 #            AdaptTo "org.eclipse.emf.ecore.EObject"{
 #                InstanceOf "org.eclipse.emf.examples.extlibrary.Library"
 #            }
 #        }
 #    }
 #}]::
 


from java.lang import Runnable
from lib import extlibraryinitHelper as initHelper
import datetime

loadModule("EcoreModule")
initEPackage("http:///org/eclipse/emf/examples/library/extlibrary.ecore/1.0.0")
input = loadModule("InputModule")
output = loadModule("OutputModule")
# Get the selected EObject
lib = getSelection("Library")

#Fill the model
print lib
for b in range(1,3):
    book = createBook()
    print book
    initHelper.initBook(eObject=book,title=askSimpleString("What is the title book?"))
    lib.getBooks().add(book)
for authorIndex in range(0,3):
    author = createWriter()
    initHelper.initWriter(author,lastName=askSimpleString("What is the last name of the writer?"),books=selectFromList(lib.getBooks()))
    lib.getWriters().add(author)


#Write the result in a file
content = "Library: \n"
for author in lib.getWriters():
    content +=author.getName()+" has written "
    for b in author.getBooks():
        content += b.getTitle()
    content+="\n"
location = input.selectContainer("Location of the result", "Select the directoty where to place the result:");
output.createNewFile(location[0], "result.txt",content)
