package problems

import problems.datastructure.TreeNode
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.HashMap

class TwoSum {

    class ChapterOne {
        fun twoSumRevisitHashMethod(nums: IntArray, target: Int): IntArray {
            val diffMap : HashMap<Int, Int>  = hashMapOf() //<friend, index>

            for (i in 0 until nums.size) {
                val num = nums[i]
                val friend = target - num
                if (diffMap.containsKey(num)) {
                    val friendIndex = diffMap[num] ?: -1
                    return intArrayOf(friendIndex, i)
                } else {
                    diffMap[friend] = i
                }
            }

            return intArrayOf(-1, -1)
        }

        //Brute method
        fun twoSum(nums: IntArray, target: Int): IntArray {

            val intArr = IntArray(2)

            for ((i, a) in nums.withIndex()) {
                for ((j, b) in nums.withIndex()) {
                    if (i == j) {
                        continue
                    }
                    if (a + b == target) {
                        intArr[0] = i
                        intArr[1] = j
                        return intArr
                    }
                }
            }

            return intArr
        }

        //Hash method
        fun twoSumHash(nums: IntArray, target: Int): IntArray {

            val diffMap : HashMap<Int, Int>  = hashMapOf() //<value, index>

            for ((index, value) in nums.withIndex()) {
                val diff = target - value
                val diffIndex = diffMap[diff]

                diffIndex?.let {
                    return intArrayOf(diffIndex, index)
                } ?: run { diffMap[value] = index }
            }

            return intArrayOf(-1, -1)
        }
    }

    class ChapterTwo {
        //two pointer method
        fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
            var i = 0
            var j = numbers.size -1

            while (true) {
                val sumIJ = numbers[i] + numbers[j]
                when {
                    sumIJ < target -> i++
                    sumIJ > target -> j--
                    i == j -> throw IllegalArgumentException("No sum")
                    sumIJ == target -> {
                        return intArrayOf(i, j)
                    }
                }
            }
        }

    }

    class ChapterThree //premium... can't access

    class ChapterFour {
        /*
        Lets review properties of a BST:
        Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
        Right subtree of a node N contains nodes whose values are greater than node N's value.
        Both left and right subtrees are also BSTs.

        IMPORTANT: Inorder traversal of a BST gives the nodes in ascending order
         */

        //T(n), S(n)
        fun findTarget(root: TreeNode?, k: Int): Boolean {
            val set : MutableSet<Int> = hashSetOf()

            val stack = Stack<TreeNode>()
            var curr: TreeNode? = root
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr)
                    curr = curr.left
                }
                curr = stack.pop()
                val num = curr.`val`
                val friend = k - num
                if (set.contains(num)) {
                    return true
                } else {
                    set.add(friend)
                }
                curr = curr.right
            }
            return false
        }
    }

}
