fun main() {
    val cards = listOf<BankCard>(
        DebitCardSber(1000.0),
        DebitCardAlfa(5000.0),
        CreditCardVtb(5000.0,10000.0)
    )

    fun getStarted() {
        var index = 0
        var exit = false
        println(
            """
                Выберите карту:
                1. DebitCardSber
                2. DebitCardAlfa
                3. CreditCardVtb
                4. Выход
            """.trimIndent()
        )

        when(readLine()?.toIntOrNull() ?: 0) {
            0 -> println("Введите значение")
            1 -> index = 0
            2 -> index = 1
            3 -> index = 2
            4 -> exit = true
        }

        while (!exit) {
            println(
                """
                    Выберите действие:
                    1. Пополнить карту
                    2. Оплатить
                    3. Получить информацию о балансе
                    4. Получить информацию о доступных средствах
                    5. Назад
                """.trimIndent()
            )

            when (readLine()?.toIntOrNull() ?: 0) {
                0 -> println("Введите значение")
                1 -> cards[index].topUp()
                2 -> cards[index].pay()
                3 -> cards[index].getInfoBalance()
                4 -> cards[index].getInfoAboutAvailableFunds()
                5 -> getStarted()
            }
        }
    }
    getStarted()


//    val sber = DebitCardSber(1000.0, 0.009)
//    val alfa = DebitCardAlfa(10000.0)
//    val vtb = CreditCardVtb(100000.0, 1.0)
//
//    sber.topUp()
//    sber.pay()
//    sber.pay()
//    sber.pay()
//    sber.topUp()
//    sber.pay()
//    sber.pay()
//    sber.pay()
//    sber.topUp()
//    sber.pay()
//    sber.pay()
//    sber.pay()
//
//    alfa.topUp()
//    alfa.pay()
//    alfa.pay()
//    alfa.pay()
//    alfa.topUp()
//    alfa.pay()
//    alfa.pay()
//    alfa.pay()
//
//    vtb.topUp()
//    vtb.pay()
//    vtb.pay()
//    vtb.pay()
//    vtb.topUp()
//    vtb.pay()
//    vtb.pay()
//    vtb.pay()
}