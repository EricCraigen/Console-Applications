import kotlin.math.roundToInt

/************************************************************
 *  Name:         Eric Craigen
 *  Date:         11/17/2020
 *  Assignment:   Check Writer
 *  Class Number: 283
 *  Description:  Program to take in a Double value and covert
 *                it to a string that can be placed on a check.
 ************************************************************/
fun Double.toCheckString() : String {
    // HashMap for nums to string
    var nums = hashMapOf<Int, String>(
            0 to "Zero",
            1 to "One",
            2 to "Two",
            3 to "Three",
            4 to "Four",
            5 to "Five",
            6 to "Six",
            7 to "Seven",
            8 to "Eight",
            9 to "Nine",
            10 to "Ten",
            11 to "Eleven",
            12 to "Twelve",
            13 to "Thirteen",
            14 to "Fourteen",
            15 to "Fifteen",
            16 to "Sixteen",
            17 to "Seventeen",
            18 to "Eighteen",
            19 to "Nineteen",
            20 to "Twenty",
            30 to "Thirty",
            40 to "Forty",
            50 to "Fifty",
            60 to "Sixty",
            70 to "Seventy",
            80 to "Eighty",
            90 to "Ninety",
    )
    // function to return the values to build the hundsStr
    fun getHunds(input: Double = this): ArrayList<Int> {
        // get hunds as whole int
        var hunds = (input.toInt() / 100)
        // get dollars to use as cents for dollars places
        var dollars = (input * 100).toInt() / 100 - (hunds * 100)
        // results array with the results for manipulation and building the retStr
        var results = arrayListOf(hunds, dollars)
        // return the results array
        return results
    }
    // initialize variables to maintain vaules through out the selection structures
    var centsStr = ""
    var retStr = ""
    var hunds = 0
    var dollars = 0
    var tens = 0
    var ones = 0
    var hundsStr = ""
    // calulate and build the centsStr
    var cents = (this * 100).roundToInt() % 100
    if (cents == 1) {
        centsStr += nums[cents] + " Cent"
    } else {
        centsStr += if (cents <= 20) {
            nums[cents] + " Cents"
        } else {
            var ones = cents % 10
            var tens = cents / 10 * 10
            if (ones == 0) {
                nums[tens] + " Cents"
            } else {
                nums[tens] + " " + nums[ones] + " Cents"
            }
        }
    }
    // getHunds function to get the hunds and dollars
    hunds = getHunds(this)[0]
    dollars = getHunds(this)[1]
    // convert dollars into "cents"
    tens = dollars / 10 * 10
    ones = dollars % 10
    hundsStr = ""
    // if hunds is zero
    if (hunds == 0 ) {
        // if dollars is zero
        if ( dollars == 0 ) {
            // add just dollars to the hundsStr
            hundsStr += nums[dollars]  + " dollars and "
            // else if dollars is 1
        } else if (dollars == 1) {
            // add just dollars and add "dollar" without the S to hundsStr
            hundsStr += nums[dollars] + " dollar and "
            // else dollars is more than one
        } else  {
            // if dollars is 20 or less
            hundsStr += if (dollars <= 20) {
                // just add dollars and to hundsStr
                nums[dollars] + " dollars and "
                // else dollars is more than 20
            } else {
                // if ones is 0
                if (ones == 0) {
                    // just add tens to hundsStr
                    nums[tens] + " dollars and "
                    //else ones is more than 0
                } else {
                    // add tens and ones to hundsStr
                    nums[tens] + " " + nums[ones] + " dollars and "
                }
            }
        }
        // else hunds is more than one
    } else {
        // if hunds is less than 10
        if ( hunds < 10 ) {
            // if dollars is 0
            if (dollars == 0) {
                // just add hunds to hundsStr
                hundsStr += nums[hunds] + " Hundred dollars and "
                // else if dollars is one
            } else if (dollars == 1) {
                // add hunds and dollars to hundsStr
                hundsStr += nums[hunds] + " Hundred " + nums[dollars] + " dollars and "
                // else dollars is more than one
            } else {
                // if dollars is 20 or less
                hundsStr += if (dollars <= 20) {
                    // add hunds and dollars to hundsStr
                    nums[hunds] + " Hundred " + nums[dollars] + " dollars and "
                    // else dollars is more than 20
                } else {
                    // assign new values to ones and tens to account for twenty or less being displayed
                    var ones = dollars % 10
                    var tens = dollars / 10 * 10
                    // if new ones is zero
                    if (ones == 0) {
                        // just add hunds and tens to hundsStr
                        nums[hunds] + " Hundred " + nums[tens] + " dollars and "
                        // else ones is more than zero
                    } else {
                        // add hunds tens and ones to hundsStr
                        nums[hunds] + " Hundred " + nums[tens] + " " + nums[ones] + " dollars and "
                    }
                }
            }
            // hunds is more than 10
        } else {
            // if dollars is zero
            if (dollars == 0) {
                // if hudns is 10
                if ( hunds == 10  ) {
                    // just and
                    hundsStr += nums[hunds] + " Hundred dollars and "
                }
            // else if dollars is one
            } else if (dollars == 1) {
                // add hunds and dollars to hundsStr
                hundsStr += nums[hunds] + " Hundred " + nums[dollars] + " dollars and "
                // else dollars is more than one
            } else {
                // if dollars is 20 or less
                hundsStr += if (dollars <= 20) {
                    // just add hunds and dollars to hundsStr
                    nums[hunds] + " Hundred " + nums[dollars] + " dollars and "
                    // else dollars is more than 20
                } else {
                    // assign new values to ones and dollars
                    var ones = dollars % 10
                    var tens = dollars / 10 * 10
                    // if new ones is zero
                    if (ones == 0) {
                        // jsut add hunds and tens to hundsStr
                        nums[hunds] + " Hundred " + nums[tens] + " dollars and "
                        // else ones is more than zero
                    } else {
                        // add hunds tens and ones to hundsStr
                        nums[hunds] + " Hundred " + nums[tens] + " " + nums[ones] + " dollars and "
                    }
                }
            }
        }
    }
    // if hudnsStr length is not zero
    if ( hundsStr.length != 0 ) {
        // set retStr to hundsStr plus centsStr
        retStr = hundsStr + centsStr
        // else there is no hunds
    } else {
        // set retStr to just centsStr
        retStr = centsStr
    }
        // return compiled retStr
        return retStr
    }

    fun main() {

    }

