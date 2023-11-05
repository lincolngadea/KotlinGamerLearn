package br.com.kotlin.learning.model

sealed class Plan(val type: String) {
    open fun getPrice(rent: Rent): Double{
        return rent.game.price * rent.rentalPeriod.inDays
    }
}