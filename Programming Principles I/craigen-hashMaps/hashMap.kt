import java.io.File
/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/26/2020
 *  Assignment:   Week 7 Project: HashMaps
 *  Class Number: 282
 *  Description:  A program to demonstrate the use of hashmaps as
 *                to maintain a simple store inventory control by
 *                utilizing read and write functions to a file
 ************************************************************/
fun main() {
    // ** create variable to store the src/products.txt file
    var productsFile = "src/products.txt"
    // ** products hashmap constructor
    var productsHash: HashMap<Int, Pair<String, Double>> = hashMapOf()

    // *-> call initialize hashmap function
    initializeHashMap(productsFile, productsHash)

    // ** array Menu List that will get passed into the menu function
    var menuItems = arrayOf(
        "View all products",
        "Add a new product",
        "Delete a product",
        "update a product",
        "View the highest priced product",
        "View the lowest priced product",
        "View sum of all product prices",
        "Exit"
    )
    //  ** assign the last list option to the exit function
    var exit = menuItems.size
    // ** create variable to hold the users menu selection
    var userChoice = 0
    println()
    println( "Local Asset Management System (LAMS) v0.1" )
    // -> while ( users choice is not exit option )
    while ( userChoice != exit ) {
         // * as user to enter a menu selection
        userChoice = menu( menuItems, "Please enter your selection: " )

        when ( userChoice ) {

            1 -> {
                // Call function to print the header of the display UI
                println(printHeader( productsHash ))
                // Call function to print the ALL products from the hashmap in ASCENDING order
                println( queryViewAllProds( productsHash ) )
            }
            2 -> {
                // ask user to enter new item description
                print( "Please enter the description of the new item: " )
                var newItemInput = readLine()!!
                // ask user to enter new item price
                print( "Please enter the price of the ${newItemInput}: " )
                var newPriceInput = readLine()!!.toDouble()
                // pass user input to add new item function for adding to hashmap
                println( addNewItem( productsHash, newItemInput, newPriceInput ) )
            }
            3 -> {
                // display header and hashmap contents to user so they can choose an item to delete
                println( printHeader( productsHash ) )
                println( printBody( productsHash ) )
                println( deleteItem( productsHash ) )
            }
            4 -> {
                // display header and hashmap contents to user so they can choose an item to update
                println( printHeader( productsHash ) )
                println( printBody( productsHash ) )
                println( updateUtility( productsHash ) )
            }
            5 -> {
                // display properly spaced header and the highest priced item
                println( printTopPriceHeader( productsHash ) )
                println( printTopPriceBody( productsHash ) )
            }
            6 -> {
                // display properly spaced header and the lowest priced item
                println( printBottomPriceHeader( productsHash ) )
                println( printBottomPriceBody( productsHash ) )


            }
            7 -> {
                // Add all the items in the hashmap and display the sum formatted as currency
                println( getSumPrice( productsHash ) )


            }
            8 -> {
                // exit the program and write the hashmap the src/products.txt
                writeHashToFile(productsFile, productsHash)
            }
            else -> {
                // if user menu selection does not equal the exit option: display warning
                if ( userChoice != exit ) {
                    println( "ERROR: Please select a valid menu option." )
                }
            }
        }
    }
}

// --> fun ( initialize HashMap from src/product.txt: store in var productsFile )
    fun initializeHashMap( productsFile : String, productsHash : HashMap<Int, Pair<String, Double>>
) : HashMap<Int, Pair<String, Double>> {
    // read and split each line the src/products.txt file and store them in the hashmap
    File( productsFile ).forEachLine {
        var cellContents = it.split("," )
        productsHash[ cellContents[0].toInt() ] = Pair( cellContents[1], cellContents[2].toDouble() )
    }
    return productsHash
}

// --> fun ( build menu for UI )
    fun menu( menuItems : Array<String>, prompt : String ) : Int {
    println()
    // loop through the menuItems array to print the menu
    for ( ( index, item ) in menuItems.withIndex() ) {
        println( "${index + 1}. $item" )
    }
    println()
    // display selection prompt to user
    print( prompt )
    // get user input
    return readLine()!!.toInt()
}

