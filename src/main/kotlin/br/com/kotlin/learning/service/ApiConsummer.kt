package br.com.kotlin.learning.service

import br.com.kotlin.learning.model.*
import br.com.kotlin.learning.utils.createGame
import br.com.kotlin.learning.utils.createPlayer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsummer {
    private val logger = KotlinLogging.logger {}

    fun gameSearch(): Result<List<Game>>{
        return runCatching {
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

            val json = dataConsumme(url)
            val gson = Gson()

            val gameTypeObject = object : TypeToken<List<GameInfo>>() {}.type
            val gameInfoList: List<GameInfo> = gson.fromJson(json, gameTypeObject)
            val playerMapped = gameInfoList.map { infoGames-> infoGames.createGame() }

            playerMapped
        }.onFailure {
            println("Error in request game API.")
        }
    }

    fun playerSearch(): Result<List<Player>> {
        return runCatching {
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

            val json = dataConsumme(url)

            val gson = Gson()

            val playerTypeObject = object : TypeToken<List<PlayerInfo>>() {}.type
            val infoPlayerList: List<PlayerInfo> = gson.fromJson(json, playerTypeObject)
            val playerMapped = infoPlayerList.map { playerInfo -> playerInfo.createPlayer() }

            playerMapped
        }.onFailure {
            println("Error in request game API.")
        }
    }

    private fun dataConsumme(url: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}