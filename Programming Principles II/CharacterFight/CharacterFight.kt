import java.io.File
/************************************************************
 *  Name:         Eric Craigen
 *  Date:         10/26/20
 *  Assignment:   Character Fight
 *  Class Number: 283
 *  Description:  Dice roll based fighting game where two fighters
 *                can enter the ring and duke it out!
 ************************************************************/
// Menu class to drive the program
class Menu(var menuItems: Array<String>, var propmpt : String ) {
    var quit = menuItems.size
    fun displayMenu(  ) : Int {
        for ( (index, item) in menuItems.withIndex() ) {
            println( "${index + 1}. $item" )  // RARE cases where we can print inside the class
        }
        return promptForInt(propmpt, 1..menuItems.size)
    }
}
// class to create Dice objects
class Dice( private var numSides : Int ) {
    fun roll() : Int {
        return ( 1..numSides ).random()
    }
    override fun toString(): String {
        return "D${numSides}"
    }
}
// class to create Character objects
class Character(var name: String, var race : String, var hitPoints : Int, var strength : Int,
                var agility : Int, var weapon : Weapon, var armor : Armor) {
    private val maxHitPoints = 100
    private val maxStrength = 50
    private val maxAgility = 10
    var currentHitPoints = 0
    // initialize the fighters attributes
    init {
        name = name.capitalize()
        race = race.capitalize()
        if (hitPoints > 100) {
            hitPoints = maxHitPoints
        }
        currentHitPoints = hitPoints
        if (strength > 50) {
            strength = maxStrength
        }
        if (agility > 10) {
            agility = maxAgility
        }
    }
    // fun to get get the current hit points of the character objects
    fun getCurrentStatus(): Int {
        return this.currentHitPoints
    }
    // fun to reduce the current hit points of the chatacter objects
    fun reduceHits( dice4 : Int = 4, dice8 : Int = 8, dice15 : Int = 15 ): Array<Int> {
        var preHit : Int = (strength * (1.0 / Dice(dice4).roll()) + (weapon.damageHits / Dice(dice8).roll())).toInt()
        var armorSave : Int = (armor.protectionHits / Dice(dice15).roll())
        var postHit : Int = preHit - armorSave
        var ifReturnLife = preHit - armorSave
        // If post hit is > 0, reduce the post hit from current hit points and if
        // current hit points drops below 0, set current hit points to 0
        if (postHit > 0) {
            currentHitPoints -= postHit
            if ( currentHitPoints < 0 ) {
                currentHitPoints = 0
            }
        } else {
            postHit = 0
        }
        // return the calculations for display in fight function
        return arrayOf(preHit, armorSave, postHit, ifReturnLife)
    }
    // fun to revive characters back to full health upon starting a new fight
    fun reviveCharacters( ) {
        currentHitPoints = hitPoints
    }
    // toString fun
    override fun toString() : String {
        return "$name"
    }
}
// class to create item objects
open class Item(var itemName : String) {
    override fun toString(): String {
        return itemName.capitalize()
    }
}
// class to create weapon objects
class Weapon(itemName : String, var damageHits : Int) :
        Item(itemName) {
    override fun toString(): String {
        return itemName
    }
}
// class to create armor objects
class Armor(itemName : String, var protectionHits : Int) :
        Item(itemName) {
        override fun toString(): String {
            return itemName
        }
}
// fun to prompt user for menu input
fun promptForInt( message: String, range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE ) : Int {
    var input : String? = ""
    do {
        print("$message ")
        input = readLine()
    } while (input.isNullOrEmpty() || input.toInt() !in range)
    return input.toInt()
}
// fun to load fighters into the game from a txt file
fun loadFighter( userInput : String ) : Character  {
    // take user input for save name and read it into a lines array
    val saveFile = "src/${userInput}"
    val lines = File( saveFile ).readLines()
    // destructure lines array into attributes to create a fighter objects that also has a weapon and armor item object
    val tempFighterName = lines[0].split( "," )[0]
    val tempFighterRace = lines[0].split( "," )[1]
    val tempFighterHitPoints = lines[0].split( ", " )[1]
    val tempFighterStrength = lines[0].split( ", " )[3]
    val tempFighterAgility = lines[0].split( ", " )[2]
    val tempWeaponName = lines[1].split( ", " )[0]
    val tempDamageHits = lines[1].split( ", " )[1]
    val tempArmorName = lines[2].split( ", " )[0]
    val tempProtectionHits = lines[2].split( ", " )[1]
    var tempWeapon = Weapon( tempWeaponName, tempDamageHits.toInt() )
    var tempArmor = Armor( tempArmorName, tempProtectionHits.toInt() )
    return Character(tempFighterName, tempFighterRace, tempFighterHitPoints.toInt(), tempFighterAgility.toInt(), tempFighterStrength.toInt(), tempWeapon, tempArmor)
}
// fun to simulate one round of fighting
fun fight(player1: Character, player2: Character, agile1: Int = player1.agility, agile2 : Int = player2.agility, D10 : Int = 10 ) {
    var retString = ""
    // determine if the player hits for misses
            if (Dice(D10).roll() < player1.agility) {
                // if it is a hit execute reduceHits fun on the CURRENT player 2
                var results = player2.reduceHits()
                // construct the retStr for display in console with correct attributes
                retString += """
            |${player1.name} fights with the ${player1.weapon.itemName}:
            |       Hit: ${results[0]}      ${player2}'s armor saved ${results[1]}
            |${player2.name} hits are reduced by ${results[2]} points.
            |${player2.name} has ${player2.getCurrentStatus()} left out of ${player2.hitPoints}
            |""".trimMargin()
            } else  {
                // else construct the retStr for showing a miss
                retString += """
            |${player1.name} fights with the ${player1.weapon.itemName}:
            |       ${player1.name} Misses!   
            |""".trimMargin()
            }
    // return the retStr in a println
    return println(retString)
}

