package problems.datastructure

class Trie {
    companion object {
        private const val ALPHABET_SIZE = 26
    }
    //Used Array because cannot set value with List
    val root = TrieNode()

    class TrieNode() {
        val treeList = Array<TrieNode?>(ALPHABET_SIZE){ null }
        var isEndNode = false
    }

    fun insert(str: String) {
        var node = root
        for (i in 0 until  str.length) {
            //'a' - 'a' == 0
            //duplicated node initialization
            val index = str[i] - 'a'
            val newNode = TrieNode()
            node.treeList[index] = newNode
            node = newNode
        }
        // mark last node as leaf
        node.isEndNode = true
    }

    fun search(str: String): Boolean {
        var node = root
        for (i in 0 until  str.length) {
            val index = str[i] - 'a'
            node.treeList[index]?.let {
                node = it
            } ?: return false
        }
        return true
    }

}