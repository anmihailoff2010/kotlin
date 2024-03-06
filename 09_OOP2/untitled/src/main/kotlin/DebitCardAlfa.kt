class DebitCardAlfa(balance: Double) : DebitCard(balance) {

        private var bonus: Double = 0.0

    fun pay(buy: Double, buyIn5ka: Boolean): Boolean {
        return if (super.pay()) {
            bonus += if (buyIn5ka) {
                when (buy) {
                    in 1.0.. 5000.0 -> 0.025 * buy
                    in 5000.0 .. 10000.0 -> 0.3 * buy
                    else -> 0.4 * buy
                }
            } else {
                0.01 * buy
            }
            true
        } else false
    }
    override fun getInfoAboutAvailableFunds () {
        val availableFunds: Double = balance + bonus
        println("Все доступные средства $availableFunds")
    }
}