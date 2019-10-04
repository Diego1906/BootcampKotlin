package Spices

data class SpiceContainer constructor(private var spice: Spice) {
    val label = spice.name
    val spiciness = spice.spiciness
}

object CONTAINER {

    fun containers() {
        val spiceCabinet: List<SpiceContainer> = listOf(
            SpiceContainer(Curry("curry", "mild", YellowSpiceColor)),
            SpiceContainer(Curry("pepper", "medium", GreenSpiceColor)),
            SpiceContainer(Curry("cayenne", "spicy", BlueSpiceColor)),
            SpiceContainer(Curry("ginger", "mild", YellowSpiceColor)),
            SpiceContainer(Curry("red curry", "medium", RedSpiceColor)),
            SpiceContainer(Curry("green curry", "mild", GreenSpiceColor)),
            SpiceContainer(Curry("hot pepper", "extremely spicy", RedSpiceColor))
        )

        spiceCabinet.filter {
            it.label != "curry" && it.label.contains('c', true).not()
        }.forEach {
            printText(it)
        }
    }

    fun printText(spice: SpiceContainer) {

//        takeIf { spice.label.length == 6 }?.apply {
//            println("Especiaria ${spice.label} e picância ${spice.spiciness}")
//        }

        takeIf { spice.label.length > 6 }?.run {
            println("Especiaria ${spice.label} e picância ${spice.spiciness}")
        }
    }
}

