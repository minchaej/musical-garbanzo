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

    companion object {
        var nodeCounter = 0
    }

    fun calculateFibonacci(n: Int): Int {
        val memo = IntArray(n)
        val ans = getFibonacciWithMemo(n, memo)
        memo.forEach { print("${it},") }
        println("")
        return ans
//        return getFibonacciWithMemo(n, memo)
//        return getFibonacciBrute(n)
    }

    private fun getFibonacciBrute(n: Int): Int {
        if (n < 2) {
            return n
        }
        nodeCounter += 2
        return getFibonacciBrute(n - 1) + getFibonacciBrute( n - 2)
    }

    private fun getFibonacciWithMemo(n: Int, memo: IntArray): Int {
        if (n < 2) {
            return n
        }
        val lhs = if (memo[n - 1] == 0) {
            nodeCounter++
            memo[n - 1] = getFibonacciWithMemo(n - 1, memo)
            memo[n - 1]
        } else {
            memo[n - 1]
        }

        val rhs = if (memo[n - 2] == 0) {
            nodeCounter++
            memo[n - 2]= getFibonacciWithMemo(n - 2, memo)
            memo[n - 2]
        } else {
            memo[n - 2]
        }

        return lhs + rhs
    }

    fun fibonacciIterative(n: Int): Int {
        if (n <= 1) {
            return n
        }
        var fib = 1
        var prevFib = 1
        for (i in 2 until n) {
            val temp = fib
            fib += prevFib
            prevFib = temp
        }
        return fib
    }

}