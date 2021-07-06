package problems

class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val list = ArrayList<String>()
        for (i in 1..n) {
            val string = when {
                i % 3 == 0 && i % 5 == 0 -> {
                    "FizzBuzz"
                }
                i % 3 == 0 -> {
                    "Fizz"
                }
                i % 5 == 0 -> {
                    "Buzz"
                }
                else -> {
                    i.toString()
                }
            }
            list.add(string)
        }
        return list
    }
}