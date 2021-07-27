package problems

import problems.datastructure.TreeNode

class ConvertSortedArrayToBinarySearchTree {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.size == 1) {
            return TreeNode(nums[0])
        }
        if (nums.size == 0) {
            return null
        }

        val centerIndex = nums.size / 2
        val root = TreeNode(nums[centerIndex])
        root.left = sortedArrayToBST(nums.sliceArray(0 .. centerIndex - 1))
        root.right = sortedArrayToBST(nums.sliceArray(centerIndex + 1 .. nums.size - 1))
        return root
    }

    //Slice is too slow
    fun sortedArrayToBSTNoSlice(nums: IntArray): TreeNode? {
        val centerIndex = nums.size / 2
        val root = TreeNode(nums[centerIndex])
        root.left = getNode(nums, 0, centerIndex - 1)
        root.right = getNode(nums, centerIndex + 1, nums.size - 1)
        return root
    }

    private fun getNode(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
        if (endIndex - startIndex == 0) {
            return TreeNode(nums[endIndex])
        }
        if (endIndex - startIndex < 0) {
            return null
        }

        val centerIndex = ((endIndex - startIndex + 1) / 2) + startIndex
        val root = TreeNode(nums[centerIndex])
        root.left = getNode(nums, startIndex, centerIndex - 1)
        root.right = getNode(nums, centerIndex + 1, endIndex)
        return root
    }

}