sealed class FireType {

    object SingleShoot : FireType()
    data class QueueShoot(val queueSize: Int) : FireType()
}