fun main() {
    // Initialize player1 and player2 character objects
    var player1 = loadFighter("gimli.txt")
    var player2 = loadFighter("legolas.txt")
    // Create Menu object
    val menu = Menu(arrayOf("Load Character 1", "Load Character 2", "Fight", "Quit"), "Please select an option: ")

    do {
    // Execute dispslayMenu fun
    val choice = menu.displayMenu()
    // When the users choice is not the quit option
    when (choice) {
        1 -> {
            // Execute loadFighter fun with users input for save file and reassign player1 to these new values
            print("Please enter a Fighter name: ")
            var userInput = readLine()!!
            player1 = loadFighter(userInput)
        }
        2 -> {
            // Execute loadFighter fun with users input for save file and reassign player2 to these new values
            print("Please enter a Fighter name: ")
            var userInput = readLine()!!
            player2 = loadFighter(userInput)
        }
        3 -> {
            // Executre reviveCharacters fun on both fighters
            player1.reviveCharacters()
            player2.reviveCharacters()
            // While neither player is dead
            while (player1.getCurrentStatus() > 0 && player2.getCurrentStatus() > 0) {
                // Create dice to roll for calculations
                var agile1 = player1.agility
                var agile2 = player2.agility
                if (Dice(agile1).roll() < Dice(agile2).roll()) {
                    // If player 1 is still alive to hit
                    if (player1.getCurrentStatus() > 0) {
                        // Execute the fight fun
                        fight(player1, player2)
                        // If player 2 is now dead, player 1 is the winner
                        if (player2.getCurrentStatus() === 0) {
                            println("""
                        |${player1.name} WINS!    
                        |""".trimMargin())
                            // break out of the while loop to not print anything else and end the fight
                            break
                        }
                    }
                    // If player 1 is still alive to hit
                    if (player2.getCurrentStatus() > 0) {
                        // Execute fight fun
                        fight(player2, player1)
                        println(player1.getCurrentStatus())
                        // If player 1 is now dead, player 2 is the winner
                        if (player1.getCurrentStatus() === 0) {
                            println("""
                        |${player2.name} WINS!    
                        |""".trimMargin())
                            // break out of the while loop to not print anything else and end the fight
                            break
                        }
                    }
                } else {
                    // If player 1 is still alive to hit
                    if (player2.getCurrentStatus() > 0) {
                        fight(player2, player1)
                        println(player1.getCurrentStatus())
                        // If player 1 is now dead, player 2 is the winner
                        if (player1.getCurrentStatus() === 0) {
                            println("""
                        |${player2.name} WINS!    
                        |""".trimMargin())
                            // break out of the while loop to not print anything else and end the fight
                            break
                        }
                    }
                    // If player 2 is still alive to hit
                    if (player1.getCurrentStatus() > 0) {
                        fight(player1, player2)
                        println(player2.getCurrentStatus())
                        // If player 2 is now dead, player 1 is the winner
                        if (player2.getCurrentStatus() === 0) {
                            println("""
                        |${player1.name} WINS!    
                        |""".trimMargin())
                            // break out of the while loop to not print anything else and end the fight
                            break
                        }
                    }
                }
                // Pause the round and wait for user to press enter
                    println("Hit return to continue ...")
                    var userContinue = readLine()!!
                }
                // print the final results after the winner is announced
                println( """
                |-------------------------
                |${player1.name} has ${player1.getCurrentStatus()} out of ${player1.hitPoints}.
                |${player2.name} has ${player2.getCurrentStatus()} out of ${player2.hitPoints}.
                |-------------------------""".trimMargin() )
            }
        }
    } while (choice != menu.quit)
}