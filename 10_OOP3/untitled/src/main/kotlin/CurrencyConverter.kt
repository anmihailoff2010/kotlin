import kotlin.math.roundToInt

interface CurrencyConverter {
    val currencyCode: String
    fun convertRub(sum: Int)
}

