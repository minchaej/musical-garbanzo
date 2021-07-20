package problems

import problems.datastructure.print

/**
 * EX: 1,2,3,4,5,6,7,8,9
 * SubArray - Contiguous part of array. | ex. 1,2,3,4 | Total available subarray = (n(n+1)) / 2
 * SubSequence (is a combination) - May not be contiguous but maintain the relative order | ex. 1,3,5,9 | Total available nonempty subsequence = 2^n - 1
 * SubSet (is a combination) - May not be contiguous and may not be in order | ex. 1,4,7,3
 */
class FourSum {

    /**
     * ANSWER:
     * skip in for loop is needed to filter out duplicated number
     * skip in summation find while loop is needed to filter out duplicated number
     */
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val arrayList = ArrayList<List<Int>>()
        nums.sort() // sort necessary to filter out duplicates

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue //since sorted, it is ok to skip and remove duplicates.
            }

            for (j in i + 1 until nums.size) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue //since sorted, it is ok to skip and remove duplicates.
                }

                val friend = target - nums[i] - nums[j]
                var left = j + 1
                var right = nums.size - 1

                while (left < right) {
                    val sumIJ = nums[left] + nums[right]
                    when {
                        sumIJ < friend -> left++
                        sumIJ > friend -> right--
                        sumIJ == friend -> {
                            //detect duplicates, since they are in order, duplicates will be adjacent.
                            //so it is sufficient to compare to previous value
                            if (left > j + 1 && right < nums.size - 1) {
                                if (nums[left] != nums[left - 1] || nums[right] != nums[right + 1]) {
                                    arrayList.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                                }
                            } else {
                                arrayList.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            }

                            left++
                            right--
                        }
                    }
                }

            }
        }

        return arrayList
    }

    //region Making this work with a generic k-combination algorithm.
    /**
     * FIRST TRY - THIS METHOD DID NOT WORK! - Came up with this with the idea of binary tree... two options for each node, to add or not to add.
     * Depth First Search - traverses far most left first. typically uses return value of recursion method.
     * Breath First Search - traverse level by level. typically has no return value in recursion method.
     */
    fun fourSumRecursiveTimeExceed(nums: IntArray, target: Int): List<List<Int>> {
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

        rec(index + 1, newSum, target, nums, newHolder, set)
        rec(index + 1, sum, target, nums, holder, set)
    }

    //Second try - removed arraylist optimized more - but still did not work. I guess the problem was asking for a non-generic answer.
    fun fourSumReNew(nums: IntArray, target: Int): List<List<Int>> {
        val set: MutableSet<List<Int>> = hashSetOf()
        val holder = IntArray(4)
        recNew(0, 0, 4, target, 0, nums, holder, set)
        return set.toList()
    }

    fun recNew (numIndex: Int, holderIndex: Int, k: Int, target: Int, sum: Int, nums: IntArray, holder:  IntArray, set: MutableSet<List<Int>>) {
        if (holderIndex == k) {
            if (sum == target) {
//                holder.print()
                set.add(holder.toList())
            }
            return
        }

        if (numIndex == nums.size) {
            return
        }

        holder[holderIndex] = nums[numIndex]
        recNew(numIndex + 1, holderIndex + 1, k, target, sum + nums[numIndex], nums, holder, set)
        recNew(numIndex + 1, holderIndex, k, target, sum, nums, holder, set)
    }
    //endregion

    //region k-combinations
    //Print all possible combinations of r elements in a given array of size n
    //https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    //Fix Elements
    private fun combinationUtilFixElements(arr: IntArray, data: IntArray, start: Int, end: Int, index: Int, r: Int) {
        if (index == r) {
            data.print()
            return
        }

        var i = start
        while (i <= end && end - i + 1 >= r - index) {
            data[index] = arr[i]
            combinationUtilFixElements(arr, data, i + 1, end, index + 1, r)
            i++
        }
    }

    fun printCombinationFixElements(arr: IntArray, r: Int) {
        val data = IntArray(r)
        combinationUtilFixElements(arr, data, 0, arr.size - 1, 0, r)
    }

    //Include and Exclude every element
    //Two  choies for each recursion; to add or not add current number
    //inspired by pascal's rule:  ncr = n-1cr + n-1cr-1
    //this is same as my answer.
    private fun combinationUtilIncludeExclude(arr: IntArray, n: Int, r: Int, index: Int, data: IntArray, i: Int) {
        if (index == r) {
            print("RES: ")
            data.print()
            return
        }
        if (i >= n) {
            return
        }
        data[index] = arr[i]
        data.print()
        combinationUtilIncludeExclude(arr, n, r, index + 1, data, i + 1) //included
        combinationUtilIncludeExclude(arr, n, r, index, data, i + 1) //excluded
    }

    fun printCombinationIncludeExclude(arr: IntArray, r: Int) {
        val data = IntArray(r)
        combinationUtilIncludeExclude(arr, arr.size, r, 0, data, 0)
    }
    //endregion

}