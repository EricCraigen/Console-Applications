/************************************************************
 *  Name:         Eric Craigen
 *  Date:         5/4/2020
 *  Assignment:   Week 4 Project: Rock Paper Scissors Lizard
 *                Spock (Extra Credit)
 *  Class Number: 282
 *  Description:  Game of RPSLS against the computer
 ************************************************************/
fun main() {

    // Introduce the game, display the rules of the game, and ask the user if they would like to play the game
    println( "Welcome to Rock-Paper-Scissors-Lizard-Spock!" )
    println( "This is a simple game of choosing one of either Rock, Paper, Scissors, Lizard, or Spock against the " +
            "computers choice" )
    println( "The rules are:" )
    println( "  Scissors cuts Paper" )
    println( "  Paper covers Rock" )
    println( "  Rock crushes Lizard" )
    println( "  Lizard poisons Spock " )
    println( "  Spock smashes Scissors " )
    println( "  Scissors decapitates Lizard " )
    println( "  Lizard eats Paper " )
    println( "  Paper disproves Spock " )
    println( "  Spock vaporizes Rock " )
    println( "  Rock crushes Scissors " )
    println()
    print( "Would you like to play? (Y or N) " )

    do {

        // Create variable and make it false so the loop can be repeated if something other than an
        // appropriate response to the question is entered
        var noResult = false
        // Create variable and store user answer to load the game menu or exit the program
        var playResult = readLine()!!.toString()
        // Create variable to store the user choice
        var userChoice = 0
        // Create variables to hold a history of the match results
        var ties = 0
        var wins = 0
        var loses = 0

        // If the user answered yes to playing the game
        if ( playResult == "y" || playResult == "Y" ) {

            // Create variable to store the computers choice
            var computerChoice = 0
            // create a variable to store the users choice as a string
            var uChoiceString = ""
            // create a variable to store the computers choice as a string
            var cChoiceString = ""
            // Create a variable to store the results of the match
            var result = ""

            //  While userChoice variable != 4
            do {

                // Print the menu
                println( "1. Rock" )
                println( "2. Paper" )
                println( "3. Scissors" )
                println( "4. Lizard" )
                println( "5. Spock" )
                println( "6. Quit" )

                // Prompt for user choice
                print( "Enter your choice: " )

                // GET the user choice and update the userChoice variable to user input
                userChoice = readLine()?.toIntOrNull() ?: 0
                // GENERATE computer choice and update computerChoice variable to a random number
                computerChoice = (1..5).random()

                // Check user choice against game menu options
                when ( userChoice ) {

                    // If user choice is 1
                    1 -> {
                        // Set user choice string variable to "rock"
                        uChoiceString = "Rock"

                        //  If computer choice is 1
                        if ( computerChoice == 1 ) {
                            // Set computer choice string variable to "rock"
                            cChoiceString = "Rock"
                            // Set result variable to "it is a tie"
                            result = "It is a tie"
                            // Increment ties by 1
                            ties++
                        }
                        // If computer choice is 2
                        if ( computerChoice == 2 ) {
                            // Set computer choice string variable to "paper"
                            cChoiceString = "Paper"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        // If computer choice is 3
                        if ( computerChoice == 3 ) {
                            // Set computer choice string variable to "scissors"
                            cChoiceString = "Scissors"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        // If computer choice is 4
                        if ( computerChoice == 4 ) {
                            // Set computer choice string variable to "lizard"
                            cChoiceString = "Lizard"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        // If computer choice is 5
                        if ( computerChoice == 5 ) {
                            // Set computer choice string variable to "spock"
                            cChoiceString = "Spock"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }

                    }
                    // If user choice is 2
                    2 -> {
                        // Set user choice string variable to "paper"
                        uChoiceString = "Paper"

                        if ( computerChoice == 1 ) {
                            // Set computer choice string variable to "rock"
                            cChoiceString = "Rock"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 2 ) {
                            // Set computer choice string variable to "paper"
                            cChoiceString = "Paper"
                            // Set result variable to "it is a tie"
                            result = "It is a tie"
                            // Increment ties by 1
                            ties++
                        }
                        if ( computerChoice == 3 ) {
                            // Set computer choice string variable to "scissors"
                            cChoiceString = "Scissors"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 4 ) {
                            // Set computer choice string variable to "lizard"
                            cChoiceString = "Lizard"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 5 ) {
                            // Set computer choice string variable to "spock"
                            cChoiceString = "Spock"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                    }
                    // If user choice is 3
                    3 -> {
                        // Set user choice string variable to "scissors"
                        uChoiceString = "Scissors"

                        if ( computerChoice == 1 ) {
                            // Set computer choice string variable to "rock"
                            cChoiceString = "Rock"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 2 ) {
                            // Set computer choice string variable to "paper"
                            cChoiceString = "Paper"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 3 ) {
                            // Set computer choice string variable to "scissors"
                            cChoiceString = "Scissors"
                            // Set result variable to "it is a tie"
                            result = "It is a tie"
                            // Increment ties by 1
                            ties++
                        }
                        if ( computerChoice == 4 ) {
                            // Set computer choice string variable to "lizard"
                            cChoiceString = "Lizard"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 5 ) {
                            // Set computer choice string variable to "spock"
                            cChoiceString = "Spock"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                    }
                    4 -> {
                        // Set user choice string variable to "scissors"
                        uChoiceString = "Lizard"

                        if ( computerChoice == 1 ) {
                            // Set computer choice string variable to "rock"
                            cChoiceString = "Rock"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 2 ) {
                            // Set computer choice string variable to "paper"
                            cChoiceString = "Paper"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 3 ) {
                            // Set computer choice string variable to "scissors"
                            cChoiceString = "Scissors"
                            // Set result variable to "You lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 4 ) {
                            // Set computer choice string variable to "lizard"
                            cChoiceString = "Lizard"
                            // Set result variable to "It is a tie"
                            result = "It is a tie"
                            // Increment ties by 1
                            ties++
                        }
                        if ( computerChoice == 5 ) {
                            // Set computer choice string variable to "spock"
                            cChoiceString = "Spock"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                    }
                    5 -> {
                        // Set user choice string variable to "scissors"
                        uChoiceString = "Spock"

                        if ( computerChoice == 1 ) {
                            // Set computer choice string variable to "rock"
                            cChoiceString = "Rock"
                            // Set result variable to "you win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 2 ) {
                            // Set computer choice string variable to "paper"
                            cChoiceString = "Paper"
                            // Set result variable to "you lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 3 ) {
                            // Set computer choice string variable to "scissors"
                            cChoiceString = "Scissors"
                            // Set result variable to "You win"
                            result = "You win"
                            // Increment wins by 1
                            wins++
                        }
                        if ( computerChoice == 4 ) {
                            // Set computer choice string variable to "lizard"
                            cChoiceString = "Lizard"
                            // Set result variable to "You lose"
                            result = "You lose"
                            // Increment loses by 1
                            loses++
                        }
                        if ( computerChoice == 5 ) {
                            // Set computer choice string variable to "spock"
                            cChoiceString = "Spock"
                            // Set result variable to "It is a tie"
                            result = "It is a tie"
                            // Increment ties by 1
                            ties++
                        }
                    }
                    // Else the user choice is anything other than 1-5
                    else -> {
                        // If user choice does not equal 6
                        if ( userChoice != 6 ) {
                            // Print an error message to input a valid menu option
                            println("ERROR: Please select a valid menu option.")
                        }
                    }

                }
                // If user choice was a menu option not being the QUIT option
                if ( userChoice < 6 && userChoice != 0 ) {
                    println()
                    // Display the computers choice
                    println( "Computer chose: $cChoiceString" )
                    // Display the users choice
                    println( "You chose: $uChoiceString" )
                    // Display the result of the match
                    println( "$result" )
                    // Print the stats header
                    println( "----STATS----" )
                    // Print the history of the game that is saved in the wins, loses, and ties variables
                    println( "Wins:   $wins" )
                    println( "Losses: $loses" )
                    println( "Ties:   $ties" )
                    println()
                }
                // While the user choice variable is not 6 restart the loop
            } while ( userChoice != 6 )

            // Else if user result to play or not is "n" or "N"
        } else if ( playResult == "n" || playResult == "N" ) {
            // Set noResult variable to true for break statement
            noResult = true
            // Else when anything else is entered ask user again if they would like to play or not, until an
            // appropriate answer is input
        } else {
            print( "Would you like to play? (Y or N) " )
        }
        // If user choice is QUIT option OR they answered No to playing the game
        if ( userChoice == 6 || noResult == true ) {
            if ( userChoice == 6 ){
                // Print the history of the game that is saved in the wins, loses, and ties variables
                println()
                println( "----FINAL----" )
                println( "Wins:   $wins" )
                println( "Losses: $loses" )
                println( "Ties:   $ties" )
            }
            // Break out of the loop and exit the program
            break
        }
        // While the player result is not a valid response repeat loop
    } while ( playResult != "y" || playResult != "Y" || playResult != "n" || playResult != "N" )
}