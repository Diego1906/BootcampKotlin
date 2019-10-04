package Aula05_Fundamental_Kotlin

fun main() {
    val allBooks: Set<String> =
        setOf("Hamlet", "MacBeth", "Noite de Reis", "Rei Lear", "A tempestade", "Hamlet", "MacBeth")

    val library: Map<String, Set<String>> =
        mapOf("Shakespeare" to allBooks, "Paulo Coelho" to allBooks, "Shakespeare" to allBooks)

    val result = library.any {
        it.value.contains("Hamlet")
    }

    println(result)


    val moreBooks: MutableMap<String, String> = mutableMapOf("Android Essencial com Kotlin" to "Ricardo Lecheta")
    if (!moreBooks.containsKey("Android Essencial com Kotlin"))
        moreBooks.put("Android Essencial com Kotlin", "Ricardo Lecheta")

    println(moreBooks)

    val value = moreBooks.getOrElse("Android Essencial com Kotlin") { "Livro não encontrado" }
    println(value)

    val value2 = moreBooks.getOrElse("Dominando Android com Kotlin") { "Livro não encontrado" }
    println(value2)
}
