import kotlin.random.Random

fun main() {
    println("Битва начинается!")
    val battle: Battle = Battle()
    var battleState = battle.getBattleState()
    while (!battle.battleIsEnd) {
        battle.iteration()
        battleState = battle.getBattleState()
    }
    battleState = battle.getBattleState()
}

fun Int.chanceTrigger(): Boolean {
    val chance:Int = Random.nextInt(1, 100)
    return chance <= this
}



