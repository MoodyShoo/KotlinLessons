import kotlin.random.Random

fun playGame(playerChoice: String) {
    val computerChoice = generateComputerChoice()
    println("Компьютер выбрал: $computerChoice")
    println("Вы выбрали: $playerChoice")

    val result = determineWinner(playerChoice, computerChoice)

    when (result) {
        0 -> println("Ничья! Попробуйте еще раз.")
        1 -> println("Вы победили!")
        -1 -> println("Вы проиграли. Попробуйте еще раз.")
    }
}

fun generateComputerChoice(): String {
    val choices = listOf("Камень", "Ножницы", "Бумага")
    return choices[Random.nextInt(choices.size)]
}

fun determineWinner(playerChoice: String, computerChoice: String): Int {
    return when {
        playerChoice == computerChoice -> 0
        (playerChoice == "Камень" && computerChoice == "Ножницы") ||
                (playerChoice == "Ножницы" && computerChoice == "Бумага") ||
                (playerChoice == "Бумага" && computerChoice == "Камень") -> 1

        else -> -1
    }
}

fun main() {
    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")

    while (true) {
        println("Выберите действие:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")
        println("0 - Выйти из игры")

        val playerChoice = readlnOrNull()?.toInt()

        when (playerChoice) {
            1 -> playGame("Камень")
            2 -> playGame("Ножницы")
            3 -> playGame("Бумага")
            0 -> {
                println("Игра завершена. До свидания!")
                return
            }
            else -> println("Некорректный выбор. Попробуйте еще раз.")
        }
    }
}



