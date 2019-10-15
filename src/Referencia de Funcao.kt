
fun main() {

    val testeRef = ::testeReferencia

    testeRef("Diego")

    testeRef.invoke("Outra forma de executar")
}

fun testeReferencia(desc: String){
    println("Função chamada por referência $desc")
}

