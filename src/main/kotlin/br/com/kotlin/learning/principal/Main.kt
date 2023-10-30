package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.service.ApiConsummer
import java.util.Scanner

fun main() {
    val read = Scanner(System.`in`)
    println("Type a game code to search:")
    val searchId = read.nextLine()

    var myGame: Game? = null

    val apiSearch = ApiConsummer()

    apiSearch.gameSearch(searchId).onSuccess {
        val resultGameObject = runCatching {
            myGame = Game(
                it.info.title,
                it.info.thumb
            )
        }
        resultGameObject.onFailure {
            println("Game not found. try again other id.")
        }

        resultGameObject.onSuccess {
            println("Do you want insert a custom description? Y/N")
            val option = read.nextLine()
            if (option.equals("y", true)) {
                println("Insert a custom description in the game:")
                val customDescription = read.nextLine()
                myGame?.description = customDescription
            } else {
                myGame?.description = myGame?.title
            }
            println(myGame)
        }

        resultGameObject.onSuccess {
            println("Success end search.")
        }
    }
}