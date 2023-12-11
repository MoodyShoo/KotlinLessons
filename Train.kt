class Train {
    class Wagons {

        val createWagon: Int
            get() {
                val capacity = (5..25).random()
                return capacity
            }

        class Passengers {
            val sellTickets: Int
                get() {
                    val sold = (5..201).random()
                    return sold
                }
        }

    }

    class Direction {

        private val cities = listOf(
            "Санкт-Петербург",
            "Москва",
            "Сочи",
            "Владивосток",
            "Тверь",
            "Пушкин",
            "Новгород",
            "Смоленск",
            "Самара",
            "Саратов",
            "Брянск",
            "Краснодар",
            "Новосибирск",
            "Хабаровск",
            "Геленджик",
        )

        val generateRoute: String
            get() {
                val city1 = cities.random()
                var city2 = cities.random()

                while (city1 == city2) {
                    city2 = cities.random()
                }
                return "$city1 - $city2"
            }
    }
}


fun main() {
    var runProgram = true

    do {
        println("Выберите действие")
        println("Exit - Выход из программы")
        println("Create - Создать новый поезд")
        val choice = readlnOrNull()?.lowercase()

        when (choice) {

            "exit" -> runProgram = false

            "create" -> {
                println("Шаг №1. Создать направление")
                val direction = Train.Direction().generateRoute
                println("Маршрут поезда: $direction")
                println()

                println("Шаг №2. Продать билеты")
                val tickets = Train.Wagons.Passengers().sellTickets
                println("Продано билетов: $tickets")
                println()

                println("Шаг №3. Собрать состав")
                var total = 0
                var i = 0

                while (total < tickets) {
                    i += 1
                    val wagcap = Train.Wagons().createWagon
                    total += wagcap
                    println("Вагон номер $i вместимостью $wagcap пассажиров")
                }
                println()

                println("Поезд $direction, состоящий из $i вагонов отправлен")
            }
            else -> println("Ошибка. Выберите корректное действие")
        }
        println()
    } while (runProgram)
}