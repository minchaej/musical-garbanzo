package problems

class MajorityElement {

    //Boyer-Moore Voting Algorithm
    fun majorityElement(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var majority = nums[0]
        var count = 1

        for (i in 1 until nums.size) {
            val curr = nums[i]
            if (curr == majority) {
                count++
            } else {
                count--
                if (count == 0) {
                    majority = curr
                    count++
                }
            }
        }

        return majority
    }
}