package br.com.kotlin.learning.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamerUser: GamerUser,
    val game: Game,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val rentValue: Double = game.price * Period.between(startDate,endDate).days
){
    override fun toString(): String {
        return "${gamerUser.name} rent the game ${game.title} " +
                "per R$$rentValue (R$${game.price}/day) " +
                "during ${Period.between(startDate,endDate).days} Day(s)"
    }
}
