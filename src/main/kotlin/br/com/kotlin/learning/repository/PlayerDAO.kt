package br.com.kotlin.learning.repository

import br.com.kotlin.learning.entities.PlayerEntity
import br.com.kotlin.learning.model.Player
import javax.persistence.EntityManager

class PlayerDAO(private val manager: EntityManager) {
    fun getPlayers(): List<Player>{
        val query = manager.createQuery("FROM PlayerEntity", PlayerEntity::class.java)
        return query.resultList.map {
            Player(it.nome,it.email,it.aniversario,it.usuario!!)
        }
    }

    fun addPlayer(player: Player){
        val entity = PlayerEntity(
            aniversario = player.birthDay,
            email = player.email,
            nome = player.name,
            usuario = player.user!!
        )
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}