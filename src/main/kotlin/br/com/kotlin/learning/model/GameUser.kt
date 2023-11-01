package br.com.kotlin.learning.model

import java.lang.IllegalArgumentException
import kotlin.random.Random

data class GameUser(
    var name: String,
    var email: String
) {
    var birthDay: String? = null
    var user: String? = null
        set(value) {
            field = value
            if(internalId.isNullOrBlank() || internalId!!.isNotEmpty()) creatCustonInternalId()
        }
    var internalId: String? = null
        private set
    constructor(name: String, email: String, birthDay: String, user: String) : this(name, email) {
        this.birthDay = birthDay
        this.user = user
    }

    init {
        this.email = checkEmail()
    }

    override fun toString(): String {
        return "Gamer(" +
                "name='$name', " +
                "email='$email', " +
                "birthDay=$birthDay, " +
                "user=$user, " +
                "internalId=$internalId)"
    }

    private fun creatCustonInternalId(){
        val randomNumber = Random.nextInt(1000)
        val newRandomNumber = String.format("%04d",randomNumber)
        internalId ="$user#$newRandomNumber"
    }

    private fun checkEmail(): String{
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}\$")
        if(emailRegex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Invalid Email!")
        }
    }
}

