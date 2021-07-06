package problems

import problems.datastructure.print


class MoveZeroes {

    fun moveZeroes(nums: IntArray) {
        var leftPointer = 0
        var rightPointer = 1
        nums.print()
        while (leftPointer < nums.size && rightPointer < nums.size) {
            val left = nums[leftPointer]
            val right = nums[rightPointer]

            when {
                left == 0 && right == 0 -> {
                    rightPointer++
                }
                left == 0 -> {
                    //swap
                    nums[leftPointer] = right
                    nums[rightPointer] = left
                    leftPointer++
                    rightPointer++
                }
                else -> {
                    leftPointer++
                    rightPointer++
                }
            }
            nums.print()
        }
    }

}