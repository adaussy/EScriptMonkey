#
 # Menu: EclipseCon > Modeling > Fill library V2
 # Description: Create a new library fill with Authors
 # Thread: UI


from java.lang import Runnable
from lib import extlibraryinitHelper as initHelper
from lib import authors as data

loadModule("EcoreModule")
input = loadModule("InputModule")
output = loadModule("OutputModule")
initEPackage("http:///org/eclipse/emf/examples/library/extlibrary.ecore/1.0.0")
# Get the selected EObject
 #Create resource semi automatically
print "Creating new resource"
newResource = createResource(name="lib_V2.extlibrary")
print "Resource has been created at "+newResource.getURI().toString()
print "Creating new library"
lib = createLibrary()
initHelper.initLibrary(lib,name="My new Library")
newResource.getContents().add(lib)

#Fill the model
print lib.getName()+" has been created"
for lastNameIte, firstNameIte in zip(data.writersLastName, data.writersFirstName):
    print "Creating new writer "+lastNameIte+" "+firstNameIte
    author = createWriter()
    initHelper.initWriter(author,lastName=lastNameIte,firstName=firstNameIte)
    lib.getWriters().add(author)


save(lib)
#Write the result in a file
print "Generating results"
content = "Library: \n"
for author in lib.getWriters():
    content +=author.getName()+"\n"
location = input.selectContainer("Location of the result", "Select the directory where to place the result:");
output.createNewFile(location[0], "result.txt",content)
