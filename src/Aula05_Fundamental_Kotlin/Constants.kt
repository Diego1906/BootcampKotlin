package Aula05_Fundamental_Kotlin

const val rocks = 3

// Para val o valor é sempre determinado no momento de execução
val number = 5

// Para const val o valor é sempre determinado no momento de compilação
const val num = 5

fun complexFunctionCall() = 10

val result = complexFunctionCall()

// Does not working
// const val result2 = complexFunctionCall()

const val CONSTANT = "top-level constant"

object Constants0 {
    const val CONSTANT2 = "object constant"
}

val foo = Constants0.CONSTANT2

class MyClass {
    companion object {
        const val CONSTANT3 = "constant inside companion"
    }
}



