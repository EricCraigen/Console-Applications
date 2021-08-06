/************************************************************
 *  Name:         Eric Craigen
 *  Date:         6/4/2020
 *  Assignment:   Connect 4 Games (FINAL)
 *  Class Number: 282
 *  Description:  A menu driven connect 4 game that offers
 *                a PlayerVPalyer, PlayerVComputer, and
 *                ComputerVComputer.
 ************************************************************/
var gameBoard = Array( 8 ){ Array( 8 ){"."} }
var gameOver = false

var players = arrayOf("X", "O")
var playerTurn = 0
var playerChoice = 0
var startingRow = 0
var startingCol = 0

fun main( ){

    var menuList = arrayOf(
        "Player Vs. Player",
        "Player Vs. computer",
        "Computer Vs. Computer",
        "Exit"
    )
    var exitOption = menuList.size
    var playerOption = 0

    while ( playerOption != exitOption ){
        playerOption = menu(menuList, "Please enter your menu selection: ")

        when ( playerOption ) {

            1 -> {
                playerVsPlayer()
            }
            2 -> {
                playerVsComputer()
            }
            3 -> {
                computerVsComputer()
            }
        }
    }
}

fun menu( menuList : Array<String>, prompt : String ) : Int {
    for ( ( index, item ) in menuList.withIndex() ) {
        println( "${index + 1}. $item" )
    }
    println()
    print( prompt )
    return readLine()!!.toInt()
}

fun printGameBoard() {
    println(" 12345678 \n" + "_________" )
    for ( row in 0 until gameBoard.size ) {
        print( " " )
        for ( col in 0 until gameBoard[ row ].size ){
            print( gameBoard[row][col] )
        }
        println()
    }
    println()
}

fun setBoardCell(row: Int, col: Int, ch: String) {
    gameBoard[row][col] = ch
}

fun clearBoard() {
    for ( row in 0 until gameBoard.size ) {
        for (col in 0 until gameBoard[row].size) {
            setBoardCell(row, col, ".")
        }
    }
}

fun isValid() {
    var isValid = false
    while ( isValid == false ) {
        if (playerChoice < 0 || playerChoice > 7) {
            println("Selection invalid, please make a selection between 1 and 8.")
            print("Select a column to place your piece (${players[playerTurn]}): ")
            playerChoice = readLine()!!.toInt() - 1
        } else {
            isValid = true
        }
    }
}

fun dropPiece() {
    if ( playerTurn == 0 ) {
        players[0] = "\u001b[31mX\u001b[37m"
    }
    if ( playerTurn == 1 ) {
        players[1] = "\u001b[34mO\u001b[37m"
    }
    var col = playerChoice
    for ( row in gameBoard.lastIndex downTo 0 ) {
        if ( gameBoard[row][col] == "." ){
            startingRow = row
            startingCol = col
            setBoardCell(row, col, players[playerTurn])
            players[0] = "X"
            players[1] = "O"
            break
        }
    }
    printGameBoard()
}

fun verticalValidation() : Boolean {
    var pieceCounter = 0
    var currentRow = 0
    while ( currentRow < gameBoard.size ) {
        for ( col in gameBoard.lastIndex downTo 0 ) {
            if ( playerTurn == 0 ) {
                players[0] = "\u001b[31mX\u001b[37m"
            }
            if ( playerTurn == 1 ) {
                players[1] = "\u001b[34mO\u001b[37m"
            }
            if (gameBoard[col][playerChoice] == players[playerTurn]) {
                pieceCounter++
            } else {
                pieceCounter = 0
            }
            currentRow++
            if (pieceCounter >= 4) {
                gameOver = true
            }
        }
    }
    players[0] = "X"
    players[1] = "O"
    return gameOver
}

