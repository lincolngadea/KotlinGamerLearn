package br.com.kotlin.learning.model

import kotlin.random.Random

data class GamerUser(
    var name: String,
    var email: String
): Recommended {
    init {
        if (this.name.isBlank()) {
            throw IllegalArgumentException("Name is null or blank!")
        }
        this.email = checkEmail()
    }

    constructor(name: String, email: String, birthDay: String, user: String) : this(name, email) {
        this.birthDay = birthDay
        this.user = user
    }

    private var birthDay: String? = null
    private var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank() || internalId!!.isNotEmpty()) createCustomInternalId()
        }
    private var internalId: String? = null
    private val listGrades = mutableListOf<Double>()

    val rentedThisGames = mutableListOf<Rent>()
    var plan: Plan = PlanStandard("BRONZE")

    override val gradeAverage: Double
        get() = listGrades.average()

    override fun toRecommend(grade: Double) {
        listGrades.add(grade)
    }

    fun rentGame(game: Game, rentalPeriod: RentalPeriod): Rent {
        val newRent = Rent(this, game, rentalPeriod)
        rentedThisGames.add(newRent)
        return newRent
    }

    fun monthGames(month:Int): List<Game> {
        return rentedThisGames
            .filter { rent ->  rent.rentalPeriod.startDate.monthValue == month}
            .map { rent ->  rent.game}
    }

    private fun createCustomInternalId() {
        val randomNumber = Random.nextInt(1000)
        val newRandomNumber = String.format("%04d", randomNumber)
        internalId = "$user#$newRandomNumber"
    }

    private fun checkEmail(): String {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (emailRegex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid Email!")
        }
    }

    override fun toString(): String {
        return "Gamer(" +
                "\nName: '$name', " +
                "\nEmail: '$email', " +
                "\nBirthDay: $birthDay, " +
                "\nUser: $user, " +
                "\nInternalId: $internalId)" +
                "\nReputation: $gradeAverage" +
                "\n##############################################"
    }
}

