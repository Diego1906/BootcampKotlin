package Spices

fun main() {
    val curry = Curry("yellow curry", "mild", GreenSpiceColor)
    println(curry.color)
}

sealed class Spice(val name: String, val spiciness: String = "mild") {

    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor) :
    Spice(name, spiciness),
    Grinder,
    SpiceColor by color {

    override fun prepareSpice() {
    }

    override fun grind() {
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

object RedSpiceColor : SpiceColor {
    override val color: Color = Color.RED
}

object BlueSpiceColor : SpiceColor {
    override val color: Color = Color.BLUE
}

object GreenSpiceColor : SpiceColor {
    override val color: Color = Color.GREEN
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}


