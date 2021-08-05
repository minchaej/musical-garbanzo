package problems

class StoneGame {
    //But as the given rules state, alex will always win...!
    fun stoneGame(piles: IntArray): Boolean {
        var beginning = 0
        var end = piles.size - 1

        var alexTurn = true
        var alex = 0
        var lee = 0

        while (beginning <= end) {
            val b = piles[beginning]
            val e = piles[end]
            if (alexTurn) {
                if (b < e) {
                    alex += e
                    end--
                } else {
                    alex += b
                    beginning++
                }
            } else {
                if (b < e) {
                    lee += b
                    beginning++
                } else {
                    lee += e
                    end--
                }
            }
            alexTurn = !alexTurn
        }
        return alex > lee
    }
}