// --> fun ( write hashmap to src/product.txt on close )
    fun writeHashToFile(productsFile: String, productsHash: HashMap<Int, Pair<String, Double>>)  {
    var fileWriter = File( productsFile ).printWriter()
    // loop through the records in the hashmap and write them line by line in csv format
    for ( dbRecord in productsHash ) {
        fileWriter.println( "${dbRecord.key},${dbRecord.value.first},${dbRecord.value.second}" )
    }
    // close the file writer
    fileWriter.close()
}

// --> fun ( calculate product.value.second.length in the hashmap ) // this allows me to add or remove spaces
// and underscores in the output as needed
    fun calcHeaderSpacings( productsHash: HashMap<Int, Pair<String, Double>> ) : Int {
    // create variables to calculate the spacing the the header for displaying all records
    var maxDescLength = 0
    var descLength: Int
    // for records in hashmap: get the length of the description for each record and store the highest number
    for (dbRecord in productsHash) {
        descLength = dbRecord.value.first.length
        // if the new desc being looked at is longer than the last:
        if (descLength > maxDescLength) {
            // store the new higher number as the max length
            maxDescLength = descLength
        }
    }
    return maxDescLength
}

// --> fun ( print header everywhere needed throughout program )
    fun printHeader( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1, padChar : String = " " ) : String {
    // create variables to calculate the under spaces needed to format the header break line correctly
    var maxDescLength = calcHeaderSpacings( productsHash )
    var headerString = ""
    var underscores = 0
    // if the max length is longther than the default column width of 11 chars:
    if (maxDescLength >= 11) {
        // number of underscores is equal to the max length value minus the default value of 11
        underscores = maxDescLength - 11
    }
    // -> loops to generate the spacing in the header
    headerString += "Item#"
    for (spaces in 0..spacingWidth + 1) {
        headerString += padChar
    }
    headerString += "Description"
    for (spaces in 0..spacingWidth + 3 + underscores) {
        headerString += padChar
    }
    headerString += "Price\n"
    // start header row two
    headerString += "_____"
    for (spaces in 0..spacingWidth + 1) {
        headerString += padChar
    }
    headerString += "___________"
    for (scores in 1..underscores) {
        headerString += "_"
    }
    for (spaces in 0..spacingWidth + 1) {
        headerString += padChar
    }
    headerString += "_______"
    return headerString
}

// --> fun ( Menu Option # 1 ( View all products query ) )
    fun queryViewAllProds(productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1,
                      padChar: String = " ") : String {
    // create variables to generate the view all prods query
    var maxDescLength = calcHeaderSpacings( productsHash )
    var descColumnWidth = 0
    var viewAllProdsDisplay = ""
    var extraSpaces = 0
    // if the desc length is less than default of 11: set descColumnWidth to the base of 14 for default spacing
    descColumnWidth = if ( maxDescLength <= 11 ) {
        14
    } else {
        // else add the three spaces needed for formatting to the descColumnWidth
        maxDescLength + 3
    }
    // loop through the records in the hashmap and build the string to display the body of the report
    for ( dbRecord in productsHash.toSortedMap() ) {
        // add the key to the output string
        viewAllProdsDisplay += "${dbRecord.key}"
        // add spacing for proper formatting
        for (spaces in 0..spacingWidth + 3) {
            viewAllProdsDisplay += padChar
        }
        // add the description to the string
        viewAllProdsDisplay += "${dbRecord.value.first}"
        // create variable to store the description length
        var descLength = dbRecord.value.first.length
        // calculate the extra spaces needed for THIS row
        extraSpaces = descColumnWidth - descLength - 2
        // add spacing for proper formatting
        for ( spaces in 0..spacingWidth + extraSpaces ) {
            viewAllProdsDisplay += padChar
        }
        // add $ sign to the output string
        viewAllProdsDisplay += "$"
        // if the price is 1 digit left of decimal: add two blank spaces between $ sign and price
        if (dbRecord.value.second in 0.0..9.99) {
            for ( spaces in 0..spacingWidth ) {
                viewAllProdsDisplay += padChar
            }
            // else
        } else
            // if the price is 2 digits left of decimal: add one blank space between $ sign and price
            if (dbRecord.value.second in 10.0..99.99) {
                for ( spaces in 0 until spacingWidth ) {
                    viewAllProdsDisplay += padChar
                }
            }
        // add the price formatted to 2 decimal places to the output string
        viewAllProdsDisplay += "${"%.2f".format(dbRecord.value.second)}\n"
    }
    return viewAllProdsDisplay
}

