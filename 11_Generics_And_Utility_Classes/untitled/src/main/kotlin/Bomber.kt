class Bomber : AbstractWarrior() {
    override val maxHealth = 70
    override val chanceToSave = 10
    override val accuracy = 30
    override val weapon = Weapons.createLauncher()
    override var currentHealth = maxHealth
    override var isKilled = false
}