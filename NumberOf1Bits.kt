package problems

class NumberOf1Bits {

    //Bit Manipulation Trick
    fun hammingWeight(n: Int): Int {
        var sum = 0
        var number = n
        while (number != 0) {
            sum++
            number = number and (number - 1)
        }
        return sum
    }
    //Loop style 1
    fun hammingWeight1(n: Int): Int {
        var sum = 0
        for (i in 0 until 32) {
            if((n and (1 shl i)) != 0) {
                sum++
            }
        }
        return sum
    }

    //Loop  style 2
    fun hammingWeight2(n: Int): Int {
        var number = n
        var sum = 0
        for (i in 0 until 32) {
            if ((number and 1) == 1) {
                sum++
            }
            number = number ushr 1
        }
        return sum
    }
}