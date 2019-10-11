package Aula05_Fundamental_Kotlin

fun main() {
    /* Na chamada de call o parâmetro precisa satisfazer as condições do where para dar certo, nesse caso extender
    * as duas interfaces i01 e i 02. Caso contrário o kotlin apresentará um erro de compilação*/
    call(Delicia())
}

class Delicia : i01, i02 {
    override fun funI01() {
        funI02()
        print("Delícia.... =)")
    }

    override fun funI02() {
        print("Ai sim hein...")
    }
}

fun <T> call(value: T) where T : i01, T : i02 {
    value.funI01()
}

interface i01 {
    fun funI01()
}

interface i02 {
    fun funI02()
}



