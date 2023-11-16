fun symcheck(arr: Array<Array<Int>>): Boolean {
    for (i in 0 ..< 5){
        for (j in 0 ..< 5)
            if(arr[i][j] != arr[j][i])
                return false
    }
    return true
}

fun main(){
    val arr: Array<Array<Int>> = Array(5) { Array(5) { 0 } }

    for (i in 0 ..< 5){
        for (j in 0 ..< 5){
            var validInput = false
            while (!validInput) {
                try {
                    print("Введите элемент массива a[$i][$j]: ")
                    arr[i][j] = readln().toInt()
                    validInput = true
                } catch (e: NumberFormatException) {
                    println("Ошибка: Введите корректное число.")
                }
            }
        }
    }

    println("Введенный массив:")
    for (row in arr) {
        for (item in row) {
            print("$item ")
        }
        println()
    }

    val result = symcheck(arr)
    println(if (result) "Массив симетричен относительно главной диагонали" else "Массив не симетричен")
}