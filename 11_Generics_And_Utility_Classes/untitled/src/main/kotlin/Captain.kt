class Captain : AbstractWarrior() {
    override val maxHealth = 70
    override val chanceToSave = 30
    override val accuracy = 70
    override val weapon = Weapons.createPistol()
    override var currentHealth = maxHealth
    override var isKilled = false
}
