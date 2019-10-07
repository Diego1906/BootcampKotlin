package Aula05_Fundamental_Kotlin

class PuzzleToy {
    var fruits = mutableListOf<String>(
        "banana", "pera", "laranja", "abacaxi", "uva", "manga", "maca", "kiwi", "mexirica"
    )

    fun removeItemFruits(size: Int) {
        val index = if (size > 0) size - 1 else 0
        if (index >= 0) {
            for (i in index downTo 0) {
                fruits.removeAt(i)
            }
        }
    }
}