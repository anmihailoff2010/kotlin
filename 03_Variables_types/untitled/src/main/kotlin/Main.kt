fun main(args: Array<String>) {
    val firstName: String = "Антон"
    val lastName: String = "Михайлов"
    var height: Double = 1.74
    val weight: Float = 75.6f
    val isChild: Boolean = height < 1.50 || weight < 40
    var info = "Моё имя: $firstName  \nМоя фамилия: $lastName  \nМой рост: $height м  \nМой вес: $weight кг  \nВы ребёнок?: $isChild"
    println(info)

    height = 1.49
    info = "Моё имя: $firstName  \nМоя фамилия: $lastName  \nМой рост: $height м  \nМой вес: $weight кг  \nВы ребёнок?: ${height < 1.50 || weight < 40}"
    println(info)
}