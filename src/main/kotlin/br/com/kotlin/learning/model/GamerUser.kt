package br.com.kotlin.learning.model

import kotlin.random.Random

data class GamerUser(
    var name: String,
    var email: String
) {
    private var birthDay: String? = null
    private var user: String? = null
        set(value) {
            field = value
            if(internalId.isNullOrBlank() || internalId!!.isNotEmpty()) creatCustonInternalId()
        }
    private var internalId: String? = null

    //    val gamesSearched = mutableListOf<Game?>()
    constructor(name: String, email: String, birthDay: String, user: String) : this(name, email) {
        this.birthDay = birthDay
        this.user = user
    }

    init {
        if(this.name.isBlank()){
            throw IllegalArgumentException("Name is null or blank!")
        }
        this.email = checkEmail()
    }

    override fun toString(): String {
        return "Gamer(" +
                "\nname='$name', " +
                "\nemail='$email', " +
                "\nbirthDay=$birthDay, " +
                "\nuser=$user, " +
                "\ninternalId=$internalId)" +
                "\n##############################################"
    }

    fun rentGame(game: Game): Rent = Rent(this,game)

    private fun creatCustonInternalId(){
        val randomNumber = Random.nextInt(1000)
        val newRandomNumber = String.format("%04d",randomNumber)
        internalId ="$user#$newRandomNumber"
    }

    private fun checkEmail(): String{
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(emailRegex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Invalid Email!")
        }
    }
}

