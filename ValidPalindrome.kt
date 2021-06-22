package problems

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val alphanumeric = s.filter { it.isLetterOrDigit() }
        val lowercase = alphanumeric.toLowerCase()

        var leftPointer = 0
        var rightPointer = lowercase.length - 1

        while (leftPointer <= rightPointer) {
            val leftChar = lowercase[leftPointer]
            val rightChar = lowercase[rightPointer]

            if (leftChar != rightChar) {
                return false
            }
            leftPointer++
            rightPointer--
        }
        return true
    }

}