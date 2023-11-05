package br.com.kotlin.learning.model

data class StandardPlan(val type: String){
    fun getPrice(rent: Rent): Double{
        return rent.game.price * rent.rentalPeriod.inDays
    }
}
