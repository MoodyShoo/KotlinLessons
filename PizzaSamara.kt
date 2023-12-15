class PizzaSamara(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) :
    PizzaCity(
        neapolitanPizzaPrice, romanPizzaPrice,
        sicilianPizzaPrice, tyroleanPizzaPrice,
    ), Drink, CheckPhoto, Sauce {

    private var showCheckCount = 0
    private var unshowCheckCount = 0
    private var totalDiscount = 0.0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1.Да\n2.Нет")
        when (readln()) {
            "1" -> {
                val discount = 50.0
                println("Вам будет скидка $discount рублей с покупки")
                showCheckCount++
                totalDiscount += discount
            }

            "2" -> {
                unshowCheckCount++
            }
        }
    }

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
                val coffeePrice = 150.0
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

    private var sauceCount = 0
    private var totalCheeseSauce = 0.0
    private var totalGarlicSauce = 0.0
    override fun sauceSale(){
        println("Будете соус?")
        println("1.Да\n2.Нет")
        when (readln()){
            "1" -> {
                println("Сырный или чесночный?")
                println("1.Сырный\n2.Чесночный")
                when(readln()){
                    "1" -> {
                        val cheeseSaucePrice = 40.0
                        println("С вас $cheeseSaucePrice рублей")
                        sauceCount++
                        totalCheeseSauce += cheeseSaucePrice
                    }
                    "2" -> {
                        val garlicSaucePrice = 50.0
                        println("С вас $garlicSaucePrice рублей")
                        sauceCount++
                        totalGarlicSauce += garlicSaucePrice
                    }
                }
            }
            "2" -> println("Без соуса")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Самаре")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Самаре")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сцилийской пиццы в Самаре")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Самаре")
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

        println("Количество показаных чеков: $showCheckCount")
        println("Общая сумма скидок: $totalDiscount")
        println("Процент людей, которые показывают чек: ${(showCheckCount.toDouble() / (showCheckCount + unshowCheckCount)) * 100}%")

        println("Соусов продано: $sauceCount")
        println("Выручка за сырный соус: $totalCheeseSauce")
        println("Выручка за чесночный соус: $totalGarlicSauce")


        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice + totalCoffee - totalDiscount + totalGarlicSauce + totalCheeseSauce

        println("Всего заработано денег: $money")
    }

}