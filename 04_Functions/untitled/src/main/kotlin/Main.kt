fun main(args: Array<String>) {
    val symbolString = """F2p)v"y233{0->c}ttelciFc"""
    val numberOfSymbols = "Length of \"$symbolString\" - ${symbolString.length} symbols"
    println(numberOfSymbols)
    val firstPart = symbolString.take(12)
    println(firstPart)
    val secondPart = symbolString.takeLast(12)
    println(secondPart)
    val result = decodingFirstPart(firstPart) + decodingSecondPart(secondPart)
    println(result)
}

fun decodingFirstPart(firstPart : String): String {
    val replacement1 = shift(firstPart) {it + 1}
    val replacement2 = replacement1.replace('5', 's')
    val replacement3 = replacement2.replace('4', 'u')
    val replacement4 = shift(replacement3) {it - 3}
    val replacement5 = replacement4.replace("0", "o")
    return replacement5
}

fun decodingSecondPart(secondPart : String): String {
    val revers = secondPart.reversed()
    val replacement6 = shift(revers) {it - 4}
    val replacement7 = replacement6.replace('_', ' ')
    return replacement7
}

fun shift (shiftSource: String,
    shiftMethod: (Char) -> Char) : String {
    return shiftSource.map(shiftMethod).joinToString("")
}