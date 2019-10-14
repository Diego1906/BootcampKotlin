package Aula06

data class Fish(var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name) {
        println("Block with")
        println(capitalize())
    }

    // RUN retornado o resultado da execução do lambda
    fish.run {
        println(name.plus(" esse é meu nome"))
    }

    // APPLY retorna o objeto após a execução do lambda
    println(fish.apply {
        name = "spashy jr"
    })

    val fish2 = Fish("splashy").apply { name = "Sharky" }
    println(fish2.name)

    // LET retorna uma cópia do objeto alterado
    println(fish2.let { it.name.capitalize() }
        .let { it.plus(" fish") }
        .let { it.length }
        .let { it.plus(31) }
    )

    val name: String? = null
    name?.let {
        println(name)
    } ?: run {
        println("Sem nome")
    }

    with(name){

    }
}

// HIGHER ORDER FUNCTION ANS LAMBDA
inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}