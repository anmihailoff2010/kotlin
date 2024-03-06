class Card {

    var card = makeCard()

    fun makeCard(): MutableList<List<Int>> {
        val dopList = (1..90).toList().shuffled()
        val card: MutableList<List<Int>> = MutableList(3){ List(4) { 0 } }
        card[0] += dopList.subList(0, 5)
        card[0] = card[0].shuffled()
        card[1] += dopList.subList(6, 11)
        card[1] = card[1].shuffled()
        card[2] += dopList.subList(12, 17)
        card[2] = card[2].shuffled()
        return card
    }
}
