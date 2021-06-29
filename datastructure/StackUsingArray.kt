package problems.datastructure

class StackUsingArray(size: Int) {
    private val arr: IntArray = IntArray(size)
    private var top: Int
    private val capacity: Int

    // Constructor to initialize the stack
    init {
        capacity = size
        top = -1
    }

    // Utility function to add an element `x` to the stack
    fun push(x: Int) {
        if (isFull) {
            println("Overflow\nProgram Terminated\n")
            System.exit(1)
        }
        println("Inserting $x")
        arr[++top] = x
    }

    // Utility function to pop a top element from the stack
    fun pop(): Int { // check for stack underflow
        if (isEmpty) {
            println("Underflow\nProgram Terminated")
            System.exit(1)
        }
        println("Removing " + peek())
        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--]
    }

    // Utility function to return the top element of the stack
    fun peek(): Int {
        if (!isEmpty) {
            return arr[top]
        } else {
            System.exit(1)
        }
        return -1
    }

    // Utility function to return the size of the stack
    fun size(): Int {
        return top + 1
    }// or return size() == 0;

    // Utility function to check if the stack is empty or not
    val isEmpty: Boolean
        get() = top == -1 // or return size() == 0;
    // or return size() == capacity;

    // Utility function to check if the stack is full or not
    val isFull: Boolean
        get() = top == capacity - 1 // or return size() == capacity;


}
