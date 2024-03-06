open class DebitCard(balance: Double) : BankCard(balance) {
    private var bonus: Double = 0.0
    override fun topUp() {
        println("\nВставьте наличные в банкомат или введите сумму.")
        val cash = readLine()?.toIntOrNull()
        if (cash != null) {
            balance += cash
            println("Пополнение прошло успешно.")
        } else println("Наличные деньги не были внесены.")
        getInfoBalance()
    }

    override fun pay(): Boolean {
        var result = false
        println("\nВведите сумму платежа.")
        val price = readLine()?.toIntOrNull()
        if (price != null) {
            if (price > balance) println("На вашей карте недостаточно средств")
            else {
                balance -= price
                println("Покупка $price руб. прошла успешно.")
                result = true
            }
        } else println("Указана неверная сумма.")
        getInfoBalance()
        return result
    }

    override fun getInfoBalance() {
        println("Ваш баланс: $balance руб.")
    }

    override fun getInfoAboutAvailableFunds() {
        val availableFunds: Double = balance + bonus
        println("Все доступные средства $availableFunds руб.")
    }

    override fun addCashBack(percentage: Double, sum: Double, buyFromPartner: Boolean) {
        balance += percentage * sum
    }

}
