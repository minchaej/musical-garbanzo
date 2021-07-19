package problems

import problems.datastructure.TreeNode
import java.util.*


/**
 * Depth First Traversals:
    (a) Inorder (Left, Root, Right) : 4 2 5 1 3
    (b) Preorder (Root, Left, Right) : 1 2 4 5 3
    (c) Postorder (Left, Right, Root) : 4 5 2 3 1
    Breadth First or Level Order Traversal : 1 2 3 4 5
    Please see this post for Breadth First Traversal.

    Lets review properties of a BST:

    Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
    Right subtree of a node N contains nodes whose values are greater than node N's value.
    Both left and right subtrees are also BSTs.
 */
class LowestCommonAncestorOfBinarySearchTree {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        /*
        case 1 : p and q both root; root is ancestor
        case 2 : p and q both less than root; traverse left
        case 3: p and q both greater than root; traverse right
        case 4: either p or q is curr; ancestor found
         */

        val pVal = p?.`val` ?: 0
        val qVal = q?.`val` ?: 0
        val rootVal = root?.`val` ?: 0

        if ((rootVal > pVal && rootVal < qVal) || (rootVal < pVal && rootVal > qVal)) {
            return root
        }

        var curr: TreeNode? = root
        while (true) {
            val currVal = curr?.`val` ?: 0

            when {
                currVal < pVal && currVal < qVal -> {
                    //traverse right
                    curr = curr?.right
                }
                currVal > pVal && currVal > qVal -> {
                    //traverse left
                    curr = curr?.left
                }
                curr == p || curr == q -> {
                    //lowest common ancestor found
                    println(currVal)
                    return curr
                }
                (currVal > pVal && currVal < qVal) || (currVal < pVal && currVal > qVal) -> {
                    //lowest common ancestor found
                    println(currVal)
                    return curr
                }
            }
        }
    }

}
