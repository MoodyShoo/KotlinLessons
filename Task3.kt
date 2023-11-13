fun convert(number: Int): String {
    return Integer.toBinaryString(number)
}

fun main() {
    do {
        print("Введите натуральное число: ")
        val input = readlnOrNull()

        try {
            val number = input?.toInt()
            if (number != null && number > 0) {
                println("Вы ввели положительное натуральное число: $number")
                val binary = convert(number)
                println("Двоичный вид числа $number: $binary")
            } else {
                println("Пожалуйста, введите корректное натуральное число.")
            }
        } catch (e: NumberFormatException) {
            println("Ошибка: Введено не число. Пожалуйста, попробуйте снова.")
        }
    } while (input.isNullOrBlank() || input.toIntOrNull() == null || input.toInt() <= 0)


}
