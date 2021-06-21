package problems

import java.util.*


class LongestSubstringWithoutRepeatingCharacters {

    //Sliding Window Optimized Time: O(n)
    fun lengthOfLongestSubstringPointer(s: String): Int {
        if (s.length == 0) return 0

        val repeatCharIndex = HashMap<Char, Int>() //char, spotted index
        var head = 0
        var currentMax = 0

        s.forEachIndexed { index, c ->
            if (repeatCharIndex.containsKey(c)) {
                val nextTo = (repeatCharIndex.remove(c) ?: 0) + 1
                if (nextTo > head) {
                    //dont set head below... negative.
                    head = nextTo
                }
            }

            val length = index - head + 1
            if (length > currentMax) {
                currentMax = length
            }
            repeatCharIndex[c] = index
        }

        return currentMax
    }

}