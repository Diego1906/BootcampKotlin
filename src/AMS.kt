import java.util.*

fun main(args: Array<String>) {

    repeat(1) {
        println("Hello, world!")
    }

    feedTheFish()

    println(fitMoreFish(10.0, listOf(3, 3, 3))) //---> false
    println(fitMoreFish(8.0, listOf(2, 2, 2), hasDecorations = false)) //---> true
    println(fitMoreFish(9.0, listOf(1, 1, 3), 3)) //---> false
    println(fitMoreFish(10.0, listOf(), 7, true)) //---> true
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 22)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    // call dirty processor
    dirtyProcessor()
}

fun randomDay(): String {
    val week = listOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )
    return week[Random().nextInt(7)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "le ttuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {

    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun getDirtySensorReading() = 20


/*
- Parameters
* tankSize (em galões)
* currentFish (uma lista de Ints representando o tamanho de cada peixe que já esteja dentro do tanque)
* fishSize (o tamanho do novo peixe que adicionaremos ao tanque)
* hasDecorations (true se o tanque tiver decorações, falso se não) */
fun fitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize.times(if (hasDecorations) 0.8 else 1.0)) >= (currentFish.sum().plus(fishSize))
}

var dirty = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

fun feedFish(dirty: Int) = dirty.plus(10)

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    println("Update with waterFilter = $dirty")

    dirty = updateDirty(dirty, ::feedFish)
    println("Update with feedFish = $dirty")

    dirty = updateDirty(dirty) {
        it.plus(50)
    }
    println("Update without last parameter = $dirty")

    dirty = updateDirty(dirty) { dirty ->
        dirty.plus(50)
    }
    println("Update using the outside lambda function = $dirty")

    dirty = updateDirty(dirty, { dirty ->
        dirty.plus(50)
    })
    println("Update with lambda function parameter = $dirty")
}