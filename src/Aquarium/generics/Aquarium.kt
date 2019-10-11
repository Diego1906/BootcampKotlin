package Aquarium.generics

fun main(args: Array<String>) {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TaperWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply.")
    }
}

class TapWaterCleaner : Cleaner<TaperWater> {
    override fun clean(waterSupply: TaperWater) {
        waterSupply.addChemicalCleaners()
    }
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {

    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium<TaperWater>(TaperWater())
    aquarium.addWater(cleaner)

    isWaterClean(aquarium)

    println(aquarium.hasWaterSupplyOfType<TaperWater>())
    println(aquarium.waterSupply.isOfType<LakeWater>())
}