// --> fun ( print the body of the view all products query (Menu Option #1) )
    fun printBody( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1,
               padChar: String = " " ) : String {
    // create variables to print contents of the hashmap on update and delete functions
    var maxDescLength = calcHeaderSpacings( productsHash )
    var descColumnWidth = 0
    var viewAllProdsDisplay = ""
    var extraSpaces = 0
    // if max description length is less than the default of 11: descColumnWidth is 14
    descColumnWidth = if ( maxDescLength <= 11 ) {
        14
    } else {
        // else: add three to the maxDescLength for proper spacing
        maxDescLength + 3
    }
    // loop through the hashmap to build the output string
    for ( dbRecord in productsHash ) {
        // add the key to the output string
        viewAllProdsDisplay += "${dbRecord.key}"
        // add spaces for proper formatting
        for (spaces in 0..spacingWidth + 3) {
            viewAllProdsDisplay += padChar
        }
        // add the description to the output string
        viewAllProdsDisplay += "${dbRecord.value.first}"
        // create variable to store the description length
        var descLength = dbRecord.value.first.length
        // calculate the extra spaces needed for each row in the report
        extraSpaces = descColumnWidth - descLength - 2
        // add spaces for proper formatting
        for ( spaces in 0..spacingWidth + extraSpaces ) {
            viewAllProdsDisplay += padChar
        }
        // add the price to the output string formatted to 2 decimal places
        viewAllProdsDisplay += "${"$%.2f".format(dbRecord.value.second)}\n"
    }
    return viewAllProdsDisplay
}

// --> fun ( add a new item to the mock Db )
    fun addNewItem(productsHash: HashMap<Int, Pair<String, Double>>, newItemInput: String, newPriceInput: Double ) : String {
    // generate a random number to assign the new key to the new record
    val randomKeyGenerator = IntArray(899) { (100..999).random() }
    // pull a number from the array and store in variable
    var newKey = randomKeyGenerator[0]
    // while the newKey generated is currently assigned to a record in the hashmap
    while ( productsHash.containsKey(newKey) ){
        for ( key in randomKeyGenerator ){
            newKey = randomKeyGenerator[0]
        }
    }
    // assign the new records information into the hashmap
    productsHash[newKey] = Pair(first = newItemInput, second = newPriceInput)
    // message: record added
    return "New Record has been added!"
}

// --> fun ( delete a item from the mock Db )
    fun deleteItem( productsHash: HashMap<Int, Pair<String, Double>> ) : String {
    // create variable for delete item function
    var errorBool = true
    var deleteChoice = 0
    // while the error state is true
    while (errorBool) {
        // ask the user to choose a record to delete
        print("Please choose a record to delete: ")
        // get the choice from the user and store it in deleteChoice
        deleteChoice = readLine()!!.toInt()
        // loop through the hashmap: the error bool with turn the false when the user choice equals a key for a record
        // contained in the hashmap
        for (dbRecord in productsHash) {
            errorBool = productsHash.containsKey(deleteChoice) == dbRecord.equals(deleteChoice)
        }
        // if the user choice was not a record: warn the user the record doesn't exist and reprint the contents of
        // the hashmap
        if (errorBool) {
            println("Record does not exist!")
            println( printHeader( productsHash ) )
            println( printBody( productsHash ) )
        }

    }
    // if the users choice did match a record in the hashmap: delete the record from the hashmap
    productsHash.remove(deleteChoice)
    // message: record deleted
    return "Record has been deleted!"
}

