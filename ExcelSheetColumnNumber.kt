package problems

class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        val stringLength = columnTitle.length
        var row = 0

        for (i in stringLength - 1 downTo 0) {
            val charInt = columnTitle[i].toInt() - 64 //By ASCII Standard
            val digit = stringLength - 1 - i
            row += Math.pow(26.0, digit.toDouble()).toInt() * charInt
        }

        return row
    }
}