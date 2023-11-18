package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.repository.GamesDAO

fun main() {
    val game = Game(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val gamesDAO = GamesDAO()
//    jogoDAO.adicionarJogo(jogo)

    val gamesList: List<Game> = gamesDAO.getGames()
    println(gamesList)
}
