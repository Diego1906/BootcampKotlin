package Aula05_Fundamental_Kotlin

fun main(args: Array<String>) {

    println("*******************************")
    println("Gato")
    println("*******************************")
    val gato = Mascote<Gato>(Gato("Siâmes"))
    println("A raça do gato é ${gato.animal.raca}.")
    gato.animal.tipoComida("ração")
    gato.animal.miar()
    println("Quando o gato mia ele pode estar com fome.")
    print("O tipo de comida do gato é ${gato.animal.getAlimento()}. ")
    gato.animal.alimentar()
    print("Hora do banho. ")
    gato.animal.tipoBanho()
    print("O gato saiu correndo, por que? ")
    gato.animal.correr()

    println("*******************************")
    println("Cachorrro")
    println("*******************************")
    val cachorro = Mascote<Cachorro>(Cachorro("Yorkshire"))
    println("A raça do cachorro é ${cachorro.animal.raca}.")
    cachorro.animal.tipoComida("ração")
    cachorro.animal.latir()
    println("Quando o cachorro lati ele está querendo se comunicar.")
    print("O tipo de comida do cachorro é ${cachorro.animal.getAlimento()}. ")
    cachorro.animal.alimentar()
    print("Hora do banho.")
    cachorro.animal.tipoBanho()
    print("Os cachorros gostam de brincar e eles correm muito. ")
    cachorro.animal.correr()
}

class Carro(val name: String)


/**************************************************
 * TESTE USANDO GENERICS COM CLASSE BASE, SUBCLASSES
 * E CLASSE COM TIPO "T" GENÉRICO
 **************************************************/
class Mascote<T : Animal>(val animal: T)

open class Animal(val raca: String) {

    private lateinit var alimento: String

    fun tipoComida(alimento: String) {
        this.alimento = alimento
    }

    fun getAlimento() = alimento

    open fun tipoBanho() {}
    open fun alimentar() {}
    open fun correr() {}
}

class Gato(raca: String) : Animal(raca) {
    override fun tipoBanho() {
        println("Usar shampoo anti-pulgas que não agrida a pele e fortaleça os pelos.")
    }

    override fun alimentar() {
        println("Colocar uma porção de 100 gramas a cada 3 horas.")
    }

    override fun correr() {
        println("Ele corre mais depressa quando está assustado.")
    }

    fun miar() {
        println("Miau")
    }
}

class Cachorro(raca: String) : Animal(raca) {
    override fun tipoBanho() {
        println("Usar shampoo que deixa o pelo liso e brilhoso.")
    }

    override fun alimentar() {
        println("Colocar uma porção de 150 gramas a cada 2 horas e meia.")
    }

    override fun correr() {
        println("Ele corre atrás da bola quando está bricando ou atrás de alguém quando está nervoso.")
    }

    fun latir() {
        println("Au-au")
    }
}