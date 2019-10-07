package Aula05_Fundamental_Kotlin

import java.util.*

class Puppy {

    val puzzleToy = PuzzleToy()

    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(book.pages))
    }

    fun playWithPuzzeToy() {
        puzzleToy.removeItemFruits(Random().nextInt(puzzleToy.fruits.size))
    }
}

