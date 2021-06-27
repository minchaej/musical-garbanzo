package problems


//Dynamic Programming and State Machine
class BestTimeToBuyAndSellStock {

    //Best Time to Buy and Sell Stock I - Easy
    class ChapterOne {
        //One Pass Method - One try
        fun maxProfit(prices: IntArray): Int {
            var lowest = prices[0]
            var profit = 0

            for (i in 1 until prices.size) {
                val price = prices[i]
                if (price > lowest) {
                    profit = Math.max(price - lowest, profit)

                } else {
                    lowest = price
                }
            }
            return profit
        }
    }

    //Best Time to Buy and Sell Stock II - Easy
    class ChapterTwo {
        //One Pass Method - One try
        fun maxProfit(prices: IntArray): Int {
            var lowest = prices[0]
            var profit = 0

            for (i in 1 until prices.size) {
                val price = prices[i]
                if (price > lowest) {
                    profit += price - lowest
                }
                lowest = price
            }
            return profit
        }
    }

    //Best Time to Buy and Sell Stock with Cooldown - Medium
    //Professor chance
    class ChapterThree {

        //State Machine
        fun maxProfit(prices: IntArray): Int {
            var noStock = 0
            var inHand = 0 - prices[0]
            var sold = 0

            for (i in 1 until prices.size) {
                val tempNoStock = noStock
                val tempInHand = inHand
                val tempSold = sold

                noStock = Math.max(tempNoStock, tempSold)
                inHand = Math.max(tempInHand, (tempNoStock - prices[i]))
                sold = tempInHand + prices[i]

            }
            return Math.max(noStock, sold)
        }

        fun maxProfitRecursion(prices: IntArray): Int {
            val n = prices.size
            val mem = IntArray(n + 1) { -1 }
            return findMax(prices, mem, 0, n)
        }

        fun findMax(prices: IntArray, mem: IntArray , curr: Int, n: Int): Int {
            if (curr >= n) {
                return 0
            }
            if (mem[curr] != -1) {
                return mem[curr]
            }
            var maxVal = 0
            for (i in curr + 1 until n) {
                if (prices[curr] < prices[i]) {
                    maxVal = Math.max(maxVal, prices[i] - prices[curr] + findMax(prices, mem, i + 2, n))
                }
            }
            maxVal = Math.max(maxVal, findMax(prices, mem, curr + 1, n))
            mem[curr] = maxVal
            return maxVal
        }

        /**
         *  An element is minima when:
         *  - it is less than or equal to both its neighbors.
         *  - For corner elements, we need to consider only one neighbor for comparison.
         */
        fun findLocalMinima(givenArray: List<Int>): List<Int> {
            if (givenArray.size == 0) return emptyList()

            val minima = ArrayList<Int>()

            for (i in 0 until givenArray.size) {
                val currentElement = givenArray[i]
                when {
                    i == 0 -> {
                        //Corner
                        if (currentElement < givenArray[i + 1]) {
                            minima.add(currentElement)
                        }
                    }
                    i == givenArray.size - 1 -> {
                        //Corner
                        if (currentElement < givenArray[i - 1]) {
                            minima.add(currentElement)
                        }
                    }
                    else -> {
                        //Not Corner
                        if (currentElement < givenArray[i - 1] && currentElement < givenArray[i + 1]) {
                            minima.add(currentElement)
                        }
                    }
                }
            }

            return minima
        }

        fun findLocalMaxima(givenArray: List<Int>): List<Int> {
            if (givenArray.size == 0) return emptyList()

            val minima = ArrayList<Int>()

            for (i in 0 until givenArray.size) {
                val currentElement = givenArray[i]
                when {
                    i == 0 -> {
                        //Corner
                        if (currentElement > givenArray[i + 1]) {
                            minima.add(currentElement)
                        }
                    }
                    i == givenArray.size - 1 -> {
                        //Corner
                        if (currentElement > givenArray[i - 1]) {
                            minima.add(currentElement)
                        }
                    }
                    else -> {
                        //Not Corner
                        if (currentElement > givenArray[i - 1] && currentElement > givenArray[i + 1]) {
                            minima.add(currentElement)
                        }
                    }
                }
            }

            return minima
        }

    }

