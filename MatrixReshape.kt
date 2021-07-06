package problems

class MatrixReshape {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if(mat.isEmpty()) {
            return emptyArray()
        }

        val rowSize = mat.size
        val colSize = mat[0].size

        if ((rowSize * colSize) != (r * c)) {
            return mat
        }

        val output = Array(r) { IntArray(c) { 0 } }


        for (i in 0 until rowSize) {
            for (j in 0 until colSize) {
                val num = mat[i][j]
                val currIndex = (colSize * i) + j
                val newRow = currIndex / c
                val newCol = currIndex % c
                output[newRow][newCol] = num
            }
        }

        return output
    }
}