fun horizontalVerification() : Boolean {
    var pieceCounter = 0
    for ( row in gameBoard.lastIndex downTo 0 ) {
        var currentCol = 0
        while ( currentCol < gameBoard.size ) {
            if ( playerTurn == 0 ) {
                players[0] = "\u001b[31mX\u001b[37m"
            }
            if ( playerTurn == 1 ) {
                players[1] = "\u001b[34mO\u001b[37m"
            }
            if (gameBoard[row][currentCol] == players[playerTurn]) {
                pieceCounter++
            } else {
                pieceCounter = 0
            }
            currentCol++
            if (pieceCounter >= 4) {
                gameOver = true
            }
        }
    }
    players[0] = "X"
    players[1] = "O"
    return gameOver
}
// these two diagonal validation functions are where I think I came the closest to achieving it correctly.
// I really gave it hell on this one and spent at least 20 hours this week on just this diagonal validation.
// I am very upset that I did not get it correctly and am still at a loss. Hopefully after finals are graded we can have
// zoom meeting to show me where I am going wrong. I enjoy Kotlin very much and have enjoyed your class. Finals this
// I spent the majority of the week stressing over CIS117 Final because I was not grasping it AT ALL, and I had already had
// this program done by the time I started Bret's final. I obsessed over it and screwed myself in the end. and despite being
// awake pretty much all week (I have not slept 4 of the nights since last sunday literally from all day long expect bathroom
// and food. And it did pay off as I know almost completely understand how stores work with flux to make your page very
// powerful. I look forward to classes in the spring and hope you and the other Instructors of CIS have a wonderful summer vacation.

// Cheers

//fun downLeftValidation() {
//    var piece1 = false
//    var piece2 = false
//    var piece3 = false
//    var piece4 = false
//    if ( playerTurn == 0 ) {
//        players[0] = "\u001b[31mX\u001b[37m"
//    }
//    if ( playerTurn == 1 ) {
//        players[1] = "\u001b[34mO\u001b[37m"
//    }
//    while ( startingRow in gameBoard.lastIndex downTo 0 ){
//        while ( startingCol in 0..gameBoard.size -1 ) {
//            if ( gameBoard[startingRow][startingCol] == players[playerTurn] ) {
//                println( gameBoard[startingRow][startingCol] )
//                piece1 = true
//            }
//            if ( gameBoard[startingRow-1][startingCol-1] == players[playerTurn] ) {
//                println( gameBoard[startingRow-1][startingCol-1] )
//                piece2 = true
//            }
//            if ( gameBoard[startingRow-2][startingCol-2] == players[playerTurn] ) {
//                println( gameBoard[startingRow-2][startingCol-2] )
//                piece3 = true
//            }
//            if ( gameBoard[startingRow-3][startingCol-3] == players[playerTurn] ) {
//                println( gameBoard[startingRow-3][startingCol-3] )
//                piece4 = true
//            }
//        }
//    }
//
//
//}

//fun downLeftValidation() : Boolean {
//
//    if ( playerTurn == 0 ) {
//        players[0] = "\u001b[31mX\u001b[37m"
//    }
//    if ( playerTurn == 1 ) {
//        players[1] = "\u001b[34mO\u001b[37m"
//    }
//    if ( startingRow > 0 && startingCol > 0 && startingRow < 7 && startingCol < 7 ){
//        for ( row in 3..gameBoard.size - 1 ) {
//            for ( col in 3..gameBoard.size -1 ) {
//                println("${row} ${col}")
//                var winCounter = 0
//                if ( ((startingRow - 1 >= 0) && (startingCol - 1 >= 0)) && gameBoard[startingRow - 1][startingCol - 1] == players[playerTurn] ) {
//                    if( ((startingRow - 2 >= 0) && (startingCol - 2 >= 0)) && gameBoard[startingRow - 2][startingCol - 2] == players[playerTurn] ) {
//                        if( ((startingRow - 3 >= 0) && (startingCol - 3 >= 0)) && gameBoard[startingRow - 3][startingCol - 3] == players[playerTurn] ) {
//                            gameOver = true
//                        }
//                    }
//                }
//            }
//        }
//    }
//    players[0] = "X"
//    players[1] = "O"
//    return gameOver
//}

