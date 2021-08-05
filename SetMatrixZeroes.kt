package problems

import problems.datastructure.print

class SetMatrixZeroes {

    fun setZeroes(matrix: Array<IntArray>) {
        val rowSet : MutableSet<Int> = hashSetOf()
        val colSet : MutableSet<Int> = hashSetOf()

        for (i in 0 until matrix.size) {
            val row = matrix[i]
            for (j in 0 until row.size) {
                if (row[j] == 0) {
                    rowSet.add(i)
                    colSet.add(j)
                }
            }
        }

        for (i in 0 until matrix.size) {
            val row = matrix[i]
            for (j in 0 until row.size) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    row[j] = 0
                }
            }
        }
//        for (i in 0 until matrix.size) {
//            matrix[i].print()
//        }
    }

}