import kotlin.random.Random
import kotlin.random.nextInt

open class Animal(
    protected var energy: Int,
    protected var weight: Int,
    var maxAge: Int,
    var name: String
) {

    protected var age: Int = 1

    val isTooOld: Boolean
        get() = age >= maxAge

    val canMove: Boolean
        get() = energy >= 5 && weight >= 2

    fun sleep() {
        if (!isTooOld) {
            energy += 5
            age += 1
            println("$name спит. $age лет сейчас.")
        }
    }

    fun eat() {
        energy += 3
        weight += 1
        tryIncrementAge()
        println("$name ест")
    }

    open fun move() {
        energy -= 5
        weight += 1
        println("$name передвигается")
        if (tryIncrementAge()) println("$age лет сейчас.") else println()
    }

    open fun reproduction(): Animal {
        val child = Animal(Random.nextInt(1..10), Random.nextInt(1..5), maxAge, name)

        println("$name родился (энергия = ${child.energy}, вес = ${child.weight}, максимальный возраст = ${maxAge}).")
        return child
    }

    private fun tryIncrementAge(): Boolean {
        return if (Random.nextBoolean() && !isTooOld) {
            age += 1
            true
        } else false
    }
}