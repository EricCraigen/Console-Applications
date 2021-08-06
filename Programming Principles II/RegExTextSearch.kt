import java.io.File

/************************************************************
 *  Name:         Eric Craigen
 *  Date:         09/27/20
 *  Assignment:   Text Search With RegEx
 *  Class Number: 283
 *  Description:  Search Enrollment.txt file for course information
 ************************************************************/

fun main() {

    // import file and store it
    val fileName = "src/Enrollment.txt"
    // regex patterns for testing the lines array
    val pattern1 = """^.{10}(.{5})\s(\d{3})""".toRegex() // pattern to find the lines we are interested in
    val pattern2 = """^\s{11}[A-Z]""".toRegex() // pattern to find the second/third comment lines if present
    val pattern3 = """^\s{58}[A-Z]""".toRegex() // pattern to find the second/third++ instructor lines if present
    // Ask user to input a Department code
    print("Enter Department: ")
    // Store userInput1 for Department code
    var userInput1 = readLine()!!.toUpperCase()
    // do while loop to keep the programming running until the command "EXIT" is entered for a department number
    do {
        // Ask user to input a Class number
        print("Enter Class Number: ")
        // Store userInput2 for Class number
        var userInput2 = readLine()!!
        // Create variable to store the users input as a regex pattern to find their desired information from the file
        var userPattern = "".toRegex()
        // if statements to assign the proper spaces in between the dept code and the class number in regex
        if (userInput1.length === 5) {
            userPattern = ("$userInput1 $userInput2").toRegex()
        }
        if (userInput1.length === 4) {
            userPattern = ("$userInput1  $userInput2").toRegex()
        }
        if (userInput1.length === 3) {
            userPattern = ("$userInput1   $userInput2").toRegex()
        }
        if (userInput1.length === 2) {
            userPattern = ("$userInput1    $userInput2").toRegex()
        }
        // read the file into an array called lines
        var lines = File(fileName).readLines()
        // looping through the lines array and testing patterns against it for matches.
        for (i in 0..(lines.size - 1)) {
            // If the usersPattern is contained as a match on a line, the first line will be printed.
            if (lines[i].contains(userPattern)) {
                if (pattern1.containsMatchIn(lines[i])) {
                    println(lines[i])
                    // If the pattern for a comment or instructor line is matched on the following line, that line will also be printed
                    if (pattern2.containsMatchIn(lines[i + 1]) || pattern3.containsMatchIn(lines[i + 1])) {
                        println(lines[i + 1])
                        // If the pattern for a comment or instructor line is matched on the following line, that line will also be printed
                        if (pattern2.containsMatchIn(lines[i + 2]) || pattern3.containsMatchIn(lines[i + 2])) {
                            println(lines[i + 2])
                            // Create a counter to count all the lines that match after the first 3 lines are printed
                            var counter = 3
                            // while pattern3 is being matched in the following lines, the lines will be printed to display all the courses information
                            while (pattern3.containsMatchIn(lines[i + counter])) {
                                println(lines[i + counter])
                                // Increase the counter while the condition is being met
                                counter++
                            }
                        }
                    }
                }
            }
        }
         // Re-ask user to input a Department code
         print("Enter Department: ")
         // Store userInput1 for Department code
         userInput1 = readLine()!!.toUpperCase()
    } while ( userInput1 != "EXIT" )
}