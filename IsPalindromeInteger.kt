package problems

object IsPalindromeInteger {

    //Pop and push method
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false //negative is never palindrome
        if (x in 0..9) return true //single nonnegative digit is palindrome

        var inputNum = x
        var outputNum = 0
        while (inputNum != 0) {
            val pop = inputNum % 10
            inputNum /= 10
            outputNum = outputNum * 10 + pop
        }
        return x == outputNum
    }

    //Brute Method
    fun isPalindromeBrute(x: Int): Boolean {
        if (x < 0) return false //negative is never palindrome
        if (x >= 0 && x < 10) return true //single nonnegative digit is palindrome

        val string = x.toString()
        val stringReversed = string.reversed()

        return string == stringReversed
    }
}
