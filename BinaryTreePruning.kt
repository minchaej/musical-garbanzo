package problems

import problems.datastructure.*


class BinaryTreePruning {

    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)

        if (root.`val` == 0 && root.left == null && root.right == null) {
            return null
        }

        return root
    }

    fun pruneTreeMySolution(root: TreeNode?): TreeNode? {
        nodys(root)
        if (root?.`val` == -99) {
            return null
        } else {
            return root
        }
    }

    private fun nodys(node: TreeNode?) {
        node?.left?.let { nodys(it) }
        node?.right?.let { nodys(it) }

        if (node?.left?.`val` == -99) {
            node.left = null
        }
        if (node?.right?.`val` == -99) {
            node.right = null
        }
        if (node?.`val` == 0 && node.left == null && node.right == null) {
            node.`val` = -99
        }
    }

    //region tc
    fun tc1() {
        val root = TreeNode(1)

        root.right = TreeNode(1)

        root.right?.left = TreeNode(0)
        root.right?.right = TreeNode(1)

        root.right?.left?.left = TreeNode(0)
        root.right?.left?.right = TreeNode(0)

        root.right?.left?.left?.left = TreeNode(1)


        root.levelOrderPrint()
        println()
        pruneTree(root).levelOrderPrint()
        println()
    }

    fun tc2() {
        val root = TreeNode(1)

        root.left = TreeNode(0)

        root.left?.left = TreeNode(0)
        root.left?.right = TreeNode(0)

        root.right = TreeNode(1)

        root.right?.left = TreeNode(0)
        root.right?.right = TreeNode(1)

        root.postOrderPrint()
        println()
        pruneTree(root).levelOrderPrint()
        println()
    }

    fun tc3() {
        val root = TreeNode(1)

        root.right = TreeNode(2)

        root.right?.left = TreeNode(3)
        root.right?.right = TreeNode(4)

        root.postOrderPrint()
        println()
        pruneTree(root).levelOrderPrint()
        println()
    }
    //endregion

}