package br.com.kotlin.learning.principal

import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.RentalPeriod
import br.com.kotlin.learning.service.ApiConsummer
import java.time.LocalDate

fun main(){
    val consummer = ApiConsummer()

    val gamerUserList = consummer.gamerUserSearch()
    val gameList = consummer.gameSearch()

    val gamerAna = gamerUserList.getOrThrow()[1]
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

    val gamerCaroline = gamerUserList.getOrThrow()[3]
    gamerCaroline.plan = PlanAssign("SILVER", 9.90, 2)

    gamerCaroline.rentGame(gameResidentVillage, rentalPeriod1)
    gamerCaroline.rentGame(gameSpider, rentalPeriod2)
    gamerCaroline.rentGame(gameTheLastOfUs,rentalPeriod3)

    println(gamerCaroline.rentedThisGames)
}