package problems


class Candy {

    /**
     * Separation into smaller problem
     * 1. Scan Left to Right
     * 2. Scan Right to Left
     */
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size){ 1 }

        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        var sum = candies[ratings.size - 1]

        for (i in ratings.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1)
            }
            sum += candies[i]
        }

        return sum
    }

    //simplified
    fun candyTwoArray(ratings: IntArray): Int {
        val ltr = IntArray(ratings.size){ 1 }
        val rtl = IntArray(ratings.size){ 1 }
        var max = 0

        for (i in 1 until ltr.size) {
            val prev = ratings[i - 1]
            val curr = ratings[i]

            if (curr > prev) {
                ltr[i] = ltr[i - 1] + 1
            }
        }

        for (i in rtl.size - 2 downTo 0) {
            val next = ratings[i + 1]
            val curr = ratings[i]

            if (curr > next) {
                rtl[i] = rtl[i + 1] + 1
            }
        }

        for (i in 0 until ltr.size) {
            max += Math.max(ltr[i], rtl[i])
        }

        return max
    }

}