package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.Player
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.GamesDAO
import br.com.kotlin.learning.repository.PlayerDAO

fun main() {
    val game = Game(
        "The Last of Us Part III",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )

    val player = Player("Lincoln Silva","lincolnsilva@lincoln.com","09/09/1990","lincolnsilva")


    val manager = DataBase.getEntityManager()
    val gamesDAO = GamesDAO(manager)
    val playersDAO = PlayerDAO(manager)
//    gamesDAO.addEntity(game)

//    gamesDAO.addGames(game)
    val gamesList: List<Game> = gamesDAO.getModelList()
    println(gamesList)

    playersDAO.addEntity(player)
    val playersList = playersDAO.getModelList()
    println(playersList)

    manager.close()
}
