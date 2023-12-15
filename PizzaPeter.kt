class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) :
    PizzaCity(
        neapolitanPizzaPrice, romanPizzaPrice,
        sicilianPizzaPrice, tyroleanPizzaPrice,
    ), Drink {

    private var coffeeCount = 0
    private var uncoffeeCount = 0
    private var totalCoffee = 0.0

    private var neapolitanCoffeeCount = 0
    private var romanCoffeeCount = 0
    private var sicilianCoffeeCount = 0
    private var tyroleanCoffeeCount = 0


    override fun drinkSale(pizzaType: String) {
        println("Вы будете кофе?")
        println("1.Да\n2.Нет")
        when (readln()) {
            "1" -> {
                val coffeePrice = 200.0
                println("С ваc $coffeePrice рублей")
                coffeeCount++
                totalCoffee += coffeePrice
                when (pizzaType) {
                    "neapolitan" -> neapolitanCoffeeCount++
                    "roman" -> romanCoffeeCount++
                    "sicilian" -> sicilianCoffeeCount++
                    "tyrolean" -> tyroleanCoffeeCount++
                }
            }
            "2" -> {
                uncoffeeCount++
            }

        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петерубрге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петерубрге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сцилийской пиццы в Санкт-Петерубрге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петерубрге")
    }

    override fun showAddStatistics() {
        println("Количество проданных кофе: $coffeeCount")
        println("Общая прибыль с кофе: $totalCoffee")
        println("Процент людей, которые покупают кофе: ${((coffeeCount.toDouble() / (coffeeCount + uncoffeeCount)) * 100)}%")

        println("Количество кофе к неаполитанской пицце: $neapolitanCoffeeCount")
        println("Количество кофе к римской пицце: $romanCoffeeCount")
        println("Количество кофе к сицилийской пицце: $sicilianCoffeeCount")
        println("Количество кофе к тирольской пицце: $tyroleanCoffeeCount")

        val totalPizzaSales = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        println("Процент кофе к неаполитанской пицце: ${((neapolitanCoffeeCount.toDouble() / totalPizzaSales) * 100)}%")
        println("Процент кофе к римской пицце: ${((romanCoffeeCount.toDouble() / totalPizzaSales) * 100)}%")
        println("Процент кофе к сицилийской пицце: ${((sicilianCoffeeCount.toDouble() / totalPizzaSales) * 100)}%")
        println("Процент кофе к тирольской пицце: ${((tyroleanCoffeeCount.toDouble() / totalPizzaSales) * 100)}%")


        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice + totalCoffee

        println("Всего заработано денег: $money")
    }
}