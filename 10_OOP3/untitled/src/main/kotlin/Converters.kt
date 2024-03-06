import kotlin.math.roundToInt

object Converters {

    val listOfCurrencies = listOf(
        DollarConverter(),
        EuroConverter(),
        YuanConverter()
    )

    fun get(currencyCode: String): CurrencyConverter {
        listOfCurrencies.forEach {
            if (it.currencyCode.uppercase() == currencyCode) return it
        }
        return object : CurrencyConverter {
            override var currencyCode = currencyCode.uppercase()
            override fun convertRub(sum: Int) = println("Такой валюты нет в списке $currencyCode")
        }
    }
}

