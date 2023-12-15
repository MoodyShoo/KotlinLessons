abstract class PizzaCity(
    internal val neapolitanPizzaPrice: Double,  internal val romanPizzaPrice: Double,
    internal val sicilianPizzaPrice: Double,  internal val tyroleanPizzaPrice: Double,
) {
    internal var neapolitanPizzaCount = 0
    internal var romanPizzaCount = 0
    internal var sicilianPizzaCount = 0
    internal var tyroleanPizzaCount = 0


    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()


    fun showStatistics(){
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

    }

    abstract fun showAddStatistics()

}