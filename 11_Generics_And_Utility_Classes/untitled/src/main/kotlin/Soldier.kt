class Soldier : AbstractWarrior() {
    override val maxHealth = 50
    override val chanceToSave = 20
    override val accuracy = 50
    override val weapon = Weapons.createMachineGun()
    override var currentHealth = maxHealth
    override var isKilled = false
}