// --> fun ( update an item in the mock Db )
    fun updateUtility(productsHash: HashMap<Int, Pair<String, Double>>) : String {
    // create variables for update utility
    var errorBool = true
    var updateChoice = 0
    // while the errorBool is true
    while (errorBool) {
        // ask the user to choose a record to update
        print("Please choose a record to update: ")
        // get and store the users choice of record to update
        updateChoice = readLine()!!.toInt()
        // loop through the hashmap to see the the users choice is contained in the hashmap
        for (dbRecord in productsHash) {
            errorBool = productsHash.containsKey(updateChoice) == dbRecord.equals(updateChoice)
        }
        // if the error bool is still true
        if (errorBool) {
            // warn user the record does not exist and reprint the contents of the hashmap
            println("Record does not exist!")
            println( printHeader( productsHash ) )
            println( printBody( productsHash ) )
        }
    }
    // the user choice matched a record: ask the user for the new description of the item
    print( "Please enter the description of the new item: " )
    // get the users input for the new description of the item
    var newItemInput = readLine()!!
    // ask the user to enter the new price of the item
    print( "Please enter the price of the ${newItemInput}: " )
    // get the users input for the new price of the item
    var newPriceInput = readLine()!!.toDouble()
    // for the record the user chose: update the value of the hashmap (Pair( , ))
    productsHash[updateChoice] = Pair(first = newItemInput, second = newPriceInput)
    // message: record updated
    return "Record has been updated!"
}

// --> fun ( get the Top price in the mock Db )
    fun getTopPrice( productsHash: HashMap<Int, Pair<String, Double>> ) : String {
    // create variables to calculate the top priced item
    var resultsString = ""
    var prevTopPrice = 0.0
    var resultsPrice = 0.0
    var resultsKey = 0
    var resultsDesc = ""
    // loop through the hashmap
    productsHash.forEach {
        prevTopPrice = it.value.second
        // if the prev price is greater than or equal to the new price:
        if ( prevTopPrice >= resultsPrice ) {
            // update the new top price value
            resultsPrice = prevTopPrice
            // get the key of that record
            resultsKey = it.key
            // get the description of that record
            resultsDesc = it.value.first
        }
    }
    //build the csv formatted string with the results of the top priced item
    resultsString += "${resultsKey},${resultsDesc},${resultsPrice}"
    return resultsString
}

// --> fun ( get the Bottom price in the mock Db )
    fun getBottomPrice( productsHash: HashMap<Int, Pair<String, Double>> ) : String {
    // create variables to calculate the lowest priced item
    var resultsString = ""
    var nextPrice = 0.0
    var resultsKey = 0
    var resultsDesc = ""
    var resultsPrice = 999.99
    // loop through the hashmap
    productsHash.forEach {
        nextPrice = it.value.second
        // if the new price is less than or equal to the prev price
        if ( resultsPrice >= nextPrice ) {
            // assign the new lower price to the results price variable
            resultsPrice = nextPrice
            // get the value of the key for this item
            resultsKey = it.key
            // get the value of the description for this item
            resultsDesc = it.value.first
        }
    }
    // build the csv formatted string with the results for the lowest priced item
    resultsString += "${resultsKey},${resultsDesc},${resultsPrice}"
    return resultsString
}

// --> fun to display the results header for the Top price result in the mock Db
    fun printTopPriceHeader( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1, padChar : String =
    " " ) : String {
    // create variables to print the header for the top price report
        var resultsTop = (getTopPrice(productsHash))
        var results = resultsTop.split(",")
        var resultsDesc = results[1].length
        var maxDescLength = resultsDesc
        var headerString = ""
        var underscores = 0
    // logic to calculate the underscores needed for proper formatting and build the result string
        if (maxDescLength >= 11) {
            underscores = maxDescLength - 11
        }
        // start header string build
        headerString += "Item#"
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "Description"
        for (spaces in 0..spacingWidth + 3 + underscores) {
            headerString += padChar
        }
        headerString += "Price\n"
        // start header row two
        headerString += "_____"
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "___________"
        for (scores in 1..underscores) {
            headerString += "_"
        }
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "_______"
    //    println(overflow)
    //    println(underscores)
        return headerString
    }

// --> fun ( display the results header for the Bottom price result in the mock Db )
    fun printBottomPriceHeader( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1, padChar : String =
        " " ) : String {
    // create variables to print the lowest priced items header
        var resultsTop = (getBottomPrice(productsHash))
        var results = resultsTop.split(",")
        var resultsDesc = results[1].length
        var maxDescLength = resultsDesc
        var headerString = ""
        var underscores = 0
    // logic to calculate the underscores needed for proper formatting and build the result string
        if (maxDescLength >= 11) {
            underscores = maxDescLength - 11
        }
        // start header string build
        headerString += "Item#"
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "Description"
        for (spaces in 0..spacingWidth + 3 + underscores) {
            headerString += padChar
        }
        headerString += "Price\n"
        // start header row two
        headerString += "_____"
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "___________"
        for (scores in 1..underscores) {
            headerString += "_"
        }
        for (spaces in 0..spacingWidth + 1) {
            headerString += padChar
        }
        headerString += "_______"
        return headerString
    }

