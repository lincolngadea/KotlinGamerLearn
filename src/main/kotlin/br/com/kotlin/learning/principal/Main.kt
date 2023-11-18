package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.GamesDAO

fun main() {
    val game = Game(
        "The Last of Us Part II",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )

    val manager = DataBase.getEntityManager()
    val gamesDAO = GamesDAO(manager)
//    jogoDAO.adicionarJogo(jogo)

    gamesDAO.addGames(game)
    val gamesList: List<Game> = gamesDAO.getGames()
    println(gamesList)

    manager.close()
}
