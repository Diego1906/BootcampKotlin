package Aula06

import Aula06.Direction.*
import kotlin.math.absoluteValue

fun main() {
    val ret = 1.rem(4)

    val game = Game()

    while (true) {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
        println(game.map.getDescription())
    }
}

class Location(val width: Int = 4, val height: Int = 4) {

    val map = Array(width) { arrayOfNulls<String>(height) }

    var currentLocation = Pair(0, 0)

    fun updateLocation(direction: Direction) {

        when (direction) {
            NORTH -> currentLocation = Pair(currentLocation.first, (currentLocation.second + 1).rem(height))
            SOUTH -> currentLocation =
                Pair(currentLocation.first, (currentLocation.second - 1).absoluteValue.rem(height))
            EAST -> currentLocation = Pair((currentLocation.first + 1).rem(width), currentLocation.second)
            WEST -> currentLocation = Pair((currentLocation.first - 1).absoluteValue.rem(width), currentLocation.second)
        }
    }

    fun getDescription(): String? {
        return map[currentLocation.first.rem(width)][currentLocation.second.rem(height)]
    }

    init {
        map[0][0] = "You are at the start of your journey. [n / e]"
        map[0][1] = "The road stretches before you. It promises beauty and adventure. [ n / s / e]"
        map[0][2] = "The road still stretches before you. It rains and the water forms puddles. [ n / s / e]"
        map[0][3] = "It is getting much colder and you wish you had a wool coat. [ s / e]"

        map[1][0] = "The narrow path stretches before you. You are glad you are on foot. [ n / e /w]"
        map[1][1] =
            "It is getting warmer. You smell moss, and marmot scat. You are stung by a mosquito. [ n / s / e / w]"
        map[1][2] = "You decide to sit on your backside and slide down a vast snowfield. [ n / s / e /w]"
        map[1][3] = "You have climbed to the top of a snowy mountain and are enjoying the view. [ w / s / e]"

        map[2][0] =
            "You cross an old stone bridge. Your hear the murmuring of water. And another grumbling sound. [ n / e / w]"
        map[2][1] =
            "A bridge troll appears. It swings a club and demands gold. You give them all your coins. [ n / s / e  /w]"
        map[2][2] = "It is getting cooler. A dense fog rolls in. You can hear strange voices. [ n / s / e / w]"
        map[2][3] =
            "The foothills promise a strenuous journey. You thread your way around gigantic boulders. [ s / e / w ]"

        map[3][0] = "Your journey continues. A fox runs across the path with a chicken in its mouth.[ n / e ]"
        map[3][1] =
            "In the distance, you see a house. You almost bump into a farmer with a large shotgun. They pay you no heed. [ n / s / w ]"
        map[3][2] =
            "It is getting hot, and dry, and very, very quiet. You think of water and wish you had brought a canteen.[ n / s / w ]"
        map[3][3] =
            "You have reached the infinite desert. There is nothing here but sand dunes. You are bitten by a sand flea.[ s / w ] "
    }
}

class Game {
    var path = mutableListOf<Direction>(START)
    var map = Location()

    val north = { path.add(NORTH) }
    val south = { path.add(SOUTH) }
    val east = { path.add(EAST) }
    val west = { path.add(WEST) }
    val end = { path.add(END); println("Game Over: $path"); path.clear(); false }

    fun makeMove(direction: String?) {

        verifyAndInitializeList()

        when (direction) {
            "n" -> {
                move(north); map.updateLocation(NORTH)
            }
            "s" -> {
                move(south); map.updateLocation(SOUTH)
            }
            "e" -> {
                move(east); map.updateLocation(EAST)
            }
            "w" -> {
                move(west); map.updateLocation(WEST)
            }
            else -> {
                move(end)
            }
        }
    }

    // HIGHER ORDER FUNCTION
    fun move(where: () -> Boolean) {
        where.invoke()
    }

    private fun verifyAndInitializeList() {
        if (path.isEmpty())
            path.add(START)
    }
}