import br.com.kotlin.learning.service.ApiConsummer

fun main(){
    val consummer = ApiConsummer()

    val gamerUserList = consummer.gamerUserSearch()
    val gameList = consummer.gameSearch()

//    println(gamerUserList)
//    println(gameList)
    val gamerAna = gamerUserList.getOrThrow()[1]
    val gameResidentVillage = gameList.getOrThrow()[10]

    val rent = gamerAna.rentGame(gameResidentVillage)

    println(rent)
}