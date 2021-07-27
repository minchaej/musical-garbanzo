package problems

class ContainerWithMostWater {
    /**
     * My Two Pointer Solution - Right off the bat & Intuitive
     */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0

        while(left != right) {
            val leftNum = height[left]
            val rightNum = height[right]

            val min = Math.min(leftNum, rightNum)
            val area = min * (right - left)
            max = Math.max(area, max)

            if (leftNum > rightNum) {
                right--
            } else {
                left++
            }
        }
        return max
    }
}