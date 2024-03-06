enum class Ammo(val damage: Int, val criticalHitChance: Int, val criticalDamageRatio: Int) {
    SOFT_BULLET(10, 30, 2),
    HARD_BULLET(20, 15, 3),
    GRANADE(30, 5, 4);


    fun currentDamage(damage: Int, criticalHitChance: Int, criticalDamageRatio: Int) : Int {
        return if (criticalHitChance.chanceTrigger()) {
            criticalDamageRatio * damage
        } else damage
    }
}

