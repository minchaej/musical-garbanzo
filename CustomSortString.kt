package problems

import java.util.HashMap

class CustomSortString {

    /**
     * rank possible due to only lower case provided
     *
     */
    fun customSortStringOptimizedWithBucket(order: String, str: String): String {
        val bucket = IntArray(order.length)

        val rank = IntArray(26) { -1 }

        for (i in 0 until order.length) {
            rank[order[i] - 'a'] = i
        }

        val notIn = StringBuilder()
        val inF = StringBuilder()

        for (i in 0 until str.length) {
            if (rank[str[i] - 'a'] == -1) {
                notIn.append(str[i])
            } else {
                bucket[rank[str[i] - 'a']]++
            }
        }

        for (i in 0 until order.length) {
            for (j in 0 until bucket[i]) {
                inF.append(order[i])
            }
        }

        return inF.toString() + notIn.toString()
    }


    /**
     * I was too focused on solving with NO String Builder.. and swapping indexes within given str.
     * However, swapping was not possible because str could have multiple occurrence of order
     * This problem asked for two conditions: Multiple occurrence and Order
     * Multiple occurrence: Dealt with HashMap counting
     * Order: Dealt with StringBuilder Order
     *
     * Things to Remember: counting could be better than swapping sometimes.
     */
    fun customSortString(order: String, str: String): String {
        val hashMap = HashMap<Char, Int>()
        for (i in 0 until order.length) {
            val c = order[i]
            hashMap[c] = 0
        }

        val strSb = StringBuilder()
        for (i in 0 until str.length) {
            val c = str[i]
            if (hashMap.containsKey(c)) {
                hashMap[c] = hashMap[c]?.plus(1) ?: 0
            } else {
                strSb.append(c)
            }
        }

        val orderSb = StringBuilder()
        for (i in 0 until order.length) {
            val c = order[i]
            val count = hashMap[c] ?: 0
            for (j in 0 until count) {
                orderSb.append(c)
            }
        }

        orderSb.append(strSb)

        return orderSb.toString()
    }
}