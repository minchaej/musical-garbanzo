package problems

class FindPeakElement {
    //I think? no purpose in real life because this algo only works since given problem is nums[i] != nums[i + 1] for all valid i

    fun findPeakElementIterative(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = (left + right) / 2
            val midVal = nums[mid]
            val rightVal = nums[mid + 1]

            if (midVal < rightVal) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }

    fun findPeakElementRecursive(nums: IntArray): Int {
        return binarySearchRecursiveShort(nums, 0, nums.size - 1)
    }

    private fun binarySearchRecursiveShort(array: IntArray, left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }
        if (left == right) {
            return left
        }
        val mid = (left + right) / 2
        val midVal = array[mid]
        val rightVal = array[mid + 1]

        if(midVal < rightVal) {
            return binarySearchRecursiveShort(array, mid + 1, right)
        } else {
            return binarySearchRecursiveShort(array, left, mid)
        }
    }

    private fun binarySearchRecursiveVerbose(array: IntArray, left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }
        val mid = (left + right) / 2
        val midVal = array[mid]

        when {
            mid - 1 >= left && mid + 1 <= right -> {
                //Both left and right neighbor available
                val leftVal = array[mid - 1]
                val rightVal = array[mid + 1]

                if (midVal > leftVal && midVal > rightVal) {
                    return mid
                } else {
                    when {
                        midVal < leftVal -> {
                            return binarySearchRecursiveVerbose(array, left, mid - 1)
                        }
                        midVal < rightVal -> {
                            return binarySearchRecursiveVerbose(array, mid + 1, right)
                        }
                        else -> return -1
                    }
                }

            }
            mid + 1 <= right -> {
                //Only right neighbor available
                val rightVal = array[mid + 1]
                if (midVal > rightVal) {
                    return mid
                } else {
                    return binarySearchRecursiveVerbose(array, mid + 1, right)
                }
            }
            mid - 1 >= left -> {
                //Only left neighbor available
                val leftVal = array[mid - 1]
                if (midVal > leftVal) {
                    return mid
                } else {
                    return binarySearchRecursiveVerbose(array, left, mid - 1)
                }
            }
            else -> {
                //only self is left
                return mid
            }
        }

    }

}