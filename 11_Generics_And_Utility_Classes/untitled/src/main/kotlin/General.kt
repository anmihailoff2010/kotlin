class General : AbstractWarrior() {
    override val maxHealth = 100
    override val chanceToSave = 40
    override val accuracy = 90
    override val weapon = Weapons.createRifle()
    override var currentHealth = maxHealth
    override var isKilled = false
}
