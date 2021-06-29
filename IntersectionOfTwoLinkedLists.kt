package problems

import problems.datastructure.ListNode

class IntersectionOfTwoLinkedLists {

    fun getIntersectionNodeSimplified(headA: ListNode?, headB: ListNode?): ListNode? {
        var pA = headA
        var pB = headB
        while (pA !== pB) {
            pA = if (pA == null) headB else pA.next
            pB = if (pB == null) headA else pB.next
        }
        return pA
    }

    //Two Pointer Solution - First Try - Time O(n) & Space O(n)
    fun getIntersectionNodeRaw(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var aLength = 0
        var aTemp = headA
        while (aTemp != null) {
            aLength++
            aTemp = aTemp.next
        }

        var bLength = 0
        var bTemp = headB
        while (bTemp != null) {
            bLength++
            bTemp = bTemp.next
        }

        val z = aLength - bLength

        if (z > 0) {
            //A is longer
            var aLoopTemp = headA
            var bLoopTemp = headB
            for (i in 0 until z) {
                aLoopTemp = aLoopTemp?.next
            }
            while (aLoopTemp != null && bLoopTemp != null) {
                if (aLoopTemp == bLoopTemp) {
                    return aLoopTemp
                }
                aLoopTemp = aLoopTemp.next
                bLoopTemp = bLoopTemp.next
            }
            return null
        } else {
            //B is longer
            var aLoopTemp = headA
            var bLoopTemp = headB
            for (i in 0 until -z) {
                bLoopTemp = bLoopTemp?.next
            }
            while (aLoopTemp != null && bLoopTemp != null) {
                if (aLoopTemp == bLoopTemp) {
                    return aLoopTemp
                }
                aLoopTemp = aLoopTemp.next
                bLoopTemp = bLoopTemp.next
            }
            return null
        }
    }
}