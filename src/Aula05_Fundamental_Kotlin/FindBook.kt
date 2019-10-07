package Aula05_Fundamental_Kotlin

class FindBook {

    private val livros: List<Book> = listOf(
        Book("Android Essencial com Kotlin", "Ricardo Lecheta", 2017, 200),
        Book("Kotlin em ação", "Marcos da Fonseca", 2018, 150),
        Book("Dominando o Android com Kotlin", "Nelson Glauber", 2019, 1120)
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