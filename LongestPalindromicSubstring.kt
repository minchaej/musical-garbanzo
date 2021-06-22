package problems

class LongestPalindromicSubstring {

    //Expand Around Center - Quite optimal solution of O(n^2)... but Manacher's algorithm could do it in O(n)
    fun longestPalindrome(s: String): String {
        var startIndex = 0
        var endIndex = 0

        for (i in 0 until s.length) {
            var tempStart = i
            var tempEnd = i

            for (j in i + 1 until s.length) {
                if (s[i] == s[j]){
                    tempEnd++
                } else {
                    break
                }
            }

            while (tempStart > 0 && tempEnd < s.length - 1) {
                val leftChar = s[tempStart - 1]
                val rightChar = s[tempEnd + 1]
                if (leftChar == rightChar) {
                    tempStart--
                    tempEnd++
                } else {
                    break
                }
            }

            val currentLength = tempEnd - tempStart + 1
            val maxLength = endIndex - startIndex + 1
            if (currentLength > maxLength) {
                endIndex = tempEnd
                startIndex = tempStart
            }

        }

        return s.substring(startIndex, endIndex + 1)
    }

    fun longestPalindromeWithString(s: String): String {

        var longestPalindrome = s[0].toString()

        for (i in 0 until s.length) {

            var leftPointer = i - 1
            var rightPointer = i
            var palindrome = ""

            for (j in i until s.length) {
                if (s[i] == s[j]){
                    palindrome += s[j]
                    rightPointer++
                } else {
                    break
                }
            }

            while (true) {
                if (leftPointer >= 0 && rightPointer  < s.length) {
                    val leftChar = s[leftPointer]
                    val rightChar = s[rightPointer]
                    if (leftChar == rightChar) {
                        leftPointer--
                        rightPointer++
                        palindrome = leftChar + palindrome + rightChar
                    } else {
                        break
                    }
                } else {
                    break
                }
            }

            if (palindrome.length > longestPalindrome.length) {
                longestPalindrome = palindrome
            }
        }

        return longestPalindrome
    }

    fun longestPalindromeScratch(s: String): String {

        var longestPalindrome = ""

        for (i in 0 until s.length) {
            //double mirror 이랍치고,, 두번 계산해서 큰걸로 가져왔어야했음...

            if (i < s.length - 1 && s[i] == s[i + 1]) {
                //case 1: double mirror
                var leftPointer = i - 1
                var rightPointer = i + 2
                var palindrome = "${s[i]}${s[i + 1]}"

                while (true) {
                    if (leftPointer >= 0 && rightPointer  < s.length) {
                        val leftChar = s[leftPointer]
                        val rightChar = s[rightPointer]
                        if (leftChar == rightChar) {
                            leftPointer--
                            rightPointer++
                            palindrome = leftChar + palindrome + leftChar
                        } else {
                            break
                        }
                    } else {
                        break
                    }
                }

                if (palindrome.length > longestPalindrome.length) {
                    longestPalindrome = palindrome
                }

            } else {
                //case 2: single mirror
                var leftPointer = i - 1
                var rightPointer = i + 1
                var palindrome = s[i].toString()
                while (true) {
                    if (leftPointer >= 0 && rightPointer  < s.length) {
                        val leftChar = s[leftPointer]
                        val rightChar = s[rightPointer]
                        if (leftChar == rightChar) {
                            leftPointer--
                            rightPointer++
                            palindrome = leftChar + palindrome + leftChar
                        } else {
                            break
                        }
                    } else {
                        break
                    }
                }

                if (palindrome.length > longestPalindrome.length) {
                    longestPalindrome = palindrome
                }

            }
        }

        return longestPalindrome
    }

}