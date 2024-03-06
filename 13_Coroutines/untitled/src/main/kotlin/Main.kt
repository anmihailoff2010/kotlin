import kotlinx.coroutines.*
import kotlin.coroutines.*
val scope = CoroutineScope(Dispatchers.Default)
suspend fun main(args: Array<String>) {
    runBlocking {
        val calculation1 = async {
            try {
                withTimeout(1500) {
                    Fibonacci.take(556)
            }
        } catch (t: TimeoutCancellationException) {
            "The 556 fibonacci number is no result (calculation was too long)"
            }
        }
        val calculation2 = async {
            try {
                withTimeout(1500) {
                    Fibonacci.take(15656889)
                }
            } catch (t: TimeoutCancellationException) {
                "The 15656889 fibonacci number is no result (calculation was too long)"
            }
        }
        launch {
            var dot = 1
            while (calculation1.isActive || calculation2.isActive) {
                if (dot % 100 == 0) {
                    println(".")
                } else {
                    print(".")
                }
                delay(10)
                dot++
            }
        }
        println("Старт программы:")
        println("\n ${calculation1.await()} \n ${calculation2.await()}")
    }
}



