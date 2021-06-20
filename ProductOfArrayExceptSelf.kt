package problems

object ProductOfArrayExceptSelf {
    fun productExceptSelfWithSmallSpace(nums: IntArray): IntArray {
        val outputArray = IntArray(nums.size)

        outputArray[0] = 1
        for (i in 1 until nums.size) {
            outputArray[i] =  outputArray [i - 1] * nums[i - 1]
        }

        var productSoFar = 1
        for (i in nums.size - 1 downTo 0) {
            outputArray[i] = outputArray[i] * productSoFar
            productSoFar *= nums[i]
        }

        return outputArray
    }


    fun productExceptSelfOriginal(nums: IntArray): IntArray {
        val outputArray = IntArray(nums.size)
        val leftArray = IntArray(nums.size)
        val rightArray = IntArray(nums.size)

        leftArray[0] = 1
        for (i in 1 until nums.size) {
            leftArray[i] = nums[i - 1] * leftArray [i - 1]
        }

        rightArray[nums.size - 1] = 1
        for (i in nums.size - 2 downTo 0) {
            rightArray[i] = nums[i + 1] * rightArray[i + 1]
        }

        for (i in 0 until nums.size) {
            outputArray[i] = leftArray[i] * rightArray[i]
        }

        return outputArray
    }
}