package br.com.kotlin.learning.model

data class Rent(
    val gamerUser: GamerUser,
    val game: Game
){
    override fun toString(): String {
        return "Rent(gamerUser=${gamerUser.name}, game=${game.title})"
    }
}
