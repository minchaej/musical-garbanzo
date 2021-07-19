package problems

/**
 * EX: 1,2,3,4,5,6,7,8,9
 * SubArray - Contiguous part of array. | ex. 1,2,3,4 | Total available subarray = (n(n+1)) / 2
 * SubSequence (is a combination) - May not be contiguous but maintain the relative order | ex. 1,3,5,9 | Total available nonempty subsequence = 2^n - 1
 * SubSet (is a combination) - May not be contiguous and may not be in order | ex. 1,4,7,3
 */
class FourSum {

    fun combinationUtil(arr: IntArray, data: IntArray, start: Int, end: Int, index: Int, r: Int) { // Current combination is ready to be printed, print it
        if (index == r) {
            for (j in 0 until r) print(data.get(j).toString() + " ")
            println("")
            return
        }

        var i = start
        while (i <= end && end - i + 1 >= r - index) {
            data[index] = arr.get(i)
            combinationUtil(arr, data, i + 1, end, index + 1, r)
            i++
        }
    }

    fun printCombination(arr: IntArray, n: Int, r: Int) { // A temporary array to store all combination one by one
        val data = IntArray(r)
        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r)
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {


        return emptyList()
    }


    /**
     * Depth First Search - traverses far most left first. typically uses return value of recursion method.
     * Breath First Search - traverse level by level. typically has no return value in recursion method.
     */

    fun fourSumRecursive(nums: IntArray, target: Int): List<List<Int>> {
        val set : MutableSet<ArrayList<Int>> = hashSetOf()
        nums.sort()
        rec(0, 0, target, nums, ArrayList<Int>(), set)
        return set.toList()
    }

    private fun rec (index: Int, sum: Int, target: Int, nums: IntArray, holder:  ArrayList<Int>, set : MutableSet<ArrayList<Int>>) {
        if (sum == target && holder.size == 4) {
            set.add(holder)
            return
        }

        if (index == nums.size) {
            return
        }

        val currNum = nums[index]
        val newSum = sum + currNum
        val newHolder = ArrayList(holder).apply { add(currNum) }

        rec(index + 1, newSum, target, nums, newHolder, set )
        rec(index + 1, sum, target, nums, holder, set)
    }

}