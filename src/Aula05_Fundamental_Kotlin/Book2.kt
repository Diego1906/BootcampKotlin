package Aula05_Fundamental_Kotlin

const val NUMBER_BOOKS = 3
const val MAX_NUMBER_BOOKS = 2

fun main() {
    val book = Book2("Android Essencial com Kotlin", "Ricardo Lecheta", 2017)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second} ")

    println(
        "Here is your book ${bookTitleAuthorYear.first} by ${bookTitleAuthorYear.second} " +
                "written in ${bookTitleAuthorYear.third}"
    )

    if (book.canBorrow(NUMBER_BOOKS))
        book.printUrl()
    else
        println(
            "Você não pode levar mais que ${MAX_NUMBER_BOOKS}. " +
                    "Devolva ${NUMBER_BOOKS - MAX_NUMBER_BOOKS} livro(s)."
        )
}

class Book2(val title: String, val author: String, val year: Int) {

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
}
