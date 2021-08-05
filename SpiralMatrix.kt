package problems

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()

        val row = matrix[0].size
        val col = matrix.size

        var x = 0
        var y = 0

        var isRow = true
        var isFirst = true

        while (true) {
            if (isRow) {
                if (isFirst) {
                    for (i in x until row) {
                        if (matrix[y][i] == Integer.MIN_VALUE) {
                            continue
                        }
                        x = i
                        res.add(matrix[y][x])
                        matrix[y][i] = Integer.MIN_VALUE
                    }
                } else {
                    for (i in row - 1 downTo 0) {
                        if (matrix[y][i] == Integer.MIN_VALUE) {
                            continue
                        }
                        x = i
                        res.add(matrix[y][x])
                        matrix[y][i] = Integer.MIN_VALUE
                    }
                }
            }

            isRow = !isRow

            if (!isRow) {
                if (isFirst) {
                    for (i in y until col) {
                        if (matrix[i][x] == Integer.MIN_VALUE) {
                            continue
                        }
                        y = i
                        res.add(matrix[y][x])
                        matrix[i][x] = Integer.MIN_VALUE
                    }
                } else {
                    for (i in col - 1 downTo 0) {
                        if (matrix[i][x] == Integer.MIN_VALUE) {
                            continue
                        }
                        y = i
                        res.add(matrix[y][x])
                        matrix[i][x] = Integer.MIN_VALUE
                    }
                }

                isRow = !isRow
                isFirst = !isFirst
                if (res.size == row * col) {
                    break
                }
            }
        }

        return res
    }
}