// I struggled on this one a lot because of the math. I understand how to follow debugging through to follow selection structures
// in order to build the string. It was just very difficult to get ANYWHERE without understanding how the results were getting there via the math.
// I finally figured out a way that made sense enough in my brain to get up to the 999.99 at around 10 am. This morning.
// I really want to keep going as I know although it is not the cleanest code ever written and it could potentially have bugs that I am unaware of, but I
// have been awake for two days straight now trying to play catch up in 4 classes after essentially missing a whole week and a half while I had to move
// my house. I am going to come back to this and fix it, I just have way more things to accomplish than I do time for the remainder of this quarter and it is going to be
// a blessing if I even make it. Or at least that's how I fell about it anyways. If I wasn't falling asleep typing right now I would push until midnight to try and finish my attempts
// at the thousands, but I cannot go three days in a row and have to accept where I got and keep it pushing. 

// Failed Attempt at thousands

//fun getThous(input: Double = this): ArrayList<Int> {
//    var thous = (input.toInt() / 1000)
//    var dollars = (input * 1000).toInt() / 1000 - (thous * 1000)
//    var results = arrayListOf(thous, dollars)
//
//    return results
//}

//var thousStr = ""
//var thous = 0
//var thousDollars = 0
//var thousTens = 0
//var thousOnes = 0

