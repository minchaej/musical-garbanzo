package problems.datastructure

fun IntArray.print() {
    this.forEach {
        print("${it}, ")
    }
    println()
}

fun CharArray.print() {
    this.forEach {
        print("${it} ")
    }
    println()
}