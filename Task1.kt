fun main() {
    var input: String?

    do{
        print("Введите строку: ")
        input = readlnOrNull()

        if (input.isNullOrEmpty()){
           println("Ошибка: Введите непустую строку")
        }
    } while (input.isNullOrEmpty())

    var result = ""
    var count = 1

    for (i in 1 until input.length)
    {
        if (input[i] == input[i-1]) {
            count++
        } else {
            result += if (count > 1) "${input[i - 1]}$count" else input[i-1]
            count = 1
        }
    }

    result += if(count > 1) "${input.last()}$count" else input.last()
    println("Результат: $result")
}
