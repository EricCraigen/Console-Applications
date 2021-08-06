/************************************************************
 *  Name:         Eric Craigen
 *  Date:         04/07/20
 *  Assignment:   Week 1 Project
 *  Class Number: 282
 *  Description:  Print out a header to put on each program
 ************************************************************/

fun main(){

    // Gathering input from user and storing it in the proper variables
    println( "Enter your first and last name." )
    var name = readLine()!!
    println( "Enter the date. (MM/DD/YY)" )
    var date = readLine()!!
    println( "Enter the assignment title." )
    var assignment = readLine()!!
    println( "Enter the class number." )
    var classNumber = readLine()!!
    println( "Enter a description of the assignment." )
    var description = readLine()!!

    // Printing the requested design using the values gathered from user
    println( "/************************************************************" )
    println( " *  Name:         $name" )
    println( " *  Date:         $date" )
    println( " *  Assignment:   $assignment" )
    println( " *  Class Number: $classNumber" )
    println( " *  Description:  $description" )
    println( " ************************************************************/" )
}