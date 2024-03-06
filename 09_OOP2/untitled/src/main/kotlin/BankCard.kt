import jdk.jfr.Percentage

abstract class BankCard(var balance: Double) {
    abstract fun topUp()
    abstract fun pay(): Boolean
    abstract fun getInfoBalance()
    abstract fun getInfoAboutAvailableFunds()
    protected abstract fun addCashBack(percentage: Double, sum: Double, buyFromPartner: Boolean)

}
