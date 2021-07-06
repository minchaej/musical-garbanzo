package problems

class ValidAnagram {
    /**
     * Since ASCII characters are directly mapped to numbers, let't talk in numbers.
     * Through Arithmatic approach, I was able to achieve Time complexity of O(n) and Space complexity of O(1)
     * Since only lower case alphabet is given for the problem, the following equation works. (If 0 is introduced, this would not work)
     *
     * Given that
     * a + b + c = i
     * a * b * c = j
     *
     * d + e + f = k
     * d * e * f = k
     *
     * If i == k
     * Then the values of a,b,c equals to values of d,e,f (not respectively though)
     * Thus, they are anagrams.
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        var add1 = 0
        var add2 = 0

        var mul1 = 1
        var mul2 = 1

        for (i in 0 until s.length) {
            val char1 = s[i].toInt()
            add1 += char1
            mul1 *= char1

            val char2 = t[i].toInt()
            add2 += char2
            mul2 *= char2
        }

        return (add1 == add2) && (mul1 == mul2)
    }
}