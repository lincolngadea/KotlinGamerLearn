package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.math.RoundingMode

sealed class Plan(val type: String) {
    open fun getPrice(rent: Rent): BigDecimal{
        val price = rent.game.price * rent.rentalPeriod.inDays
        return price.toBigDecimal().setScale(2,RoundingMode.HALF_EVEN)
    }
}