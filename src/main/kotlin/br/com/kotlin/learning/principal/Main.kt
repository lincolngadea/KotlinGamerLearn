package br.com.kotlin.learning.principal

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

    gamerAna.rentGame(gameResidentVillage,rentalPeriod1)
    gamerAna.rentGame(gameSpider,rentalPeriod2)
    gamerAna.rentGame(gameTheLastOfUs,rentalPeriod3)

    println(gamerAna.rentedThisGames)
}