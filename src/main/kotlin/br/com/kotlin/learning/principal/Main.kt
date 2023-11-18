package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.RentalPeriod
import br.com.kotlin.learning.service.ApiConsummer
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main(){
    val consummer = ApiConsummer()

    val playerList = consummer.playerSearch()
    val gameList = consummer.gameSearch()

//    val gamerAna = gamerUserList.getOrThrow()[1]
    val gameResidentVillage = gameList.getOrThrow()[10]
    val gameSpider = gameList.getOrThrow()[13]
    val gameTheLastOfUs = gameList.getOrThrow()[2]

    val rentalPeriod1 = RentalPeriod(LocalDate.now(),LocalDate.now().plusDays(10))
    val rentalPeriod2 = RentalPeriod(LocalDate.now(),LocalDate.now().plusDays(3))
    val rentalPeriod3 = RentalPeriod(LocalDate.now(),LocalDate.now().plusDays(15))

//    gamerAna.rentGame(gameResidentVillage,rentalPeriod1)
//    gamerAna.rentGame(gameSpider,rentalPeriod2)
//    gamerAna.rentGame(gameTheLastOfUs,rentalPeriod3)
//
//    println(gamerAna.rentedThisGames)

    val playerCaroline = playerList.getOrThrow()[3]
    playerCaroline.plan = PlanAssign("SILVER", 9.90, BigDecimal(0.15) ,2)

    playerCaroline.rentGame(gameResidentVillage, rentalPeriod1)
    playerCaroline.rentGame(gameSpider, rentalPeriod2)
    playerCaroline.rentGame(gameTheLastOfUs,rentalPeriod3)

//    println(gamerCaroline.rentedThisGames)

    playerCaroline.toRecommend(7.0)
    playerCaroline.toRecommend(10.0)
    playerCaroline.toRecommend(9.5)
//    println(gamerCaroline)

    playerCaroline.toRecommendGame(gameTheLastOfUs,10.0)
    playerCaroline.toRecommendGame(gameTheLastOfUs,9.0)

    playerCaroline.rentGame(gameTheLastOfUs, rentalPeriod3)
//    println("Games Recomendations: ${gamerCaroline.listRecommendedGame}")

    println(playerCaroline.rentedThisGames)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializer = gson.toJson(playerCaroline.listRecommendedGame)

    val file = File("jogosRecomendados.json")
    file.writeText(serializer)
    println(serializer)
}