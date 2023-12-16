import kotlin.random.Random

fun main() {
    println(" ______________________________________")
    println("|___________BULLS__AND__COWS___________|")

    val secretNumber = generateUniqueNumber()
    println("Компьютер загадал число.Попробуй угадать")

    var attempts = 0

    while (true) {
        print("Введите ваш вариант: ")
        val guess = readlnOrNull()?.trim()

        if (guess == null || guess.length != 4 || !guess.all { it.isDigit() }) {
            println("Пожалуйста, введите четыре цифры.")
            continue
        }


        attempts++

        val bullsAndCows = calculateBullsAndCows(secretNumber, guess.map { it.toString().toInt() })

        println("Быки: ${bullsAndCows.first}, Коровы: ${bullsAndCows.second}")

        if (bullsAndCows.first == 4) {
            println("Победа! Вы угадали число ${secretNumber.joinToString("")} за $attempts попыток.")
            break
        }
    }
}

fun generateUniqueNumber(): List<Int> {
    val generatedNumbers = mutableListOf<Int>()

    generatedNumbers.add(0)

    while (generatedNumbers.size < 4) {
        val symbol = Random.nextInt(0, 10)
        if (!generatedNumbers.contains(symbol)) {
            generatedNumbers.add(symbol)
        }
    }

    return generatedNumbers
}

fun calculateBullsAndCows(secret: List<Int>, guess: List<Int>): Pair<Int, Int> {
    var bulls = 0
    var cows = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            bulls++
        } else if (secret.contains(guess[i])) {
            cows++
        }
    }

    return Pair(bulls, cows)
}