//    if (thous == 0 ) {
//        if ( thousDollars == 0 ) {
//            thousStr += nums[thous]  + " Thousand dollars and "
//        } else if (thousDollars == 1) {
//            hundsStr += nums[thousDollars] + " Thousand dollar and "
//        } else  {
//            thousStr += if (thousDollars <= 20) {
//                nums[thousDollars] + " Thousand dollars and "
//            } else {
//                if (thousOnes == 0) {
//                    nums[thousTens] + " Thousand dollars and "
//                } else {
//                    nums[thousTens] + " " + nums[thousOnes] + " Thousand dollars and "
//                }
//            }
//        }
//    } else {
//        if ( thous < 10 ) {
//            if (thousDollars == 0) {
//                thousStr += nums[thous] + " Thousand dollars and "
//            } else if (thousDollars == 1) {
//                thousStr += nums[thousTens] + " Thousand " + nums[thousDollars] + " dollars and "
//            } else {
//                thousStr += if (thousDollars <= 20) {
//                    nums[thous] + " Thousand " + nums[thousDollars] + " dollars and "
//                } else {
//                    var ones = thousDollars % 10
//                    var tens = thousDollars / 10 * 10
//                    if (thousOnes == 0) {
//                        nums[thousTens] + " Thousand " + nums[thousTens] + " dollars and "
//                    } else {
//                        nums[thousTens] + " Thousand " + nums[thousTens] + " " + nums[thousOnes] + " dollars and "
//                    }
//                }
//            }
//        } else {
//            if (thousDollars == 0) {
//                if ( thous == 10  ) {
//                    thousStr += nums[thous] + " Thousand dollars and "
//                } else {
//                    thousStr += nums[thous] + " Thousand dollars and "
//                }
//            } else if (thousDollars == 1) {
//                thousStr += nums[thous] + " Thousand " + nums[thousDollars] + " dollars and "
//            } else {
//                thousStr += if (dollars <= 20) {
//                    nums[thous] + " Thousand " + nums[thousDollars] + " dollars and "
//                } else {
//                    var thousOnes = thousDollars % 10
//                    var thousTens = thousDollars / 10 * 10
//                    if (ones == 0) {
//                        nums[thous] + " Thousand " + nums[thousTens] + " dollars and "
//                    } else {
//                        nums[thous] + " Thousand " + nums[thousTens] + " " + nums[thousOnes] + " dollars and "
//                    }
//                }
//            }
//        }
//    }

//    if ( this > 999.99 ) {
//        retStr = thousStr + centsStr
//    } else

//thous = getThous(this)[0]
//thousDollars = getThous(this)[1]
//thousTens =  thousDollars / 100 * 100
//thousOnes =  thousDollars % 100

//var hunds = input.roundToInt() / 100
//var dollars = (input * 100).roundToInt() / 100
//var tens = dollars / 10 * 10
//var ones = dollars % 10



// Failed Attempts

//        var hundsStr = ""
//    println( "Hunds: ${ hunds }")

//    if ( this > .99 ) {
//    if ( hunds <= 20 ) {
//        var dollars = ((this / 100) * 100).roundToInt() % 100
//        println( dollars )
//        if ( dollars <= 20 ) {
//            var ones = dollars % 10
//            var tens = dollars / 10 * 10
//            if ( hunds == 0 ) {
//                if (tens == 0) {
//                    hundsStr += nums[tens] + " dollars and " + centsStr
//                    if (ones == 0) {
//                        hundsStr += nums[hunds] + " Hundred " + " dollars and " + centsStr
//                    } else {
//                        hundsStr += nums[hunds] + " Hundred " + " " + nums[ones] + " dollars and " + centsStr
//                    }
//                } else {
//                    if (ones == 0) {
//                        hundsStr += nums[hunds] + " Hundred " + nums[tens] + " dollars and " + centsStr
//                    } else {
//                        hundsStr += nums[hunds] + " Hundred " + nums[tens] + " " + nums[ones] + " dollars and " + centsStr
//                    }
//                }
//            } else {
//                if (tens == 0) {
//                    hundsStr += nums[hunds] + " Hundred dollars and " + centsStr
//                    if (ones == 0) {
//                        hundsStr += nums[hunds] + " Hundred " + " dollars and " + centsStr
//                    } else {
//                        hundsStr += nums[hunds] + " Hundred " + " " + nums[ones] + " dollars and " + centsStr
//                    }
//                } else {
//                    if (ones == 0) {
//                        hundsStr += nums[hunds] + " Hundred " + nums[tens] + " dollars and " + centsStr
//                    } else {
//                        hundsStr += nums[hunds] + " Hundred " + nums[tens] + " " + nums[ones] + " dollars and " + centsStr
//                    }
//                }
//            }
//        } else {
//            var ones = dollars % 10
//            var tens = dollars / 10 * 10
//            if ( tens == 0 ) {
//                hundsStr += nums[hunds] + " Hundred dollars and " + centsStr
//                if ( ones == 0 ) {
//                    hundsStr += nums[hunds] + " Hundred " + " dollars and " + centsStr
//                } else {
//                    hundsStr += nums[hunds] + " Hundred " + " " + nums[ones] + " dollars and " + centsStr
//                }
//            } else {
//                if ( ones == 0 ) {
//                    hundsStr += nums[hunds] + " Hundred " + nums[tens] + " dollars and " + centsStr
//                } else {
//                    hundsStr += nums[hunds] + " Hundred " + nums[tens] + " " + nums[ones] + " dollars and " + centsStr
////                }
//            }
//        }
//    }
//    else if ( hunds <= 20 ) {
//        var dollars = ((this / 100) * 100).roundToInt() % 100
//        if ( dollars != 0 ) {
//            if ( dollars <= 20 ) {
//                var ones = dollars % 10
//                var tens = dollars / 10 * 10
//                if ( ones == 0 ) {
//
//                }
//            }
//        } else {
//            var ones = hunds % 10
//            hundsStr = nums[ones] + " dollars and " + centsStr
//        }

