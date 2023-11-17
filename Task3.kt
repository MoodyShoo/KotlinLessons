fun encrypt(inputText: String, keyword: String, alphabet: Map<Char, Int>): String {
    val repeatedKeyword = keyword.repeat((inputText.length / keyword.length) + 1)
    val keywordNumbers = repeatedKeyword.map { alphabet[it] ?: 0 }

    val messageNumbers = inputText.map { alphabet[it] ?: 0 }

    return messageNumbers.zip(keywordNumbers) { messageNum, keywordNum ->
        val sum = (messageNum + keywordNum)
        if (sum > 33) sum - 33 else sum
    }.map { number ->
        alphabet.entries.firstOrNull { it.value == number }?.key ?: ' '
    }.joinToString("")
}

fun decrypt(encryptedText: String, keyword: String, alphabet: Map<Char, Int>): String {
    val repeatedKeyword = keyword.repeat((encryptedText.length / keyword.length) + 1)
    val keywordNumbers = repeatedKeyword.map { alphabet[it] ?: 0 }

    val encryptedNumbers = encryptedText.map { alphabet[it] ?: 0 }

    return encryptedNumbers.zip(keywordNumbers) { encryptedNum, keywordNum ->
        val difference = (encryptedNum - keywordNum)
        if (difference <= 0) difference + 33 else difference
    }.map { number ->
        alphabet.entries.firstOrNull { it.value == number }?.key ?: ' '
    }.joinToString("")
}

fun main() {
    val alphabet = mapOf(
        'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25, 'Ж' to 12,
        'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29,
        'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27,
        'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17
    )

    println("Выберите действие\n1 - Зашифровать\n2 - Расшифровать")
    val choice = readlnOrNull()?.toInt()

    when (choice) {
        1 -> {
            print("Введите ключевое слово: ")
            val keyword =  readlnOrNull()?.uppercase() ?: ""
            print("Введите сообщение: ")
            val message =  readlnOrNull()?.uppercase() ?: ""
            val encryptedMessage = encrypt(message, keyword, alphabet)
            println("Зашифрованный текст: $encryptedMessage")
        }
        2 -> {
            print("Введите ключевое слово: ")
            val keyword = readlnOrNull()?.uppercase() ?: ""
            print("Введите зашифрованное сообщение: ")
            val encryptedMessage =  readlnOrNull()?.uppercase() ?: ""
            val decryptedMessage = decrypt(encryptedMessage, keyword, alphabet)
            println("Расшифрованный текст: $decryptedMessage")
        }
        else -> println("Некорректный выбор.")
    }
}
