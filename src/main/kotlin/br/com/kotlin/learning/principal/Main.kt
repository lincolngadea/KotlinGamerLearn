//package br.com.kotlin.learning.principal
//
//import br.com.kotlin.learning.model.Game
//import br.com.kotlin.learning.model.GamerUser
//import br.com.kotlin.learning.service.ApiConsummer
//import br.com.kotlin.learning.utils.transformaData
//import java.util.Scanner
//
//fun main() {
//    val read = Scanner(System.`in`)
//    val gamer = GamerUser.createGamer(read)
//    println(gamer)
//    gamer.birthDay?.let { println(it.transformaData()) }
//    var myGame: Game? = null
//    val apiSearch = ApiConsummer()
//    do {
//        println("Type a game code to search:")
//        val searchId = read.nextLine()
//
//        apiSearch.gameSearchFirst(searchId).onSuccess {
//            val resultGameObject = runCatching {
//                myGame = Game(
//                    it.info.title,
//                    it.info.thumb
//                )
//            }
//            resultGameObject.onFailure {
//                println("Game not found. try again other id.")
//            }
//
//            resultGameObject.onSuccess {
//                println("Do you want insert a custom description? Y/N")
//                val option = read.nextLine()
//                if (option.equals("y", true)) {
//                    println("Insert a custom description in the game:")
//                    val customDescription = read.nextLine()
//                    myGame?.description = customDescription
//                } else {
//                    myGame?.description = myGame?.titulo
//                }
//                gamer.gamesSearched.add(myGame)
//            }
//
//            resultGameObject.onSuccess {
//                println("Success end search.")
//            }
//        }
//        println("Do you want a new search?Y/N")
//        val ask = read.nextLine()
//    } while (ask.equals("Y", true))
//
//    println("Games Searched:")
//    println(gamer.gamesSearched)
//
//    println("Games Searched by title:")
//    gamer.gamesSearched.sortBy { it?.titulo }
//    gamer.gamesSearched.forEach { println("Title:${it?.titulo}") }
//
//    println("Do you Want remove some element of game list?Y/N")
//    val removeGameElement = read.nextLine()
//    if(removeGameElement.equals("Y",true)){
//        println("Insert element position to remove:")
//        val elementPosition = read.nextInt()
//        gamer.gamesSearched.removeAt(elementPosition)
//        println("Updated game list:")
//        println(gamer.gamesSearched)
//    }
//    println("End Search!")
//}