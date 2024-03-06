class TV(val brand: String, val model: String, val diagonal: Int) {

    //Вывод информации о телевизоре
    fun tvInfo() {
        println("${brand} ${model} ${diagonal}\"")
    }

    //Создание рандомного списка каналов
    private val spisKan = Channels.getRandomChannels()

    //Вывод списка канолов (только для контроля)
    fun vivodSpiskaKanalov() {
        for (i in spisKan.indices) {
            println("${i + 1} - ${spisKan[i]}")
        }
    }

    //Переменная состояние телевизора (включен или выключен)
    var televizorVklyuchen = false
        private set

    //Включение телевизора
    fun on() {
        println("Включить телевизор ${brand}")
        televizorVklyuchen = true
    }

    //Выключение телевизора
    fun off() {
        println("Выключить телевизор ${brand}")
        televizorVklyuchen = false
    }

    //Состояние телевизора (включен или выключен)
    fun sostoyanieOnOff() {
        if (televizorVklyuchen == false)
            println("Телевизор ${brand} выключен")
        else
            println("Телевизор ${brand} включен")
    }

    //Переменная состояние звука
    private var zvuk = 0

    //Прибавление звука
    fun pribavlenieZvuka() {
        println("Прибавление звука у $brand на одну единицу")
        if (televizorVklyuchen == false) {
            println("Звук не прибавлен - телевизор выключен")
        } else if (zvuk < zvukMax) {
            zvuk += 1
            sostoyanieZvuka()
        } else println("Звук у $brand - $zvuk больше не прибавляется, т.к. он на максимуме")
    }

    //Убавление звука
    fun ubavlenieZvuka() {
        println("Убавление звука у $brand на одну единицу")
        if (televizorVklyuchen == false) {
            println("Звук не убавлен - телевизор выключен")
        } else if (zvuk > 0 ) {
            zvuk --
            sostoyanieZvuka()
        } else println("Звук у $brand - $zvuk больше не убавляется, т.к. он на минимуме")
    }

    //Состояние звука
    fun sostoyanieZvuka() {
        println ("У ${brand} звук - $zvuk")
    }

    //Переменная порядкового номера канала
    private var nomerKanala = 1

    //Переключение каналов на одну позицию вверх
    fun pereklyuchenieKanalaVverh() {
        televizorVklyuchen = true
        println("Переключение каналов $brand на одну позицию вверх")
        if (nomerKanala  < spisKan.size ) {
            nomerKanala ++
        } else nomerKanala = 1
        vivodKanala()
    }

    //Переключение каналов на одну позицию вниз
    fun pereklyuchenieKanalaVniz() {
        televizorVklyuchen = true
        println("Переключение каналов $brand на одну позицию вниз")
        if (nomerKanala  > 1 ) {
            nomerKanala --
        } else nomerKanala = spisKan.size
        vivodKanala()
    }

    //Переключение каналов вручную
    fun perekluchenieKanalaVruchnuyu() {
        televizorVklyuchen = true
        nomerKanala = (1..spisKan.size).random()
        println("Переключение каналов $brand вручную: выбран канал $nomerKanala")
        vivodKanala()
    }

    //Вывод текущего канала
    fun vivodKanala() {
        println("У $brand выбран канал: $nomerKanala - \"${spisKan[nomerKanala - 1]}\"")
    }

    //Максимальная громкость
    companion object {
        const val zvukMax = 5
    }
}