// --> fun ( display the Top price body (single result) )
    fun printTopPriceBody( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1,
                       padChar: String = " " ) : String{
    // create variables to print the top price result
        var resultsString = ""
        var resultsTop = (getTopPrice(productsHash))
        var results = resultsTop.split(",")
        var resultsKey = results[0].toInt()
        var resultsDesc = results[1]
        var resultsPrice = results[2].toDouble()
        var maxDescLength = resultsDesc.length
        var descColumnWidth = 0
        var extraSpaces = 0
        // logic to calculate the spacing needed for proper formatting and build the result string
        descColumnWidth = if ( maxDescLength <= 11 ) {
            14
        } else {
            maxDescLength + 3
        }
        resultsString += resultsKey
        for (spaces in 0..spacingWidth + 3) {
            resultsString += padChar
        }
        resultsString += resultsDesc
        var descLength = resultsDesc.length
        extraSpaces = descColumnWidth - descLength - 2

        for ( spaces in 0..spacingWidth + extraSpaces ) {
            resultsString += padChar
        }
        resultsString += "$"
        if (resultsPrice in 0.0..9.99) {
            for ( spaces in 0..spacingWidth ) {
                resultsString += padChar
            }
        } else
            if (resultsPrice in 10.0..99.99) {
                for ( spaces in 0 until spacingWidth ) {
                    resultsString += padChar
                }
            }
        resultsString += "${"%.2f".format(resultsPrice)}\n"
    //    resultsString += "${resultsKey},${resultsDesc},${resultsPrice}"
        return resultsString
    }

// --> fun ( display the Bottom price body (single result) )
    fun printBottomPriceBody( productsHash: HashMap<Int, Pair<String, Double>>, spacingWidth : Int = 1,
                           padChar: String = " " ) : String{
    // create variables to print the result for the lowest priced item
        var resultsString = ""
        var resultsBottom = (getBottomPrice(productsHash))
        var results = resultsBottom.split(",")
        var resultsKey = results[0].toInt()
        var resultsDesc = results[1]
        var resultsPrice = results[2].toDouble()
        var maxDescLength = resultsDesc.length
        var descColumnWidth = 0
        var extraSpaces = 0
    // logic to calculate the spacing needed for proper formatting and build the result string
    descColumnWidth = if ( maxDescLength <= 11 ) {
            14
        } else {
            maxDescLength + 3
        }
        resultsString += resultsKey
        for (spaces in 0..spacingWidth + 3) {
            resultsString += padChar
        }
        resultsString += resultsDesc
        var descLength = resultsDesc.length
        extraSpaces = descColumnWidth - descLength - 2

        for ( spaces in 0..spacingWidth + extraSpaces ) {
            resultsString += padChar
        }
        resultsString += "$"
        if (resultsPrice in 0.0..9.99) {
            for ( spaces in 0..spacingWidth ) {
                resultsString += padChar
            }
        } else
            if (resultsPrice in 10.0..99.99) {
                for ( spaces in 0 until spacingWidth ) {
                    resultsString += padChar
                }
            }
        resultsString += "${"%.2f".format(resultsPrice)}\n"
    //    resultsString += "${resultsKey},${resultsDesc},${resultsPrice}"
        return resultsString
    }

// --> fun ( get and display the Sum of the prices in the mock Db )
    fun getSumPrice( productsHash: HashMap<Int, Pair<String, Double>> ) : String {
    // create variable to store the sum
        var resultsPrice = 0.0
    // loop through the hashmap: add each price value to itself as the loop progresses and store it in the results
    // price variable
        productsHash.forEach {
            resultsPrice += it.value.second
        }
    // return the results price formatted as currency in the result string
        return "The Total of all products is: $${"%.2f".format(resultsPrice)}"
    }