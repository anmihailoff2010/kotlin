import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    val players = List(2){ Player(1) }
    val gameScope = CoroutineScope(Job() + Dispatchers.Unconfined)

    val mainJob = gameScope.launch {
        players.forEach { player ->
            val playerNumber = players.indexOf(player) + 1
            println("Билеты игрока $playerNumber")
            players.forEach { it.printCards() }
            player.cards.forEach { card ->
                var counter = 0
                val cardNumber = player.cards.indexOf(card) + 1
                val job = launch {
                    GeneratorShared.sharedFlow.collect { collectedNum ->
                        for (line in card) {
                            if (collectedNum in line) {
                                println("совпало $collectedNum")
                                counter += 1
                                println("counter of card $cardNumber of player $playerNumber = $counter")
                                if (counter == 15) {
                                    println("!!!!Игрок $playerNumber ВЫИГРЫВАЕТ с билетом № $cardNumber !!!")
                                    GeneratorShared.scope.cancel()
                                    gameScope.cancel()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    mainJob.join()
}

