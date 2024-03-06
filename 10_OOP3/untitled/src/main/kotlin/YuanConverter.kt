import kotlin.math.roundToInt

class YuanConverter : CurrencyConverter {
    override var currencyCode = "CNY"
    private val converter = 10.25

    override fun convertRub(sum: Int) {
        val n = sum / converter
        val roundOf = (n * 100.0).roundToInt() / 100.0
        println("$sum рублей = $roundOf $currencyCode")
    }
}
