fun group(words: List<String>): List<List<String>> {
    val anagramGroups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = String(word.toCharArray().sortedArray())
        anagramGroups.getOrPut(sortedWord) { mutableListOf() }.add(word)
    }

    return anagramGroups.values.toList()
}

fun main() {
    println("Введите массив слов через пробел:")
    val userInput = readlnOrNull()

    if (userInput.isNullOrBlank()) {
        println("Ошибка: Введите непустой массив слов.")
        return
    }

    val wordList = userInput.split(" ")

    if (wordList.any { it.isBlank() }) {
        println("Ошибка: Введите корректные слова.")
        return
    }

    val result = group(wordList)

    println("Группы анаграмм:")
    for (group in result) {
        println(group.joinToString(", "))
    }
}

