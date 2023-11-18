package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.GameEntity
import br.com.kotlin.learning.model.Game

class GamesDAO {

    fun getGames(): List<Game>{
        val manager = DataBase.getEntityManager()
        try {
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
        }finally {
            manager.close()
        }
    }
}