import kotlin.math.roundToInt

fun main() {
    Converters.get("USD").convertRub(100)
    Converters.get("EUR").convertRub(100)
    Converters.get("CNY").convertRub(100)

    Converters.get("GBP").convertRub(100)

    class GBP {
        val anonim = object : CurrencyConverter {
            override val currencyCode = "GBP"
            val converter = 85
            override fun convertRub(sum: Int) {
                val n = sum / converter!!
                val roundOf = (n * 100.0).roundToInt() / 100.0
                println("$sum рублей = $roundOf $currencyCode")
            }

            val listOfCurrencies = listOf(
                DollarConverter(),
                EuroConverter(),
                YuanConverter(),
                GBP()
            )
        }
    }
}

