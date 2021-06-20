package problems

class ClimbingStairs {

    //Fibonacci
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        var first = 1
        var second = 2
        for (i in 3..n) {
            val third = first + second
            first = second
            second = third
        }
        return second
    }

}