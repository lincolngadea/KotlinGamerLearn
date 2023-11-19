package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.PlanAssignEntity
import br.com.kotlin.learning.entities.PlanEntity
import br.com.kotlin.learning.entities.PlanStandardEntity
import br.com.kotlin.learning.model.Plan
import br.com.kotlin.learning.model.PlanAssign
import br.com.kotlin.learning.model.PlanStandard
import toEntity
import toModel
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(model: Plan): PlanEntity {
        return model.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

}