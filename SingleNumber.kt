package problems

/**
 * Bit Manipulation Problem - Must be solved with O(n) time and O(1) space.
 * Given:
 * a XOR 0 = a
 * a XOR a = 0
 * a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
 */
class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var a = 0
        for (i in 0 until nums.size) {
            a = a xor nums[i]
        }
        return a
    }
}