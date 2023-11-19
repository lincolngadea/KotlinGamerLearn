import br.com.kotlin.learning.entities.PlanAssignEntity
import br.com.kotlin.learning.entities.PlanEntity
import br.com.kotlin.learning.entities.PlanStandardEntity
import br.com.kotlin.learning.model.Plan
import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.PlanStandard

fun Plan.toEntity(): PlanEntity{
    return if(this is PlanAssign){
        PlanAssignEntity(this.type, this.monthPayment,this.discountPercentage,this.gameIncludes,this.id)
    } else{
        PlanStandardEntity(this.type,this.id)
    }
}

fun PlanEntity.toModel(): Plan{
    return if(this is PlanAssignEntity){
        PlanAssign(this.type,this.monthPayment,this.discountPercentage,this.gameIncludes,this.id)
    }else{
        PlanStandard(this.type,this.id)
    }
}