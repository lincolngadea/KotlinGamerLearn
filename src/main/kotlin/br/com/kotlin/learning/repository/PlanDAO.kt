package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.PlanAssignEntity
import br.com.kotlin.learning.entities.PlanEntity
import br.com.kotlin.learning.entities.PlanStandardEntity
import br.com.kotlin.learning.model.Plan
import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.PlanStandard
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(model: Plan): PlanEntity {
        return if(model is PlanAssign){
            PlanAssignEntity(model.type, model.monthPayment,model.discountPercentage,model.gameIncludes,model.id)
        } else{
            PlanStandardEntity(model.type,model.id)
        }
    }

    override fun toModel(entity: PlanEntity): Plan {
        return if(entity is PlanAssignEntity){
            PlanAssign(entity.type,entity.monthPayment,entity.discountPercentage,entity.gameIncludes,entity.id)
        }else{
            PlanStandard(entity.type,entity.id)
        }
    }

}