package problems

object AddTwoNumbers {
    class ListNode(val `val` : Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbersNewRefactor(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        var isCarry = false
        var sumNodeHead: ListNode? = null
        var sumNodeTrail: ListNode? = null

        while (true) {
            if (node1 != null || node2 != null) {
                val num1 = node1?.`val` ?: 0
                val num2 = node2?.`val` ?: 0
                var sum = num1 + num2
                //carry logic
                if (isCarry) sum++
                if (sum > 9) {
                    isCarry = true
                    sum -= 10
                } else {
                    isCarry = false
                }
                //node initialization only required here becuase node have at lease one number
                if (sumNodeTrail == null) {
                    //initial link
                    sumNodeHead = ListNode(sum)
                    sumNodeTrail = sumNodeHead
                } else {
                    //adding link
                    sumNodeTrail.next = ListNode(sum)
                    sumNodeTrail = sumNodeTrail.next
                }
                //shift node
                node1 = node1?.next
                node2 = node2?.next
            } else {
                //node complete, return answer.
                if (isCarry) sumNodeTrail?.next = ListNode(1)
                return sumNodeHead
            }
        }
    }

    /* Below are previous attemps */

    fun addTwoNumber() {
        val a1 = ListNode(2)
        val a2 = ListNode(4)
        val a3 = ListNode(3)
        a1.next = a2
        a2.next = a3

        val b1 = ListNode(5)
        val b2 = ListNode(6)
        val b3 = ListNode(4)
        b1.next = b2
        b2.next = b3

        var l1 = a1
        var l2 = b1

        var s1 = ""
        var s2 = ""

        println("START")

        while (true) {
            s1 += l1.`val`
            l1.next?.let {
                l1 = it
            } ?: break
        }

        while (true) {
            s2 += l2.`val`

            l2.next?.let {
                l2 = it
            } ?: break
        }

        val reversedInt1 = s1.reversed().toInt()
        val reversedInt2 = s2.reversed().toInt()
        val sumReversedString = (reversedInt1 + reversedInt2).toString().reversed()


        var sumNodeHead: ListNode? = null
        var sumNodeTrail: ListNode? = null

        for ((index, sumChar) in sumReversedString.withIndex()) {
            if (sumNodeTrail == null) {
                //initial link
                sumNodeHead = ListNode(sumChar.toInt())
                sumNodeTrail = sumNodeHead
            } else {
                //adding link
                sumNodeTrail.next = ListNode(sumChar.toInt())
                sumNodeTrail = sumNodeTrail.next

            }
        }

        println(sumNodeHead?.`val`)
        println(sumNodeHead?.next?.`val`)
        println(sumNodeHead?.next?.next?.`val`)
    }

    fun addTwoNumbersJava(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var p = l1
        var q = l2
        var curr: ListNode? = dummyHead

        var carry = 0

        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr?.next = ListNode(sum % 10)
            curr = curr?.next

            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (carry > 0) {
            curr?.next = ListNode(carry)
        }
        return dummyHead.next
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        //Calculate l1
        var digit1 = 0
        var num1 = 0

        while (true) {
            num1 += node1!!.`val` * (Math.pow(10.0, digit1.toDouble())).toInt()
            digit1++
            node1.next?.let {
                node1 = it
            } ?: break
        }

        var digit2 = 0
        var num2 = 0

        //Calculate l2
        while (true) {
            num2 += node2!!.`val` * (Math.pow(10.0, digit2.toDouble())).toInt()
            digit2++
            node2.next?.let {
                node2 = it
            } ?: break
        }

        //Calculate Sum
        var sum = num1 + num2
        var sumNodeHead: ListNode? = null
        var sumNodeTrail: ListNode? = null

        do {
            val pop = sum % 10
            sum /= 10
            if (sumNodeTrail == null) {
                //initial link
                sumNodeHead = ListNode(pop)
                sumNodeTrail = sumNodeHead
            } else {
                //adding link
                sumNodeTrail.next = ListNode(pop)
                sumNodeTrail = sumNodeTrail.next

            }
        } while (sum != 0)

        return sumNodeHead
    }

    /*
    1. compare bit by bit
    2. if addition is greater than 10
    3. add one to next.
     */
    fun addTwoNumbersNew(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        var isCarry = false
        var sumNodeHead: ListNode? = null
        var sumNodeTrail: ListNode? = null

        while (true) {
            when {
                node1 != null && node2 != null -> {
                    //node1 and node2 both exist
                    var sum = node1.`val` + node2.`val`
                    if (isCarry) sum++
                    if (sum > 9) {
                        isCarry = true
                        sum -= 10
                    } else {
                        isCarry = false
                    }

                    //node initialization only required here becuase node have at lease one number
                    if (sumNodeTrail == null) {
                        //initial link
                        sumNodeHead = ListNode(sum)
                        sumNodeTrail = sumNodeHead
                    } else {
                        //adding link
                        sumNodeTrail.next = ListNode(sum)
                        sumNodeTrail = sumNodeTrail.next
                    }

                    node1 = node1.next
                    node2 = node2.next
                }
                node1 != null && node2 == null -> {
                    //node1 and node2 both exist
                    var sum = node1.`val`
                    if (isCarry) sum++
                    if (sum > 9) {
                        isCarry = true
                        sum -= 10
                    } else {
                        isCarry = false
                    }

                    if (sumNodeTrail != null) {
                        sumNodeTrail.next = ListNode(sum)
                        sumNodeTrail = sumNodeTrail.next
                    }

                    node1 = node1.next
                }
                node1 == null && node2 != null -> {
                    //node1 and node2 both exist
                    var sum = node2.`val`
                    if (isCarry) sum++
                    if (sum > 9) {
                        isCarry = true
                        sum -= 10
                    } else {
                        isCarry = false
                    }

                    if (sumNodeTrail != null) {
                        sumNodeTrail.next = ListNode(sum)
                        sumNodeTrail = sumNodeTrail.next
                    }

                    node2 = node2.next
                }
                node1 == null && node2 == null -> {
                    if (isCarry) sumNodeTrail?.next = ListNode(1)
                    return sumNodeHead
                }
            }
        }
    }

}
