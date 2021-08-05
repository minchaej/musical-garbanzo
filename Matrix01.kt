package problems

import problems.datastructure.print
import java.util.*


class Matrix01 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        /**
         * initialize with big number because
         * - There is at least one 0 in mat.
         * - 1 <= m, n <= 104
         * - 1 <= m * n <= 104
         */
        val res = Array<IntArray>(mat.size){ IntArray(mat[0].size){ Integer.MAX_VALUE - 10000 } }

        for (i in 0 until mat.size) {
            val width = mat[i].size
            for (j in 0 until width) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0
                } else {
                    if (i > 0) {
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1)
                    }
                    if (j > 0) {
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1)
                    }
                }
            }
        }

        for (i in mat.size - 1 downTo 0) {
            val width = mat[i].size
            for (j in width - 1 downTo 0) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0
                } else {

                    if (i < mat.size - 1) {
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1)
                    }
                    if (j < width - 1) {
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1)
                    }
                }
            }
        }

//        for (i in 0 until res.size) {
//            res[i].print()
//        }
        return res
    }

    //LeetCode Answer Checker is weird, this is not an accepted answer
    //todo: check with profs if this is really wrong
    fun updateMatrixFirst(mat: Array<IntArray>): Array<IntArray> {
        val res = Array<IntArray>(mat.size){ IntArray(mat[0].size) }
        val zeros: Queue<Pair<Int, Int>> = LinkedList()

        for (i in 0 until mat.size) {
            val width = mat[i].size
            for (j in 0 until width) {
                if (mat[i][j] == 0) {
                    if (zeros.size == width) {
                        zeros.poll()
                    }
                    zeros.add(Pair(i, j))
                } else {
                    //last zeros of width amount
                    if (zeros.size != 0) {
                        var min = Integer.MAX_VALUE
                        zeros.forEach { pair ->
                            val xDiff = Math.abs(i - pair.first)
                            val yDiff = Math.abs(j - pair.second)
                            min = Math.min(xDiff + yDiff, min)
                        }
                        res[i][j] = min
                    } else {
                        res[i][j] = -1
                    }
                }
            }
        }

        zeros.clear()

        for (i in mat.size - 1 downTo 0) {
            val width = mat[i].size
            for (j in width - 1 downTo 0) {
                if (mat[i][j] == 0) {
                    if (zeros.size == width) {
                        zeros.poll()
                    }
                    zeros.add(Pair(i, j))
                } else {
                    //last zeros of width amount
                    if (zeros.size != 0) {
                        var min = Integer.MAX_VALUE
                        zeros.forEach { pair ->
                            val xDiff = Math.abs(i - pair.first)
                            val yDiff = Math.abs(j - pair.second)
                            min = Math.min(xDiff + yDiff, min)
                        }
                        if (res[i][j] == -1) {
                            res[i][j] = min
                        } else {
                            res[i][j] = Math.min(res[i][j], min)
                        }
                    }
                }
            }
        }

        for (i in 0 until res.size) {
            res[i].print()
        }
        return res
    }
}