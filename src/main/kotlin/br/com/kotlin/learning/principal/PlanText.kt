import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.PlanStandard
import br.com.kotlin.learning.repository.DataBase
import br.com.kotlin.learning.repository.PlanDAO
import java.math.BigDecimal

fun main(){

    val standard = PlanStandard("BRONZE")
    val silver = PlanAssign("SILVER",24.5, BigDecimal(0.5),3)
    val gold = PlanAssign("GOLD", 35.0, BigDecimal(0.7),4)
    val platine = PlanAssign("PLATINE", 45.0, BigDecimal(0.9), 5)
    val diamond = PlanAssign("DIAMOND", 50.0, BigDecimal(10.0), 6)

    val manager = DataBase.getEntityManager()
    val planDAO = PlanDAO(manager)
//    planDAO.addEntity(standard)
//    planDAO.addEntity(silver)
//    planDAO.addEntity(gold)
//    planDAO.addEntity(platine)
//    planDAO.addEntity(diamond)

    val planList = planDAO.getModelList()
    println(planList)

    manager.close()

}