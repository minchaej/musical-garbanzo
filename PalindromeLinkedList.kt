package problems

import problems.datastructure.ListNode
import java.lang.StringBuilder

class PalindromeLinkedList {
    //

    /**
     * Could you do it in O(n) time and O(1) space? <-- No Stack
     *
     * Space O(1) - Must Reverse; Cannot Convert it to Int and compare;
     * Space O(n) - Stack
     *
     * Int is faster than String.
     * But Int wont work because "The number of nodes in the list is in the range [1, 105]"
     *
     * So... by the time **fast** reaches zero, **slow** will be at half.
     */
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        var prev: ListNode? = null
        while (slow != null) {
            val temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        }

        var left = head
        var right = prev

        while (right != null) {
            if (left?.`val` != right.`val`) {
                return false
            }
            left = left.next
            right = right.next
        }

        return true
    }
}