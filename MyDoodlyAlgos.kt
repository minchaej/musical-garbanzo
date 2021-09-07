package problems

class MyDoodlyAlgos {
    /**
     * Compare which of the two strings must be first in alphabetical order!
     * If a is first in alphabetical order return TRUE
     */
    fun compare(a: String, b: String): Boolean {
        val shorter = if (a.length > b.length) {
            b
        } else {
            a
        }
        for (i in 0 until shorter.length) {
            val diff = a[i] - b[i]
            when {
                diff < 0 -> {
                    return true
                }
                diff > 0 -> {
                    return false
                }
            }
        }
        return true
    }

}