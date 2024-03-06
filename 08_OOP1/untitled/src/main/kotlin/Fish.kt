class Fish(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {

    override fun move() {
        super.move()
        println("плывет")
    }

    override fun reproduction(): Animal {
        return super.reproduction()
        return Animal(energy, weight, maxAge, name)
    }
}