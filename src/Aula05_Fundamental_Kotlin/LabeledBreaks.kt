package Aula05_Fundamental_Kotlin

fun main() {
    labels()
}

fun labels() {
    loop@ for (i in 1..10) {
        println("i is $i")
        loop2@ for (j in 1..5) {
            println("j is $j")
            if (i > 3) {
                break@loop
            } else
                continue@loop2
        }
    }
    println("final method")
}