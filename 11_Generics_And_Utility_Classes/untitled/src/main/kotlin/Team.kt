import kotlin.random.Random

class Team {
    private val team: MutableList<AbstractWarrior> = mutableListOf()

    fun createTeam() : MutableList<AbstractWarrior> {
        for (n in 1..10) {
            when {
                5.chanceTrigger() -> team.add(Bomber())
                10.chanceTrigger() -> team.add(General())
                40.chanceTrigger() -> team.add(Captain())
                else -> team.add(Soldier())
            }
        }
        return team
    }

    fun getTeamList() : MutableList<AbstractWarrior> {
        return team
    }
}