/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/25/2020
 *  Assignment:   Reverse Digits
 *  Class Number: 282
 *  Description:  A program to take a number from a user and
 *                reverse its digits
 ************************************************************/
fun main() {
    // ask the user to enter a number greater than 1
    print( "Please enter a number greater than 1: " )
    // get and store the users number
    var userInput = readLine()?.toIntOrNull() ?: 0
    // call the reverse digit func and pass the users input to it
    println( reverseDigit( userInput ) )
}
// func to reverse the digits of the users number
fun reverseDigit( userInput : Int  ) : Int {
    // create variable to store the users input to be modified
    var forwardNumber = userInput
    // create variable to store the reversed number
    var reversedNumber = 0
    // while the forward number still has a value
    while ( forwardNumber !=0 ) {
        // the reversed number is equal to itself times 10 plus 10 percent of the forward number
        reversedNumber = reversedNumber * 10 + forwardNumber % 10
        // divide the forward number by 10 to clear the decimal value to pull the next "last number"
        forwardNumber /=10
    }
    // return the reversed number for display
    return reversedNumber
}