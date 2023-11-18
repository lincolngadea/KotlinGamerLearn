package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.GameEntity
import br.com.kotlin.learning.model.Game
import javax.persistence.EntityManager

class GamesDAO(private val manager: EntityManager) {

    fun getGames(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        val gameEntity = query.resultList
        val game = gameEntity.map {
            Game(
                it.titulo,
                it.capa,
                it.preco,
                it.descricao
            )
        }
        return game
    }

    fun addGames(game: Game) {
        val entity = GameEntity(
            capa = game.thumb,
            descricao = game.description,
            preco = game.price,
            titulo = game.title
        )
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}