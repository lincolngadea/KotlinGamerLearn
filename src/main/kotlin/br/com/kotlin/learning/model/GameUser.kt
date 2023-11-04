package br.com.kotlin.learning.model

import java.lang.IllegalArgumentException
import java.util.Scanner
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
    private var internalId: String? = null
        private set

    val gamesSearched = mutableListOf<Game?>()
    constructor(name: String, email: String, birthDay: String, user: String) : this(name, email) {
        this.birthDay = birthDay
        this.user = user
    }

    companion object{
        fun createGamer(read: Scanner): GameUser{
            println("Well Come the AluGames! We are make your register. Type your name:")
            val name = read.nextLine()
            println("Type your email:")
            val email = read.nextLine()
            println("Do you want to complete your register with user and birthday?Y/N")
            val option = read.nextLine()

            return if (option.equals("Y",true)){
                println("Type your birthday (DD/MM/YYYY):")
                val birthDay = read.nextLine()
                println("Type your username:")
                val username = read.nextLine()
                GameUser(name,email,birthDay,username)
            }else{
                GameUser(name,email)
            }
        }
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

