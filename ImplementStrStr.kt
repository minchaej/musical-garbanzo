package problems

class ImplementStrStr {

    //Apparenlty, Brute is the suggested method
    fun strStrBrute(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        for (i in 0 until haystack.length - needle.length + 1) {
            var isMatching = false
            for (j in 0 until needle.length) {
                if (haystack[j + i] == needle[j]) {
                    isMatching = true
                } else {
                    isMatching = false
                    break
                }
            }
            if (isMatching) {
                return i
            }
        }

        return -1
    }

    //Does not work - tried scanning method and failed to spot needle duplicates.
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        var matchCounter = 0
        var startingIndex = -1



        for (i in 0 until haystack.length) {

            if (matchCounter < needle.length) {
                //not yet found
                if (haystack[i] == needle[matchCounter]) {
                    if (matchCounter == 0) {
                        //initial found
                        startingIndex = i
                    }
                    matchCounter++
                } else {
                    startingIndex = -1
                    matchCounter = 0
                }
            } else {
                //found
            }

        }
        if (matchCounter != needle.length) {
            startingIndex = -1
        }
        return startingIndex
    }
}