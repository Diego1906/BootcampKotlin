package Aquarium

abstract class Spice(val name: String, val spiciness: String = "mild") {

    private val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
/*
    val spices1 =
        listOf<Spice>(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "extremely spicy")
        )

    init {
        for (o in spices1) {
            println("Objeto spice ${o.name} e ${o.spiciness}")
        }
    }

    val spice: Spice = Spice("cayenne", spiciness = "spicy")

    val spicelist = spices1.filter { it.heat < 5 }

    fun makeSalt() = Spice("Salt")

 */
}

class Curry(val spiciness: String = "mild")
class Pepper(val spiciness: String = "medium")
class Cayenne(val spiciness: String = "spicy")
class Ginger(val spiciness: String = "mild")
class RedCurry(val spiciness: String = "medium")
class GreenCurry(val spiciness: String = "mild")
class HotPepper(val spiciness: String = "extremely spicy")