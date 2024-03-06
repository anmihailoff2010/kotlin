object Channels {
    internal val spisokKanalov = listOf(
        "Первый",
        "Россия 1",
        "Россия 24",
        "Россия Культура",
        "СТС",
        "ТНТ",
        "ТВ 3",
        "Кино ТВ",
        "Киносемья",
        "Матч ТВ"
    )

    fun getRandomChannels () : List<String> {
        val peremeshaniySpisok = spisokKanalov.shuffled()
        val kolichestvoKanalov = (4..8).random()
        val randomniySpisok = List(kolichestvoKanalov) { index -> peremeshaniySpisok[index] }
        return randomniySpisok
    }
}