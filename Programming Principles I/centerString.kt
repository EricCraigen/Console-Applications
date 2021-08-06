/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/26/2020
 *  Assignment:   Center String (Extra Credit)
 *  Class Number: 282
 *  Description:  program to take as users input and center it
 *                in a new string with spacing to center the input
 ************************************************************/
fun main() {
    // ask user to input some text with a max of 78 characters
    print( "Please enter some text: " )
    // read user input and store in userTextInput
    var userTextInput = readLine()!!
    print( "Please enter a number larger than the length of the text you entered: " )
    // ask the user to input a number greater than the length of thier endter text
    var columnWidth = readLine()?.toIntOrNull() ?: 80
    // display results by calling centerString func by passing userTextInput and columnWidth to it
    println( centerString( userTextInput, columnWidth ) )
}
// func centerString to center user input in a separate output string
fun centerString( userTextInput : String, columnWidth : Int = 80, padChar : String = " " ) : String {
    // calculate the length of the users input
    var inputTextLength = userTextInput.length - 2
    // find out if the length of the input is divisible by 2 and assign it to odd even
    var oddEven = inputTextLength % 2
    // set var spacing half of the column width minus the input length minus 2
    var spacing = ( columnWidth - inputTextLength - 2 ) / 2
    // initialize the outputText string variable
    var outputText = ""
    // if evenOdd was 1 calculate the spacing for each side of an even number input length
    if ( oddEven == 1 && inputTextLength < columnWidth - 2 ) {
        // if user input columnWidth divisible by two
        if ( columnWidth % 2 == 1 ) {
            // append the first char to the output string
            outputText += "\""
            // for the spaces from 0 to spacing:append padChar (blank space) to the output string
            for (spaces in 0 until spacing - 1) {
                outputText += padChar
            }
            // append the users input text to the output string
            outputText += userTextInput
            // for the spaces from 0 to spacing minus 1:append padChar (blank space) to the output string
            for (spaces in 0 until spacing - 1 ) {
                outputText += padChar
            }
            // append the final char to the column making the total column width 80 chars
            outputText += "\""
        }
        // if user input columnWidth is NOT divisible by two
        if ( columnWidth % 2 == 0 ) {
            // append the first char to the output string
            outputText += "\""
            // for the spaces from 0 to spacing:append padChar (blank space) to the output string
            for (spaces in 0 until spacing ) {
                outputText += padChar
            }
            // append the users input text to the output string
            outputText += userTextInput
            // for the spaces from 0 to spacing minus 1:append padChar (blank space) to the output string
            for (spaces in 0 until spacing - 1 ) {
                outputText += padChar
            }
            // append the final char to the column making the total column width 80 chars
            outputText += "\""
        }
    }
    // if evenOdd was 0 calculate the spacing for each side of an even number input length
    if ( oddEven == 0 && inputTextLength < columnWidth - 2 ) {
        // if user input columnWidth divisible by two
        if ( columnWidth % 2 == 1 ) {
            // append the first char to the output string
            outputText += "\""
            // for the spaces from 0 to spacing minus 1:append padChar (blank space) to the output string
            for (spaces in 0 until spacing ) {
                outputText += padChar
            }
            // append the users input text to the output string
            outputText += userTextInput
            // for the spaces from 0 to spacing:append padChar (blank space) to the output string
            for (spaces in 0 until spacing -1 ) {
                outputText += padChar
            }
            // append the final char to the column making the total column width 80 chars
            outputText += "\""
        }
        // if user input columnWidth is NOT divisible by two
        if ( columnWidth % 2 == 0 ) {
            // append the first char to the output string
            outputText += "\""
            // for the spaces from 0 to spacing minus 1:append padChar (blank space) to the output string
            for (spaces in 0 until spacing - 1) {
                outputText += padChar
            }
            // append the users input text to the output string
            outputText += userTextInput
            // for the spaces from 0 to spacing:append padChar (blank space) to the output string
            for (spaces in 0 until spacing - 1) {
                outputText += padChar
            }
            // append the final char to the column making the total column width 80 chars
            outputText += "\""
        }
    }
    // if the input text length was greater columnWidth: display error
    if (inputTextLength > columnWidth) {
        outputText += "Please try again. Enter a number that is at least two MORE than the number of " +
                "characters in your entered text."
    }
    return outputText
}