//        var ones = tens % 10
//        println( "Hunds Tens: ${tens}" )
//        println( "Hunds Ones: ${ones}" )
//        if ( ones != 0 ) {
////            if ( ones != 1 ) {
////                retStr = nums[tens] + " " + nums[ones] + " dollar and " + retStr
////            } else {
//                retStr = nums[tens] + " dollars and " + retStr
////            }
//        } else {
//            retStr = nums[tens] + " dollars and " + retStr
//        }
//    }


//    println( "Hunds: ${ cents  }")
//    println( "\tHunds Tens: ${tens}" )
//    println( "\tHunds Ones: ${ones}\n" )

//    if ( hunds <= 20 ) {
//        if ( hunds == 1 ) {
//            retStr += nums[hunds] + "  dollars and "
//        } else {
//
//        }
//    } else {
//        if ( (hunds % 100) <= 20 ) {
//            retStr =  nums[hunds] + " dollars and "
//        } else {
//            var ones = hunds % 100
//            var tens = hunds / 100 * 100
//            tempOnes = ones
//            tempTens = tens
//            if (ones == 0) {
//                nums[tens] + " dollars and "
//            } else {
//                nums[tens] + " " + nums[ones] + " dollars and "
//            }
//        }
//        println( "Hunds: ${hunds}" )
//        println( "\tHunds Tens: ${tempTens}" )
//        println( "\tHunds Ones: ${tempOnes}\n" )
//    }


//    if ( hunds == 1 ) {
//        var ones = hunds % 100
////            println( ones )
//        retStr = nums[ones] + " dollar and " + retStr
//
//    } else {
//        if ( hunds <= 20 ) {
//        retStr = nums[hunds] + " Hundred dollars and " + retStr
//        } else {
//            if (ones == 0) {
//                retStr = nums[hunds] + " " +  nums[tens] + " Hundred dollars and " + retStr
//            } else {
//                retStr = nums[hunds] + " " + nums[tens] + " " + nums[ones] + " Hundred dollars and " + retStr
//            }
//        }
//    }

//    var hunds = (this / 100) - cents.toDouble() / 10000 % 100

