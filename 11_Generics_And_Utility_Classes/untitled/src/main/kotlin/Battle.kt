import kotlin.random.Random
import kotlin.random.nextInt

class Battle {
    private val team1 = Team().createTeam()
    private val team2 = Team().createTeam()
    var battleIsEnd: Boolean = false
    private var team1Alive = true
    private var team2Alive = true

    fun getBattleState() : BattleState {
        team1Alive = false
        team2Alive = false
        for (warrior in team1) {
            if (!warrior.isKilled) {
                team1Alive = true
                break
            }
        }
        for (warrior in team2) {
            if (!warrior.isKilled) {
                team2Alive = true
                break
            }
        }
        return when {
            team1Alive && !team2Alive -> {
                println("Победа первой команды")
                battleIsEnd = true
                BattleState.Team1Win
            }
            !team1Alive && team2Alive -> {
                println("Победа второй команды")
                battleIsEnd = true
                BattleState.Team2Win
            }
            !team1Alive && !team2Alive -> {
                println("Ничья")
                battleIsEnd = true
                BattleState.Draw
            }
            else -> {
                println("Битва в разгаре...")
                BattleState.Progress(team1, team2).printInfo()
                BattleState.Progress(team1, team2)
            }
        }
    }

    fun iteration() {
        val wasKilledTeam1: MutableList<Int> = mutableListOf()
        val wasKilledTeam2: MutableList<Int> = mutableListOf()
        var t1 = 0
        var t2 = 0
        while (t1 < team1.size || t2 < team2.size) {
            for (i in t1 until team1.size) {
                if (!team1[i].isKilled) {
                    val num: Int = Random.nextInt(0 until team2.size)
                    team1[i].attack(team2[num])
                    if (team2[num].isKilled && !wasKilledTeam2.contains(num)) wasKilledTeam2.add(num)
                }
                t1++
                break
            }
            for (n in t2 until team2.size) {
                if (!team2[n].isKilled) {
                    val num: Int = Random.nextInt(0 until team1.size)
                    team2[n].attack(team1[num])
                    if (team1[num].isKilled && !wasKilledTeam1.contains(num)) wasKilledTeam1.add(num)
                }
                t2++
                break
            }
        }
        wasKilledTeam1.sortDescending()
        wasKilledTeam2.sortDescending()
        for (killed in wasKilledTeam1) team1.removeAt(killed)
        for (killed in wasKilledTeam2) team2.removeAt(killed)
    }
}