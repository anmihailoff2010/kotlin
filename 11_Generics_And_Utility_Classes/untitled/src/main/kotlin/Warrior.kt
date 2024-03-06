interface Warrior {
    var isKilled: Boolean
    val chanceToSave: Int

    fun attack(warrior: Warrior)
    fun getDamage(damage: Int)
}