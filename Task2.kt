fun main() {
    var input: String?

    do {
        print("Введите строку: ")
        input = readlnOrNull()

        if (input.isNullOrEmpty()) {
            println("Ошибка: Введите непустую строку")
            input = null
        }
    } while (input.isNullOrEmpty())

    val charCounts = mutableMapOf<Char, Int>()

    for (char in input) {
        charCounts[char] = charCounts.getOrDefault(char, 0) + 1
    }

    val sortedCharCounts = charCounts.toList().sortedBy { it.first }

    println("Результат:")
    for ((char, count) in sortedCharCounts) {
        println("$char - $count")
    }
}