sealed class BattleState {
    class Progress(private val team1: MutableList<AbstractWarrior>, private val team2: MutableList<AbstractWarrior>) : BattleState() {
        fun printInfo() {
            println("Статус 1 команды:")
            for (warrior in team1) {
                println("$warrior - здоровье: ${warrior.currentHealth}")
            }
            println("Статус 2 команды:")
            for (warrior in team2) {
                println("$warrior - здоровье: ${warrior.currentHealth}")
            }
        }
    }
    object Team1Win : BattleState()
    object Team2Win : BattleState()
    object Draw : BattleState()
}