//    var hunds = ((this * 100) / 100 - cents.toDouble() / 100).roundToInt() % 100
//    var ones = hunds % 10
//    var tens = hunds / 10 * 10
//    if ( hunds == 1 || hunds ) {
//        retStr = nums[hunds] + " dollar and " + retStr
//    } else {
////        retStr = nums[hunds] + " dollars and " + retStr
//        if ( hunds <= 20 ) {
//            retStr = nums[hunds] + " dollars and " + retStr
//        } else {
//            if (ones == 0) {
//                retStr = nums[tens] + " dollars and " + retStr
//            } else if ( ones == 1 && tens == 0 && hunds != 0){
//                retStr = nums[tens] + " dollar and " + retStr
//            } else {
//                retStr = nums[tens] + " " + nums[ones] + " dollars and " + retStr
//            }
//        }
//    }
//    hunds = ((this * 100) / 100 - cents.toDouble() / 100).roundToInt()
//    if ( hunds >= 100 ){
//        hunds = (hunds / 100)
////        println( "hunds should = ${hunds}" )
//        if ( hunds <= 20 ) {
//            retStr = nums[hunds] + " Hundred " + retStr
//        }
//    }
//
//    println( hunds )


//    var hundsRetStr = ""
//    var hunds = ( ((this * 100).roundToInt() - cents) / 100 ) / 100
//    var dollars = ( ((this * 100).roundToInt() - cents) / 100 ) - (hunds * 100)
//    if (hunds <= 20 && hunds !== 0 && dollars !== 0) {
//            hundsRetStr = nums[hunds] + " Hundred and "
//            if ( dollars == 0 ) {
//                retStr = hundsRetStr + retStr
//            } else {
//                var ones = dollars % 10
//                var tens = dollars / 10 * 10
//                if (tens == 0) {
//                    if ( ones == 1 ) {
//                        retStr = hundsRetStr + nums[ones] + " Dollar and " + retStr
//                    } else {
//                        retStr = hundsRetStr + nums[ones] + " Dollars and " + retStr
//                    }
//                } else {
//                    if ( dollars <= 90 ) {
//                        if ( dollars <= 90 ) {
//                            if (dollars <= 20) {
//                                retStr = hundsRetStr + nums[dollars] + " Dollars and " + retStr
//                            } else {
//                                dollars = dollars - ones
//                                retStr = hundsRetStr + nums[dollars] + " Dollars and " + retStr
//                            }
//                        } else {
//                            retStr = hundsRetStr + nums[dollars] + " " + nums[ones] + " Dollars and " + retStr
//                        }
//                    } else {
//                        retStr = hundsRetStr + nums[tens] + " " + nums[ones] + " Dollars and " + retStr
//                    }
//                }
//            }
//        }
//
//    if ( hunds == 0 && dollars !== 0 ){
//            var ones = dollars % 10
//            var tens = dollars / 10 * 10
//            if (tens == 0) {
//                if ( ones == 1 ) {
//                    retStr = nums[ones] + " Dollar and " + retStr
//                } else {
//                    retStr = nums[ones] + " Dollars and " + retStr
//                }
//            } else {
//                if ( dollars <= 90 ) {
//                    if ( dollars <= 90 ) {
//                        if ( dollars <= 20 ) {
//                            retStr = hundsRetStr + nums[dollars] + " Dollars and " + retStr
//                        } else {
//                            if ( dollars !== 0 ) {
//                                dollars = dollars - ones
//                                retStr = hundsRetStr + nums[dollars] + " " + nums[ones] + " Dollars and " + retStr
//                            } else {
//                                dollars = dollars - ones
//                                retStr = hundsRetStr + nums[dollars] + " Dollars and " + retStr
//                            }
//                        }
//                    } else {
//                        retStr = hundsRetStr + nums[tens] + " " + nums[ones] + " Dollars and " + retStr
//                    }
//                } else {
//                    retStr = nums[tens] + " " + nums[ones] + " Dollars and " + retStr
//                }
//            }
//        }
//    else if (  ) {
//        var ones = dollars % 10
//        var tens = dollars / 10 * 10
//        if (tens == 0) {
//            if ( ones == 1 ) {
//                retStr = nums[ones] + " Dollar and " + retStr
//            } else {
//                retStr = nums[ones] + " Dollars and " + retStr
//            }
//        } else {
//            if ( dollars == 0 ) {
//                retStr = nums[dollars] + " Dollars and " + retStr
//            } else {
//                retStr = nums[tens] + " " + nums[ones] + " Dollars and " + retStr
//            }
//        }
//    }