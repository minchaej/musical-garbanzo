package problems

import java.util.*


class SymmetricTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    //By Queue; inspired by Breadth First Search (aka Command and Conquer), Most Optimal in terms of memory.
    fun isSymmetricQueue(root: TreeNode?): Boolean {
        val q: Queue<TreeNode?> = LinkedList()
        q.poll()
        q.add(root)
        q.add(root)
        while (!q.isEmpty()) {
            val t1 = q.poll()
            val t2 = q.poll()
            if (t1 == null && t2 == null) continue
            if (t1 == null || t2 == null) return false
            if (t1.`val` != t2.`val`) return false
            q.add(t1.left)
            q.add(t2.right)
            q.add(t1.right)
            q.add(t2.left)
            q.forEach { print("${it?.`val`}, " ) }
            println("")
        }
        return true
    }

    //By recursive
    //For first call, pass in same root node.
    fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1 == null || t2 == null) return false

        return t1.`val` == t2.`val` && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right)
    }

    //Stack
    fun isSymmetricStack(root: TreeNode?): Boolean {
        val stackLeft = Stack<TreeNode>()
        val stackRight = Stack<TreeNode>()

        var currLeft: TreeNode? = root?.left
        var currRight: TreeNode? = root?.right

        while (currLeft != null || !stackLeft.isEmpty() || currRight != null || !stackRight.isEmpty()) {
            while (currLeft != null || currRight != null) {
                if (currLeft?.`val` != currRight?.`val`) return false
                stackLeft.push(currLeft)
                stackRight.push(currRight)
                currLeft = currLeft?.left
                currRight = currRight?.right
            }
            currLeft = stackLeft.pop()
            currRight = stackRight.pop()
            if (currLeft?.`val` != currRight?.`val`) return false
            currLeft = currLeft?.right
            currRight = currRight?.left
        }
        return true
    }

    fun tester() {
        //[1,99,2,3]
        val root = TreeNode(1)

        root.left = TreeNode(2)
        root.left?.right = TreeNode(3)

        root.right = TreeNode(2)
        root.right?.right = TreeNode(3)

        //1,2,2,3,4,4,3
        val root2 = TreeNode(1)

        root2.left = TreeNode(2)
        root2.left?.left = TreeNode(3)
        root2.left?.right = TreeNode(4)

        root2.right = TreeNode(2)
        root2.right?.left = TreeNode(4)
        root2.right?.right = TreeNode(3)

        val root3 = TreeNode(1)
        root3.left = TreeNode(2)
        root3.left?.left = TreeNode(31)
        root3.left?.right = TreeNode(32)

        root3.right = TreeNode(2)
        root3.right?.left = TreeNode(33)
        root3.right?.right = TreeNode(34)

        println(isSymmetricQueue(root3))
    }

}