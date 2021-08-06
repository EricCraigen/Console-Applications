import java.io.File
import java.io.PrintWriter

/************************************************************
 *  Name:         Eric Craigen
 *  Date:         11/25/2020
 *  Assignment:   Final: Word Search
 *  Class Number: 283
 *  Description:  Read a file of words and create a randomly
 *                generated Word Search Puzzle file with a corresponding
 *                Puzzle Key file.
 ************************************************************/
// Class to  create word puzzle objects
class Puzzle(var rows : Int, var col : Int, var fileName : String) {
    // Define variables to be used globally inside class methods to build the board
    private var emptyCell = '.'
    private var board = Array(rows){ Array(col){ emptyCell} }
    private var words = File(fileName).readLines()
    private var puzzleLetters = arrayListOf<Char>()
    private var wordCtr = 0
    private var startRow = (1 until rows).random()
    private var startCol = (1 until col).random()
    private var directions = arrayListOf(1,2,3,4,5,6,7,8)

    // Function to get letters from words that are contained within words
    private fun getPuzzleLetter(): ArrayList<Char> {
        for ( word in words ) {
            for (letter in word) {
                // If the current letter is not already in puzzleLetters array and is not a space
                if ( letter.toUpperCase() !in puzzleLetters && letter != ' ' ) {
                    // Add the current letter to puzzleLetters array
                    puzzleLetters.plusAssign(letter.toUpperCase())
                }
            }
        }
        return puzzleLetters
    }

    private fun writeKeyToFile(): PrintWriter {
        // Create file named puzzleKey.txt and open the file writer for it
        val puzzleKeyWriter = File( "src/puzzleKey.txt" ).printWriter()
        // Print the key board to puzzleKey.txt
        puzzleKeyWriter.println( printBoard())
        // Print the list of words to puzzleKey.txt
        puzzleKeyWriter.println( printWords() )
        // Close the file writer
        puzzleKeyWriter.close()
        return puzzleKeyWriter
    }

