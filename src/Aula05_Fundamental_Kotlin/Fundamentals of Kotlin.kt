package Aula05_Fundamental_Kotlin

fun main() {

    val (result, _, ligado) = retorno()

    println(result)
    //println(status)
    println(ligado)
}

data class Result(val result: Int, val status: String, val ligado: Boolean)

fun retorno() = Result(92, "ok", false)


