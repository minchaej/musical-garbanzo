package problems

import problems.datastructure.print

class PushDominoes {

    val L = 'L'
    val R = 'R'
    val O = '.'


    fun pushDominoes(dominoes: String): String {

        val R_Array = CharArray(dominoes.length){ O }
        var R_Last = O
        for (i in 0 until dominoes.length) {
            if (dominoes[i] == R) {
                R_Last = R
                R_Array[i] = R
            }

            if (dominoes[i] == L) {
                R_Last = L
            }

            if (dominoes[i] == O) {
                if (R_Last == R) {
                    R_Array[i] = R
                }
            }
        }

        val L_Array = CharArray(dominoes.length){ O }
        var L_Last = O
        for (i in dominoes.length - 1 downTo 0) {
            if (dominoes[i] == R) {
                L_Last = R
            }

            if (dominoes[i] == L) {
                L_Last = L
                L_Array[i] = L
            }

            if (dominoes[i] == O) {
                if (L_Last == L) {
                    L_Array[i] = L
                }
            }
        }

        val X_Array = CharArray(dominoes.length){ O }
        var start: Int? = null
        var end: Int? = null
        for (i in 0 until dominoes.length) {
            when {
                R_Array[i] != O && L_Array[i] != O -> {
                    X_Array[i] = 'X'
                    if (start == null) {
                        start = i
                    }
                }
                R_Array[i] != O -> {
                    X_Array[i] = R_Array[i]
                }
                L_Array[i] != O -> {
                    X_Array[i] = L_Array[i]
                    if (start != null) {
                        end = i - 1

                        var left = start ?: 0
                        var right = end ?: 0

                        while(left <= right) {
                            if (left == right) {
                                X_Array[left] = O
                            } else {
                                X_Array[left] = R
                                X_Array[right] = L
                            }
                            left++
                            right--
                        }
                        start = null
                        end = null
                    }
                }
            }
        }

//        R_Array.print()
//        L_Array.print()
//        X_Array.print()

        val sb = StringBuilder()
        for (i in 0 until X_Array.size) {
            sb.append(X_Array[i])
        }

        return sb.toString()
    }

    fun pushDominoesBrute(dominoes: String): String {
        val array = CharArray(dominoes.length)
        for (i in 0 until dominoes.length) {
            array[i] = dominoes[i]
        }

        var oppo = 0
        var last = O
        for (i in 0 until array.size) {

            if (array[i] == L && last == R) {
                var left = oppo
                var right = i

                while(left <= right) {
                    if (left == right) {
                        array[left] = O
                    } else {
                        array[left] = R
                        array[right] = L
                    }
                    left++
                    right--
                }
                last = O
                continue
            }

            if (array[i] == L) {
                last = array[i]
                oppo = i

                for (j in i - 1 downTo 0) {
                    if (array[j] == O) {
                        array[j] = L
                    } else {
                        break
                    }
                }
            }

            if (array[i] == R) {
                last = array[i]
                oppo = i

            }

            if (array[i] == O) {
                if (last == R) {
                    array[i] = R
                }
            }

        }

        val sb = StringBuilder()
        for (i in 0 until array.size) {
            sb.append(array[i])
        }

        return sb.toString()
    }
}