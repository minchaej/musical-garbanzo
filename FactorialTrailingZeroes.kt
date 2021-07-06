package problems

class FactorialTrailingZeroes {

    //Best solution...
    fun trailingZeroes(n: Int): Int {
        var count = 0
        var number = n

        while (number >= 5) {
            count += number / 5
            number /= 5
        }

        return count
    }

        //Without altering original value
    fun trailingZeroesMathematically(n: Int): Int {
        var count = 0
        var power = 1.0

        while (true) {
            val res = n / Math.pow(5.0, power).toInt()
            if (res == 0) {
                break
            } else {
                count += res
                power++
            }
        }
        return count
    }

     /**
    * By Unique-Prime-Factorisation Theorem, all natural number can be stated using only product of prime numbers.
    * Find all 5s
    */
    fun trailingZeroesBrute(n: Int): Int {
        var count = 0
        for (i in 1..n) {
            var temp = i
            while (true) {
                if (temp % 5 == 0) {
                    count++
                } else {
                    break
                }
                temp /= 5
            }
        }

        return count
    }
}