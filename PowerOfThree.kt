package problems

import kotlin.math.roundToInt

class PowerOfThree {
    //logb(n) = log(n) / log(b) <-- out of double; precision error
    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && 1162261467 % n == 0;
    }
}