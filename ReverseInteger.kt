package problems

object ReverseInteger {

    //Pop and push method
    fun reverse(x: Int): Int {
        var rev = 0
        var input = x

        while (input != 0) {
            val pop = input % 10 //get last value
            input /= 10 //eliminate last value

            if (rev > Integer.MAX_VALUE / 10) return 0
            if (rev < Integer.MIN_VALUE / 10) return 0

            rev = rev * 10 + pop //push last value
        }

        return rev
    }

}
