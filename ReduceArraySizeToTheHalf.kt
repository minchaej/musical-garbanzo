package problems

import java.util.HashMap

class ReduceArraySizeToTheHalf {
    fun minSetSize(arr: IntArray): Int {
        val hashMap = HashMap<Int, Int>()

        for (i in 0 until arr.size) {
            val num = arr[i]
            hashMap[num] = hashMap[num]?.plus(1) ?: 1
        }

        val sumMustBeGreaterThan = arr.size / 2

        var counter = 0
        var sum = 0

        val list = ArrayList<Int>(hashMap.size)

        for ((key, value) in hashMap) {
            list.add(value)
        }

        list.sortDescending()

        for (i in 0 until list.size) {
            sum += list[i]
            counter++
            if (sum >= sumMustBeGreaterThan) {
                break
            }
        }

        return counter
    }
}