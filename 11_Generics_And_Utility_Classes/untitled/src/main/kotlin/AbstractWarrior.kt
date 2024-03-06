abstract class AbstractWarrior : Warrior {
    abstract val maxHealth: Int // максимальный уровень здоровья
    abstract override val chanceToSave: Int // уклонение - шанс избежать попадания
    abstract val accuracy: Int // точность - вероятность попадания
    abstract val weapon: AbstractWeapon // оружие
    abstract var currentHealth: Int // текущий уровень здоровья

    override fun attack(warrior: Warrior) {
        val getBulletsResult = runCatching {weapon.getBullet()}

        if (getBulletsResult.isSuccess) {
            val bullets: List<Ammo> = getBulletsResult.getOrThrow()
            for (bullet in bullets) {
                if (accuracy.chanceTrigger() && !warrior.chanceToSave.chanceTrigger()) {
                    warrior.getDamage(bullet.currentDamage(bullet.damage, bullet.criticalHitChance, bullet.criticalDamageRatio))
                }
            }
        }
        if (getBulletsResult.isFailure) {
            println(getBulletsResult.exceptionOrNull())
            weapon.recharge()
            println("Недостаточно патронов, пропускаю ход и перезаряжаюсь")
        }
    }

    override fun getDamage(damage: Int) {
        currentHealth -= damage
        if (currentHealth <= 0) isKilled = true
    }
}
