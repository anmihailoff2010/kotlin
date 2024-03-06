class Bird(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {

    override fun move() {
        super.move()
        println("летит")
    }

    override fun reproduction(): Animal {
        return super.reproduction()
        return Animal(energy, weight, maxAge, name)
    }
}