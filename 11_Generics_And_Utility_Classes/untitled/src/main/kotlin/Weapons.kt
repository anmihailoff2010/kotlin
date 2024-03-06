object Weapons {

    fun createPistol() : AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxCountInCharger = 8
            override val fireType = FireType.SingleShoot
            override var charger = Stack<Ammo>()
            override var isEmptyCharger = true
            override val ammoType = Ammo.HARD_BULLET
        }
    }

    fun createMachineGun() : AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxCountInCharger = 30
            override val fireType = FireType.QueueShoot(3)
            override var charger = Stack<Ammo>()
            override var isEmptyCharger = true
            override val ammoType = Ammo.SOFT_BULLET
        }
    }

    fun createLauncher() : AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxCountInCharger = 1
            override val fireType = FireType.SingleShoot
            override var charger = Stack<Ammo>()
            override var isEmptyCharger = true
            override val ammoType = Ammo.GRANADE
        }
    }

    fun createRifle() : AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxCountInCharger = 2
            override val fireType = FireType.SingleShoot
            override var charger = Stack<Ammo>()
            override var isEmptyCharger = true
            override val ammoType = Ammo.HARD_BULLET
        }
    }
}