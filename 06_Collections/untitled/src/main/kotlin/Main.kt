fun main(args: Array<String>) {
    println("Введите число:")
    var n: Int? = readLine()?.toIntOrNull() ?: return
    while (n!! <= 0) {
        println("Число $n - некорректно! Введите корректное число")
        n = readLine()?.toIntOrNull() ?: return
    }
    val phoneList = list(n)
    println(phoneList.filter { it.startsWith("+7") })
    val newSet = phoneList.toSet()
    println("Количество уникальных номеров - ${newSet.size}: $newSet")
    println("Длина всех уникальных номеров = ${newSet.sumOf { it.length }}")

    val phoneAndNameList = mutableMapOf<String, String>()
    newSet.forEach {
        println("Введите имя человека с номером $it:")
        val name = readLine().toString()
        phoneAndNameList.set(it, name)
    }
    phoneAndNameList.forEach { entries ->
        println("Абонент:${entries.value}.Номер телефона:${entries.key}.")
    }
}

fun list(n : Int) : MutableList<String> {
    val mutableList = mutableListOf<String>()
    for (j in 0 until n) {
        println("Введите номер телефона пользователя: ")
        val phoneNumber = readLine().toString()
        mutableList.add(phoneNumber)
    }
    return mutableList
}