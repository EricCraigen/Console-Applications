/************************************************************
 *  Name:         Eric Craigen
 *  Date:         4/21/2020
 *  Assignment:   Week 3 Project: Triangle
 *  Class Number: 282
 *  Description:  Create a triangle drawing application
 ************************************************************/

//  *** START PSEUDO CODE ***

// **  GENERAL CODE  **

//      Ask the user for a number of rows
//      Create and store value in variable: size w/ a readLine
//      Create variable: reset and set it to size for later use

//  **  PART 1  **

//      (Top Row)

//      If size >= 1: print line 1 of triangle "*"

//      (Second Row)

//      If number is >= 2: print line 2 of triangle "**"

//      (Interior Rows)

//      Print inner lines for size > 2
//          For size > 2: execute code
//              print "*" to start the line
//              for counter2 >= counter 1: print " "
//          Print line "*" to finish off line

//      (Bottom Row)

//      If size > 2: execute code
//          for counter in size: execute code
//              print "*"
//          print line to start part 2 on a new line

//  **  PART 2  **

//      for counter in 1 to size
//          for counter2 in 1 to counter: print the value of counter2
//      print line to start Extra Credit on a new line

//  **  Extra Credit  **

//      (Top Row)

//      Instantiate variable for while loop counter
//      If size >= 1: execute code
//          While count <= size -2: print " " and increase counter by 1
//          Print line "*" to start the next line

//      (Second Row)

//      Reset the counter to 0
//      If size >= 2: execute code
//          While count <= size -3: print " " and increase counter by 1
//          Print line "**" to start the inner lines

//      (Interior Rows)

//      For counter in 1 to size - 3: execute code
//          For counter2 in size to 4 (decreasing counter 2 each loop)
//              // Print " "
//          // Print "*"
//          For counter3 in 1 to count 1
//              Print " "
//          Print line "*" to start the next line
//          Decrease size by 1 to get 1 less blank space in the start of each middle row

//      (Bottom Row)

//      If size > 2: execute code
//          For counter in 1 to reset: execute code
//              Print "*"
//          Print line in to start a new row for future expansion

//  *** END PSEUDO CODE ***

fun main() {

    // Ask the user for a number of rows
    print("Please enter a number of rows: ")
    // Create and store value in variable: size w/ a readLine
    var size = readLine()!!.toInt()
    // Create variable: reset and set it to size for later use
    var reset = size

//  ***** Part-1 *****

    // Print top line of triangle if size is >= 1
    if ( size >= 1 ) {
        println( "*" )
    }
    // If number is >= 2: print line 2 of triangle "**"
    if ( size >= 2 ) {
        println( "**" )
    }

    // Print inner lines for size > 2
    // For size > 2: execute code
    for ( i in 1..size - 3 ) {
        // Print "*" to start the line
        print( "*" )
        // For counter2 >= counter 1: print " "
        for ( j in 1..i ) {
            print( " " )
        }
        // Print line "*" to finish current line and start the next
        println( "*" )
    }

    // If size > 2: execute code
    if ( size > 2 ) {
        // for counter in size: print "*"
        for ( i in 1..size ) {
            print( "*" )
        }
        // print line to start part 2 on a new line
        println()
    }

//  ***** Part-2 *****

    // for counter in 1 to size
    for ( i in 1..size ) {
        // for counter2 in 1 to counter: print the value of counter2
        for ( j in 1..i ) {
            print( "$j" )
        }
        println()
    }

//  ***** Extra Credit *****

    // Instantiate variable for while loop counter
    var count = 0

    // If size >= 1: execute code
    if ( size >= 1 ) {

        // While count <= size -2: print " " and increase counter by 1
        while ( count <= size - 2 ) {
            print( " " )
            count++
        }
        // Print line "*" to start the next line
        println( "*" )
    }

    // Reset the counter to 0
    count = 0

    // If size >= 2: execute code
    if ( size >= 2 ) {

        // While count <= size -3: print " " and increase counter by 1
        while (count <= size - 3) {
            print(" ")
            count++
        }
        // Print line "**" to start the inner lines
        println("**")
    }

    // For counter in 1 to size - 3: execute code
    for ( i in 1..size - 3 ) {

        // For counter2 in size to 4 (decreasing counter 2 each loop)
        for ( j in size downTo 4 ) {
            // Print " "
            print( " " )
        }
        // Print "*"
        print( "*" )
        // For counter3 in 1 to count 1
        for ( k in 1..i ) {
            // Print " "
            print( " " )
        }
        // Print line "*" to start the next line
        println( "*" )
        // Decrease size by 1 to get 1 less blank space in the start of each middle row
        size--
    }

    // If size > 2: execute code
    if ( size > 2 ) {
        // For counter in 1 to reset: execute code
        for ( i in 1..reset ) {
            // Print "*"
            print( "*" )
        }
        // Print line in to start a new row for future expansion
        println()
    }
}

