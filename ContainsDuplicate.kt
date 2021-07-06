package problems

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set : MutableSet<Int> = hashSetOf()

        for (i in 0 until nums.size) {
            val num = nums[i]
            if (set.contains(num)) {
                return true
            } else {
                set.add(num)
            }
        }

        return false
    }
}