/************************************************************
 *  Name:         Eric Craigen
 *  Date:         10/04/2020
 *  Assignment:   Week 2 - Various Classes
 *  Class Number: 283
 *  Description:  Classes to create people, characters, and
 *                addresses
 ************************************************************/

// Person class constructor
class Person( var firstName : String, var lastName : String, var age : Int, var hairColor : String,
              var eyeColor : String ) {
    // Person class to String output
    override fun toString(): String {
        return "PERSON: \n\tfirstName: ${firstName}\n\tlastName: ${lastName}\n\tage:" +
                " ${age}\n\thairColor: ${hairColor}\n\teyeColor: $eyeColor\n"
    }
}
// Address class constructor
class Address( var line1 : String, var line2 : String, var city : String, var state : String, var zip
: String ) {
    // Address class to String output
    override fun toString(): String {
        return "ADDRESS: \n\tline1: ${line1}\n\tline2: ${line2}\n\tcity: ${city}\n\tstate: " +
                "${state}\n\tzip: $zip\n"
    }
}
// Character class constructor
class Character( var name : String, var race : String, var hitPoints : Int, var gold : Int,  ) {
    // Mutable lists to hold the characters weapons and clothing
    private var weapons = mutableListOf<String>()
    private var clothing = mutableListOf<String>()
    // addWeapon function to add weapons to characters
    fun addWeapon( newWeapon : String ) {
        // add the newWeapon to the weapons list
        weapons.add( newWeapon )
    }
    // dropWeapon function to remove weapons from characters
    fun dropWeapon( droppedWeapon : String ) {
        // drop the droppedWeapon from the weapons list
        weapons.remove( droppedWeapon )
    }
    // addClothing function to add clothing to characters
    fun addClothing( newClothing : String ) {
        // add the newClothing to the clothing list
        clothing.add( newClothing )
    }
    // dropClothing function to remove clothing from characters
    fun dropClothing( droppedClothes : String ) {
        // drop the droppedClothes from the clothing list
        clothing.remove( droppedClothes )
    }
    // getWeapons function to add the weapons list to the Character class to String output
    private fun getWeapons() : String {
        // Create blank return String
        var retStr = ""
        // for each weapon in the weapons list
        for ( weapon in weapons ) {
            // if the weapon is not the last in the list
            retStr += if ( weapon != weapons.last() ) {
                // add the weapon to the String with a trailing comma
                "${weapon}, "
                // else just add the weapon without a trailing comma
            }else weapon
        }
        // Return the newly constructed weapons String
        return retStr
    }
    // getClothing function to add the clothing list to the Character class to String output
    private fun getClothing() : String {
        // Create blank return String
        var retStr = ""
        // for each piece of clothing in the clothing list
        for ( clothes in clothing ) {
            // if the piece of clothing is not the last in the list
            retStr += if ( clothes != clothing.last() ) {
                // add the piece of clothes to the String with a trailing comma
                "${clothes}, "
                // else just add the piece of clothing without a trailing comma
            }else {
                clothes
            }
        }
        // Return the newly constructed clothing String
        return retStr
    }
    // Character class to String output
    override fun toString(): String {
        return "CHARACTER: \n\tname: ${name}\n\trace: ${race}\n\thitPoints: ${hitPoints}\n\tgold: " +
                "%,d".format(gold) + "\n\tweapons: ${getWeapons()}\n\tclothing: ${getClothing()}\n\n"
    }
}

fun main () {

    // Create a new Person named Eric
    var eric = Person( "Eric", "Craigen", 30, "Brown", "Brown" )
    println( eric.firstName )
    println( eric )
    // Change the age of Person Eric
    eric.age = 31
    println( eric )

    // Create a new Address for Eric
    var ericAddress = Address( "1823 N. Nelson St.", "", "Spokane", "WA", "99207" )
    println( ericAddress )
    // Change the line2 in address to BASEMENT
    ericAddress.line2 = "BASEMENT"
    println( ericAddress )

    // Create a new Person named Jamie
    var jaime = Person( "Jamie", "Gould", 31, "Dark Red", "Green" )
    println( jaime.firstName )
    println( jaime )
    // Change the hair and eye color for Jamie
    jaime.hairColor = "Blonde"
    jaime.eyeColor = "Brown"
    println( jaime )
    // Change the eyeColor for Jamie again
    jaime.eyeColor = "Green"
    println( jaime )

    // Create new Address for Jamie
    var jamieAddress = Address( "1497 Beers Humbird Rd", "#1", "Cocoalla", "ID", "83813" )
    println( jamieAddress )
    // Change every line of the Address for Jamie since she moved in with me
    jamieAddress.line1 = "1823 N. Nelson St."
    jamieAddress.line2 = "BASEMENT"
    jamieAddress.city = "Spokane"
    jamieAddress.state = "WA"
    jamieAddress.zip = "99207"
    println( jamieAddress )

    // Create new Character named Geralt
    var geralt = Character( "Geralt", "Mutant", 1500, 10000000  )
    println( geralt )
    // Add clothing to Character Geralt
    geralt.addClothing( "Cat School Helm" )
    geralt.addClothing( "Cat School Gloves" )
    geralt.addClothing( "Cat School Boots" )
    geralt.addClothing( "Cat School Chest Piece" )
    println( "*** \tclothing added\t ***\n$geralt" )
    // Drop clothing from Character Geralt
    geralt.dropClothing( "Cat School Helm" )
    println( "*** \tclothing removed\t ***\n$geralt" )
    // Add clothing to Character Geralt
    geralt.addClothing( "Bear School Helm" )
    println( "*** \tclothing added\t ***\n$geralt" )
    // Add weapons to Character Geralt
    geralt.addWeapon( "Cat School Steel Sword" )
    geralt.addWeapon( "Cat School Silver Sword" )
    geralt.addWeapon( "Bear School Crossbow" )
    geralt.addWeapon( "Yarden" )
    println( "*** \tweapons added\t ***\n$geralt" )
    // Drop weapon from Character Geralt
    geralt.dropWeapon( "Yarden" )
    println( "*** \tweapons removed\t ***\n$geralt" )
    // Add weapon to Character Geralt
    geralt.addWeapon( "Igni" )
    println( "*** \tweapons added\t ***\n$geralt" )
    // Change the gold and hitPoints that Character Geralt has
    geralt.gold = 200
    geralt.hitPoints = 340
    println( geralt )

    // Create new Character named Yenneifer
    var yennifer = Character( "Yennifer", "Human", 950, 352015410 )
    println( yennifer )
    // Add weapons to Character Yennifer
    yennifer.addWeapon( "Firebolt" )
    yennifer.addWeapon( "Cure" )
    yennifer.addWeapon( "Summon" )
    println( "*** \tweapons added\t ***\n$yennifer" )
    // Drop weapon from Character Yennifer
    yennifer.dropWeapon( "Cure" )
    println( "*** \tweapons removed\t ***\n$yennifer" )
    // Add clothing to Character Yennifer
    yennifer.addClothing( "Black Dress" )
    yennifer.addClothing( "Amulet of Ruin" )
    yennifer.addClothing( "Leather Boots" )
    println( "*** \tclothing added\t ***\n$yennifer" )
    // Drop clothing from Character Yennifer
    yennifer.dropClothing( "Black Dress" )
    println( "*** \tclothing removed\t ***\n$yennifer" )
    // Change the race and name of Character Yennifer
    yennifer.race = "Human/Witch"
    yennifer.name = "Geralt's Girl"
    println( yennifer )
}
