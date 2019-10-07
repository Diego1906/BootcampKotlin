package Aula05_Fundamental_Kotlin

const val NUMBER_BOOKS = 3
const val MAX_NUMBER_BOOKS = 2

class Book(val title: String, val author: String, val year: Int, var pages: Int) {

    val grassPages: Double = 1.5

    companion object {
        const val BASE_URL = "https://www.google.com/search?q="
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(numberBooks: Int) = (numberBooks <= MAX_NUMBER_BOOKS)

    fun printUrl() {
        println(BASE_URL + title.replace(' ', '-')) // + ".html"
    }

    fun getWeightBook(): Double = this.weight()
}

fun Book.weight(): Double {
    return pages.times(grassPages)
}

fun Book.tornPages(pagesDamaged: Int) {
    if (pages >= pagesDamaged && pagesDamaged > 0) {
        pages -= pagesDamaged
    } else {
        pages = 0
    }
}