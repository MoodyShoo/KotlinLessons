fun main() {
    do {
        print("Введите выражение (ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ): ")
        val input = readlnOrNull()

        if (input != null) {
            val inputParts = input.split(" ")

            if (inputParts.size == 3) {
                try {
                    val num1 = inputParts[0].toDouble()
                    val num2 = inputParts[1].toDouble()
                    val operation = inputParts[2]

                    val result = when (operation) {
                        "+" -> num1 + num2
                        "-" -> num1 - num2
                        "*" -> num1 * num2
                        "/" -> num1 / num2
                        else -> {
                            println("Ошибка: Неверная операция. Пожалуйста, используйте +, -, *, /.")
                            continue
                        }
                    }

                    println("Результат: $result")
                    break

                } catch (e: NumberFormatException) {
                    println("Ошибка: Введены некорректные числа или операция. Пожалуйста, попробуйте снова.")
                }
            } else {
                println("Ошибка: Некорректный формат ввода. Пожалуйста, используйте ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ.")
            }
        }
    } while (true)
}
