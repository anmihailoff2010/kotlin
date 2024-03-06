fun main(args: Array<String>) {
    println("Введите число:")
    var n: Int? = readLine()?.toIntOrNull() ?: return
    while (n!! <= 0) {
        println("Число $n - некорректно! Введите корректное число")
        n = readLine()?.toIntOrNull() ?: return
    }
    println(fibonacci(n))
}

fun fibonacci(n: Int): Int {
    var n1 = 1
    var n2 = 1

    for (i: Int in 3..n) {
        val n = n1
        n1 += n2
        n2 = n
    }
    return n1
}