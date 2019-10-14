package Aula06

fun main() {
    val game = Game()
    game.printDirections()
    game.north(Directions.NORTH)
    game.south(Directions.SOUTH)
    game.east(Directions.EAST)
    game.west(Directions.WEST)
    val returnEnd = game.end()
    game.printDirections()
    println(returnEnd)
}

class Game {
    private var path: MutableList<Directions> = mutableListOf(Directions.START)

    private val expression = { directions: Directions -> addDirections(directions) }

    val north = expression
    val south = expression
    val east = expression
    val west = expression
    val end = {
        addDirections(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    private fun addDirections(directions: Directions) {
        path.add(directions)
    }

    fun printDirections() {
        println(path)
    }
}