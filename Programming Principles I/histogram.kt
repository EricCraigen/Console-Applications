/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/19/2020
 *  Assignment:   Week 5 Project: Histogram
 *  Class Number: 282
 *  Description:  Create 200 random numbers and count the values
 *                in the specified ranges.
 ************************************************************/
fun main() {

    // ** create empty array of integers to store the 200 random numbers
    var numbers = intArrayOf()
    // ** create empty array of integers to store the value of the ranges
    var ranges = intArrayOf(0,0,0,0,0,0,0,0,0,0)

    // ** generate 200 random numbers (between 1-100 inclusive) in numbers array
    for ( i in 1..200 ) {
        // numberGenerator variable to hold random number value
        var numberGenerator = (1..100).random()
        // add the the random number to the numbers array
        numbers += numberGenerator
    }

    // ** loop through numbers array to find range values and assign them to the ranges array
    for ( number in 0..( numbers.size - 1 ) ) {
        // if the number being evaluated from the numbers array is between 1 and 10:
        if ( numbers[ number ] in 1..10 ) {
            // increment ranges array position 0 by 1
            ranges[0]++
        }
        // if the number being evaluated from the numbers array is between 10 and 20:
        if ( numbers[ number ] in 11..20 ) {
            // increment ranges array position 1 by 1
            ranges[1]++
        }
        // if the number being evaluated from the numbers array is between 21 and 30:
        if ( numbers[ number ] in 21..30 ) {
            // increment ranges array position 2 by 1
            ranges[2]++
        }
        // if the number being evaluated from the numbers array is between 31 and 40:
        if ( numbers[ number ] in 31..40 ) {
            // increment ranges array position 3 by 1
            ranges[3]++
        }
        // if the number being evaluated from the numbers array is between 41 and 50:
        if ( numbers[ number ] in 41..50 ) {
            // increment ranges array position 4 by 1
            ranges[4]++
        }
        // if the number being evaluated from the numbers array is between 51 and 60:
        if ( numbers[ number ] in 51..60 ) {
            // increment ranges array position 5 by 1
            ranges[5]++
        }
        // if the number being evaluated from the numbers array is between 61 and 70:
        if ( numbers[ number ] in 61..70 ) {
            // increment ranges array position 6 by 1
            ranges[6]++
        }
        // if the number being evaluated from the numbers array is between 71 and 80:
        if ( numbers[ number ] in 71..80 ) {
            // increment ranges array position 7 by 1
            ranges[7]++
        }
        // if the number being evaluated from the numbers array is between 81 and 90:
        if ( numbers[ number ] in 81..90 ) {
            // increment ranges array position 8 by 1
            ranges[8]++
        }
        // if the number being evaluated from the numbers array is between 91 and 100:
        if ( numbers[ number ] in 91..100 ) {
            // increment ranges array position 9 by 1
            ranges[9]++
        }
    }
    // ** print the top two header rows of the output display
    println()
    println( "Range         # Found        Chart" )
    println( "--------      ----------     -------------------------------------------" )

    // if ranges array position 0 is greater than 9:
    if ( ranges[0] > 9 ) {
        // print the spacing for a two digit range found value
        print(" 1 -  10       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print(" 1 -  10       |   ")
    }
    // print the value of ranges array position 0
    print( ranges[0] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 0 value:
    for ( tens in 1..ranges[0] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    // println to start the next line
    println()

    // if ranges array position 1 is greater than 9:
    if ( ranges[1] > 9 ) {
        // print the spacing for a two digit range found value
        print("11 -  20       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("11 -  20       |   ")
    }
    // print the value of ranges array position 1
    print( ranges[1] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 1 value:
    for ( teens in 1..ranges[1] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 2 is greater than 9:
    if ( ranges[2] > 9 ) {
        // print the spacing for a two digit range found value
        print("21 -  30       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("21 -  30       |   ")
    }
    // print the value of ranges array position 2
    print( ranges[2] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 2 value:
    for ( twenties in 1..ranges[2] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 3 is greater than 9:
    if ( ranges[3] > 9 ) {
        // print the spacing for a two digit range found value
        print("31 -  40       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("31 -  40       |   ")
    }
    // print the value of ranges array position 3
    print( ranges[3] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 3 value:
    for ( thirties in 1..ranges[3] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 4 is greater than 9:
    if ( ranges[4] > 9 ) {
        // print the spacing for a two digit range found value
        print("41 -  50       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("41 -  50       |   ")
    }
    // print the value of ranges array position 4
    print( ranges[4] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 4 value:
    for ( forties in 1..ranges[4] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 5 is greater than 9:
    if ( ranges[5] > 9 ) {
        // print the spacing for a two digit range found value
        print("51 -  60       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("51 -  60       |   ")
    }
    // print the value of ranges array position 5
    print( ranges[5] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 5 value:
    for ( fifties in 1..ranges[5] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 6 is greater than 9:
    if ( ranges[6] > 9 ) {
        // print the spacing for a two digit range found value
        print("61 -  70       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("61 -  70       |   ")
    }
    // print the value of ranges array position 6
    print( ranges[6] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 6 value:
    for ( sixties in 1..ranges[6] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 7 is greater than 9:
    if ( ranges[7] > 9 ) {
        // print the spacing for a two digit range found value
        print("71 -  80       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("71 -  80       |   ")
    }
    // print the value of ranges array position 7
    print( ranges[7] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 7 value:
    for ( seventies in 1..ranges[7] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 8 is greater than 9:
    if ( ranges[8] > 9 ) {
        // print the spacing for a two digit range found value
        print("81 -  90       |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("81 -  90       |   ")
    }
    // print the value of ranges array position 8
    print( ranges[8] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 8 value:
    for ( eighties in 1..ranges[8] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()

    // if ranges array position 9 is greater than 9:
    if ( ranges[9] > 9 ) {
        // print the spacing for a two digit range found value
        print("91 -  100      |  ")
    }else {
        // else print the spacing for a single digit range found value
        print("91 -  100      |   ")
    }
    // print the value of ranges array position 9
    print( ranges[9] )
    // print the next part of formatting the line
    print( "  |      " )
    // loop through ranges array position 9 value:
    for ( nineties in 1..ranges[9] ) {
        // print the corresponding number of *'s to the range found value
        print( "*" )
    }
    println()
}