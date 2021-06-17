package problems

import java.util.*
import kotlin.collections.ArrayList

object IntegerToRoman {

    //Think of a method to implement this with Reverse a LinkedList
    //Think of the modulus way...modulus to get the first digit (MSB)
    data class RomanNumeral (
        val precedent: Char?,
        val value: Int
    )

    data class RomanString (
        val ones: Char,
        val fives: Char,
        val tens: Char
    )

    //Clean method
    fun intToRomanNoList(num: Int): String {
        val romanKey = ArrayList<RomanString>()
        romanKey.add(RomanString('I', 'V', 'X'))
        romanKey.add(RomanString('X', 'L', 'C'))
        romanKey.add(RomanString('C', 'D', 'M'))
        romanKey.add(RomanString('M', '!',  '?'))

        var input = num
        var currentDigit = 0
        var romanNumber = ""

        while (input != 0) {
            val digit = input % 10
            val key = romanKey[currentDigit]
            var tempString = ""

            when {
                digit == 4 -> {
                    tempString = "${key.ones}${key.fives}"
                }
                digit == 9 -> {
                    tempString ="${key.ones}${key.tens}"
                }
                digit >= 5 -> {
                    var tempDigit = digit
                    tempDigit -= 5
                    tempString = "${key.fives}"
                    for (i in 1..tempDigit) {
                        tempString += key.ones
                    }
                }
                else -> {
                    for (i in 1..digit) {
                        tempString += key.ones
                    }
                }
            }

            romanNumber = tempString + romanNumber

            input /= 10
            currentDigit++
        }

        return romanNumber
    }

    //old method
    fun intToRomanWithList(num: Int): String {
        val romanKey = ArrayList<RomanString>()
        romanKey.add(RomanString('I', 'V', 'X'))
        romanKey.add(RomanString('X', 'L', 'C'))
        romanKey.add(RomanString('C', 'D', 'M'))
        romanKey.add(RomanString('M', '!',  '?'))

        var input = num
        val digitList = LinkedList<Int>()
        var romanNumber = ""

        while (input != 0) {
            digitList.add(input % 10)
            input /= 10
        }

        digitList.forEachIndexed { index, digit ->
            /*
            1 I
            2 II
            3 III
            4 IV
            5 V
            6 VI
            7 VII
            8 VII
            9 IX
             */

            val key = romanKey[index]
            var tempString = ""

            when {
                digit == 4 -> {
                    tempString = "${key.ones}${key.fives}"
                }
                digit == 9 -> {
                    tempString ="${key.ones}${key.tens}"
                }
                digit >= 5 -> {
                    var tempDigit = digit
                    tempDigit -= 5
                    tempString = "${key.fives}"
                    for (i in 1..tempDigit) {
                        tempString += key.ones
                    }
                }
                else -> {
                    for (i in 1..digit) {
                        tempString += key.ones
                    }
                }
            }

            romanNumber = tempString + romanNumber
        }

        return romanNumber
    }

}
