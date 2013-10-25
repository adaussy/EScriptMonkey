#
 # Menu: EclipseCon > Modeling > Fill library V2
 # Description: Create a new library fill with Authors
 # Thread: UI


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
    if not stock is None:
        for a in stock:
            eObject.getStock().add(a)
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


            
writersLastName = ["WELLMAN",
"MANLY WADE",
"WELLMAN",
"SHAW",
"HICKS",
"CHASE",
"DE MILLE",
"KIMZEY",
"NEWTON",
"PAUL",
"JACOBS",
"HALL",
"THROOP",
"OWEN",
"ZACHARY",
"GODFREY, JR.",
"HOOPER",
"RUARK",
"RUSSELL",
"EHLE",
"MCFEE",
"GRAHAM",
"MILLER",
"RICHARDSON",
"WOLFE",
"YOUNG",
"DISANTO",
"STREET",
"HARMON",
"SAWYER",
"SIMPSON",
"TILLEY",
"JONES",
"STALLINGS",
"STOCKARD",
"KAUFMAN",
"POE",
"HORTON",
"HUNTER",
"OLMSTEAD",
"FLETCHER",
"HUGHES",
"CASH",
"DIXON, JR.",
"AMMONS",
"HAWKS",
"SHEPARD",
"GASTON",
"HALE",
"MCLAURIN",
"PAGE",
"BLACKSTOCK",
"STRANGE",
"MCCULLERS",
"CHESNUTT",
"GERARD",
"RANDALL",
"STICK",
"HOLDEN",
"WECHTER",
"DE BLIEU",
"WALSER",
"LEFLER",
"DAVIS",
"MURRAY",
"GOLDMAN",
"WEBB",
"BEVINGTON",
"SMITH",
"EDGERTON",
"FRANKLIN",
"WILKINSON",
"BROWN",
"GURGANUS",
"CHESHIRE, JR.",
"CRISP",
"EATON",
"FRIES",
"BLAIR",
"HANES",
"EATON",
"PEARSON",
"TUCKER",
"FULLER",
"ATKINS",
"BROCKMAN",
"SLAUGHTER",
"STEM, JR.",
"HENDERSON",
"JARRELL",
"CARD",
"MURROW",
"DEAGON",
"PORTER",
"GILBERT",
"WATSON",
"WATSON",
"FLYNT",
"TOURGEE",
"FOWLER",
"GREEN",
"GREEN",
"CHAPPELL",
"GODWIN",
"TUCKER",
"MORGAN",
"WILLIAMS",
"SANDBURG",
"MOORE",
"JOHNSON",
"PARRAMORE",
"CREDLE",
"WHEDBE",
"MACNEILL",
"STEINKE",
"GOERCH",
"BETTS",
"HURMENCE",
"BRIDGERS",
"BYER",
"MARON",
"POWELL",
"STEPHENSON",
"ETHRIDGE",
"KEY",
"DARGAN",
"PRITCHARD",
"WHITTLESEY",
"WALKER",
"SUK",
"BLYTHE",
"REDDY",
"BYARS",
"ROBERTS",
"NEWMAN",
"GREY",
"LINER",
"HAAS",
"KURALT",
"GOLDEN",
"LUDVIGSON",
"KRATT",
"HENDERSON",
"BOYD",
"SMITH",
"ROUNDS",
"RAGAN",
"COONEY",
"WILDER, JR.",
"GIBBONS",
"PAYNE",
"RENDER",
"ASHE",
"MEADER",
"WORTH",
"BRINKLEY",
"BACHE",
"FORT",
"HARRIS",
"ROOKE",
"HOLMAN",
"SIMPSON",
"HUDSON",
"SAFRANSKY",
"RUSSELL",
"SEAY",
"RUBIN, JR.",
"SAULS",
"WANN",
"WAGNER",
"HARDY",
"GREEN",
"ZUG III",
"FITZ-SIMMONS",
"ATHAS",
"STEELE",
"SPEARMAN",
"SMITH",
"HOGAN",
"STREET",
"HENDERSON",
"DRAKE",
"LIPSITZ",
"KOCH",
"BROOKHOUSE",
"MCCURDY",
"MCKENNA",
"PATTERSON",
"JONES",
"WILLIAMS",
"QUAKER",
"LONG",
"NAUMOFF",
"COTTEN",
"PIERCE",
"HALLBERG",
"WICKER",
"MCLEOD",
"MITCHELL",
"MCCORKLE",
"TIERNAM",
"HELPER",
"JOHNSON",
"BAYES",
"MCNEILL",
"ROSS",
"MORGAN",
"MOOSE",
"KEPHART",
"DYKEMAN",
"BOYARD",
"BOYSTER",
"MOORE",
"CAUDLE",
"HOLDEN",
"SLEDD",
"BRANTLEY",
"WOOTEN",
"ADCOCK",
"RUDNER",
"DANIELS",
"DAVIS-GARDNER",
"DANIELS",
"TLYER",
"HAWKINS",
"BARRAX",
"PATTON",
"HAYWOOD",
"KESSELL",
"PAGE",
"PRICE",
"POLK",
"WILLIAMS",
"YOUNT",
"WEST",
"LINNEY",
"ROGERS",
"BUDDOUR",
"PEARSON",
"APPLEWHITE",
"SHACKLEFORD",
"FERRELL",
"SHIVERS",
"CONNER",
"BONER",
"DOWNER"]


