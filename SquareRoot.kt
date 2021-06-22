package problems

class SquareRoot {

    //binary search
    fun mySqrt(x: Int): Int {
        if (x < 2) return x
        var left: Long = 0
        var right: Long = x / 2L

        while (left <= right) {
            val mid = (left + right) / 2
            if (x >= (mid * mid) && x < ((mid + 1) * (mid + 1))) {
                return mid.toInt()
            } else if (x < (mid * mid)) {
                //x < (mid * mid)
                right = mid - 1
            } else {
                // x >= ((mid + 1) * (mid + 1))
                left = mid + 1
            }
        }
        return -1
    }

    //brute
    fun mySqrtBrute(x: Int): Int {
        var lhs: Long = 0
        while (true) {
            if (x >= (lhs * lhs) && x < ((lhs + 1) * (lhs + 1))) {
                return lhs.toInt()
            }
            lhs++
        }
    }
}