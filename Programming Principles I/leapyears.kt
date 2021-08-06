/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/26/2020
 *  Assignment:   Leap Years (Extra Credit)
 *  Class Number: 282
 *  Description:  Program to calculate and display the leap years
 *                in a user defined range
 ************************************************************/
fun main() {
    // ask user to enter a starting year
    print( "Please enter a starting year: " )
    // get and store the starting year from user
    var year1 = readLine()!!.toInt()
    // ask user to enter a ending year
    print( "Please enter a ending year: " )
    // get and store the ending year from user
    var year2 = readLine()!!.toInt()
    // create array to start the leap years
    val yearHolder = ArrayList<Int>()
    // create blank output string to update
    var outputString = ""
    // while ending year plus one is greater than starting year
    while ( year2 + 1 > year1 ) {
        // if leap starting year qualifies as a leap year
        if ( checkIfLeapYear(year1) ) {
            // append year to yearHolder array
            yearHolder += year1
            // increment starting year by 1
            year1++
        }else {
            // else increment starting year by 1
            year1++
        }
    }
    // loop through years in yearHolder: build the output string
    for ( year in yearHolder ) {
        // append each value in the array to the output string
        outputString += ( "${year}, " )
    }
    // output string minus last to chars to delete the final comma and space
    println( outputString.dropLast(2) )
}
// func to check if a year is a leap year
fun checkIfLeapYear(year1 : Int) : Boolean {
    // if the year is divisible by 400 OR is divisible by 4 AND NOT by 100 return true
    return year1 % 400 == 0 || (year1 % 4 == 0 ) && year1 % 100 !=0
}