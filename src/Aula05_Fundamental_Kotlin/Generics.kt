package Aula05_Fundamental_Kotlin

fun main() {

    // Generic Functions
    testeBox<String>("Diego")
    testeBox<Int>(1)
    testeBox<Boolean>(true)

    val charSequence: CharSequence
    //val result = copyWhenGreater( TesteGenerics() )

}


// Using generics
class Box<T>(t: T) {
    val value = t
}

fun <T> testeBox(t: T) {
    val box = Box(t)
    lateinit var msg: String
    when (t) {
        is Int -> {
            msg = "\"t\" is an interger = ${box.value}"
        }
        is String -> {
            val box2 = Box<String>(t)
            msg = "\"t\" is an string = ${box2.value}"
        }
        is Boolean -> {
            msg = "\"t\" is an boolean = ${box.value}"
        }
    }
    println(msg)
}

// Function using clause WHERE
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where
              T : Comparable<T> {
    return list.filter {
        it > threshold
    }.map {
        it.toString()
    }
}

class TesteGenerics<T> : CharSequence, Comparable<T>{
    override fun compareTo(other: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val length: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun get(index: Int): Char {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}