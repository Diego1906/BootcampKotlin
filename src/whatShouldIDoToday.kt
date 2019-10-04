fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy", "rainy"))
    println(whatShouldIDoToday("sad"))
    println(whatShouldIDoToday(getMoodUser()))
}

fun getMoodUser(): String {
    print("How do you feel?")
    return readLine()!!
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isVeryHot(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun isSadRainyCold(
    mood: String,
    weather: String,
    temperature: Int
) = mood == "sad" && weather == "rainy" && temperature == 0

fun isVeryHot(temperature: Int) = temperature > 35



