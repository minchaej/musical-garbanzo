package problems

class LetterCombinationsOfPhoneNumber {

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        if (digits.length == 1) {
            return gen(digits[0])
        } else {
            val sub = letterCombinations(digits.substring(1 until digits.length))
            val pri = gen(digits[0])
            val list = ArrayList<String>()
            val sb = StringBuilder()
            for (i in 0 until pri.size) {
                for (j in 0 until sub.size) {
                    sb.append(pri[i])
                    sb.append(sub[j])
                    list.add(sb.toString())
                    sb.clear()
                }
            }

            return list
        }
    }

    fun gen(digit: Char): List<String> {
        val num = digit.toString().toInt()
        return when (num) {
            2 -> listOf("a","b","c")
            3 -> listOf("d","e","f")
            4 -> listOf("g","h","i")
            5 -> listOf("j","k","l")
            6 -> listOf("m","n","o")
            7 -> listOf("p","q","r", "s")
            8 -> listOf("t","u","v")
            9 -> listOf("w","x","y", "z")
            else -> emptyList()
        }
    }

    fun letterCombinationsWrong(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val list = ArrayList<String>()
        val default = StringBuilder()

        for (i in 0 until digits.length) {
            val digit = digits[i].toString().toInt()
            if (digit > 7) {
                default.append((((digit - 2) * 3) + 1 + 97).toChar().toString())
            } else {
                default.append((((digit - 2) * 3) + 97).toChar().toString())
            }
        }

        for (i in digits.length - 1 downTo 0) {
            val digit = digits[i].toString().toInt()
            val letters = default.substring(0 until digits.length) //wrong consequtive only

            if (digit == 7 || digit == 9) {
                for (j in 0 until 4) {
//                println(97.toChar())
//                println((((digit - 2) * 3) + 97 + j).toChar())
                    if (digit > 7) {
                        default.append((((digit - 2) * 3) + 1 + 97).toChar().toString())
                    } else {
                        default.append((((digit - 2) * 3) + 97).toChar().toString())
                    }
                }
            } else {
                for (j in 0 until 3) {
//                println(97.toChar())
//                println((((digit - 2) * 3) + 97 + j).toChar())
                    if (digit > 7) {
                        default.append((((digit - 2) * 3) + 1 + 97).toChar().toString())
                    } else {
                        default.append((((digit - 2) * 3) + 97).toChar().toString())
                    }
                }
            }


        }


        return emptyList()
    }
}