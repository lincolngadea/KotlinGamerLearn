import br.com.kotlin.learning.model.Rent
import br.com.kotlin.learning.model.RentalPeriod
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.GamesDAO
import br.com.kotlin.learning.repository.PlayerDAO
import br.com.kotlin.learning.repository.RentDAO

fun main(){

    val manager = DataBase.getEntityManager()
    val gameDAO = GamesDAO(manager)
    val playerDAO = PlayerDAO(manager)
    val rentDAO = RentDAO(manager)

    val player = playerDAO.getModelFromId(3)
    val game = gameDAO.getModelFromId(1)
    val rent = player.rentGame(game,RentalPeriod())

    rentDAO.addEntity(rent)

    val rents = rentDAO.getModelList()
    println(rents)

    manager.close()
}