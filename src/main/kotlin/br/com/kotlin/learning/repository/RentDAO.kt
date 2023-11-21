package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.RentEntity
import br.com.kotlin.learning.model.Rent
import toEntity
import toModel
import java.math.BigDecimal
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager): DAO<Rent, RentEntity>(manager, RentEntity::class.java) {
    override fun toEntity(model: Rent): RentEntity {
        return RentEntity(model.player.toEntity(),model.game.toEntity(),model.rentalPeriod)
            .apply {
                rentValue = BigDecimal(3.4)
                id = model.id
            }
    }

    override fun toModel(entity: RentEntity): Rent {
        return Rent(entity.player.toModel(),entity.game.toModel(),entity.period)
            .apply { id = entity.id }
    }

}