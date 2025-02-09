package Aula06

fun main() {

    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas are code blocks enclosed in curly braces.
    val result = items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

    println(result)


    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", {
            acc, i -> acc + " " + i
    })
    println(joinedToString)

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
    println(product)


    // The two parameters working of same form
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }

    val result2 = runTransformation(repeatFun) // OK
    println(result2)

}
