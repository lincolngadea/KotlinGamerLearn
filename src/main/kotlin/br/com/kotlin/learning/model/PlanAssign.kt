package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.math.RoundingMode

class PlanAssign(
    type: String,
    val monthPayment: Double,
    private val discountPercentage: BigDecimal,
    private val gameIncludes: Int
) : Plan(type) {
    override fun getPrice(rent: Rent): BigDecimal {
        val numberOfRentals = rent.player.monthGames(rent.rentalPeriod.startDate.monthValue).size + 1
        return if (numberOfRentals <= gameIncludes) {
            BigDecimal(0.0)
        } else {
            var originalPrice = super.getPrice(rent)
            if (rent.player.gradeAverage > 8) {
                originalPrice -= originalPrice * discountPercentage
            }
            originalPrice.setScale(2,RoundingMode.HALF_EVEN)
        }
    }
}
