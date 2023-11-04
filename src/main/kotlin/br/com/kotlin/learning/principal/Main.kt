package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.GameUser
import br.com.kotlin.learning.service.ApiConsummer
import java.util.Scanner

fun main() {
    val read = Scanner(System.`in`)
    val gamer = GameUser.createGamer(read)
    println(gamer)
    var myGame: Game? = null
    val apiSearch = ApiConsummer()
    do {
        println("Type a game code to search:")
        val searchId = read.nextLine()

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
                gamer.gamesSearched.add(myGame)
            }

            resultGameObject.onSuccess {
                println("Success end search.")
            }
        }
        println("Do you want a new search?Y/N")
        val ask = read.nextLine()
    } while (ask.equals("Y", true))
    println("Games Searcheds:")
    println(gamer.gamesSearched)
    println("End Search!")
}