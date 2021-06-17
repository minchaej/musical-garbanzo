package problems

import java.util.*
import kotlin.collections.HashMap

object ValidParentheses {
    fun isValid(s: String): Boolean {
        val inputSize = s.length
        if ((inputSize % 2) == 1) return false //Has to be even to be true

        val parenthesesKey = HashMap<Char, Char>()
        parenthesesKey.put(')', '(')
        parenthesesKey.put('}', '{')
        parenthesesKey.put(']', '[')

        val stack = Stack<Char>()

        for (i in 0 until inputSize) {
            val char = s[i]
            if (parenthesesKey.containsKey(char)) {
                //is a closing
                val opening = parenthesesKey[char] //retrieve opening
                if (stack.isNotEmpty() && stack.peek() == opening) {
                    stack.pop()
                } else {
                    //means nothing is infront of the closing bracket
                    //Or what is infront of the closing bracket does not match itself
                    return false
                }
            } else {
                //is a opening
                stack.push(char)
            }
        }

        return stack.size == 0
    }

}