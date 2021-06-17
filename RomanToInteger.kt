package problems

object RomanToInteger{

    data class RomanNumeral (
        val precedent: Char?,
        val value: Int
    )

    fun romanToInt(input: String): Int {
        //ArrayList has to iterate so it is a bad option
        val romanKey = HashMap<Char, RomanNumeral>()
        romanKey.put('I', RomanNumeral(null, 1))
        romanKey.put('V', RomanNumeral('I', 5))
        romanKey.put('X', RomanNumeral('I', 10))
        romanKey.put('L', RomanNumeral('X', 50))
        romanKey.put('C', RomanNumeral('X', 100))
        romanKey.put('D', RomanNumeral('C', 500))
        romanKey.put('M', RomanNumeral('C', 1000))

        var previousChar: Char? = null
        var previousValue = 0
        var sum = 0

        for ((index, char) in input.withIndex()) {
            romanKey[char]?.let { romanNumeral ->

                if (previousChar != null && previousChar == romanNumeral.precedent) {
                    sum += (romanNumeral.value - (2 * previousValue))
                } else {
                    sum += romanNumeral.value
                }

                previousChar = char
                previousValue = romanNumeral.value
            } ?: continue
        }
        return sum
    }

    fun helper(input: String) {
        val romanKey = LinkedHashMap<Char, Int>()
        romanKey.put('I', 1)
        romanKey.put('V', 5)
        romanKey.put('X', 10)
        romanKey.put('L', 50)
        romanKey.put('C', 100)
        romanKey.put('D', 500)
        romanKey.put('M', 1000)
    }
}