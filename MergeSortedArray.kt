package problems

class MergeSortedArray {

    //time O(n/2) with space O(1)
    fun mergeFromSolution(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var end = m + n - 1
        var i = m - 1
        var j = n - 1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i]
                i--
            } else {
                nums1[end--] = nums2[j]
                j--
            }
        }
    }

    //Faster; time O(n/2) with space O(n)
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val array = IntArray(m + n)

        var head1Pointer = 0
        var trail1Pointer = m - 1

        var head2Pointer = 0
        var trail2Pointer = n - 1

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

        array.forEachIndexed { index, i ->
            print("${i}, ")
            nums1[index] = i
        }
    }


    //I wanted O(1) space complexity; without using extra array. but failed.
    fun mergeTriedNewApproach(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        var nums2Pointer = 0
        for (nums1Pointer in 0 until nums1.size) {

            //num1 vs num2
            val num1 = nums1[nums1Pointer]
            val num2 = nums2[nums2Pointer]

            if (num1 > num2) {
                //swap
                val temp = nums1[nums1Pointer]
                nums1[nums1Pointer] = nums2[nums2Pointer]
                nums2[nums2Pointer] = temp
            } else {
                nums2Pointer++
            }

        }
    }
}