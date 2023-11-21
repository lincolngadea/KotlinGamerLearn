import br.com.kotlin.learning.model.Player
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.PlanDAO
import br.com.kotlin.learning.repository.PlayerDAO

//mport br.com.kotlin.learning.model.Player

fun main() {

//    val player1 = Player("Rafael Rolim", "rafael@rolim.com", "09/09/09", "rafaelrolim")
    val player2 = Player("Pedro Rolim", "pedro@rolim.com","09/09/09","pedrorolim")

    val manager = DataBase.getEntityManager()

    val playerDAO = PlayerDAO(manager)
    val planosDAO = PlanDAO(manager)

//    player1.plan = planosDAO.getModelFromId(3)
    player2.plan = planosDAO.getModelFromId(4)

    println("Player: $player2")


    playerDAO.addEntity(player2)
//    playerDAO.addEntity(player2)
//
    val playersList = playerDAO.getModelList()
    println(playersList)
//
//    val planList = planosDAO.getModelList()
//    println(planList)

    manager.close()
}