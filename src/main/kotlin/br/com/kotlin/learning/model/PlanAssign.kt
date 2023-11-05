package br.com.kotlin.learning.model

class PlanAssign(
    type: String,
    val monthPayment: Double,
    private val discountPercentage: Double,
    private val gameIncludes: Int
) : Plan(type) {
    override fun getPrice(rent: Rent): Double {
        val numberOfRentals = rent.gamerUser.monthGames(rent.rentalPeriod.startDate.monthValue).size + 1
        return if (numberOfRentals <= gameIncludes) {
            0.0
        } else {
            var originalPrice = super.getPrice(rent)
            if (rent.gamerUser.gradeAverage > 8) {
                originalPrice -= originalPrice * discountPercentage
            }
            originalPrice
        }
    }
}
