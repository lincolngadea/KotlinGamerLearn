import br.com.kotlin.learning.model.GameUser

fun main(){
    val gamer = GameUser("Lincoln","lincoln@email.com")
    println(gamer)

    gamer.let {
        it.birthDay = "09/09/2009"
        it.user = "Lincoln10"
    }

    println(gamer)
}