import java.util.*

fun main(args: Array<String>) {
    val hour = args[0].toInt()
    println(if (hour >= 0 && hour < 12) "Good morning, Kotlin" else "Good night, Kotlin.")
    dayOfWeek()
}

/*
fun Aula05_Fundamental_Kotlin.main(args: Array<String>) {
    println("Hello ${args[0]}")
    dayOfWeek()
}
 */

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(
        "Today is ${when (day) {
            1 -> "sunday"
            2 -> "monday"
            3 -> "tuesday"
            4 -> "wednesday"
            5 -> "thursday"
            6 -> "friday"
            7 -> "saturday"
            else -> "Time has stopped"
        }}"
    )
}