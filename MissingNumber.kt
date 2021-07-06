package problems

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        var indexSum = 0
        var numSum = 0

        for (i in 0 until nums.size) {
            val num = nums[i]
            numSum += num
            indexSum += i
        }
        indexSum += nums.size

        if (indexSum == numSum) {
            return 0
        } else {
            return indexSum - numSum
        }
    }
}