package problems

object TwoSum {

    //two pointer method
    fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size -1

        while (true) {
            val sumIJ = numbers[i] + numbers[j]
            when {
                sumIJ < target -> i++
                sumIJ > target -> j--
                i == j -> throw IllegalArgumentException("No sum")
                sumIJ == target -> {
                    return intArrayOf(i, j)
                }
            }
        }

    }

    //Brute method
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val intArr = IntArray(2)

        for ((i, a) in nums.withIndex()) {
            for ((j, b) in nums.withIndex()) {
                if (i == j) {
                    continue
                }
                if (a + b == target) {
                    intArr[0] = i
                    intArr[1] = j
                    return intArr
                }
            }
        }

        return intArr
    }

    //Hash method
    fun twoSumHash(nums: IntArray, target: Int): IntArray {

        val diffMap : HashMap<Int, Int>  = hashMapOf() //<value, index>

        for ((index, value) in nums.withIndex()) {
            val diff = target - value
            val diffIndex = diffMap[diff]

            diffIndex?.let {
                return intArrayOf(diffIndex, index)
            } ?: run { diffMap[value] = index }
        }

        return intArrayOf(-1, -1)
    }
}
