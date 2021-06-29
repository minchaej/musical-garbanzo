package problems

class MinStack {

    //1 compute in push and pop, soryting. logn for every transaction. BAD
    //2. compute in getMin, do not lazy, see if unchanged... BAD
    //3. Instantiate one more Stack and save the min.

    class ListNode(var `val` : Int) {
        var next: ListNode? = null
    }

    private var minTop: ListNode? = null
    var top: ListNode? = null

    fun push(`val`: Int) {
        val node = ListNode(`val`)
        node.next = top
        top = node

        if (minTop == null) {
            //initialize
            val minNode = ListNode(`val`)
            minNode.next = minTop
            minTop = minNode
        } else {
            val minnie = Math.min(`val`, minTop!!.`val`)
            val minNode = ListNode(minnie)
            minNode.next = minTop
            minTop = minNode
        }
    }

    val isEmpty: Boolean
        get() = top == null

    //return null if empty
    fun peek(): Int? {
        if (isEmpty) {
            return null
        } else {
            return top?.`val`
        }
    }

    fun pop() {
        if (isEmpty) {
            //cannot pop
        } else {
            top = top?.next
//            min = Math.min(top!!.`val`, min)
            minTop = minTop?.next
        }
    }

    fun top(): Int {
        return top!!.`val`
    }

    fun getMin(): Int {
        return minTop!!.`val`
    }

}


