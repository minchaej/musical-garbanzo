package problems

import java.util.HashMap

class IntersectionOfTwoArraysII {
    //for real... this is the solution on leetcode.. disapointing..
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val hashMap = HashMap<Int, Int>()

        for (i in 0 until nums1.size) {
            val num1 = nums1[i]
            hashMap[num1] = hashMap[num1]?.plus(1) ?: 1
        }

         val a = arrayListOf<Int>()

        for (i in 0 until nums2.size) {
            val num2 = nums2[i]
            if (hashMap.containsKey(num2) && hashMap[num2] != 0) {
                hashMap[num2] = hashMap[num2]?.minus(1) ?: 0
                a.add(num2)
            }
        }
        return a.toIntArray()
    }
}