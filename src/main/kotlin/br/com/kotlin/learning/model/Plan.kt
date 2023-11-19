package br.com.kotlin.learning.model

import java.math.BigDecimal
import java.math.RoundingMode

sealed class Plan(val type: String, var id: Int = 0) {
    open fun getPrice(rent: Rent): BigDecimal{
        val price = rent.game.price * rent.rentalPeriod.inDays
        return price.toBigDecimal().setScale(2,RoundingMode.HALF_EVEN)
    }

    override fun toString(): String {
        return "Plan(" +
                "\ntype='$type', " +
                "\nid=$id)"
    }


}