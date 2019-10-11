package Buildings

fun main() {

    val wood = Wood()
    Building<Wood>(wood).build()
    isSmallBuilding(Building(wood))
    println()

    val brick = Brick()
    Building<Brick>(brick).build()
    isSmallBuilding(Building(brick))
}

open class BaseBuildingMaterial {
    open val numberNeeded: Int = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded: Int = 8
}

class Building<out T : BaseBuildingMaterial>(private val building: T) {

    private val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int = building.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("\"$actualMaterialsNeeded ${building::class.simpleName} required\".")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500)
        println("small building")
    else
        println("large building")
}
