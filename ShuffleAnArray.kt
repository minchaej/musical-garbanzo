package problems

import problems.datastructure.print

class ShuffleAnArray {
    class Solution(private val nums: IntArray) {
        fun reset() = nums
        fun shuffle() = nums.toList().shuffled().toIntArray()
    }

    fun permutations(array: IntArray, index: Int) {
        if (index == array.size - 1) {
//            array.print()
            return
        }
        for (i in index until array.size) {
            swap(array, i, index)
            permutations(array, index + 1)
            swap(array, i, index)
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

}