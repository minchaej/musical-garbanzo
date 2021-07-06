package problems

import problems.datastructure.ListNode

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {

        var headNode = head

        while (head?.next != null) {
            val a = head
            val b = head.next
            val c = head.next?.next

            b?.next = headNode
            a.next = c

            headNode = b
        }

        return headNode
    }
}