package problems

import problems.datastructure.print
import kotlin.math.absoluteValue

class ReverseBits {

    /**
     * Master of bit manipulation
     */
    fun reverseBits(n: Int): Int {
        var number = n
        number = ((number and 0xffff0000.toInt()) ushr 16) or ((number and 0x0000ffff) shl 16)
        number = ((number and 0xff00ff00.toInt()) ushr 8) or ((number and 0x00ff00ff) shl 8)
        number = ((number and 0xf0f0f0f0.toInt()) ushr 4) or ((number and 0x0f0f0f0f) shl 4)
        number = ((number and 0xcccccccc.toInt()) ushr 2) or ((number and 0x33333333) shl 2)
        number = ((number and 0xaaaaaaaa.toInt()) ushr 1) or ((number and 0x55555555) shl 1)
        return number
    }

    /**
     * Kotlin binary operations: https://www.programiz.com/kotlin-programming/bitwise
     * shl = multiply by two
     * shr = divide by 2
     * ~(1 << i) = (1 shl 3).inv()
     */
    fun reverseBitsNaive(n:Int): Int {
        var result = 0
        var number = n

        for (i in 0 until 32) {
            result = result shl 1

            //result = result or (number and 1)
            if ((number and 1) == 1) {
                result++
            }
            number = number shr 1
        }

        return result
    }

    /**
     * Integer.parseInt only works for positive value
     * Given 32 bit integer
     * Java's integer has no unsigned. So it is represented in Two's complement
     */
    fun twoscomplementMethod(n:Int): Int {
        var number = n.absoluteValue
        val integerSize = 32
        val bits = IntArray(integerSize) //or could initialize with 0

        //1. Turn in to bit
        for (i in bits.size - 1 downTo 0) {
            bits[i] = number % 2
            number /= 2
        }

        bits.print()

        //2. Turn in to Two's complement - Invert Bits
        if (n < 0) {
            //n is negative
            for (i in 0 until bits.size) {
                val bit = bits[i]
                if (bit == 0) {
                    bits[i] = 1
                } else {
                    bits[i] = 0
                }
            }
        }

        bits.print()

        //3. Turn in to Two's complement - Add 1 bit
        val firstBitAdded = bits[bits.size - 1]  + 1
        val isCarry = firstBitAdded == 2
        if (isCarry) {
            bits[bits.size - 1] = 0
        } else {
            bits[bits.size - 1] = firstBitAdded
        }
        for (i in bits.size - 2 downTo 0) {
            val bit = bits[i]
            if (isCarry) {
                if (bit == 1) {
                    bits[i] = 0
                } else {
                    bits[i] = bit + 1
                }
            } else {
                break
            }
        }

        bits.print()

        //4. Reverse the array
        val reversedBits = IntArray(integerSize)
        for (i in 0 until bits.size) {
            val bit = bits[i]
            val index = integerSize - i - 1
            reversedBits[index] = bit
        }

        reversedBits.print()

        //5. bit to int, if MSB is 1, then it is negative
        var res = 0
        for (i in reversedBits.size - 1 downTo 0) {
            val bit = reversedBits[i]
            val power = integerSize - i - 1
            if (bit == 1) {
                if (i == 0) {
                    res -= Math.pow(2.0, power.toDouble()).toInt()
                } else {
                    res += Math.pow(2.0, power.toDouble()).toInt()
                }
            }
        }
        println(res)

        return 1
    }
}