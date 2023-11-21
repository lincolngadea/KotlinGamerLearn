package br.com.kotlin.learning.model

import java.math.BigDecimal

data class Rent(
    val player: Player,
    val game: Game,
    val rentalPeriod: RentalPeriod
){
    private val rentValue: BigDecimal = player.plan.getPrice(this)
    var id:Int = 0

    override fun toString(): String {
        return "${player.name} rent the game ${game.title} " +
                "per R$$rentValue (R$${game.price}/day) " +
                "during ${rentalPeriod.inDays} Day(s)"
    }
}
