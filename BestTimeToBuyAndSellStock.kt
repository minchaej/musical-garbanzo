package problems

class BestTimeToBuyAndSellStock {

    class ChapterOne{
        //One Pass Method
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

}