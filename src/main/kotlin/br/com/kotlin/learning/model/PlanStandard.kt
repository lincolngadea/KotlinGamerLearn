package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.math.RoundingMode

class PlanStandard(type: String): Plan(type){
    override fun getPrice(rent: Rent): BigDecimal {
        var originalPrice = super.getPrice(rent)
        if(rent.player.gradeAverage > 8.0){
            originalPrice -= originalPrice * BigDecimal(0.1)
        }
        return originalPrice.setScale(2,RoundingMode.HALF_EVEN)
    }
}
