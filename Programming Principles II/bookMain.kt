import java.io.File

/************************************************************
 *  Name:         Eric Craigen
 *  Date:         10/12/2020
 *  Assignment:   Project: Books Class
 *  Class Number: 283
 *  Description:  A book inventory management and report generating
 *                application.
 ************************************************************/
// class for Book that defines what a Book is and how it should be displayed when called to print
class Book( var title : String, var author : String, var publicationYear : Int, var numberOfPages : Int, var isbn : Long ) {
    // override fun to convert a book into a formatted string for the report views
    override fun toString(): String {
            return "${title.padEnd(30).substring(0, 30)} ${author.padEnd(15).substring(0, 15)} ${publicationYear.toString().padStart(6).substring(0, 6)
            } ${numberOfPages.toString().padStart(5).substring(0, 5)} ${isbn.toString().padEnd(11).substring(0, 11)} http://www.biblio.com/${isbn.toString().padEnd(11).substring(0, 11)}"
    }
    // fun to convert list of books into a TAB delim strings for writing to a file
    fun toTab(): String {
        return "${title}\t${author}\t${publicationYear}\t${numberOfPages}\t$isbn"
    }
}
// fun to write the books list to file books.txt
fun writeToFile( books: MutableList<Book> ) {
    // open the file writer on books.txt
    val fileWriter = File( "src/books.txt" ).printWriter()
    // read over books and print each book with the toTab fun to the file
    for ( book in books ) {
        fileWriter.println( book.toTab())
    }
    // close the file writer on books.txt
    fileWriter.close()
}
// fun to print the headers dependent upon which spacing is needed for the correct report
fun printHeaders( headerSelectBool: Boolean ) {
    if ( headerSelectBool ) {
        println( """                                           Geeks Publishing, Inc.
    Name                           Author          Pub Yr Pages ISBN        URL
    ------------------------------ --------------- ------ ----- ----------- --------------------------------
    """.trimIndent() )
        } else
        {
            println( "                                       Geeks Publishing, Inc.")
            println( "      Name                           Author          Pub Yr Pages ISBN        URL")
            println( "      ------------------------------ --------------- ------ ----- ----------- --------------------------------" )
        }
}
// fun to view all books in books list with the appropriate header
fun viewAllBooks( books : MutableList<Book>, headerSelectBool: Boolean ) {
    printHeaders( headerSelectBool )
    for ( book in books ) {
        println(book)
    }
}
// fun to add a book to the books list
fun addBook(books: MutableList<Book>, headerSelectBool: Boolean) {
    // print the books again to show user current books in db
    viewAllBooks( books, headerSelectBool )
    print( "\nPlease enter the Name of the new book: " )
    var tempTitle = readLine()!!
    // validate the user did not enter an empty string and re-prompt for value if needed
        while ( tempTitle == "" ){
            print( "Please enter the Name of the new book: " )
            tempTitle = readLine()!!
        }
    print("Please enter the Author for '$tempTitle': ")
    var tempAuthor = readLine()!!
    // validate the user did not enter an empty string and re-prompt for value if needed
    while ( tempAuthor == "" ){
        print( "Please enter the Author for '$tempTitle': " )
        tempAuthor = readLine()!!
    }
    print("Please enter the Publication Year: ")
    var tempPubYear = readLine()!!.toIntOrNull()  ?: 0
    // validate the year entered is greater or equal to 1600 and re-prompt for value if needed
    while ( tempPubYear < 1600 ){
        print( "Please enter the Publication Year: " )
        tempPubYear = readLine()!!.toIntOrNull()  ?: 0
    }
    print("Please enter the number of pages: ")
    var tempPagesNum = readLine()!!.toIntOrNull()  ?: 0
    // validate the number of pages is greater than 0 and re-prompt for value if needed
    while ( tempPagesNum < 1 ){
        print( "Please enter the number of pages: " )
        tempPagesNum = readLine()!!.toIntOrNull()  ?: 0
    }
    print("Please enter the ISBN: ")
    var tempISBN = readLine()!!.toLongOrNull()  ?: 0
    // validate that the user has entered more than a blank string amd re-prompt for value if needed
    while ( tempISBN < 1 ){
        print( "Please enter the ISBN: " )
        tempISBN = readLine()!!.toLongOrNull()  ?: 0
    }
    val tempBook = Book( tempTitle, tempAuthor, tempPubYear, tempPagesNum, tempISBN)
    books.add( tempBook )
}
// fun to update a book in the books list
fun updateBook( books: MutableList<Book>, headerSelectBool: Boolean ) {
    // ctr to display the books in a numbered list for selection
    var ctr = 0
    printHeaders(headerSelectBool)
    // print each book in books and increment the ctr after each evaluation
    for ( book in books ) {
        println( "   ${ctr++ + 1}. $book" )
    }
    print("\nPlease choose a book to update: ")
    var tempToUpdate = readLine()!!.toIntOrNull()  ?: 0
    while ( tempToUpdate < 1 ){
        print( "Please choose a book to update: " )
        tempToUpdate = readLine()!!.toIntOrNull()  ?: 0
    }
    print( "Please enter the new Name of the book:" )
    var tempTitle = readLine()!!
    while ( tempTitle == "" ){
        print( "Please enter the new Name of the book: " )
        tempTitle = readLine()!!
    }
    print("Please enter the new Author for '$tempTitle': ")
    var tempAuthor = readLine()!!
    while ( tempAuthor == "" ){
        print( "Please enter the new Author for '$tempTitle': " )
        tempAuthor = readLine()!!
    }
    print("Please enter the new Publication Year: ")
    var tempPubYear = readLine()!!.toIntOrNull()  ?: 0
    while ( tempPubYear < 1600 ){
        print( "Please enter the new Publication Year: " )
        tempPubYear = readLine()!!.toIntOrNull()  ?: 0
    }
    print("Please enter the new number of pages: ")
    var tempPagesNum = readLine()!!.toIntOrNull()  ?: 0
    while ( tempPagesNum < 1 ){
        print( "Please enter the new number of pages: " )
        tempPagesNum = readLine()!!.toIntOrNull()  ?: 0
    }
    print("Please enter the new ISBN: ")
    var tempISBN = readLine()!!.toLongOrNull()  ?: 0
    while ( tempISBN < 1 ){
        print( "Please enter the new ISBN: " )
        tempISBN = readLine()!!.toLongOrNull()  ?: 0
    }
    val tempBook = Book( tempTitle, tempAuthor, tempPubYear, tempPagesNum, tempISBN)
    // reassign the value at the selected value - 1 in the index of books to the new tempBook value
    books[tempToUpdate - 1] = tempBook
}
// fun to delete a book from the books list
fun deleteBook( books: MutableList<Book>, headerSelectBool: Boolean ) {
    var ctr = 0
    printHeaders(headerSelectBool)
    for ( book in books ) {
        println( "   ${ctr++ + 1}. $book" )
    }
    print("\nPlease choose a book to delete: ")
    var tempToDelete = readLine()!!.toIntOrNull()  ?: 0
    while ( tempToDelete < 1 ){
        print( "Please choose a book to delete: " )
        tempToDelete = readLine()!!.toIntOrNull()  ?: 0
    }
    // delete the book at index of the users selection -1
    books.removeAt( tempToDelete - 1 )
}
// fun for comparing the list of books against one another for reporting
fun compareBooks( books: MutableList<Book>, userSelection : Int, headerSelectBool: Boolean )  {
    when ( userSelection ) {
        // display most pages book
        5 -> {
            printHeaders(headerSelectBool)
            // assign the max value for book.numberOfPages and reassign the value if a new higher value is found
            val tempMostPages = books.maxByOrNull { book: Book -> book.numberOfPages }
            for ( book in books ) {
                // any books with the number that tempMostPages landed on will be printed.
                // This covers the case  of two or more books having the same amount of pages and that being the most
                if ( book.numberOfPages == tempMostPages?.numberOfPages ) {
                    println(book)
                }
            }
        }
        6 -> {
            printHeaders(headerSelectBool)
            // assign the min value for book.numberOfPages and reassign the value if a new lower value is found
            val tempMinPages = books.minByOrNull { book: Book -> book.numberOfPages }
            for ( book in books ) {
                // any books with the number that tempMinPages landed on will be printed.
                // This covers the case  of two or more books having the same amount of pages and that being the least
                if ( book.numberOfPages == tempMinPages?.numberOfPages ) {
                    println(book)
                }
            }
        }
        7 -> {
            printHeaders(headerSelectBool)
            // display all books that are greater than or equal to 200 pages
            for ( book in books ) {
                if ( book.numberOfPages >= 200 ) {
                    println(book)
                }
            }
        }
        8 -> {
            printHeaders(headerSelectBool)
            // display all books that are less than 200 pages
            for ( book in books ) {
                if ( book.numberOfPages < 200 ) {
                    println(book)
                }
            }
        }
        9 -> {
            printHeaders(headerSelectBool)
            // display all books that are in-between 50 and 300 INCLUSIVE
            for ( book in books ) {
                if (book.numberOfPages in 50..300) {
                    println(book)
                }
            }
        }
    }
}
// main application fun
fun main() {
    // Initialize empty list to hold books
    val books = mutableListOf<Book>()
    // var to hold the file to be read into books list
    val fileName = "src/books.txt"
    // read the lines in the file
    val lines = File(fileName).readLines()
    // for each line present in the file de-structure into book properties and assign to temp book
    for ( line in lines ) {
        val tempProperties = line.split("\t")
        val tempBook = Book( tempProperties[0],tempProperties[1],tempProperties[2].toInt(),tempProperties[3].toInt(),tempProperties[4].toLong())
        // add each temp book to the books list
        books.add( tempBook )
    }
    // list to hold the menu items of the application
    val menuItems = mutableListOf<String>(
            "View all books",
            "Add book",
            "Update book",
            "Delete book",
            "View book with most pages",
            "View book with least pages",
            "View books with pages greater than or equal to 200",
            "View books with pages less than 200",
            "View books with pages between 50 - 300 inclusive",
            "Exit"
    )
    // variables for testing conditions for printing or exiting the program
    var headerSelectBool = true
    var returnBool = false
    var userSelection = 0
    // run the application while the return (exit) bool is false
    do {
        // generate menu items return string for menu display
        var menuStr = "\n"
        for (item in menuItems) {
            menuStr += if ( menuItems.indexOf(item) < 10 ) {
                "${(menuItems.indexOf(item) + 1).toString().padStart(2)}. $item\n"
            } else {
                "${menuItems.indexOf(item) + 1}. $item\n"
            }
        }
        // print the menuStr and prompt for a selection
        println("$menuStr")
        print("Please enter your selection: ")
        userSelection = readLine()!!.toIntOrNull() ?: 0
        // logic to call on application functions based of the users input, until the choose to exit
        when (userSelection) {
            1 -> {
                viewAllBooks( books, headerSelectBool )
            }
            2 -> {
                addBook( books, headerSelectBool )
            }
            3 -> {
                headerSelectBool = false
                updateBook( books, headerSelectBool )
                headerSelectBool = true
            }
            4 -> {
                headerSelectBool = false
                deleteBook( books, headerSelectBool )
                headerSelectBool = true
            }
            5 -> {
                compareBooks( books, userSelection, headerSelectBool )
            }
            6 -> {
                compareBooks( books, userSelection, headerSelectBool )
            }
            7 -> {
                compareBooks( books, userSelection, headerSelectBool )
            }
            8 -> {
                compareBooks( books, userSelection, headerSelectBool )
            }
            9 -> {
                compareBooks( books, userSelection, headerSelectBool )
            }
            10 -> {
                returnBool = true
                // write the books list to books.txt
                writeToFile( books )
            }
        }
        // kill application
    } while (!returnBool)
}