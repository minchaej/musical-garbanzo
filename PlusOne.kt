package problems

class PlusOne {

    //I could have used LinkedList but since return type is IntArray it is inefficient to convert linedlist to IntArray all the time.
    //Only full carry requires extra space, so I can recycle given digit array.
    fun plusOne(digits: IntArray): IntArray {
        var isCarry = 0
        for (i in digits.size - 1 downTo 0) {
            val added = if (i == digits.size - 1) digits[i] + isCarry + 1 else digits[i] + isCarry
            if (added >= 10) {
                isCarry = 1
                digits[i] = added - 10
            } else {
                isCarry = 0
                digits[i] = added
            }
        }
        if (isCarry == 1) {
            val carryDigit = IntArray(digits.size + 1)
            carryDigit[0] = 1
            for (i in 1 until digits.size) {
                carryDigit[i] = digits[i - 1]
            }
            return carryDigit
        }
        return digits
    }
}