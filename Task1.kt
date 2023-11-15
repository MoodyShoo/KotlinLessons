fun main() {
    print("Введите кол-во строк массива: ")
    var rows = readln().toIntOrNull() ?:0

    while (rows <= 0){
        print("Ошибка ввода строк. Введите положительное число: ")
        rows = readln().toIntOrNull() ?:0
    }

    print("Введите кол-во столбцов массива: ")
    var cols = readln().toIntOrNull() ?:0

    while (cols <= 0){
        print("Ошибка ввода столбцов. Введите положительное число: ")
        cols = readln().toIntOrNull() ?:0
    }

    val array: Array<Array<Int>> = Array(rows) { Array(cols) { 0 } }
    val uniqueDigits = mutableSetOf<Int>()

    for (i in 0 ..< rows) {
        for (j in 0 ..< cols) {
            print("Введите трёхзначное число a[$i][$j]: ")
            var num = readln().toIntOrNull() ?:0

            while ( num !in 100..999) {
                println("Ошибка ввода. Пожалуйста, введите трёхзначное число.")
                print("Введите трёхзначное число a[$i][$j]: ")
                num = readln().toIntOrNull() ?:0
            }
            array[i][j] = num

            num.toString().forEach {
                uniqueDigits.add(it.toString().toInt())
            }
        }
    }

    for (row in array) {
        for (item in row) {
            print("$item ")
        }
        println()
    }

    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}