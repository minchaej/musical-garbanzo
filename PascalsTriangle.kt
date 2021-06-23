package problems

class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val row = List(numRows) { ArrayList<Int>(it + 1) }

        for (i in 0 until row.size) {
            val column = row[i]
            for (j in 0 .. i) {
                if (j == 0 || j == i) {
                    column.add(1)
                } else {
                    val left = row[i - 1][j - 1]
                    val right = row[i - 1][j]
                    column.add(left + right)
                }
            }
        }
        return row
    }
}