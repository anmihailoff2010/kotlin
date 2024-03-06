class Player(cardsNumber: Int) {

    val cards = List(cardsNumber) { Card().card }
    fun printCards(){
        val cards = cards
        for (card in cards) {
            println("----------------------------------------")
            for (line in card) {
                println("${line.joinToString (" | ")} \t")
            }
            println("----------------------------------------")
        }
    }
}
