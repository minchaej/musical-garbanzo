package problems

object LongestCommonPrefix {

    //Divide and conquer
    fun longestCommonPrefixDivideAndConquer(strs: Array<String>): String {
        return if (strs.size == 0) "" else longestCommonPrefix(strs, 0, strs.size - 1)
    }

    private fun longestCommonPrefix(strs: Array<String>, l: Int, r: Int): String {
        return if (l == r) {
            strs[l]
        } else {
            val mid = (l + r) / 2
            val lcpLeft = longestCommonPrefix(strs, l, mid)
            val lcpRight = longestCommonPrefix(strs, mid + 1, r)
            println("left: ${lcpLeft}, right: ${lcpRight}")
            commonPrefix(lcpLeft, lcpRight)
        }
    }

    private fun commonPrefix(left: String, right: String): String {
        val min = Math.min(left.length, right.length)
        for (i in 0 until min) {
            if (left[i] != right[i]) return left.substring(0, i)
        }
        return left.substring(0, min)
    }


    //Vertical Approach
    fun longestCommonPrefixVerticalApproach(strs: Array<String>): String {
        val longestPrefix = strs[0]
        var longestCommonPrefix = ""

        for (i in 0 until longestPrefix.length) {
            val singlePrefix = longestPrefix[i]

            for (j in 1 until strs.size) {
                if (i == strs[j].length || strs[j][i] != singlePrefix) {
                    return longestCommonPrefix
                }
            }
            longestCommonPrefix += singlePrefix
        }

        return longestCommonPrefix
    }

    //Horizontal Approach
    fun longestCommonPrefix(strs: Array<String>): String {
        var longestPrefix = strs[0]

        for (i in 1 until strs.size) {
            val comparingString = strs[i]
            var prefix = ""

            for ((index, c) in longestPrefix.withIndex()) {
                if (index < comparingString.length && c == comparingString[index]) {
                    prefix += c
                } else {
                    break
                }
            }

            longestPrefix = prefix

            if (prefix == "") {
                break
            }
        }
        return longestPrefix
    }

    //Finding prefix of all combinations
    fun findingCommonPrefixForAllCombination(strs: Array<String>): String {
        val prefixSet : MutableSet<String> = hashSetOf()

        var longest = ""

        longest.indexOf("")

        for (i in 0 until strs.size) {
            val startingString = strs[i].split("")

            for (j in i + 1 until strs.size) {
                val comparingString = strs[j].split("")
                var prefix = ""

                //compare string a and b
                for ((index, a) in startingString.withIndex()) {
                    if (index < comparingString.size && a == comparingString[index]) {
                        prefix += a
                    } else {
                        break
                    }
                }

                //add prefix if not empty
                if (prefix.isNotEmpty()) {
                    prefixSet.add(prefix)
                    longest = prefix
                }
            }
        }

        var longestPrefix = ""

        prefixSet.forEach { prefix ->
            if (prefix.length > longestPrefix.length) {
                longestPrefix = prefix
            }
        }

        return longestPrefix
    }
}