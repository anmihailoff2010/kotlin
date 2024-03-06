class Dog(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {

    override fun move() {
        super.move()
        println("бежит")
    }

    override fun reproduction(): Animal {
        return super.reproduction()
        return Animal(energy, weight, maxAge, name)
    }
}