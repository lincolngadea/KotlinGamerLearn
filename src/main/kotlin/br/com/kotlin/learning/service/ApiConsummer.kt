package br.com.kotlin.learning.service

import br.com.kotlin.learning.model.*
import br.com.kotlin.learning.utils.criaGame
import br.com.kotlin.learning.utils.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsummer {
    private val logger = KotlinLogging.logger {}
//    fun gameSearchFirst(id: String): Result<InfoGame> {
//        return runCatching {
//            val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
//
//            val json = dataConsumme(url)
//            val gson = Gson()
//
//            gson.fromJson(json, InfoGame::class.java)
//        }.onFailure {
//            println("Error in request game API.")
//        }
//    }

    fun gameSearch(): Result<List<Game>>{
        return runCatching {
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

            val json = dataConsumme(url)
            val gson = Gson()

            val gameTypeObject = object : TypeToken<List<InfoGame>>() {}.type
            val infoGameList: List<InfoGame> = gson.fromJson(json, gameTypeObject)
            val gamerUserMapped = infoGameList.map { infoGames-> infoGames.criaGame() }

            gamerUserMapped
        }.onFailure {
            println("Error in request game API.")
        }
    }

    fun gamerUserSearch(): Result<List<GamerUser>> {
        return runCatching {
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

            val json = dataConsumme(url)

            val gson = Gson()

            val gamerTypeObject = object : TypeToken<List<InfoGamerUser>>() {}.type
            val infoGamerList: List<InfoGamerUser> = gson.fromJson(json, gamerTypeObject)
            val gamerUserMapped = infoGamerList.map { infoGamerUser -> infoGamerUser.criaGamer() }

            gamerUserMapped
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