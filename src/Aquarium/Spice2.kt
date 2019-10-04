package Aquarium

abstract class Teste2 {
    abstract fun welcome()

    var nomeNovo: String? = ""

    fun messageBaseClass() = "Eu sou a classe pai Teste e estou aqui para ajudar"

    fun getNome() {
        do {
            print("Olá, digite seu nome: ")

            nomeNovo = readLine()

        } while (nomeNovo.isNullOrEmpty())
    }

    companion object PAI {
        val congratulations = "Thank you"
    }
}

class Spice2(val name: String, val spiciness: String = "mild") : Teste2() {

    override fun welcome() {
        println("Seja bem-vindo, ${this.nomeNovo}. ${this.messageBaseClass()}.\n${PAI.congratulations}")
    }
}

