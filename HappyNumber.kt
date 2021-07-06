package problems

class HappyNumber {
    fun isHappy(n: Int): Boolean {

        var digit = 0
        var inputNum = n

        while (true) {
            var outputNum = 0

            while (inputNum != 0) {
                val pop = inputNum % 10
                inputNum /= 10
                outputNum += pop * pop
                digit++
            }
            if (outputNum == 1) {
                return true
            }
            if (outputNum == 4) {
                return false
            }
            inputNum = outputNum
        }

    }

    fun test(n: Int) {
        var outputNum = 0
        var digit = 0
        var inputNum = n

        while (inputNum != 0) {
            val pop = inputNum % 10
            inputNum /= 10
            outputNum += pop * pop
            digit++
        }

        println(outputNum)
    }
}