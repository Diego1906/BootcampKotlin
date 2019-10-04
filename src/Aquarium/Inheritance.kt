package Aquarium

//interface AquariumAction {
////    fun eat()
////    fun jump()
////    fun clear()
////    fun catchFish()
////    fun swim() {
////        println("swim")
////    }
////}
////
////interface FishAction {
////    fun eat()
////}
////
////abstract class AquariumFish2 : FishAction {
////
////    abstract val color: String
////    override fun eat() {
////        println("yum")
////    }
////}

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus(RedColor)
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("a lot of algae"),
    FishColor by fishColor

object GoldColor : FishColor {
    override val color: String = "gold"
}

object RedColor : FishColor {
    override val color: String = "red"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
