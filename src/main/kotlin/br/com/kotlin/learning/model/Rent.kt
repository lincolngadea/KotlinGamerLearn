package br.com.kotlin.learning.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamerUser: GamerUser,
    val game: Game,
    val rentalPeriod: RentalPeriod,
    val rentValue: Double = game.price * rentalPeriod.inDays
){

    override fun toString(): String {
        return "${gamerUser.name} rent the game ${game.title} " +
                "per R$$rentValue (R$${game.price}/day) " +
                "during ${rentalPeriod.inDays} Day(s)"
    }
}
