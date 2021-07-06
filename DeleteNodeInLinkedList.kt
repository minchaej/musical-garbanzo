package problems

import problems.datastructure.ListNode

class DeleteNodeInLinkedList {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val` ?: -99
        node?.next = node?.next?.next
    }
}