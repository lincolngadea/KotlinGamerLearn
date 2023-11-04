import br.com.kotlin.learning.service.ApiConsummer

fun main(){
    val consummerGamer = ApiConsummer().gamerUserSearch()
    println(consummerGamer)
}