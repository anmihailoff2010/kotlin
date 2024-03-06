class DebitCardSber(balance: Double) : DebitCard(balance) {

    private var bonus: Double = 0.0
    fun pay(buy: Double, buyInCertainCategory: Boolean, buyFromPartner: Boolean): Boolean {
        return if (super.pay()) {
            if (buyInCertainCategory && !buyFromPartner) addCashBack(0.2, buy, buyFromPartner = false)
            if (buyFromPartner) addCashBack(0.5, buy, buyFromPartner = true)
            true
        } else false
    }

    fun percentage(year: Double) {
        balance += 0.05 * year
    }

    override fun getInfoAboutAvailableFunds () {
        val availableFunds: Double = balance + bonus
        println("Все доступные средства $availableFunds")
    }
}