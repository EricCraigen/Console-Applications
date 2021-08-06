/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/25/2020
 *  Assignment:   Extra Credit #1: Coins
 *  Class Number: 282
 *  Description:  Program to total users change value by quarters,
 *                dimes, nickels, pennies and display as currency
 ************************************************************/
fun main() {
    // ask user for number of quarters in jar
    print("Please enter the number of Quarters in your jar: ")
    // get and store users input for amount of quarters in jar
    val quarters= readLine()?.toIntOrNull() ?: 0
    // ask user for number of dimes in jar
    print("Please enter the number of Dimes in your jar: ")
    // get and store users input for amount of dimes in jar
    val dimes= readLine()?.toIntOrNull() ?: 0
    // ask user for number of nickles in jar
    print("Please enter the number of Nickels in your jar: ")
    // get and store users input for amount of nickles in jar
    val nickels= readLine()?.toIntOrNull() ?: 0
    // ask user for number of pennies in jar
    print("Please enter the number of Pennies in your jar: ")
    // get and store users input for amount of pennies in jar
    val pennies= readLine()?.toIntOrNull() ?: 0
    // time time number of quarters by .25 to calculate their value and store it in a new variable
    var quartersT = quarters * 0.25
    // time time number of dimes by .10 to calculate their value and store it in a new variable
    var dimesT = dimes * 0.10
    // time time number of nickels by .05 to calculate their value and store it in a new variable
    var nickelsT = nickels * 0.05
    // time time number of pennies by .01 to calculate their value and store it in a new variable
    var penniesT = pennies * 0.01
    // sum the T varibales and start the value in total
    var total = quartersT + dimesT + nickelsT + penniesT
    // println for spacing
    println()
    // println to tell the user how many of each coin they have as well as their total, formatted in dollars
    println("You have ${quarters} quarters, ${dimes} dimes, ${nickels.toInt()} nickles, ${pennies} pennies for a total of ${"$%.2f".format(total)}")
}