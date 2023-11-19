package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.Id

class PlanAssign(
    type: String,
    val monthPayment: Double,
    val discountPercentage: BigDecimal,
    val gameIncludes: Int,
    id: Int = 0
) : Plan(type,id) {
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

    override fun toString(): String {
        return "PlanAssign(" +
                "\nmonthPayment=$monthPayment, " +
                "\ndiscountPercentage=$discountPercentage, " +
                "\ngameIncludes=$gameIncludes" +
                "\n####################################################)\n"
    }


}
