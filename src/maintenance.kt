fun main() {
    car("Fiesta", 2015, "Branca")
    trocarOleo(6, 9850)
    println(lavarCarro("Limpo"))
}

val car: (String, Int, String) -> Unit = { nome, ano, cor ->
    println(
        if (nome == "Onix") "Chevrolet $nome ano $ano cor $cor"
        else "Veículo de outra marca"
    )
}

fun trocarOleo(qtdeMeses: Int = 0, km: Int = 0) {
    when {
        qtdeMeses in 1..6 && km <= 10000 -> {
            println("Ainda você pode rodar")
        }
        qtdeMeses > 6 -> {
            println("Passou da hora de trocar o óleo")
        }
    }
}

fun lavarCarro(estadoVeículo: String): String {
    return if (estadoVeículo == "sujo") "Lavar carro" else "O carro está limpo"
}
