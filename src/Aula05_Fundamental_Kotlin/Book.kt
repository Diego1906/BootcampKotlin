package Aula05_Fundamental_Kotlin

fun main() {

    val findBook = FindBook()

    val retorno = findBook.pair("Kotlin", "Ricardo")
    println("Impressão ${retorno.first} e do ${retorno.second}")
    println()

    val (title, author) = findBook.pair("Kotlin", "Ricardo")
    println("Aqui está o livro $title, escrito por $author.")
    println()

    val (title2, author2) = findBook.pair("ação", "Marcos")
    println("Aqui está o livro $title2, escrito por $author2.")
    println()

    val (title3, author3, year3) = findBook.triple("Android", "Nelson", 2019)
    println("Aqui está o livro $title3, escrito por $author3 em $year3.")
}

data class Book(val title: String, val author: String, val year: Int = 0)

class FindBook {

    private val livros: List<Book> = listOf(
        Book("Android Essencial com Kotlin", "Ricardo Lecheta", 2017),
        Book("Kotlin em ação", "Marcos da Fonseca", 2018),
        Book("Dominando o Android com Kotlin", "Nelson Glauber", 2019)
    )

    fun pair(title: String, author: String): Pair<String, String> {

        val result = livros.filter {
            it.title.contains(title) && it.author.contains(author)
        }.first()

        return Pair(result.title, result.author)
    }

    fun triple(title: String, author: String, year: Int): Triple<String, String, Int> {
        val result = livros.filter {
            it.title.contains(title) && it.author.contains(author) && it.year == year
        }.first()

        return Triple(result.title, result.author, result.year)
    }
}
