package problems

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var closest: Int? = null
        var diff = 0

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue //since sorted, it is ok to skip and remove duplicates.
            }

            var left = i + 1
            var right = nums.size - 1

            //two pointer sum find
            while (left != right) {
                val sum = nums[left] + nums[right] + nums[i]
//                println("${nums[i]}, ${nums[left]}, ${nums[right]}")

                when {
                    sum < target -> left++
                    sum > target -> right--
                    sum == target -> {
                        return sum
                    }
                }

                if (closest == null) {
                    closest = sum
                    diff = Math.abs(target - closest)
                } else {
//                    val prevDiff = Math.abs(target - closest)
                    val currDiff = Math.abs(target - sum)
                    if (currDiff < diff) {
                        closest = sum
                        diff = currDiff
                    }
                }
            }
        }

        return closest ?: 0
    }
}