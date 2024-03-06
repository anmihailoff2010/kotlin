import java.util.Random
abstract class AbstractWeapon {
    abstract val maxCountInCharger: Int
    abstract val fireType: FireType
    abstract var charger: Stack<Ammo>
    abstract var isEmptyCharger: Boolean
    abstract val ammoType: Ammo

    private fun createBullet() : Ammo {
        return ammoType

    }
    fun recharge() {
        charger = Stack()
        for (n in 1..maxCountInCharger) {
            charger.push(createBullet())
        }
        isEmptyCharger = false
    }
    fun getBullet() : List<Ammo> {
        val listOfBullet: MutableList<Ammo> = mutableListOf()
        if (fireType == FireType.QueueShoot(3)) {
            for (i in 1..3) {
                listOfBullet.add(charger.pop() ?: throw NoAmmoException())
            }
            if (charger.isEmpty()) isEmptyCharger = true
            return listOfBullet
        }
        listOfBullet.add(charger.pop() ?: throw NoAmmoException())
        if (charger.isEmpty()) isEmptyCharger = true
        return listOfBullet
    }
}


