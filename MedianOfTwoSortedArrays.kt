package problems

import kotlin.math.max
import kotlin.math.min


class MedianOfTwoSortedArrays {

    //Recursive solution
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return if (nums2.size < nums1.size) {
            findMedianSortedArrays(nums2, nums1)
        } else {
            println("P: ${0} to ${nums1.size}")
            recursive(nums1, nums2, 0, nums1.size)
        }
    }

    private fun recursive(x: IntArray, y: IntArray, start: Int, end: Int): Double {
        var partitionX = 0
        var partitionY = 0
        partitionX = (start + end) / 2
        partitionY = ((x.size + y.size + 1) / 2 - partitionX)
        val maxLeftX = if (partitionX == 0) Int.MIN_VALUE else x.get(partitionX - 1)
        val maxLeftY = if (partitionY == 0) Int.MIN_VALUE else y.get(partitionY - 1)
        val minRightX = if (partitionX == x.size) Int.MAX_VALUE else x.get(partitionX)
        val minRightY = if (partitionY == y.size) Int.MAX_VALUE else y.get(partitionY)

        return if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((x.size + y.size) % 2 == 0) {
                (Math.max(maxLeftX, maxLeftY) + Math.min(
                    minRightX,
                    minRightY
                )).toDouble() / 2
            } else {
                Math.max(maxLeftX, maxLeftY).toDouble()
            }
        } else if (maxLeftX > minRightY) {
            println("A: ${start} to ${partitionX - 1}")
            recursive(x, y, start, partitionX - 1)
        } else {
            println("B: ${partitionX + 1} to ${end}")
            recursive(x, y, partitionX + 1, end)
        }
    }

    fun findMedianSortedArrayIterative(nums1: IntArray, nums2: IntArray): Double { // Ensuring nums1 as the smallest of the 2 arrays
        if (nums1.size > nums2.size) return findMedianSortedArrayIterative(nums2, nums1)
        val n1Len = nums1.size
        val n2Len = nums2.size
        var lo = 0
        var hi = n1Len // Since there are n1Len elements in nums1, that means we can cut nums1 into n1Len+1 ways (0.. n1Len)
        val totalLen = n1Len + n2Len
        val halfLenOfMergedArrays = (totalLen + 1) / 2
        // We'll do a binary search through the smaller of the 2 arrays by partitioning the 2 arrays such that
        // the count of elements on left half of nums1 and nums2 is equal to the right half
        while (lo <= hi) {
            val n1CutPoint = (lo + hi) / 2
            val n2CutPoint = halfLenOfMergedArrays - n1CutPoint
//            print("${n1CutPoint}, ")     //4, 1, 2, 3 //450, 224, 337, 280, 252, 238,
            print("${n2CutPoint}, ")   //6, 9, 8, 7     //500, 726, 613, 670, 698, 712,

            val n1LeftMax = if (n1CutPoint == 0) Int.MIN_VALUE else nums1.get(n1CutPoint - 1)
            val n2LeftMax = if (n2CutPoint == 0) Int.MIN_VALUE else nums2.get(n2CutPoint - 1)
            val n1RightMin = if (n1CutPoint == n1Len) Int.MAX_VALUE else nums1.get(n1CutPoint)
            val n2RightMin = if (n2CutPoint == n2Len) Int.MAX_VALUE else nums2.get(n2CutPoint)
            // When both nums1 and nums2 Max elements of the left part is lesser than the opposite right halves
            if (n1LeftMax <= n2RightMin && n2LeftMax <= n1RightMin)
                return if (totalLen % 2 != 0) Math.max(n1LeftMax, n2LeftMax).toDouble()
                else  // If total number of elements is odd
                (Math.max(n1LeftMax, n2LeftMax) + Math.min(n1RightMin, n2RightMin)).toDouble() / 2 // If total number of elements is even
            else if (n1LeftMax > n2RightMin) hi = n1CutPoint - 1
            else lo = n1CutPoint + 1
        }
        throw IllegalArgumentException()
    }

    fun findMedianSortedArraysBrute(nums1: IntArray, nums2: IntArray): Double {
        val array = IntArray(nums1.size + nums2.size)
        if (array.size == 0) return 0.0

        var head1Pointer = 0
        var trail1Pointer = nums1.size - 1

        var head2Pointer = 0
        var trail2Pointer = nums2.size - 1

        var headArrayPointer = 0
        var trailArrayPointer = array.size - 1

        while (headArrayPointer <= trailArrayPointer) {
            when {
                head1Pointer > trail1Pointer -> {
                    //head1 deplete
                    val head2 = nums2[head2Pointer]
                    val trail2 = nums2[trail2Pointer]
                    array[headArrayPointer] = head2
                    array[trailArrayPointer] = trail2

                    head2Pointer++
                    trail2Pointer--
                }
                head2Pointer > trail2Pointer -> {
                    //head2 deplete
                    val head1 = nums1[head1Pointer]
                    val trail1 = nums1[trail1Pointer]
                    array[headArrayPointer] = head1
                    array[trailArrayPointer] = trail1

                    head1Pointer++
                    trail1Pointer--
                }
                else -> {
                    val head1 = nums1[head1Pointer]
                    val head2 = nums2[head2Pointer]

                    val trail1 = nums1[trail1Pointer]
                    val trail2 = nums2[trail2Pointer]

                    if (head1 < head2) {
                        array[headArrayPointer] = head1
                        head1Pointer++
                    } else {
                        array[headArrayPointer] = head2
                        head2Pointer++
                    }

                    if (trail1 > trail2) {
                        array[trailArrayPointer] = trail1
                        trail1Pointer--
                    } else {
                        array[trailArrayPointer] = trail2
                        trail2Pointer--
                    }
                }
            }

            headArrayPointer++
            trailArrayPointer--
        }

        array.forEach { print("${it},") }
        println("")

        val medianIndex = array.size / 2
        if (array.size % 2 == 1) {
            return array[medianIndex].toDouble()
        } else {
            return (array[medianIndex] + array[medianIndex - 1]) / 2.0
        }
    }

    //region Binary Search
    fun binarySearchIterative(array: IntArray, target: Int): Boolean {
        var left = 0
        var right = array.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (array[mid] == target) {
                return true
            } else if (target < array[mid]) {
                right = mid - 1
            } else {
                //target > array[mid]
                left = mid + 1
            }
        }

        return false
    }

    fun binarySearchRecursive(array: IntArray, target: Int): Boolean {
        return binarySearchRecursive(array, target, 0, array.size - 1)
    }

    private fun binarySearchRecursive(array: IntArray, target: Int, left: Int, right: Int): Boolean {
        if (left > right) {
            return false
        }
        val mid = (left + right) / 2
        if (array[mid] == target) {
            return true
        } else if (target < array[mid]) {
            return binarySearchRecursive(array, target, left, mid - 1)
        } else {
            return binarySearchRecursive(array, target, mid + 1, right)
        }
    }
    //endregion
}