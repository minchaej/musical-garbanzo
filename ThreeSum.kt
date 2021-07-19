package problems

class ThreeSum {

    /**
     * Trial and error:
     * 1. triple loop with set - 1500ms
     * 2. double loop two pointer with set - 700ms
     * 3. double loop two pointer no set - 350ms
     */
    fun threeSums(nums: IntArray): List<List<Int>> {
        val arrayList = ArrayList<List<Int>>()

        nums.sort() // sort necessary to filter out duplicates

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue //since sorted, it is ok to skip and remove duplicates.
            }

            val target = 0 - nums[i]
            var left = i + 1
            var right = nums.size - 1

            //two pointer sum find
            while (left < right) {
                val sumIJ = nums[left] + nums[right]
                when {
                    sumIJ < target -> left++
                    sumIJ > target -> right--
                    sumIJ == target -> {
                        //detect duplicates, since they are in order, duplicates will be adjacent.
                        //so it is sufficient to compare to previous value
                        if (left > i + 1 && right < nums.size - 1) {
                            if (nums[left] != nums[left - 1] || nums[right] != nums[right + 1]) {
                                arrayList.add(listOf(nums[i], nums[left], nums[right]))
                            }
                        } else {
                            arrayList.add(listOf(nums[i], nums[left], nums[right]))
                        }
                        left++
                        right--
                    }
                }
            }
        }
        return arrayList
    }

}