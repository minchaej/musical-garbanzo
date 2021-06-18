package problems

object MergeTwoSortedLists {

    class ListNode(val `val` : Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1: ListNode? = l1
        var node2: ListNode? = l2

        var mergedNodeHead: ListNode? = null
        var mergedNodeTrail: ListNode? = null

        loop@ while (true) {
            val num1 = node1?.`val`
            val num2 = node2?.`val`

            val toAdd = when {
                num1 != null && num2 == null -> {
                    node1 = node1?.next
                    num1
                }
                num1 == null && num2 != null -> {
                    node2 = node2?.next
                    num2
                }
                num1 != null && num2 != null -> {
                    if (num1 <= num2) {
                        node1 = node1?.next
                        num1
                    } else {
                        node2 = node2?.next
                        num2
                    }
                }
                else -> {
                    //num1 == null && num2 == null
                    break@loop
                }
            }

            if (mergedNodeHead == null) {
                mergedNodeHead = ListNode(toAdd)
                mergedNodeTrail = mergedNodeHead
            } else {
                mergedNodeTrail?.next = ListNode(toAdd)
                mergedNodeTrail = mergedNodeTrail?.next
            }

        }

        return mergedNodeHead
    }

}