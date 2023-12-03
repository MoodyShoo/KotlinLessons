import java.util.*

fun createStandardPortyTable(size: Int): Array<IntArray> {
    val portyTable = Array(size) { IntArray(size) }
    var counter = 1

    for (i in 0 until size) {
        for (j in 0 until size) {
            portyTable[i][j] = counter
            counter++
            if (counter > size * size) {
                counter = 1
            }
        }
    }
    return portyTable
}

fun createRandomPortyTable(size: Int): Array<IntArray> {
    val random = Random()
    val usedNumbers = mutableSetOf<Int>()

    val portyTable = Array(size) { IntArray(size) }

    for (i in 0 until size) {
        for (j in 0 until size) {
            var randomValue: Int
            do {
                randomValue = random.nextInt(999) + 1
            } while (randomValue in usedNumbers)

            usedNumbers.add(randomValue)
            portyTable[i][j] = randomValue
        }
    }

    return portyTable
}

fun printPortyTable(portyTable: Array<IntArray>) {
    // Вывод заголовка с буквами алфавита
    print("  ")
    for (i in 'А' until 'А' + portyTable.size) {
        print("${i.toString().padStart(3, ' ')} ")
    }
    println()

    // Вывод таблицы с буквами алфавита и числами
    for (i in portyTable.indices) {
        print("${('А' + i).toString().padStart(2, ' ')} ")
        for (j in portyTable.indices) {
            print("${portyTable[i][j].toString().padStart(3, '0')} ")
        }
        println()
    }
}

fun encryptMessage(message: String, helpSymbol: String, portyTable: Array<IntArray>): String {
    val paddedMessage = if (message.length % 2 != 0) message + helpSymbol else message
    val encryptedPairs = paddedMessage.chunked(2).map { pair ->
        val row = (pair[0].code - 'А'.code + portyTable.size) % portyTable.size
        val col = (pair[1].code - 'А'.code + portyTable.size) % portyTable.size
        val encryptedValue = portyTable[row][col]
        encryptedValue.toString().padStart(3, '0')
    }
    return encryptedPairs.joinToString(" ")
}

fun main() {
    print("Введите исходное сообщение: ")
    val inputMessage = readlnOrNull()?.uppercase() ?: ""
    print("Введите вспомогательный символ: ")
    val helpSymbol = readlnOrNull()?.uppercase() ?: ""
    print("Использовать типовую таблицу или случайную? (S/R): ")
    val choice = readlnOrNull()?.uppercase()

    when (choice){
        "S" -> {
            println("Типовая шифровальная таблица: ")
            val portyTable = createStandardPortyTable(31)
            printPortyTable(portyTable)

            val encryptedMessage = encryptMessage(inputMessage, helpSymbol, portyTable)
            println("Зашифрованное сообщение: $encryptedMessage")
        }
        "R" -> {
            println("Случайная шифровальная таблица: ")
            val portyTable = createRandomPortyTable(31)
            printPortyTable(portyTable)

            val encryptedMessage = encryptMessage(inputMessage, helpSymbol, portyTable)
            println("Зашифрованное сообщение: $encryptedMessage")
        }
    }
}

