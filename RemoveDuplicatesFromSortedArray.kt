package problems


object RemoveDuplicatesFromSortedArray {

    fun removeDuplicatesReturnCountOnly(nums: IntArray): Int {
        if (nums.size == 0) return 0

        var counter = 1

        for (i in 1 until nums.size) {
            if (nums[i-1] != nums[i]) {
                counter++
            }
        }
        return counter
    }

    fun removeDuplicatesReturnArray(nums: IntArray): IntArray {
        var currentNum: Int? = null

        for ((index, num) in nums.withIndex()) {
            if (currentNum == null){
                //initialize
                currentNum = num
            } else {
                if (currentNum == num) {
                    //remove and shift left
                    nums[index - 1] = 1
                    currentNum = num
                } else {
                    //move on
                    currentNum = num
                }
            }
        }

        return intArrayOf(1,1)
    }

}