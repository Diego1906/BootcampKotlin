package Aula05_Fundamental_Kotlin

fun main() {

    // PRIMEIRO EXEMPLO
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

    // SEGUNDO EXEMPLO
    val book = Book("Android Essencial com Kotlin", "Ricardo Lecheta", 2017, 210)
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

    // TERCEIRO EXEMPLO
    println("This book contains ${book.getWeightBook()} grass")

    // QUARTO EXEMPLO
    val puppy = Puppy()
    val bookNew = Book("Arquitetura Limpa", "Robert C. Martin", 2018, 169)
    playWithBook(bookNew, puppy)

    playWithPuzzeToy(puppy)
}

/* Crie um puppy e dê um 'book' para ele brincar até que não haja mais páginas. */
private fun playWithBook(book: Book, puppy: Puppy) {
    println("\nThis book contains ${book.pages} pages.")
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}. ")
}

private fun playWithPuzzeToy(puppy: Puppy) {
    println("\nQuantidade de fruta(s) é ${puppy.puzzleToy.fruits.size}")
    while (puppy.puzzleToy.fruits.size > 0) {
        puppy.playWithPuzzeToy()
        println("Quantidade de fruta(s) é ${puppy.puzzleToy.fruits.size}")
    }
}
