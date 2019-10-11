fun main() {
    val amor = Amor()

    while (!amor.jaGozou())
        println("... s2 ... Amor EU TE AMO... É maravilhoso fazer amor com você ... s2 ...")
}

class Amor {

    private var penetracoes = 1

    fun jaGozou() = fazerAmor()

    private fun fazerAmor(): Boolean {
        colocarPiru()
        return retirarPiru()
    }

    private fun colocarPiru() {
        println("Ta gostoso Demais... UOLLLLLLL.\n\n$penetracoes° penetrada...")
    }

    private fun retirarPiru(): Boolean {
        println("Sua Delícia... =)")
        return vaiGozar()
    }

    private fun vaiGozar(): Boolean {
        setPenetracoes()
        return if (penetracoes > 5) true else false
    }

    private fun setPenetracoes() {
        penetracoes++
    }
}