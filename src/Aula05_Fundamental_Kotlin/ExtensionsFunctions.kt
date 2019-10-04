package Aula05_Fundamental_Kotlin

fun main() {
    extensionsExample()
    propertyExample()
    nullableExample()

    val list = mutableListOf(1, 2, 3, 4)
    list.swap(0, 3) // 'this' inside 'swap()' will hold the value of 'list'
    println(list)

    ExtensionsCompanion.printCompanion()

    val connection = Connection()
    connection.connect()
    println(connection.toString())
}

// Extension Function
fun String.hasSpaces(): Boolean {
    val found = this.find {
        it == ' '
    }
    return found != null
}

// Extension Function
fun String.hasSpacesTwo() = find { it == ' ' } != null

fun extensionsExample() {
    println("Does it have spaces?".hasSpaces())
    println("Are there spaces blank in this string?".hasSpacesTwo())
}

class AquariumPlant(val color: String, private val size: Int)

// Extension Propertie
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

// Using extension propertie
fun propertyExample() {
    val plant = AquariumPlant("Red", 50)
    println(plant.isGreen)
}

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun nullableExample() {
    // This code block will not be run, because AquariumPlant is null
    var plant: AquariumPlant? = null
    plant.pull()

    plant = AquariumPlant("Blue", 14)
    plant.pull()
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

class ExtensionsCompanion {
    companion object {}
}

fun ExtensionsCompanion.Companion.printCompanion() {
    println("companion")
}

class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection {
    fun Host.getConnectionString() {
        println(toString())         // calls Host.toString()
        println(this@Connection.toString())  // calls Connection.toString()
    }

    fun connect() {
        val host = Host("kotl.in")
        host.getConnectionString()   // calls the extension function
    }

    override fun toString(): String {
        super.toString()
        return "teste"
    }
}
