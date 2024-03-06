import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import java.lang.Thread.yield
import java.math.BigInteger

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        val fb1 = scope.async{
            println("Вычисляем число Фибоначчи № $n")
            fb(n)
        }
        delay(1000)
        fb1.cancelAndJoin()
        return fb1.await()
    }

    suspend fun fb(n: Int): BigInteger {
        val f1 = 0L
        val f2 = 1L
        val f3 = 1L
        val f1b = f1.toBigInteger()
        var f2b = f2.toBigInteger()
        var f3b = f3.toBigInteger()
        if (n == 0) {
            return f1b
        } else {
            for (i in 2 .. n -2) {
                yield()
                val fn: BigInteger = f2b + f3b
                f2b = f3b
                f3b = fn
            }
            return f3b
        }
    }
}