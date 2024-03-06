import java.lang.Exception

open class Wheel(var currentPressure: Double) {

    fun GetPressure(pressure: Double) {

        if (pressure > 10.0 || pressure < 0.0)
            throw Except.IncorrectPressure()
        else currentPressure = pressure
    }

    fun CheckPressure() {

        if (currentPressure < 1.6 && currentPressure > 0.0) {
            throw Except.TooLowPressure()
        }
        else if (currentPressure in 1.6..2.5) {
            println("Нормальный уровень давления. Можете эксплуатировать.")
        }
        else if (currentPressure in 2.5..10.0)
            throw Except.TooHighPressure()
    }
}