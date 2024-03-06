import kotlin.math.roundToInt

class EuroConverter : CurrencyConverter {
    override val currencyCode = "EUR"
    private val converter = 75.33

    override fun convertRub(sum: Int) {
        val n = sum / converter
        val roundOf = (n * 100.0).roundToInt() / 100.0
        println("$sum рублей = $roundOf $currencyCode")
    }
}

