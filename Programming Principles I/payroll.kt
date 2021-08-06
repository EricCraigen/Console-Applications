/************************************************************
 *  Name:         Eric Craigen
 *  Date:         4/8/2020
 *  Assignment:   Payroll
 *  Class Number: 282
 *  Description:  Simple payroll calculation application
 ************************************************************/
fun main(){

    // Gather required information from user and store in appropriate variables
    print( "Enter Employee's name: " )
    var name = readLine()!!
    print( "Enter number of hours worked in a week: " )
    var totalHours = readLine()!!.toFloat()
    print( "Enter hourly pay rate: " )
    var payRate = readLine()!!.toFloat()
    print( "Enter federal tax withholding rate: " )
    var fedPercentage = readLine()!!.toFloat()
    print( "Enter state tax withholding rate: " )
    var statePercentage = readLine()!!.toFloat()

    // Find the space in between first and last name
    var firstSpace = name.indexOf(" ")
    // Make displayed name the value of the last name after a space
    var displayName = name.substring(firstSpace + 1 )
    // Calculate and store grossPay
    var grossPay = totalHours * payRate
    // Calculate and store fedHoldings
    var fedHoldings = fedPercentage * grossPay
    // Calculate and store stateHoldings
    var stateHoldings = statePercentage * grossPay
    // Calculate and store netPay
    var netPay = grossPay - ( ( fedPercentage * grossPay ) + ( statePercentage * grossPay ) )

    // Display output in correct formatting for report
    println( "\nEmployee Name:  $displayName" )
    println( "Hours Worked:  ${ "%.1f".format( totalHours ) }" )
    println( "Pay Rate:  ${ "$%.2f".format( payRate ) }" )
    println( "Gross Pay:  ${ "$%.2f".format( grossPay ) }" )

    println( "\nDeductions:" )
    println( "   Federal Withholding (${fedPercentage * 100}%): ${ "$%.2f".format( fedHoldings ) }" )
    println( "   State Withholding (${statePercentage * 100}%): ${ "$%.2f".format( stateHoldings ) }" )
    println( "   Total Deduction:  ${ "$%.2f".format( fedHoldings + stateHoldings )  }" )
    println( "Net Pay:  ${ "$%.2f".format( netPay ) }" )

}