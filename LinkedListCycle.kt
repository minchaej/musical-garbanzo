package problems

class LinkedListCycle {

    class ListNode(var `val` : Int) {
        var next: ListNode? = null
    }

    //LinkedListCycle I - Easy
    class ChpaterOne {

        //Floyd's Tortoise And Hare
        fun hasCycle(head: ListNode?): Boolean {
            if (head == null) {
                return false
            }
            var slow = head
            var fast = head.next
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false
                }
                slow = slow?.next
                fast = fast.next?.next
            }
            return true
        }

        //Visit Remnant
        fun hasCycles(head: ListNode?): Boolean {
            var node = head
            while(node != null) {
                if (node.`val` == Integer.MIN_VALUE) {
                    return true
                } else {
                    node.`val` = Integer.MIN_VALUE
                    node = node.next
                }
            }
            return false
        }

        //HashTable
        fun hasCycled(head: ListNode?): Boolean {
            val nodeSet : MutableSet<ListNode> = hashSetOf()

            var node = head
            while(node != null) {
                if (nodeSet.contains(node)) {
                    return true
                } else {
                    nodeSet.add(node)
                    node = node.next
                }
            }
            return false
        }
    }

    //LinkedListCycle II - Medium
    class ChapterTwo {

        fun hasCycle(head: ListNode?): Boolean {
            if (head == null) {
                return false
            }
            var slow = head
            var fast = head.next
            while (slow != fast) {
                //if slow meets end first no loop
                //if fast meets end first loop
                if (fast == null || fast.next == null) {
                    return false
                }
                slow = slow?.next
                fast = fast.next?.next
            }
            return true
        }

        //Visit Remnant
        fun detectCycle(head: ListNode?): ListNode? {
            var node = head
            while(node != null) {
                if (node.`val` == Integer.MIN_VALUE) {
                    return node
                } else {
                    node.`val` = Integer.MIN_VALUE
                    node = node.next
                }
            }
            return null
        }

    }


}