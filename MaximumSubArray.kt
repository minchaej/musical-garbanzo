package problems

object MaximumSubArray {

    /**
     When the sum of all numbers until index i inclusive is lower than lower than num[i],
     start a new subarray. (kadane's algorithm)

     testcases:
     [2, 5, -11, 6, 7]
     [2,-1,-1,-1, -1, 500]
     [-1,-1,-1,-1,500,-1,-1,-1]
     [-2,1,-3,4,-1,2,1,-5,-1]
     */
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var all = nums[0]
        var current = all
        var startingIndex = 0 //startingIndex of the Max Sum SubArray
        var endingIndex = 0 //endingIndex of the Max Sum SubArray

        for (i in 1 until nums.size) {
            val num = nums[i]
            current += num
            if (current < num) {
                current = num
                startingIndex = i
            }
            if (all < current) {
                all = current
                endingIndex = i
            }
        }

        return all
    }

    //My Countless Tries...

    //Time exceeded...
    fun bruteforce(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) return nums[0]
        if (size == 0) return 0

        val maxIndex = size - 1
        var loopCount = size - 1
        var maxSum = Integer.MIN_VALUE

        while (loopCount >= 0) {

            var headIndex = 0
            var trailIndex = loopCount

            while (true) {
                var rangeSum = 0
                for (i in headIndex..trailIndex) {
                    rangeSum += nums[i]
                }

                if (rangeSum > maxSum) {
                    maxSum = rangeSum
                }

                if (trailIndex == maxIndex) {
                    break
                } else {
                    headIndex++
                    trailIndex++
                }
            }
            loopCount--
        }

        return maxSum
    }

    fun maxSubArrayWrong(nums: IntArray): Int {
        val size = nums.size
        if (size < 2) return 0
        var pointerHead = 0
        var pointerTrail = size - 1
        var currentMax = 0

        loop@ while (true) {

            val headNum = nums[pointerHead]
            val trailNum = nums[pointerTrail]

            if (pointerHead == pointerTrail) {
                if (nums[pointerHead] > currentMax) {
                    currentMax = nums[pointerHead]
                }
                break
            }

            when {
                headNum < 1 && trailNum < 1 -> {
                    pointerHead++
                    pointerTrail--
                    continue@loop
                }
                headNum < 1 -> {
                    pointerHead++
                    continue@loop
                }
                trailNum < 1 -> {
                    pointerTrail--
                    continue@loop
                }
            }

            var rangeSum = 0

            for (i in pointerHead..pointerTrail) {
                rangeSum += nums[i]
            }

            val nextPointerHead = pointerHead + 1
            val nextPointerTrail = pointerTrail - 1

            if (headNum > trailNum) {
                pointerTrail--
            } else {
                pointerHead++
            }

            if (rangeSum > currentMax) {
                currentMax = rangeSum
            }

        }


        return currentMax
    }
    /*
    how its going to divide
    1. oscilationg no
    2. half and half no
     */
    fun maxSubArrayOld(nums: IntArray): Int {
        val size = nums.size
        if (size < 2) return 0

        var pointerHead = 0
        var pointerTrail = size - 1
        var currentMax = Integer.MIN_VALUE
        val mid = size / 2

        var isHead = true


        while (true) {
            var rangeSum = 0

            if (pointerHead == pointerTrail) {
                if (nums[pointerHead] > currentMax) {
                    currentMax = nums[pointerHead]
                }
                break
            }

            for (i in pointerHead..pointerTrail) {
                rangeSum += nums[i]
            }

            if (rangeSum > currentMax) {
                currentMax = rangeSum
            }

            if (isHead) {
                pointerHead++

            } else {
                pointerTrail--

            }
            isHead = !isHead

            /*
            if (pointerHead < mid) {
                pointerHead++
            } else {
                pointerTrail--
            }
            */
        }

        //It will never be minvalue as nums array will have at least one member.
        return currentMax
    }

    fun findMaxTwoNumbers(nums: IntArray): Int {
        var firstNum = nums[0]
        if (nums.size == 1) return firstNum
        var secondNum = nums[1]

        for (i in 2 until nums.size) {
            val num = nums[i]
            when {
                num > firstNum -> {
                    firstNum = num
                }
                num < firstNum && num > secondNum -> {
                    secondNum = num
                }
            }
        }

        return firstNum + secondNum
    }
}