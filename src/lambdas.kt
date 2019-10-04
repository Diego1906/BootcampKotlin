import java.util.*

fun main() {
    gamePlay(rollDice2(4))
}

fun gamePlay(diceRoll: Int) {
    // do something with the dice roll
    println(diceRoll)
}

val rollDice = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(12).plus(1)
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides).plus(1)
}

