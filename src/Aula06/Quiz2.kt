package Aula06

fun main() {
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
