#
 # Menu: EclipseCon > Modeling > Fill library
 # Description: Put a descript here
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

 
 
# Init Book
# @generated 
def initBook(eObject,publicationDate=None,copies=None,borrowers=None,title=None,pages=None,category=None,author=None):
    if not title is None:
        eObject.setTitle(title)
    if not pages is None:
        eObject.setPages(pages)
    if not category is None:
        eObject.setCategory(category)
    if not author is None:
        eObject.setAuthor(author)

# Init Library
# @generated 
def initLibrary(eObject,address=None,name=None,stock=None,branches=None,parentBranch=None,people=None):
    initAddressable(eObject,address)
    if not name is None:
        eObject.setName(name)
    if not writers is None:
        for a in writers:
            eObject.getWriters().add(a)
    if not employees is None:
        for a in employees:
            eObject.getEmployees().add(a)
    if not borrowers is None:
        for a in borrowers:
            eObject.getBorrowers().add(a)
    if not stock is None:
        for a in stock:
            eObject.getStock().add(a)
    if not books is None:
        for a in books:
            eObject.getBooks().add(a)
    if not branches is None:
        for a in branches:
            eObject.getBranches().add(a)
    if not parentBranch is None:
        eObject.setParentBranch(parentBranch)
    if not people is None:
        for a in people:
            eObject.getPeople().add(a)

# Init Writer
# @generated 
def initWriter(eObject,address=None,firstName=None,lastName=None,name=None,books=None):
    initPerson(eObject,address,firstName,lastName)
    if not name is None:
        eObject.setName(name)
    if not books is None:
        for a in books:
            eObject.getBooks().add(a)

# Init Item
# @generated 
def initItem(eObject,publicationDate=None):
    if not publicationDate is None:
        eObject.setPublicationDate(publicationDate)

# Init Lendable
# @generated 
def initLendable(eObject,copies=None,borrowers=None):
    if not copies is None:
        eObject.setCopies(copies)
    if not borrowers is None:
        for a in borrowers:
            eObject.getBorrowers().add(a)


# Init Periodical
# @generated 
def initPeriodical(eObject,publicationDate=None,title=None,issuesPerYear=None):
    initItem(eObject,publicationDate)
    if not title is None:
        eObject.setTitle(title)
    if not issuesPerYear is None:
        eObject.setIssuesPerYear(issuesPerYear)

# Init AudioVisualItem
# @generated 
def initAudioVisualItem(eObject,publicationDate=None,copies=None,borrowers=None,title=None,minutesLength=None,damaged=None):
    if not title is None:
        eObject.setTitle(title)
    if not minutesLength is None:
        eObject.setMinutesLength(minutesLength)
    if not damaged is None:
        eObject.setDamaged(damaged)

# Init BookOnTape
# @generated 
def initBookOnTape(eObject,publicationDate=None,copies=None,borrowers=None,title=None,minutesLength=None,damaged=None,reader=None,author=None):
    initAudioVisualItem(eObject,publicationDate,copies,borrowers,title,minutesLength,damaged)
    if not reader is None:
        eObject.setReader(reader)
    if not author is None:
        eObject.setAuthor(author)

# Init VideoCassette
# @generated 
def initVideoCassette(eObject,publicationDate=None,copies=None,borrowers=None,title=None,minutesLength=None,damaged=None,cast=None):
    initAudioVisualItem(eObject,publicationDate,copies,borrowers,title,minutesLength,damaged)
    if not cast is None:
        for a in cast:
            eObject.getCast().add(a)

# Init Borrower
# @generated 
def initBorrower(eObject,address=None,firstName=None,lastName=None,borrowed=None):
    initPerson(eObject,address,firstName,lastName)
    if not borrowed is None:
        for a in borrowed:
            eObject.getBorrowed().add(a)

# Init Person
# @generated 
def initPerson(eObject,address=None,firstName=None,lastName=None):
    initAddressable(eObject,address)
    if not firstName is None:
        eObject.setFirstName(firstName)
    if not lastName is None:
        eObject.setLastName(lastName)

# Init Employee
# @generated 
def initEmployee(eObject,address=None,firstName=None,lastName=None,manager=None):
    initPerson(eObject,address,firstName,lastName)
    if not manager is None:
        eObject.setManager(manager)

# Init Addressable
# @generated 
def initAddressable(eObject,address=None):
    if not address is None:
        eObject.setAddress(address)


            
        
loadModule("EcoreModule")
input = loadModule("InputModule")
loadModule("WorkbenchModule")
output = loadModule("OutputModule")
initEPackage("http:///org/eclipse/emf/examples/library/extlibrary.ecore/1.0.0")
# Get the selected EObject
lib = getSelection("Library")

#Fill the model
print lib
for b in range(1,3):
    book = createBook()
    print book
    initBook(eObject=book,title=askSimpleString("What is the title book?"))
    lib.getBooks().add(book)
for authorIndex in range(0,3):
    author = createWriter()
    initWriter(author,lastName=askSimpleString("What is the last name of the writer?"),books=selectFromList(lib.getBooks()))
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
