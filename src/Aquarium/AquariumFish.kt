package Aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark(fishColor: FishColor = GoldColor) :
    AquariumFish(),
    FishAction by PrintingFishAction("hunt and eat fish"),
    FishColor by fishColor
