package problems

class ReverseString {
    fun reverseString(s: CharArray) {
        var leftPointer = 0
        var rightPointer = s.size - 1

        while (leftPointer <= rightPointer) {
            val leftChar = s[leftPointer]
            val rightChar = s[rightPointer]

            s[rightPointer] = leftChar
            s[leftPointer] = rightChar

            leftPointer++
            rightPointer--
        }
    }
}