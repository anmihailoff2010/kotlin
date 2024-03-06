sealed class Except {

    class TooHighPressure(message: String = "Слишком высокое давление"): Exception(message) {
        init {
            Exception(message)
        }
    }

    class TooLowPressure(message: String = "Слишком низкое давление"): Exception(message) {
        init {
            Exception(message)
        }
    }

    class IncorrectPressure(message: String = "Недопустимый уровень давления"): Exception(message) {
        init {
            Exception(message)
        }
    }
}