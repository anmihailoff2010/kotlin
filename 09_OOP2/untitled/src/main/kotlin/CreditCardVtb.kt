class CreditCardVtb(balance: Double, creditLimit: Double) : CreditCard(balance, creditLimit){

    fun pay(buy: Double, buyInCertainCategory: Boolean): Boolean {
        return if (super.pay()) {
            if (buyInCertainCategory) addCashBack(0.5, buy, buyFromPartner = false)
            true
        } else false
    }
}