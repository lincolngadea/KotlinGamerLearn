package br.com.kotlin.learning.service

import br.com.kotlin.learning.model.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsummer {

    fun gameSearch(id: String): Result<InfoGame> {
        return runCatching {
            val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

            val client: HttpClient = HttpClient.newHttpClient()
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build()
            val response = client
                .send(request, HttpResponse.BodyHandlers.ofString())

            val json = response.body()

            val gson = Gson()

            gson.fromJson(json, InfoGame::class.java)
        }.onFailure {
            println("Error in request game API.")
        }
    }
}