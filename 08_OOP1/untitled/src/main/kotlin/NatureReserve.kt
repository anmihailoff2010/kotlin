import kotlin.random.Random

class NatureReserve () {
    var animals = mutableListOf(
            Bird(energy = 5, weight = 1, maxAge = 5, name = "Попугай"),
            Bird(energy = 7, weight = 3, maxAge = 7, name = "Орел"),
            Bird(energy = 3, weight = 5, maxAge = 7, name = "Ястреб"),
            Bird(energy = 8, weight = 9, maxAge = 8, name = "Ворона"),
            Bird(energy = 4, weight = 2, maxAge = 4, name = "Воробей"),

            Fish(energy = 8, weight = 2, maxAge = 4, name = "Карась"),
            Fish(energy = 2, weight = 3, maxAge = 5, name = "Акула"),
            Fish(energy = 4, weight = 1, maxAge = 3, name = "Окунь"),

            Dog(energy = 9, weight = 6, maxAge = 9, name = "Овчарка"),
            Dog(energy = 8, weight = 9, maxAge = 12, name = "Хаски"),

            Animal(energy = 4, weight = 8, maxAge = 8, name = "Жираф"),
            Animal(energy = 6, weight = 2, maxAge = 5, name = "Зебра")
        )

    fun lifeCycle() {
        println("Введите количество жизненных циклов")
        val n = readlnOrNull()?.toInt()
        for (a in 0..n!!) {
            for (i in animals.indices) {
                when((1..4).random()) {
                    1 -> animals[i].move()
                    2 -> animals.add(animals[i].reproduction())
                    3 -> animals[i].eat()
                    4 -> animals[i].sleep()
                }
            }
            animals.removeAll { animals -> animals.isTooOld }
            if (animals.isEmpty()) {
                println("В заповеднике не осталось животных")
                break
            }
            println("Животных в заповеднике: ${animals.size}")
        }
    }
}

