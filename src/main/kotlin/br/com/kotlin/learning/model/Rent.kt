package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamerUser: GamerUser,
    val game: Game,
    val rentalPeriod: RentalPeriod
){
    private val rentValue: BigDecimal = gamerUser.plan.getPrice(this)
    override fun toString(): String {
        return "${gamerUser.name} rent the game ${game.title} " +
                "per R$$rentValue (R$${game.price}/day) " +
                "during ${rentalPeriod.inDays} Day(s)"
    }
}
