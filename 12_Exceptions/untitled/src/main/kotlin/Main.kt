fun main(args: Array<String>) {

    val Wheel = Wheel(2.0)

    try {

        Wheel.GetPressure(3.0)
        Wheel.CheckPressure()
    }
    catch (E: Except.IncorrectPressure) {
        println("Критический уровень давления в колесе. Нельзя эксплуатировать колесо.")
    }
    catch (E: Except.TooHighPressure) {
        println("Достаточный уровень давления. Можете эксплуатировать.")
    }
    catch (E: Except.TooLowPressure) {
        println("Низкий уровень давления. Эксплуатация возможна, но нежелательна.")
    } finally {
        println("----------------------------------------------------------------")
    }
}