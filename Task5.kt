fun findIntegerExp(n: Int, x: Int): Int? {
    var y = 0
    var result = 1

    while (result < n) {
        result *= x
        y++
    }

    return if (result == n) y else null
}

fun main() {
    do {
        print("Введите целое число n: ")
        val nInput = readlnOrNull()

        print("Введите основание степени x: ")
        val xInput = readlnOrNull()

        if (nInput != null && xInput != null) {
            try {
                val n = nInput.toInt()
                val x = xInput.toInt()

                val exp = findIntegerExp(n, x)

                if (exp != null) {
                    println("Целочисленный показатель степени y: $exp")
                    break
                } else {
                    println("Целочисленный показатель не существует.")
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

