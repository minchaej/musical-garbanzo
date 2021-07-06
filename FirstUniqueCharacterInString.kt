package problems

import java.util.HashMap

class FirstUniqueCharacterInString {
    fun firstUniqChar(s: String): Int {
        val hashMap = HashMap<Char, Int>()

        for (i in 0 until s.length) {
            val char = s[i]
            hashMap[char] = hashMap[char]?.plus(1) ?: 1
        }

        var index = -1

        for (i in 0 until s.length) {
            val char = s[i]
            if (hashMap[char] == 1) {
                index = i
                break
            }
        }

        return index
    }
}