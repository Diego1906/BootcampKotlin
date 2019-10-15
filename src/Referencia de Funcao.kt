import java.io.File

fun main() {

    val testeRef = ::testeReferencia

    testeRef("Diego")

    testeRef.invoke("Outra forma de executar")

    val reader = File("").bufferedReader()
    reader.use {
        it.readLine()
    }
}

fun testeReferencia(desc: String) {
    println("Função chamada por referência $desc")
}

