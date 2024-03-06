open class CreditCard(balance: Double, private val creditLimit: Double) : BankCard(balance) {
    var ownFunds: Double = balance
    var creditFunds: Double = creditLimit
    override fun topUp() {
        println("\nВставьте наличные в банкомат или введите сумму.")
        val cash = readLine()?.toIntOrNull()
        if (cash != null) {
            creditFunds += cash
            val overCharge: Double = maxOf(0.0, creditFunds - creditLimit)
            ownFunds += overCharge
            creditFunds = minOf(creditLimit, creditFunds)
            println("Пополнение $cash руб. прошло успешно.")
        } else println("Наличные деньги не были внесены.")
        getInfoAboutAvailableFunds()
    }

    override fun pay(): Boolean {
        var result = false
        println("\nВведите сумму платежа.")
        val price = readLine()?.toIntOrNull()
        if (price != null) {
            if (price > ownFunds + creditFunds) println("На вашей карте недостаточно средств.")
            else {
                ownFunds -= price
                val overDraft: Double = minOf(0.0, ownFunds)
                creditFunds += overDraft
                ownFunds = maxOf(0.0, ownFunds)
                println("Покупка $price руб. прошла успешно.")
                result = true
            }
        } else println("Указана неверная сумма")
        getInfoAboutAvailableFunds()
        return result
    }

    override fun getInfoBalance() {
        println("Ваш баланс: ${ownFunds + creditFunds} руб.")
    }

    override fun getInfoAboutAvailableFunds() {
        val availableFunds: Double = balance
        println("Все доступные средства $availableFunds руб.")
    }

    override fun addCashBack(percentage: Double, sum: Double, buyFromPartner: Boolean) {
        if (creditFunds < creditLimit) {
            if (creditFunds + percentage * sum > creditLimit) {
                ownFunds = percentage * sum - (creditLimit - creditFunds)
                creditFunds = creditLimit
            } else {
                creditFunds += percentage * sum
            }
        } else {
            ownFunds += percentage * sum
        }
    }

}