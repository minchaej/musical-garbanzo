package problems

class SlowestKey {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var maxTime = releaseTimes[0]
        var maxChar = keysPressed[0]

        for (i in 1 until releaseTimes.size) {
            val time = releaseTimes[i] - releaseTimes[i - 1]
            if (time == maxTime) {
                if (maxChar - keysPressed[i] < 0) {
                    maxChar = keysPressed[i]
                }
            }
            if (time > maxTime) {
                maxTime = time
                maxChar = keysPressed[i]
            }
        }

        return maxChar
    }
}