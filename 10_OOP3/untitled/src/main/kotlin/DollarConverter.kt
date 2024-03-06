import kotlin.math.roundToInt

class DollarConverter : CurrencyConverter {
    override var currencyCode = "USD"
    private val converter = 69.13

    override fun convertRub(sum: Int) {
        val n = sum / converter
        val roundOf = (n * 100.0).roundToInt() / 100.0
        println("$sum рублей = $roundOf $currencyCode")
    }
}

