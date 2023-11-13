fun main() {
    do {
        print("Введите первое число: ")
        val num1 = readlnOrNull()

        print("Введите второе число: ")
        val num2 = readlnOrNull()

        if (num1 != null && num2 != null) {
            try {
                val unite = num1 + num2
                val result = unite.toInt()
                if (result % 2 == 0){
                    println("Создать нечетное число невозможно")
                    break
                } else {
                    println("Нечетное число создано: $result")
                    break
                }

            } catch (e: NumberFormatException) {
                println("Ошибка: Введены некорректные числа. Пожалуйста, попробуйте снова.")
            }
        } else {
            println("Ошибка: Введенные значения не могут быть пустыми. Пожалуйста, попробуйте снова.")
        }
    } while (true)
}