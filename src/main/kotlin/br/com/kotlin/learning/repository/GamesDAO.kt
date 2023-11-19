package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.GameEntity
import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.Plan
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager) : DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toModel(entity: GameEntity): Game {
        return Game(entity.titulo, entity.capa, entity.preco, entity.descricao)
    }

    override fun toEntity(model: Game): GameEntity {
        return GameEntity(
            capa = model.thumb,
            descricao = model.description,
            preco = model.price,
            titulo = model.title
        )
    }
}