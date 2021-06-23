package problems

import java.util.*

class MaximumDepthOfBinaryTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    //Breath First Search; Level by level method; Uses Queue
    //https://www.youtube.com/watch?v=hTM3phVI6YQ
    //https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/
    fun maxDepthByBreathFirstSearch(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        var level = 0
        val q: Queue<TreeNode?> = LinkedList()
        q.offer(root)

        while(q.isNotEmpty()) {
            for (i in 0 until q.size){
                val node = q.poll()
                if (node?.left != null) {
                    q.offer(node.left)
                }
                if (node?.right != null) {
                    q.offer(node.right)
                }
            }
            level++
        }

        return level
    }

    //Iterative Depth First Search; Uses Stack
    data class DepthTreeNode (
        val node: TreeNode?,
        val depth: Int
    )
    fun maxDepthIterative(root: TreeNode?): Int {
        val stack = Stack<DepthTreeNode>()
        var max = 0
        stack.push(DepthTreeNode(root, 1))

        while (stack.isNotEmpty()) {
            val depthTreeNode = stack.pop()
            val node = depthTreeNode.node
            val depth = depthTreeNode.depth
            if (node != null) {
                max = Math.max(max, depth)
                stack.push(DepthTreeNode(node.left, depth + 1))
                stack.push(DepthTreeNode(node.right, depth + 1))
            }
        }
        return max
    }

    //Recursive Depth First Search; Single line recursive method; Uses Stack
    fun maxDepthRecursiveSingle(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + Math.max(maxDepthRecursiveSingle(root.left), maxDepthRecursiveSingle(root.right))
    }



    //Recursive Method
    fun maxDepthRecursive(root: TreeNode?): Int {
        return nody(root, 0)
    }

    private fun nody(node: TreeNode?, currentMax: Int): Int {
        if (node == null) {
            return currentMax
        }
        return Math.max(nody(node.left, currentMax + 1), nody(node.right, currentMax + 1))
    }

    fun tester() {
        //[1,99,2,3]
        val root = TreeNode(1)

        root.left = TreeNode(2)
        root.left?.left = TreeNode(3)
        root.left?.left?.left = TreeNode(3)

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

        root3.right = TreeNode(2)
        root3.right?.left = TreeNode(2)
        root3.right?.right = TreeNode(2)

        println(maxDepthRecursive(root3))
        println(maxDepthRecursiveSingle(root3))
        println(maxDepthByBreathFirstSearch(root3))
        println(maxDepthIterative(root3))
    }

}