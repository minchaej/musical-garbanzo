package problems.datastructure

class StackUsingLinkedlist {
    // A linked list node
    class Node {
        var data // integer data
                = 0
        var link // reference variable Node type
                : Node? = null
    }

    // create global top reference variable global
    var top: Node? = null

    // Utility function to add an element x in the stack
    fun push(x: Int) // insert at the beginning
    { // create new node temp and allocate memory
        val temp = Node()
        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (temp == null) {
            print("\nHeap Overflow")
            return
        }
        // initialize data into temp data field
        temp.data = x
        // put top reference into temp link
        temp.link = top
        // update top reference
        top = temp
    }

    // Utility function to check if the stack is empty or not
    val isEmpty: Boolean
        get() = top == null

    // Utility function to return top element in a stack
    fun peek(): Int { // check for empty stack
        return if (!isEmpty) {
            top!!.data
        } else {
            println("Stack is empty")
            -1
        }
    }

    // Utility function to pop top element from the stack
    fun pop() // remove at the beginning
    { // check for stack underflow
        if (top == null) {
            print("\nStack Underflow")
            return
        }
        // update the top pointer to point to the next node
        top = top!!.link
    }

    fun display() { // check for stack underflow
        if (top == null) {
            System.out.printf("\nStack Underflow")
            System.exit(1)
        } else {
            var temp = top
            while (temp != null) { // print node data
                System.out.printf("%d->", temp.data)
                // assign temp link to temp
                temp = temp.link
            }
        }
    }

}