    // Function to create the board and create the puzzle.txt and puzzleKey.txt files
    fun createBoard() {
        // Sort words my desc length and loop over each of them
        for (word in words.sortedByDescending { it.length }) {
            var tempDirection = directions.random()
//             Place Word based on direction picked
            if (tempDirection == 1) {
            placeCharsWestToEast()
            }
            if (tempDirection == 2) {
                placeCharsEastToWest()
            }
            if (tempDirection == 3) {
                placeCharsNorthToSouth()
            }
            if (tempDirection == 4) {
                placeCharsSouthToNorth()
            }
            if (tempDirection == 5) {
                placeCharsSouthWestToNorthEast()
            }
            if (tempDirection == 6) {
                placeCharsSouthEastToNorthWest()
            }
            if (tempDirection == 7) {
                placeCharsNorthEastToSouthWest()
            }
            if (tempDirection == 8) {
                placeCharsNorthWestToSouthEast()
            }
        }
        writeKeyToFile()
        // Fill all emptyCells left on board with random letters from puzzleLetters array
        for ( row in 0 until rows ) {
            for ( cols in 0 until col ) {
                if ( board[row][cols] == emptyCell ){
                    board[row][cols] = getPuzzleLetter().random()
                }
            }
        }
        // Create file named puzzle.txt and open the file writer for it
        val puzzleWriter = File( "src/puzzle.txt" ).printWriter()
        // Print the filled board to puzzle.txt
        puzzleWriter.println( printBoard())
        // Print the list of words to puzzle.txt
        puzzleWriter.println( printWords() )
        // Close the file writer
        puzzleWriter.close()
    }
// Function for building word list retStr
    fun printWords(): String {
    // Prompt the end user with directions and size of words list
        var retStr = "Find the following ${words.size} words:\n\n"
    // Initialize and set wordRowCtr to 0
        var wordRowCtr = 0
    // loop over words
        for (word in words) {
            // append retStr with paddinig before and after for first column of words
            retStr += if (wordRowCtr == 0) {
                "               ${word.padEnd(20)}"
            // else the word is in the second or second column
            } else {
                word. padEnd(20)
            }
            wordRowCtr++
            // place the final word in the row, or third column of words
            if (wordRowCtr == 3) {
                retStr += "\n"
                wordRowCtr = 0
            }
        }
        return retStr
    }

// functions below test and place at the same time. I know that we were to have to separate functions for this, but this
    // is the way that I was able to figure out a solution. There are 8 functions below that test and place the words in all
    // 8 directions.
    private fun placeCharsWestToEast() {
    // Pick a random row and col to start testing and placing word.
            startRow = (1 until rows).random()
            startCol = (1 until col).random()
    // Set letterCtr to 0
            var letterCtr = 0
    // Set flag varible of wordPlaced to false
            var wordPlaced = false
    // While wordPlaced is not set to true, try to place the word
            while (wordPlaced != true) {
                // Select and set the current word to words sub wordCtr
                var word = words[wordCtr]
                // loop over the letters in the word and begin testing to place the word.
                for (letter in word) {
                    // test conditions and place the letter.
                    if (startRow != rows && startCol != col && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[startRow][++startCol] !in puzzleLetters)) {
                            if ( letter == ' ' ) {
                                board[startRow][startCol] = '.'
                                letterCtr++
                                startCol++
                            } else {
                                board[startRow][startCol] = word[letterCtr].toUpperCase()
                                letterCtr++
                                startCol++
                            }
                        wordPlaced = true
                        // else the word fell out of bounds or would overwrite and already placed letter
                    } else {
                        // while letterCtr is greater than 0
                        while ( letterCtr > 0 ) {
                            // repeat letterCtr and set the already tested and placed letters back to an empty cell
                            repeat(letterCtr) {
                                --startCol
                                board[startRow][startCol] = emptyCell
                            }
                            //pick a new random row and col to start testing and placing the word again.
                            startRow = (1 until rows).random()
                            startCol = (1 until col).random()
                            wordPlaced = false
                            letterCtr = 0
                        }
                    }

                }
            }
        // increment wordCtr
        wordCtr++
    }

    private fun placeCharsEastToWest() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[startRow][--startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startCol--
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startCol--
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        ++startCol
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsNorthToSouth() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[--startRow][startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow++
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow++
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        --startRow
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsSouthToNorth() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[++startRow][startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow--
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow--
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        ++startRow
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsSouthWestToNorthEast() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[++startRow][++startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow--
                        startCol--
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow--
                        startCol--
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        ++startRow
                        ++startCol
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsSouthEastToNorthWest() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[++startRow][--startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow--
                        startCol++
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow--
                        startCol++
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        ++startRow
                        --startCol
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsNorthEastToSouthWest() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[--startRow][--startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow++
                        startCol++
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow++
                        startCol++
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        --startRow
                        --startCol
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    private fun placeCharsNorthWestToSouthEast() {
        var startRow = (1 until rows).random()
        var startCol = (1 until col).random()
        var letterCtr = 0

        var wordPlaced = false
        while (wordPlaced != true) {
            var word = words[wordCtr]

            for (letter in word) {
                if ( ( startRow != rows && startRow != rows - ( rows + 1) ) && ( startCol != col && startCol != col - ( col + 1 ) ) && (board[startRow][startCol] == emptyCell && board[startRow][startCol] !in puzzleLetters || board[startRow][startCol] == letter && board[--startRow][++startCol] !in puzzleLetters)) {
                    if ( letter == ' ' ) {
                        board[startRow][startCol] = '.'
                        letterCtr++
                        startRow++
                        startCol--
                    } else {
                        board[startRow][startCol] = word[letterCtr].toUpperCase()
                        letterCtr++
                        startRow++
                        startCol--
                    }
                    wordPlaced = true
                } else {
                    repeat(letterCtr) {
                        --startRow
                        ++startCol
                        board[startRow][startCol] = emptyCell
                    }
                    startRow = (1 until rows).random()
                    startCol = (1 until col).random()
                    wordPlaced = false
                    letterCtr = 0
                    break
                }

            }
        }
        wordCtr++
    }

    // Function to build the printBoard retStr
    fun printBoard(): String {
        var retStr = ""
        for ( row in board.indices) {
            for ( col in board[0].indices) {
                retStr += board[row][col]
            }
            retStr += "\n"
        }
        retStr += "\n"
        return retStr
    }
    // override function set to printBoard.
    override fun toString(): String {
        return printBoard()
    }
}

fun main() {
    var puzzle = Puzzle(45, 45, "src/words.txt")
    puzzle.createBoard()
    println( puzzle.printBoard() )
    println( puzzle.printWords() )
}