package Aula05_Fundamental_Kotlin

fun main() {
    val testList: List<Int> = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    println("Lista normal")
    println(testList)
    println()

    println("Sub lista")
    println(testList.subList(3, testList.size))
    println()

    println("Lista invertida")
    println(reverseList(testList))
    println()

    println("Lista invertida com While")
    println(reverseList2(testList))
    println()

    println("Lista invertida com downTo")
    println(reverseList3(testList))
    println()

    println("Lista invertida usando a função Reversed()")
    println(reverseList4(testList))
    println()
}

fun reverseList(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()

    for (i in 0..list.size - 1) {
        result.add(list[list.size - i - 1])
    }
    return result
}

fun reverseList2(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()

    var index = list.size - 1

    while (index >= 0) {
        result.add(list[index])
        index--
    }
    return result
}

fun reverseList3(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()

    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}

fun reverseList4(list: List<Int>): List<Int> {
    return list.reversed()
}