    //Best Time to Buy and Sell Stock with Transaction Fee - Medium
    class ChapterFour {

        //State Machine - One Try
        fun maxProfit(prices: IntArray, fee: Int): Int {
            var noStock = 0
            var inHand = 0 - prices[0]

            for (i in 1 until prices.size) {
                val tempNoStock = noStock
                val tempInHand = inHand

                noStock = Math.max(tempNoStock, (tempInHand + prices[i] - fee))
                inHand = Math.max(tempInHand, tempNoStock - prices[i])
            }
            return noStock
        }

    }

    //Best Time to Buy and Sell Stock III - Hard
    // First Buy -> First Sell -> Second Buy -> Second Sell
    class ChapterFive {

        fun maxProfit(prices: IntArray): Int {
            if (prices.size == 0) return 0

            var fb = Integer.MIN_VALUE
            var sb = Integer.MIN_VALUE
            var fs = 0
            var ss = 0

            for (i in 0 until prices.size) {
                fb = Math.max(fb, 0 - prices[i])
                fs = Math.max(fs, fb + prices[i])
                sb = Math.max(sb, fs - prices[i])
                ss = Math.max(ss, sb + prices[i])
            }

            return ss
        }

        //1,2,4,2,5,7,2,4,9,0
        fun maxProfitHWithLog(prices: IntArray): Int {
            if (prices.size == 0) return 0
            val fb = IntArray(prices.size)
            val fs = IntArray(prices.size)
            val sb = IntArray(prices.size)
            val ss = IntArray(prices.size)

            fb[0] = 0 - prices[0]
            fs[0] = 0
            sb[0] = 0 - prices[0]
            ss[0] = 0

            for (i in 1 until prices.size) {
                fb[i] = Math.max(fb[i - 1], 0 - prices[i])
                fs[i] = Math.max(fs[i - 1], fb[i] + prices[i])
                sb[i] = Math.max(sb[i - 1], fs[i] - prices[i])
                ss[i] = Math.max(ss[i - 1], sb[i] + prices[i])
            }
            fb.forEach { print("${it}, ") }; println();
            fs.forEach { print("${it}, ") }; println();
            sb.forEach { print("${it}, ") }; println();
            ss.forEach { print("${it}, ") }; println();
            return ss[prices.size - 1]
        }

    }

    // Best Time to Buy and Sell Stock IV - Hard
    //Just Parameterize Answer from chapter five
    class ChapterSix {

        fun maxProfit(k: Int, prices: IntArray): Int {
            if (prices.size == 0 || k == 0) return 0
            val buys = IntArray(k){ Integer.MIN_VALUE }
            val sells = IntArray(k)

            for (i in 0 until prices.size) {
                for (j in 0 until k) {
                    if (j == 0) {
                        buys[j] = Math.max(buys[j], 0 - prices[i])
                        sells[j] = Math.max(sells[j], buys[j] + prices[i])
                    } else {
                        buys[j] = Math.max(buys[j], sells[j - 1] - prices[i])
                        sells[j] = Math.max(sells[j], buys[j] + prices[i])
                    }

                }
            }
            return sells[k - 1]
        }

        fun maxProfitArray(k: Int, prices: IntArray): Int {
            if (prices.size == 0 || k == 0) return 0
            val buys = List<IntArray>(k) { IntArray(prices.size) { if (it == 0) 0 - prices[0] else 0 } }
            val sells = List<IntArray>(k) { IntArray(prices.size) }

            for (i in 0 until k) {
                for (j in 1 until prices.size) {
                    if (i == 0) {
                        buys[i][j] = Math.max(buys[i][j - 1], 0 - prices[j])
                        sells[i][j] = Math.max(sells[i][j - 1], buys[i][j] + prices[j])
                    } else {
                        buys[i][j] = Math.max(buys[i][j - 1], sells[i - 1][j] - prices[j])
                        sells[i][j] = Math.max(sells[i][j - 1], buys[i][j] + prices[j])
                    }
                }
            }

            return sells[k - 1][prices.size - 1]
        }

    }

}