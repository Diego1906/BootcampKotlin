package Aula06

fun main() {

    val numbers01 = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    numbers01.filter { it > 4 && it < 8 }.forEach { value -> println("$value!") }

    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call
    println()

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    // SOLUÇÃO 01
    numbers.printNumbers {
        println(this)
    }

    // SOLUÇÃO 02
    print(numbers.divisibleBy {
        it.rem(3)
    })

    // SOLUÇÃO 03
    print(numbers.retornaNovaLista {
        it.rem(3)
    })

    // USANDO FUNÇÃO ANÔNIMA NO FILTER
    val ints = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    val re = ints.filter(
        fun(item) = item > 0
    )
    println("\n $re")

    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print("Total: $sum")

    // Function literals with receiver
    val sumFunAnnonimous = fun Int.(other: Int): Int = this + other
    val sumNum = 10.sumFunAnnonimous(50)
    println("\n\n$sumNum")

    val sum02: Int.(Int) -> Int = { num -> plus(num) }
    val ret = 50.sum02(50)
    println("\n\n$ret")
}

fun List<Int>.printNumbers(block: Int.() -> Unit) {
    this.map {
        if (it.rem(3).equals(0))
            it.block()
    }
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun List<Int>.retornaNovaLista(block: (Int) -> Int): List<Int> {
    return this.filter {
        block(it) == 0
    }
}


