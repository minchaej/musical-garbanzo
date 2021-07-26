package problems

import java.util.*


/**
 * Think in one-dimension.
 * To get all possible subsequence of an array, each element had two choices (1) to include (2) to exclude.
 * Since it had two choices, time complexity is 2^n.
 * This problem is similar in a way, but each element has four choices. (1) to be used for a side, and square has four sides
 * So basic solution has 4^n; this is called "BackTracking"
 *
 * todo: Solve this with Dynamic Programming; reduces time to 2^n; NP-hard problem
 *
 * Tip: When analyzing code and do not under loop, unfold the loop and recognize the pattern.
 */
class MatchsticksToSquare {

    fun makesquare(matchsticks: IntArray): Boolean {
        var perimeter = 0
        for (i in 0 until matchsticks.size) {
            perimeter += matchsticks[i]
        }

        if (perimeter % 4 != 0) {
            return false
        }

        val side = perimeter / 4

        matchsticks.sortDescending()

        return df(0, 0, 0, 0, 0, matchsticks, side)
    }

    fun df(a: Int, b: Int, c: Int, d: Int, index: Int, matchsticks: IntArray, targetSide: Int): Boolean {
        if (matchsticks.size == index) {
            return a == b && b == c && c == d
        }

        val m = matchsticks[index]
        if (a + m <= targetSide && df(a + m, b, c, d, index + 1, matchsticks, targetSide)) {
            return true
        }
        if (b + m <= targetSide && df(a, b + m, c, d, index + 1, matchsticks, targetSide)) {
            return true
        }
        if (c + m <= targetSide && df(a, b, c + m, d, index + 1, matchsticks, targetSide)) {
            return true
        }
        if (d + m <= targetSide && df(a, b, c, d + m, index + 1, matchsticks, targetSide)) {
            return true
        }

        return false
    }

    //region My First Answer - Time Limit Exceed
    fun myMakesquare(matchsticks: IntArray): Boolean {
        var sum = 0
        for (i in 0 until matchsticks.size) {
            sum += matchsticks[i]
        }
        val lengthOfEachSide = sum.toDouble() / 4.0
        if (lengthOfEachSide % 1 != 0.0) {
            return false
        }
        //check if elements in array
        val target = lengthOfEachSide.toInt()
        val set : MutableSet<Int> = hashSetOf()

        //combin to find....
        val array = ArrayList<List<Int>>()
        allTargets(matchsticks, 0, ArrayList<Int>(), 0, target, array)

        //must use all sticks and no reuse

        return newww(array, matchsticks.size)
    }

    private fun allTargets(arr: IntArray, index: Int, path: ArrayList<Int>, sum: Int, target: Int, sides: ArrayList<List<Int>>) {
        if (index == arr.size) {
            if (path.size > 0) {
                if (sum == target) {
                    val side = ArrayList(path)
                    sides.add(side)
                }
            }
        } else {
            //include
            allTargets(arr, index + 1, path, sum, target, sides)
            //exclude
            path.add(index)
            allTargets(arr, index + 1, path, sum + arr[index], target, sides)
            path.removeAt(path.size - 1)
        }
    }

    private fun newww(arr: ArrayList<List<Int>>, target: Int): Boolean {
        for (i in 0 until arr.size) {
            for (j in i + 1 until arr.size) {
                for (k in j + 1 until arr.size) {
                    for (l in k + 1 until arr.size) {
                        val total = ArrayList<Int>()
                        val set : MutableSet<Int> = hashSetOf()

                        total.addAll(arr[i])
                        set.addAll(arr[i])

                        total.addAll(arr[j])
                        set.addAll(arr[j])

                        total.addAll(arr[k])
                        set.addAll(arr[k])

                        total.addAll(arr[l])
                        set.addAll(arr[l])

                        if (total.size == target && set.size == target) {
                            println(arr[i])
                            println(arr[j])
                            println(arr[k])
                            println(arr[l])
                            return true
                        }
                    }
                }
            }
        }
        return false
    }
    //endregion

    //region garbage
    fun recNew (numIndex: Int, holderIndex: Int, nums: ArrayList<List<Int>>, holder:  ArrayList<List<Int>>, combos: ArrayList<ArrayList<List<Int>>>) {
        if (holderIndex == 4) {
            combos.add(holder)
            return
        }

        if (numIndex == nums.size) {
            return
        }

        holder[holderIndex] = nums[numIndex]
        recNew(numIndex + 1, holderIndex + 1, nums, holder, combos)
        recNew(numIndex + 1, holderIndex, nums, holder, combos)
    }

    private fun allCombo(arr: ArrayList<List<Int>>, index: Int, path: ArrayList<List<Int>>, sides: ArrayList<ArrayList<List<Int>>>) {
        if (index == arr.size) {
            if (path.size > 0) {
                val side = ArrayList(path)
                sides.add(side)
            }
        } else {
            //include
            allCombo(arr, index + 1, path, sides)
            //exclude
            path.add(arr[index])
            allCombo(arr, index + 1, path, sides)
            path.removeAt(path.size - 1)
        }
    }

    /**
     * Bitwise operation to generate subsequence. - Iterative
     *
     * todo: reach out profs
     * https://www.programmersought.com/article/77371403463/
     * https://stackoverflow.com/questions/48098179/what-is-the-logic-to-use-bitwise-operation-in-generating-subsequences
     */
    fun magicSubsequence(arr: IntArray) {
        val length = arr.size
        val end = 1 shl length
        val subsequence = ArrayList<Int>()

        for (mark in 0 until end) {
            for (i in 0 until length) {
                if ((1 shl i and mark) != 0) {
                    //print(arr[i])
                    subsequence.add(arr[i])
                }
            }
            println(subsequence)
            subsequence.clear()
        }
    }

    //Recursive
    private fun printSubsequences(arr: IntArray, index: Int, path: ArrayList<Int>, sum: Int, target:Int, set : MutableSet<Int>) {
        if (index == arr.size) {
            if (path.size > 0) {
                print("Sum: $sum ")
                println(path)
            }
        } else {
            //include
            printSubsequences(arr, index + 1, path, sum, target, set)
            //exclude
            if (!set.contains(index)) {
                path.add(arr[index])
                printSubsequences(arr, index + 1, path, sum + arr[index], target, set)
                path.removeAt(path.size - 1)
            }
        }
    }
    //endregion

}