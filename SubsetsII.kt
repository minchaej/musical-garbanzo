package problems

import java.util.ArrayList

//all combination of set, subset, subsequence
class SubsetsII {

    //todo: https://www.youtube.com/watch?v=xXKL9YBWgCY
    fun subsetsWithDupIterative(nums: IntArray): List<List<Int>> {
        val length = nums.size
        val end = 1 shl length
        val set : MutableSet<List<Int>> = hashSetOf()

        nums.sort()
        for (mark in 0 until end) {
            val subsequence = ArrayList<Int>()
            for (i in 0 until length) {
                if ((1 shl i and mark) != 0) {
                    subsequence.add(nums[i])
                }
            }
            set.add(subsequence)
        }

        return set.toList()
    }

    //could be optimized with memoization if this was a recursion
    fun subsetsWithDupRecursive(nums: IntArray): List<List<Int>> {
        val set : MutableSet<ArrayList<Int>> = hashSetOf()
        nums.sort()
        rec(0, nums, ArrayList<Int>(), set)
        return set.toList()
    }

    private fun rec (index: Int, nums: IntArray, holder:  ArrayList<Int>, set : MutableSet<ArrayList<Int>>) {
        set.add(holder)

        if (index == nums.size) {
            return
        }

        val currNum = nums[index]
        val newHolder = ArrayList(holder).apply { add(currNum) }

        rec(index + 1, nums, newHolder, set)
        rec(index + 1, nums, holder, set)
    }

}