fun upLeftValidation() {
    if (gameBoard[startingRow][startingCol] == players[playerTurn] &&
            gameBoard[startingRow + 3][startingCol - 3] == players[playerTurn] && gameBoard[startingRow + 2][startingCol - 2] ==
            players[playerTurn] && gameBoard[startingRow + 1][startingCol - 1] == players[playerTurn]) {
        gameOver = true
    }
}

fun playerVsPlayer() {
    printGameBoard()
    println( "Player (X) is playing against Player (O)." )
    gameOver= false
    playerTurn = 0
    while ( !gameOver ) {
        print( "Select a column to place your piece (${players[playerTurn]}): " )
        playerChoice = readLine()!!.toIntOrNull()!! -1

        isValid()
        dropPiece()
        verticalValidation()
        horizontalVerification()
//        downLeftValidation()
        if ( gameOver == true ) {
            clearBoard()
            println( "${players[playerTurn]} Wins!!!" )
            println()
        }
        playerTurn++
        playerTurn = playerTurn % 2
    }
}

fun playerVsComputer() {
    printGameBoard()
    println( "Player (X) is playing against Player (O)." )
    gameOver= false
//    playerTurn = 0
    while ( !gameOver ) {
        print( "Select a column to place your piece (${players[playerTurn]}): " )
        if ( playerTurn === 0 ) {
            playerChoice = readLine()?.toIntOrNull()!! - 1
        }

        if (playerTurn === 1){
            var computerChoice = (1..8).shuffled().last()
            playerChoice = computerChoice
        }
        isValid()
        dropPiece()
        verticalValidation()
        horizontalVerification()
//        downLeftValidation()
        if ( gameOver == true ) {
            clearBoard()
            println( "${players[playerTurn]} Wins!!!" )
            println()
        }
        playerTurn++
        playerTurn = playerTurn % 2
    }
}

fun computerVsComputer() {
    printGameBoard()
    println( "Player (X) is playing against Player (O)." )
    gameOver= false
    while ( !gameOver ) {
        print( "Select a column to place your piece (${players[playerTurn]}): " )
        if ( playerTurn === 0 ) {
            var computerChoice = (1 until 8).shuffled().last()
            playerChoice = computerChoice
        }
        if (playerTurn === 1){
            var computerChoice = (1 until 8).shuffled().last()
            playerChoice = computerChoice
        }
        isValid()
        dropPiece()
        verticalValidation()
        horizontalVerification()
//        downLeftValidation()
        if ( gameOver == true ) {
            clearBoard()
            println( "${players[playerTurn]} Wins!!!" )
            println()
        }
        playerTurn++
        playerTurn = playerTurn % 2
    }
}

//fun forwardSlantValidation() : Boolean {
//    var pieceCounter = 0
//    var currentRow = 7
////    var currentCol = 0
////    var col = playerChoice
//    while ( currentRow in gameBoard.lastIndex downTo 0 ) {
//        var currentCol = 0
//        while ( currentCol in 0..gameBoard.size ) {
//            if ( playerTurn == 0 ) {
//                players[0] = "\u001b[31mX\u001b[37m"
//            }
//            if ( playerTurn == 1 ) {
//                players[1] = "\u001b[34mO\u001b[37m"
//            }
//            if (gameBoard[currentRow][currentCol] == players[playerTurn]) {
//                pieceCounter++
//                currentCol++
//                currentRow--
//            } else {
//                pieceCounter = 0
//                currentCol++
//
//            }
////            currentCol++
//            if (pieceCounter >= 4) {
//                gameOver = true
//            }
//        }
//    }
//    players[0] = "X"
//    players[1] = "O"
//    return gameOver
//}

