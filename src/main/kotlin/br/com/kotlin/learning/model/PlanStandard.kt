package br.com.kotlin.learning.model

class PlanStandard(type: String): Plan(type){
    override fun getPrice(rent: Rent): Double {
        var originalPrice = super.getPrice(rent)
        if(rent.gamerUser.gradeAverage > 8.0){
            originalPrice -= originalPrice * 0.1
        }
        return originalPrice
    }
}
