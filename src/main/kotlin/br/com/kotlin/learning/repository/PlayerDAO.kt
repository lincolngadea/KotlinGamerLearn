package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.PlayerEntity
import br.com.kotlin.learning.model.Player
import toEntity
import toModel
import javax.persistence.EntityManager

class PlayerDAO(manager: EntityManager): DAO<Player,PlayerEntity>(manager, PlayerEntity::class.java) {
    override fun toModel(entity: PlayerEntity): Player {
        return Player(
            entity.nome,
            entity.email,
            entity.aniversario,
            entity.usuario
        ).apply {
            plan = entity.plano.toModel()
        }
    }

    override fun toEntity(model: Player): PlayerEntity {
        return PlayerEntity(
            aniversario = model.birthDay,
            email = model.email,
            nome = model.name,
            usuario = model.user!!,
            plano = model.plan.toEntity()
        )
    }
}