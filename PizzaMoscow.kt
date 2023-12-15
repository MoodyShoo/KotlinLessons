class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) :
    PizzaCity(
        neapolitanPizzaPrice, romanPizzaPrice,
        sicilianPizzaPrice, tyroleanPizzaPrice,
    ), CheckPhoto {

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

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сцилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    override fun showAddStatistics() {
        println("Количество показаных чеков: $showCheckCount")
        println("Общая сумма скидок: $totalDiscount")
        println("Процент людей, которые показывают чек: ${(showCheckCount.toDouble() / (showCheckCount + unshowCheckCount)) * 100}%")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice - totalDiscount

        println("Всего заработано денег: $money")
    }
}