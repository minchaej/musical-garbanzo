package problems

class CountPrimes {
    fun countPrimes(n: Int): Int {
        if (n < 3) {
            return 0
        }

        val truthArray = Array(n + 1){ true }

        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (truthArray[i]) {
                for (j in (i * i)..n step i) {
                    truthArray[j] = false
                }
            }
        }


        var sum = 0
        for (i in 2 until truthArray.size - 1) {
            if (truthArray[i]) {
                sum++
            }
        }
        return sum
    }
}