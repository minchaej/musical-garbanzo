package problems

import java.util.*

class RemoveAllAdjacentDuplicatesInString {

    //Using String Builder
    //Stack is slow....
    fun removeDuplicates(s: String): String {
        val sb = StringBuilder()
        sb.append(s[0])

        for (i in 1 until s.length) {
            val curr = s[i]
            if (sb.isNotEmpty() && sb.get(sb.length - 1) == curr) {
                sb.deleteCharAt(sb.length - 1)
            } else {
                sb.append(curr)
            }
        }

        return sb.toString()
    }



        //Using Stack
    fun removeDuplicatesStack(s: String): String {
        val stack = Stack<Char>()
        stack.push(s[0])

        for (i in 1 until s.length) {
            val curr = s[i]
            if (stack.isNotEmpty() && stack.peek() == curr) {
                stack.pop()
            } else {
                stack.push(curr)
            }
        }
        return String(stack.toCharArray())
    }
}