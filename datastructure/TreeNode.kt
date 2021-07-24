package problems.datastructure

import java.util.*

class TreeNode(var `val`: Int) {
    companion object {
        fun getOneToSevenTree(): TreeNode {
            val root = TreeNode(1)

            root.left = TreeNode(2)
            root.right = TreeNode(3)

            root.left?.left = TreeNode(4)
            root.left?.right = TreeNode(5)

            root.right?.left = TreeNode(6)
            root.right?.right = TreeNode(7)

            return root
        }
    }

    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Depth First Traversals: 1 2 3 4 5
    (a) Inorder (Left, Root, Right) : 4 2 5 1 3
    (b) Preorder (Root, Left, Right) : 1 2 4 5 3
    (c) Postorder (Left, Right, Root) : 4 5 2 3 1
    (d) Breadth First or Level Order Traversal : 1 2 3 4 5
    Please see this post for Breadth First Traversal.

    Lets review properties of a BST:

    Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
    Right subtree of a node N contains nodes whose values are greater than node N's value.
    Both left and right subtrees are also BSTs.
 */

fun TreeNode?.inOrderPrint() {
    this?.left?.inOrderPrint()
    this?.`val`?.let { print("${it} ") }
    this?.right?.inOrderPrint()
}

fun TreeNode?.preOrderPrint() {
    this?.`val`?.let { print("${it} ") }
    this?.left?.preOrderPrint()
    this?.right?.preOrderPrint()
}

fun TreeNode?.postOrderPrint() {
    this?.left?.postOrderPrint()
    this?.right?.postOrderPrint()
    this?.`val`?.let { print("${it} ") }
}

//Breadth First or Level Order Traversal
fun TreeNode?.levelOrderPrint() {
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(this)
    while (!queue.isEmpty()) {
        val tempNode: TreeNode = queue.poll()
        print("${tempNode.`val`} ")
        if (tempNode.left != null) {
            queue.add(tempNode.left)
        }
        if (tempNode.right != null) {
            queue.add(tempNode.right)
        }
    }
}