//fun forwardSlantValidation() : Boolean {
//println( startingCol )
//    // Down and to the right win checking
//    if ( playerTurn == 0 ) {
//       players[0] = "\u001b[31mX\u001b[37m"
//    }
//    if ( playerTurn == 1 ) {
//        players[1] = "\u001b[34mO\u001b[37m"
//    }
//    while ( gameBoard[startingRow][startingCol] == gameBoard[4][1] || gameBoard[startingRow][startingCol] == gameBoard[4][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][3] || gameBoard[startingRow][startingCol] == gameBoard[4][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][5] || gameBoard[startingRow][startingCol] == gameBoard[5][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][2] || gameBoard[startingRow][startingCol] == gameBoard[5][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][4] || gameBoard[startingRow][startingCol] == gameBoard[5][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][1] || gameBoard[startingRow][startingCol] == gameBoard[6][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][3] || gameBoard[startingRow][startingCol] == gameBoard[6][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][5] || gameBoard[startingRow][startingCol] == gameBoard[7][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][2] || gameBoard[startingRow][startingCol] == gameBoard[7][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][4] || gameBoard[startingRow][startingCol] == gameBoard[7][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][1] || gameBoard[startingRow][startingCol] == gameBoard[8][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][3] || gameBoard[startingRow][startingCol] == gameBoard[8][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][5] || gameBoard[startingRow][startingCol] == players[playerTurn] &&
//            gameBoard[startingRow - 3][startingCol + 3] == players[playerTurn] && gameBoard[startingRow - 2][startingCol + 2] ==
//            players[playerTurn] && gameBoard[startingRow - 1][startingCol + 1] == players[playerTurn]) {
//        gameOver = true }
//
//    downRightValidation()
//    while ( gameBoard[startingRow][startingCol] == gameBoard[1][1] || gameBoard[startingRow][startingCol] == gameBoard[1][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[1][3] || gameBoard[startingRow][startingCol] == gameBoard[1][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[1][5] || gameBoard[startingRow][startingCol] == gameBoard[2][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[2][2] || gameBoard[startingRow][startingCol] == gameBoard[2][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[2][4] || gameBoard[startingRow][startingCol] == gameBoard[2][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][1] || gameBoard[startingRow][startingCol] == gameBoard[3][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][3] || gameBoard[startingRow][startingCol] == gameBoard[3][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][5] || gameBoard[startingRow][startingCol] == gameBoard[4][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][2] || gameBoard[startingRow][startingCol] == gameBoard[4][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][4] || gameBoard[startingRow][startingCol] == gameBoard[4][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][1] || gameBoard[startingRow][startingCol] == gameBoard[5][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][3] || gameBoard[startingRow][startingCol] == gameBoard[5][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][5]) {
//        upRightValidation()
//        if (gameBoard[startingRow][startingCol] == players[playerTurn] &&
//                gameBoard[startingRow + 3][startingCol + 3] == players[playerTurn] && gameBoard[startingRow + 2][startingCol + 2] ==
//                players[playerTurn] && gameBoard[startingRow + 1][startingCol + 1] == players[playerTurn]) {
//            gameOver = true
//        }
//    }
//    while ( gameBoard[startingRow][startingCol] == gameBoard[4][4] || gameBoard[startingRow][startingCol] == gameBoard[4][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][6] || gameBoard[startingRow][startingCol] == gameBoard[4][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][8] || gameBoard[startingRow][startingCol] == gameBoard[5][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][5] || gameBoard[startingRow][startingCol] == gameBoard[5][6] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][7] || gameBoard[startingRow][startingCol] == gameBoard[5][8] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][4] || gameBoard[startingRow][startingCol] == gameBoard[6][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][6] || gameBoard[startingRow][startingCol] == gameBoard[6][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][8] || gameBoard[startingRow][startingCol] == gameBoard[7][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][5] || gameBoard[startingRow][startingCol] == gameBoard[7][6] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][7] || gameBoard[startingRow][startingCol] == gameBoard[7][8] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][4] || gameBoard[startingRow][startingCol] == gameBoard[8][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][6] || gameBoard[startingRow][startingCol] == gameBoard[8][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][8]) {
//        downLeftValidation()
//        if (gameBoard[startingRow][startingCol] == players[playerTurn] &&
//                gameBoard[startingRow - 3][startingCol - 3] == players[playerTurn] && gameBoard[startingRow - 2][startingCol - 2] ==
//                players[playerTurn] && gameBoard[startingRow - 1][startingCol - 1] == players[playerTurn]) {
//            gameOver = true
//        }
//    }
//    while ( gameBoard[startingRow][startingCol] == gameBoard[1][4] || gameBoard[startingRow][startingCol] == gameBoard[1][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[1][6] || gameBoard[startingRow][startingCol] == gameBoard[1][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[1][8] || gameBoard[startingRow][startingCol] == gameBoard[2][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[2][5] || gameBoard[startingRow][startingCol] == gameBoard[2][6] ||
//            gameBoard[startingRow][startingCol] == gameBoard[2][7] || gameBoard[startingRow][startingCol] == gameBoard[2][8] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][4] || gameBoard[startingRow][startingCol] == gameBoard[3][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][6] || gameBoard[startingRow][startingCol] == gameBoard[3][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[3][8] || gameBoard[startingRow][startingCol] == gameBoard[4][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][5] || gameBoard[startingRow][startingCol] == gameBoard[4][6] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][7] || gameBoard[startingRow][startingCol] == gameBoard[4][8] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][4] || gameBoard[startingRow][startingCol] == gameBoard[5][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][6] || gameBoard[startingRow][startingCol] == gameBoard[5][7] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][8]) {
//        upLeftValidation()
//        if (gameBoard[startingRow][startingCol] == players[playerTurn] &&
//                gameBoard[startingRow + 3][startingCol - 3] == players[playerTurn] && gameBoard[startingRow + 2][startingCol - 2] ==
//                players[playerTurn] && gameBoard[startingRow + 1][startingCol - 1] == players[playerTurn]) {
//            gameOver = true
//        }
//    }
//                    if ( gameBoard[startingRow][startingCol] == players[playerTurn] && gameBoard[startingRow + 3][startingCol + 3] == players[playerTurn] &&
//                                    gameBoard[startingRow + 2][startingCol + 2] == players[playerTurn] && gameBoard[startingRow + 1][startingCol + 1] == players[playerTurn] ) {
//                                gameOver = true
//                    }
//                    else if ( gameBoard[startingRow][startingCol] == players[playerTurn] && gameBoard[startingRow - 3][startingCol - 3] == players[playerTurn] &&
//                                    gameBoard[startingRow - 2][startingCol - 2] == players[playerTurn] && gameBoard[startingRow - 1][startingCol - 1] == players[playerTurn] ) {
//                                gameOver = true
//                    }
//                    else if ( gameBoard[startingRow][startingCol] == players[playerTurn] && gameBoard[startingRow + 3][startingCol - 3] == players[playerTurn] &&
//                                    gameBoard[startingRow + 2][startingCol - 2] == players[playerTurn] && gameBoard[startingRow + 1][startingCol - 1] == players[playerTurn] ) {
//                                gameOver = true
//                    }
//                }
//            }
//    players[0] = "X"
//    players[1] = "O"
//    return gameOver
//}
//fun downRightValidation() {
//    while ( gameBoard[startingRow][startingCol] == gameBoard[4][1] || gameBoard[startingRow][startingCol] == gameBoard[4][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][3] || gameBoard[startingRow][startingCol] == gameBoard[4][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[4][5] || gameBoard[startingRow][startingCol] == gameBoard[5][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][2] || gameBoard[startingRow][startingCol] == gameBoard[5][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[5][4] || gameBoard[startingRow][startingCol] == gameBoard[5][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][1] || gameBoard[startingRow][startingCol] == gameBoard[6][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][3] || gameBoard[startingRow][startingCol] == gameBoard[6][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[6][5] || gameBoard[startingRow][startingCol] == gameBoard[7][1] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][2] || gameBoard[startingRow][startingCol] == gameBoard[7][3] ||
//            gameBoard[startingRow][startingCol] == gameBoard[7][4] || gameBoard[startingRow][startingCol] == gameBoard[7][5] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][1] || gameBoard[startingRow][startingCol] == gameBoard[8][2] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][3] || gameBoard[startingRow][startingCol] == gameBoard[8][4] ||
//            gameBoard[startingRow][startingCol] == gameBoard[8][5] || gameBoard[startingRow][startingCol] == players[playerTurn] &&
//            gameBoard[startingRow - 3][startingCol + 3] == players[playerTurn] && gameBoard[startingRow - 2][startingCol + 2] ==
//            players[playerTurn] && gameBoard[startingRow - 1][startingCol + 1] == players[playerTurn]) {
//        gameOver = true }
//}
//fun upRightValidation() {
//
//
//    if (gameBoard[startingRow][startingCol] == players[playerTurn] &&
//            gameBoard[startingRow + 3][startingCol + 3] == players[playerTurn] && gameBoard[startingRow + 2][startingCol + 2] ==
//            players[playerTurn] && gameBoard[startingRow + 1][startingCol + 1] == players[playerTurn]) {
//        gameOver = true
//    }
//}
//fun downLeftValidation() {
//
//    if ( playerTurn == 0 ) {
//        players[0] = "\u001b[31mX\u001b[37m"
//    }
//    if ( playerTurn == 1 ) {
//        players[1] = "\u001b[34mO\u001b[37m"
//    }
//    println( players[playerTurn] )
//    for ( row in 3..gameBoard.size - 1 ) {
//        for ( col in 3..gameBoard.size - 1 ){
//            var currentRow = 0
//            currentRow = row
//            var currentCol = 0
//            currentCol = col
//            var true1 = false
//            var true2 = false
//            var true3 = false
//            var true4 = false
//            var val1 = "${gameBoard[currentRow][currentCol]} ${currentRow} ${currentCol}"
//            var val2 = "${gameBoard[currentRow-1][currentCol-1]} ${currentRow-1} ${currentCol-1}"
//            var val3 = "${gameBoard[currentRow-2][currentCol-2]} ${currentRow-2} ${currentCol-2}"
//            var val4 = "${gameBoard[currentRow-3][currentCol-3]} ${currentRow-3} ${currentCol-3}"
//            if(gameBoard[currentRow][currentCol] == players[playerTurn] ){
//                true1 = true
//            }
//            if(gameBoard[currentRow - 1][currentCol - 1] == players[playerTurn] ){
//                true2 = true
//            }
//            if(gameBoard[currentRow - 2][currentCol - 2] == players[playerTurn] ){
//                true3 = true
//            }
//            if(gameBoard[currentRow - 3][currentCol - 3] == players[playerTurn] ){
//                true4 = true
//            }
//            println( "${gameBoard[row][col]} ${gameBoard[row-1][col-1]} ${gameBoard[row-2][row-2]} ${gameBoard[row-3][col-3]}"  )
//            println( "${true1} ${val1}" )
//            println( "${true2} ${val2}" )
//            println( "${true3} ${val3}" )
//            println( "${true4} ${val4}" )
//            if (gameBoard[col][row] == players[playerTurn] &&
//                    gameBoard[col - 3][row - 3] == players[playerTurn] &&
//                    gameBoard[col - 2][row - 2] == players[playerTurn] &&
//                    gameBoard[col - 1][row - 1] == players[playerTurn]) {
//                gameOver = true
//            }
//        }
//    }
//    players[0] = "X"
//    players[1] = "O"
//}