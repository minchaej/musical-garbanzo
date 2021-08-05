package problems

class ToeplitzMatrix {
    /**
     * What if the matrix is stored on disk, and the memory is limited such that
     * you can only load at most one row of the matrix into the memory at once?
     */
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        var row = intArrayOf(0)
        for (i in 0 until matrix.size) {
            if (i > 0) {
                for (j in 1 until row.size) {
                    if (row[j - 1] != matrix[i][j]) {
                        return false
                    }
                }
            }
            row = matrix[i]
        }
        return true
    }
}