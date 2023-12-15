import kotlin.system.exitProcess

fun main() {

    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        167.5, 215.0
    )

    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )

    val pizzaSamara = PizzaSamara(
        150.0, 221.5,
        145.5, 190.0
    )

    var currentPizzaCity: PizzaCity

    while (true) {

        println("Добрый день! Выберите город")
        println("1.Москва\n2.Санкт-Петербург\n3.Самара\n0.Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaSamara
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1.Неаполитанская пицца\n2.Римская пицца\n3.Сицилийская пицца\n4.Тирольская пицца\n\n0.Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity, "neapolitan")
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity, "roman")
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity, "sicilian")
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity, "tyrolean")
        }

        "0" -> selectAddStatistics(currentPizzaCity)
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, name: String) {
    if (currentPizzaCity is CheckPhoto) currentPizzaCity.showCheckPhoto()
    if (currentPizzaCity is Drink) currentPizzaCity.drinkSale(name)
    if (currentPizzaCity is Sauce) currentPizzaCity.sauceSale()
}

fun selectAddStatistics(currentPizzaCity: PizzaCity){
    when(currentPizzaCity) {
        is CheckPhoto -> {
            currentPizzaCity.showStatistics()
            currentPizzaCity.showAddStatistics()
        }
        is Drink -> {
            currentPizzaCity.showStatistics()
            currentPizzaCity.showAddStatistics()
        }
        is Sauce -> {
            currentPizzaCity.showStatistics()
            currentPizzaCity.showAddStatistics()
        }
    }
}