writersFirstName = ["MANLY WADE",
"BYNUM",
"ROY",
"RICHARD",
"CECIL B.",
"ARDIS",
"SUZANNE",
"NELLIE MILES",
"HARRIET A.",
"CLEMENT (REV.)",
"GEORGE H.",
"GUY",
"HUGH",
"THOMAS",
"JOSEPH J.",
"ROBERT",
"HARRY K.",
"JOHN",
"MICHAEL",
"BILLY (REV.)",
"JIM WAYNE",
"HOWARD",
"THOMAS",
"CHARLOTTE",
"GRACE",
"JULIA MONTGOMERY",
"WILLIAM",
"LEMUEL",
"BOB",
"NANCY",
"H. G.",
"LAURENCE",
"HENRY JEROME",
"WALLACE",
"CLARENCE",
"GEORGE MOSES",
"KERMIT",
"STANLEY",
"INGLIS",
"HATCHER",
"W. J.",
"THOMAS",
"A. R.",
"FRANCIS LESTER (REV.)",
"JAMES BIDDLE",
"WILLIAM",
"E. J.",
"TIM",
"HUBBARD FULTON",
"WALTER",
"ROBERT",
"CARSON",
"CHARLES W.",
"PHILIP",
"JOHN D.",
"DAVID",
"JOSEPH WILLIAM",
"NELL WISE",
"JON",
"RICHARD",
"HUGH T.",
"BURKE",
"PAULI",
"LAUREL",
"MENA",
"HELEN",
"AMANDA",
"CLYDE",
"JOHN HOPE",
"SYLVIA",
"FRANK C.",
"ALLAN",
"J. B. (RT. REV.)",
"LUCY CHERRY",
"WILLIAM CLEMENT",
"ADELAIDE L.",
"JOHN FRIES",
"FRANK BORDEN",
"CHARLES EDWARD",
"T. R.",
"HELEN",
"EDWIN W.",
"STEWART",
"ZOE KINCAID",
"FRANK G.",
"THAD",
"CALVIN WILEY",
"RANDALL",
"ORSON SCOTT",
"EDWARD R.",
"ANN",
"WILLIAM SIDNEY (O. HENRY)",
"MARIE",
"ROBERT",
"EDWARD R.",
"CANDACE",
"ALBION W.",
"MALCOM",
"PAUL",
"LEWIS W.",
"FRED",
"GAIL",
"GLEN",
"ROBERT",
"JONATHAN",
"CARL",
"JOHN WHEELER",
"F. ROY",
"THOMAS C.",
"ELLIS",
"CHARLES HARRY",
"BEN DIXON",
"DARCY PHELPS",
"CARL",
"DORIS",
"BELINDA",
"SUE ELLEN",
"KATHRYN STRIPLING",
"MARGARET",
"WILLIAM S.",
"SHELBY",
"WILLIE SNOW",
"ALEXANDER",
"OLIVE TILFORD",
"JOHN W.",
"SARAH",
"LOCHLIN",
"JULIE",
"LEGETTE",
"T. J.",
"BETSY",
"NANCY",
"PAUL BAKER",
"ROBERT WATERS",
"AMON",
"BEN",
"CHARLES",
"HARRY",
"SUSAN",
"MARY",
"PHILO",
"JAMES",
"STEPHEN E.",
"GLEN",
"SAM",
"CAROLINE B.",
"ROY",
"KAYE",
"PEGGY",
"JESSIE",
"SAMUEL A.",
"STEPHEN W.",
"KATHRYN",
"DAVID",
"ELLYN",
"CHARLES",
"BERNICE KELLY",
"LEON",
"C. HUGH",
"BLAND",
"ARTHUR PALMER",
"SY",
"PHILLIPS",
"JAMES",
"LOUIS D.",
"ROGER",
"JIM",
"KARL EDWARD",
"WILLIAM M.",
"ELIZABETH LAY",
"CHARLES T.",
"FOSTER",
"DAPHNE",
"MAX",
"WALTER",
"LEE",
"JUDY",
"JAMES",
"ARCHIBALD",
"DAVID",
"LOU",
"FREDERICK HENRY",
"CHRISTOPHER",
"HAROLD GRIER",
"RICHARD",
"DANIEL W.",
"PAUL",
"SAMM-ART",
"HENRY WHITE",
"VIRGINIA LOVE",
"LAWRENCE",
"SALLIE SOUTHALL",
"OVID WILLIAMS",
"WILLIAM",
"TOM",
"NORMAN",
"JOSEPH",
"JILL",
"FRANCES FISHER (""CHRISTIAN REID"")",
"HINTON ROWAN",
"GERALD W.",
"RONALD H.",
"JOHN CHARLES",
"HEATHER",
"FRED T.",
"RUTH",
"HORACE",
"WILMA",
"MARY",
"VERMONT",
"LENARD D.",
"NEIL",
"WILLIAM W.",
"BENJAMIN F.",
"RUSSELL",
"ANNA",
"BETTY",
"LAWRENCE",
"JONATHAN",
"ANGELA",
"JOSEPHUS",
"ANNE",
"THOMAS",
"GERALD",
"FRANCES GRAY",
"MARSHALL D.",
"JOHN",
"WALTER HINES",
"REYNOLDS",
"WILLIAM T.",
"CRATIS",
"JOHN",
"JOHN FOSTER",
"ROMULUS",
"DENNIS",
"MARGARET",
"JAMES LARKIN",
"JAMES",
"RUBY",
"ANDERSON",
"LOUISE",
"R. D. W.",
"JOHN HENRY",
"HILDA"
]

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
initLibrary(lib,name="My new Library")
newResource.getContents().add(lib)

#Fill the model
print lib.getName()+" has been created"
for lastNameIte, firstNameIte in zip(writersLastName, writersFirstName):
    print "Creating new writer "+lastNameIte+" "+firstNameIte
    author = createWriter()
    initWriter(author,lastName=lastNameIte,firstName=firstNameIte)
    lib.getWriters().add(author)


save(lib)
#Write the result in a file
print "Generating results"
content = "Library: \n"
for author in lib.getWriters():
    content +=author.getName()+"\n"
location = input.selectContainer("Location of the result", "Select the directory where to place the result:");
output.createNewFile(location[0], "result.txt",content)
