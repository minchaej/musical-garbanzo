package problems

class ComplexNumberMultiplication {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val array1 = num1.split("+")
        val real1 = array1[0].toInt()
        val img1 = array1[1].dropLast(1).toInt()

        val array2 = num2.split("+")
        val real2 = array2[0].toInt()
        val img2 = array2[1].dropLast(1).toInt()

        val real = (real1 * real2) - (img1 * img2)
        val img = (real1 * img2) +(real2 * img1)

        return "${real}+${img}i"
    }
}