package problems

import java.util.HashMap

class MapSumTrie {
    companion object {
        private const val ALPHABET_SIZE = 26
    }

    class TrieNode(var count: Int) {
        val treeList = Array<TrieNode?>(ALPHABET_SIZE){ null }
    }

    //Used Array because cannot set value with List
    private val root = TrieNode(0)
    private val keyMap = HashMap<String, Int>()

    fun insert(key: String, value: Int) {

        var node = root
        if (keyMap.contains(key)) {
            for (i in 0 until  key.length) {
                //duplicated node initialization
                val index = key[i] - 'a'
                node.treeList[index]?.let {
                    if (it.count != 0) {
                        it.count = it.count - (keyMap[key] ?: 0) + value
                    }
                    node = it
                }
            }
        } else {
            for (i in 0 until  key.length) {
                //duplicated node initialization
                val index = key[i] - 'a'
                node.treeList[index]?.let {
                    if (it.count != 0) {
                        it.count += value
                    }
                    node = it
                } ?: run {
                    val newNode = TrieNode(0)
                    node.treeList[index] = newNode
                    node = newNode
                }
            }
        }
        keyMap[key] = value
        node.count = value
    }

    fun search(str: String): Int {
        var node = root
        var count = 0
        for (i in 0 until  str.length) {
            val index = str[i] - 'a'
            node.treeList[index]?.let {
                count += it.count
                node = it
            } ?: return 0
        }

        return count
    }
}

class MapSum {
    private val prefixMap = HashMap<String, Int>()
    private val keyMap = HashMap<String, Int>()

    fun insert(key: String, value: Int) {
        val sb = StringBuilder()

        if (keyMap.contains(key)) {
            //- and +
            for (i in 0 until key.length) {
                sb.append(key[i])
                if (prefixMap.containsKey(sb.toString())) {
                    prefixMap[sb.toString()] = (prefixMap[sb.toString()] ?: 0) - (keyMap[key] ?: 0) + value
                } else {
                    prefixMap[sb.toString()] = value
                }
            }
        } else {
            //only +
            for (i in 0 until key.length) {
                sb.append(key[i])
                if (prefixMap.containsKey(sb.toString())) {
                    prefixMap[sb.toString()] = (prefixMap[sb.toString()] ?: 0) + value
                } else {
                    prefixMap[sb.toString()] = value
                }
            }
        }
        keyMap[key] = value
    }

    fun sum(prefix: String): Int {
        return prefixMap[prefix] ?: 0
    }
}