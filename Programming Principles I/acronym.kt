/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/26/2020
 *  Assignment:   Acronym (Extra Credit)
 *  Class Number: 282
 *  Description:  A program to take a users sentence and convert
 *                it to an acronym
 ************************************************************/
fun main() {
    // ask the use to input a sequence of words
    print( "Please enter a sequence of words to turn into an acronym: " )
    // get user input and store it as the users sentence
    var userSentence = readLine()!!.trim()
    // call the acronym function and pass the users sentence into it
    println( acronym(trimInteriorExtraSpaces(userSentence) ) )
//    userSentence = StringUtils.normalizeSpace( userSentence )
}
// func to remove any extra interior spaces that reside in userSentence
fun trimInteriorExtraSpaces( userSentence: String ) : String {
    // create variable to store the trimmed string
    var trimmedString = ""
    // create variable to hold the prev character in the string for comparison to the next
    var prevChar = ""
    // loop and look and each char in the input:
    for ( char in userSentence ) {
        // if the prevChar and char are not both a space:
        if ( !(prevChar == " " && char == ' ' ) ) {
            // add the character to the output string
            trimmedString += char
        }
        //
        prevChar = char.toString()
    }
    return trimmedString
}

// func to convert a sentence into an acronym
fun acronym( trimmedString : String ) : String {
    // create variable to store the acronym
    var acronym = ""
    // create an array and split the users sentence by spaces into words and store them in the array
    var words = trimmedString.split(" ")
    // loop through each of the words
    words.forEach {
        // create a variable to store the current word being evaluated in the words array position and capitalize it
        var letters = it.capitalize()
        // append the first letter to the acronym variable
        acronym += letters.first()
    }
    // return acronym to main program
    return acronym
}