package problems

import problems.datastructure.ListNode
import problems.datastructure.TreeNode

class ConvertSortedListToBinarySearchTree {

    /**
     * my tortoise and ohare inspired solution...
     */
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            return TreeNode(head.`val`)
        }
        return carryme(head, null, false)
    }

    fun carryme(startNode: ListNode?, endNode: ListNode?, isRight: Boolean): TreeNode? {
        if (startNode == null || startNode == endNode) {
            return null
        }

        var tortoise = startNode
        var ohare = startNode
        while(ohare != endNode && ohare?.next != endNode) {
            tortoise = tortoise?.next
            ohare = ohare?.next?.next
        }

        val root = TreeNode(tortoise?.`val` ?: -99)
        root.left = carryme(startNode, tortoise, false)
        root.right = carryme(tortoise?.next, endNode, true)
        return root
    }

}