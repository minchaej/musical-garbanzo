package problems

import java.util.ArrayList

//todo: HARD - revisit after mastering backtracking with DP.
class WordLadderIII {

    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {

        val totalSubsequence: MutableSet<List<String>> = hashSetOf()
        b(arrayListOf(beginWord), endWord, wordList, totalSubsequence)

        val filteredSubsequence: MutableSet<List<String>> = hashSetOf()
        var min = Integer.MAX_VALUE
        totalSubsequence.forEach {
            if (it.size < min) {
                filteredSubsequence.clear()
                min = it.size
            }
            if (it.size == min) {
                filteredSubsequence.add(it)
            }
        }

        return filteredSubsequence.toList()
    }

    fun b(addedList: ArrayList<String>, endWord: String, availWordList: List<String>, set: MutableSet<List<String>>) {
        if (availWordList.size == 0) {
            if (addedList[addedList.size - 1] == endWord) {
//                println(addedList)
                set.add(ArrayList(addedList))
            }
            return
        }

        for (i in 0 until availWordList.size) {
            val word = availWordList[i]
            if (legalityChecker(addedList[addedList.size - 1], word)) {
                addedList.add(word)
                val removed = ArrayList(availWordList)
                removed.remove(word)
                b(addedList, endWord, removed, set)
                addedList.removeAt(addedList.size - 1)
            }

            val removed = ArrayList(availWordList)
            removed.remove(word)
            b(addedList, endWord, removed, set)
        }
    }

    private fun legalityChecker(a: String, b: String): Boolean {
        //a and b length same
        var onlyOneDiffAllowedFlag = true

        for (i in 0 until a.length) {
            if (a[i] == b[i]) {
                //pass
            } else {
                if (onlyOneDiffAllowedFlag) {
                    onlyOneDiffAllowedFlag = false
                } else {
                    return false
                }
            }
        }

        return true
    }

    private fun legalityCheckerOld(a: String, b: String): Boolean {
        //multi and addi?
        if (a == b) {
            return false
        }

        val aCount = IntArray(26) { 0 }
        for (i in 0 until a.length) {
            aCount[a[i] - 'a'] = aCount[a[i] - 'a'] + 1
        }

        val bCount = IntArray(26) { 0 }
        for (i in 0 until b.length) {
            bCount[b[i] - 'a'] = bCount[b[i] - 'a'] + 1
        }

        var onlyOneDiffAllowedFlag = 0
        for (i in 0 until aCount.size) {
            if (aCount[i] != bCount[i]) {
                if (onlyOneDiffAllowedFlag < 2) {
                    onlyOneDiffAllowedFlag++
                } else {
                    return false
                }
            }
        }

        return true
    }

    fun tc() {
//        println(findLadders("hit", "cog", arrayListOf("hot","dot","dog","lot","log","cog")))
//        println(findLadders("a", "c", arrayListOf("a", "b", "c")))
//        println(findLadders("lost", "cost", arrayListOf("most","fist","lost","cost","fish")))
        println(findLadders("teach", "place", arrayListOf("peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach")))
//        println(legalityChecker("lest", "lose"))

//        val totalSubsequence: MutableSet<List<String>> = hashSetOf()
////        b(arrayListOf("hit"), "cog", arrayListOf("hot","dot","dog","lot","log","cog"), totalSubsequence)
//        b(arrayListOf("hot"), "dog", arrayListOf("hot","dog","dot"), totalSubsequence)
////        println(totalSubsequence)
//
//        val filteredSubsequence: MutableSet<List<String>> = hashSetOf()
//        var min = Integer.MAX_VALUE
//        totalSubsequence.forEach {
//            if (it.size < min) {
//                filteredSubsequence.clear()
//                min = it.size
//            }
//            if (it.size == min) {
//                filteredSubsequence.add(it)
//            }
//        }
//        println(filteredSubsequence)
    }

}

class WordLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        return magicSubsequence(beginWord, endWord, wordList)
    }

    fun magicSubsequence(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val length = wordList.size
        val end = 1 shl length

        val newWordList = ArrayList<String>()

        var hasEndWord = false
        for (i in 0 until length) {
            val word = wordList[i]
            if (word == endWord) {
                newWordList.add(wordList[length - 1])
                hasEndWord = true
            } else if (i == length - 1 && hasEndWord) {
                newWordList.add(endWord)
            } else {
                newWordList.add(word)
            }
        }

        println(newWordList)


        val allSubSequence: MutableSet<List<String>> = hashSetOf()
        val subsequence = ArrayList<String>()
        val reserveWord: MutableSet<String> = hashSetOf()

        for (mark in 0 until end) {
            subsequence.add(beginWord)
            for (i in 0 until length) {
                if ((1 shl i and mark) != 0) {
                    //print(arr[i])
                    val word = newWordList[i]
                    if (legalityChecker(word, subsequence[subsequence.size - 1])) {
                        subsequence.add(word)
                    } else {
                        var toRemove: String? = null
                        reserveWord.forEach {
                            if (legalityChecker(word, subsequence[subsequence.size - 1])) {
                                subsequence.add(it)
                                toRemove = it
                                return@forEach
                            }
                        }
                        toRemove?.let { reserveWord.remove(it) }
                        reserveWord.add(word)
                    }
                }
            }
            if (subsequence.size > 1) {
                allSubSequence.add(ArrayList(subsequence))
            }
            subsequence.clear()
            reserveWord.clear()
        }
//        println(allSubSequence)

        val filteredSubsequence: MutableSet<List<String>> = hashSetOf()
        var min = Integer.MAX_VALUE
        allSubSequence.forEach {
            val lastWord = it[it.size - 1]
            if (lastWord == endWord) {
                if (it.size < min) {
                    filteredSubsequence.clear()
                    min = it.size
                }
                if (it.size == min) {
                    filteredSubsequence.add(it)
                }
            }
        }
        println(filteredSubsequence)

        return filteredSubsequence.toList()
    }

    private fun legalityChecker(a: String, b: String): Boolean {
        //multi and addi?

        val aCount = IntArray(26) { 0 }
        for (i in 0 until a.length) {
            aCount[a[i] - 'a'] = aCount[a[i] - 'a'] + 1
        }

        val bCount = IntArray(26) { 0 }
        for (i in 0 until b.length) {
            bCount[b[i] - 'a'] = bCount[b[i] - 'a'] + 1
        }

        var onlyOneDiffAllowedFlag = 0
        for (i in 0 until aCount.size) {
            if (aCount[i] != bCount[i]) {
                if (onlyOneDiffAllowedFlag < 2) {
                    onlyOneDiffAllowedFlag++
                } else {
                    return false
                }
            }
        }

        return true
    }

    fun tc1() {
//        magicSubsequence("hit", "cog", listOf("hot","dot","dog","lot","log","cog"))
//        magicSubsequence("hot", "dog", listOf("hot","dog","dot"))
        magicSubsequence("hit", "cog", listOf("hot","cog","dot","dog","hit","lot","log"))



    }

}