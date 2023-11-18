package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.Player
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.GamesDAO
import br.com.kotlin.learning.repository.PlayerDAO

fun main() {
    val game = Game(
        "The Last of Us Part II",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )

    val player = Player("Lincoln Gadea","lincoln@lincoln.com","09/09/1990","lincolngadea")


    val manager = DataBase.getEntityManager()
    val gamesDAO = GamesDAO(manager)
    val playersDAO = PlayerDAO(manager)
//    jogoDAO.adicionarJogo(jogo)

//    gamesDAO.addGames(game)
    val gamesList: List<Game> = gamesDAO.getGames()
    println(gamesList)

    playersDAO.addPlayer(player)
    val playersList = playersDAO.getPlayers()
    println(playersList)

    manager.close()
}
