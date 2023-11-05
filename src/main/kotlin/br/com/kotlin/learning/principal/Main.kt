import br.com.kotlin.learning.model.RentalPeriod
import br.com.kotlin.learning.service.ApiConsummer
import java.time.LocalDate

fun main(){
    val consummer = ApiConsummer()

    val gamerUserList = consummer.gamerUserSearch()
    val gameList = consummer.gameSearch()

    val gamerAna = gamerUserList.getOrThrow()[1]
    val gameResidentVillage = gameList.getOrThrow()[10]

    val startDate = LocalDate.now()
    val endDate = startDate.plusDays(10)
    val rentalPeriod = RentalPeriod(startDate,endDate)
    val rent = gamerAna.rentGame(gameResidentVillage,rentalPeriod)

    println(rent)
}