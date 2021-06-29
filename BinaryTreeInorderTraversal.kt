package problems

import java.util.*


class BinaryTreeInorderTraversal {

    companion object {
        var counter = 0
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun tester() {
        //[1,99,2,3]
        val root = TreeNode(1)
        root.left = TreeNode(99)
        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)


        //1,2,2,3,4,4,3
        val root2 = TreeNode(1)

        root2.left = TreeNode(2)
        root2.left?.left = TreeNode(3)
        root2.left?.right = TreeNode(4)

        root2.right = TreeNode(2)
        root2.right?.left = TreeNode(4)
        root2.right?.right = TreeNode(3)

        println(inorderTraversalIterative(root2))
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val arrayList = ArrayList<Int>()
        nody(root, arrayList)
        return arrayList
    }

    private fun nody(node: TreeNode?, arrayList: ArrayList<Int>) {
        node?.left?.let { nody(it, arrayList) }
        println(node?.`val`)
        node?.`val`?.let { arrayList.add(it) }
        node?.right?.let { nody(it, arrayList) }
    }

    //https://stackoverflow.com/questions/159590/way-to-go-from-recursion-to-iteration
    fun inorderTraversalIterative(root: TreeNode): List<Int>? {
        val res: MutableList<Int> = ArrayList()
        val stack = Stack<TreeNode>()
        var curr: TreeNode? = root
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            res.add(curr.`val`)
            curr = curr.right
        }
        return res
    }

    //https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
    fun inorderTraversalMorrisTraversal(root: TreeNode?): List<Int>? {
        val res: MutableList<Int> = ArrayList()
        var curr = root
        var pre: TreeNode?
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.`val`)
                curr = curr.right // move to next right node
            } else { // has a left subtree
                pre = curr.left
                while (pre!!.right != null) { // find rightmost
                    pre = pre.right
                }
                pre.right = curr // put cur after the pre node
                val temp: TreeNode = curr // store cur node
                curr = curr.left // move cur to the top of the new tree
                temp.left = null // original cur left be null, avoid infinite loops
            }
        }
        return res
    }

}